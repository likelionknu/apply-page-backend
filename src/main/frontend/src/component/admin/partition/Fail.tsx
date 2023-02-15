import React from 'react'
import { Content, FailMailSend, List, NotData, Section, onModalType } from '../emotion/component'
import Header from '../common/Header';
import { Position, PositionBox } from '../emotion/component';
import { frontendDummy, backendDummy, designDummy } from './dummy';
import { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
import axios from 'axios';
import { Button, Loading, Modal } from '../../emotion/component';
import { useDispatch, useSelector } from 'react-redux';
import { TestState } from '../../../app/store';
import { renderNewList, saveModalState } from '../../../features/fetcherSlice';
import Detail from '../detail/Detail';
import { emailType, userType } from './Type';
import mailLoading from '../../../images/mailLoading.gif';

export default function Fail() {


    const [position, setPosition] = useState<string>('백엔드');
    const [frontend, setFrontend] = useState<[]>([]);
    const [backend, setBackend] = useState<[]>([]);
    const [design, setDesign] = useState<[]>([]);
    const [failList, setFailList] = useState<[]>([]);
    const [mailState, setMailState] = useState<boolean>(false);
    const [mailMessage, setMailMessage] = useState<string>("메일 전송 중입니다..");
    const [mailButtonState, setMailButtonState] = useState<boolean>(false);

    const [backendState, setBackendState] = useState<boolean | null>(true);
    const [frontendState, setFrontendState] = useState<boolean | null>(true);
    const [designState, setDesignState] = useState<boolean | null>(true);
    const [clickState, setClickState] = useState<boolean>(false);
    const [sid, setSid] = useState<string>('');
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const userModalState = useSelector((state: TestState) => state.fetcher.userModalState);
    const adminState = useSelector((state: TestState) => (state.fetcher.adminState));
    const newList = useSelector((state: TestState) => (state.fetcher.newList));

    useEffect(() => {

        if (adminState === false) {
            navigate('/error');
        }

        dispatch(saveModalState(false));
        axios.get('/backendApplication/getApplicationWithPassOrNotAndSubmission?passOrNot=false&submission=true')
            .then((res) => {
                // console.log(res);
                setBackend(() => {
                    return res.data
                });

                if (res.data.length < 1) {
                    setBackendState(false);
                } else {
                    setBackendState(null);
                }
            })
    }, [])

    useEffect(() => {
        if (position === "백엔드") {
            axios.get('/backendApplication/getApplicationWithPassOrNotAndSubmission?passOrNot=false&submission=true')
                .then((res) => {
                    setBackend(res.data);

                    if (res.data.length < 1) {
                        setBackendState(false);
                    } else {
                        setBackendState(null);
                    }
                })
        }

        if (position === "프론트엔드") {
            axios.get('/frontendApplication/getApplicationsWithPassOrNotAndSubmission?passOrNot=false&submission=true')
                .then((res) => {
                    setFrontend(res.data);

                    if (res.data.length < 1) {
                        setFrontendState(false);
                    } else {
                        setFrontendState(null);
                    }
                })
        }

        if (position === "디자인") {
            axios.get('/designApplication/getApplicationsWithPassOrNotAndSubmission?passOrNot=false&submission=true')
                .then((res) => {
                    setDesign(res.data);

                    if (res.data.length < 1) {
                        setDesignState(false);
                    } else {
                        setDesignState(null);
                    }
                })
        }
    }, [userModalState, newList])

    /* 포지션을 체크하는 함수 */
    function CheckPosition(event: React.MouseEvent<HTMLButtonElement>): void {
        const name = (event.target as HTMLButtonElement).name;
        setPosition(name);

        if (name === "백엔드") {
            axios.get('/backendApplication/getApplicationWithPassOrNotAndSubmission?passOrNot=false&submission=true')
                .then((res) => {
                    setBackend(res.data);

                    if (res.data.length < 1) {
                        setBackendState(false);
                    } else {
                        setBackendState(null);
                    }
                })
        }

        if (name === "프론트엔드") {
            axios.get('/frontendApplication/getApplicationsWithPassOrNotAndSubmission?passOrNot=false&submission=true')
                .then((res) => {
                    setFrontend(res.data);

                    if (res.data.length < 1) {
                        setFrontendState(false);
                    } else {
                        setFrontendState(null);
                    }
                })
        }

        if (name === "디자인") {
            axios.get('/designApplication/getApplicationsWithPassOrNotAndSubmission?passOrNot=false&submission=true')
                .then((res) => {
                    setDesign(res.data);

                    if (res.data.length < 1) {
                        setDesignState(false);
                    } else {
                        setDesignState(null);
                    }
                })
        }

    }

    // sid 값을 Detail 페이지로 넘겨주면서 모달창으로 연결해주는 함수
    const onModal: onModalType = async (userID: string) => {
        await setSid(userID);
        await dispatch(saveModalState({ userModalState: true }))
    }

    const SendMail = async () => {
        if (window.confirm("정말로 메일 전체 전송을 하시겠어요?")) {
            setMailState(!mailState);
            if (position === "백엔드") {
                if (backend.length >= 1) {
                    backend.map(async (data: emailType) => {
                        await axios.post(`/emailSender/sendFailMail`, JSON.stringify([{
                            email: data.email,
                            interviewDate: "string",
                            interviewLocation: "string",
                            interviewTime: "string",
                            name: data.name,
                        }]),
                            {
                                headers: {
                                    "Content-type": "application/json",
                                }
                            })
                            .then(async (res) => {
                                await backend.map(async (data: emailType) => {
                                    axios.put(`/backendApplication/changeSendMail?sid=${data.sid}`)
                                        .then(async (res) => {
                                            await setMailMessage(`${data.name}님에게 합격 메일 전송 완료!`);
                                            await setMailButtonState(true);
                                        })
                                        .catch(async (error) => {
                                            alert(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                            await setMailMessage(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                            await setMailButtonState(true);
                                        })
                                })
                            })
                            .catch(async (error) => {
                                alert(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                await setMailMessage(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                await setMailButtonState(true);
                            })
                    }
                    )
                } else if (backend.length === 0) {
                    alert("보낼 지원자가 존재하지 않아요!");
                }
            }

            if (position === "프론트엔드") {
                if (frontend.length >= 1) {
                    frontend.map(async (data: emailType) => {
                        await axios.post(`/emailSender/sendFailMail`, JSON.stringify([{
                            email: data.email,
                            interviewDate: "string",
                            interviewLocation: "string",
                            interviewTime: "string",
                            name: data.name,
                        }]),
                            {
                                headers: {
                                    "Content-type": "application/json",
                                }
                            })
                            .then(async (res) => {
                                await frontend.map(async (data: emailType) => {
                                    axios.put(`/frontendApplication/changeSendMail?sid=${data.sid}`)
                                        .then(async (res) => {
                                            await setMailMessage(`${data.name}님에게 합격 메일 전송 완료!`);
                                            await setMailButtonState(true);
                                        })
                                        .catch(async (error) => {
                                            alert(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                            await setMailMessage(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                            await setMailButtonState(true);
                                        })
                                })
                            })
                            .catch(async (error) => {
                                alert(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                await setMailMessage(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                await setMailButtonState(true);
                            })
                    }
                    )
                } else if (frontend.length === 0) {
                    alert("보낼 지원자가 존재하지 않아요!");
                }
            }

            if (position === "디자인") {
                if (design.length >= 1) {
                    design.map(async (data: emailType) => {
                        await axios.post(`/emailSender/sendFailMail`, JSON.stringify([{
                            email: data.email,
                            interviewDate: "string",
                            interviewLocation: "string",
                            interviewTime: "string",
                            name: data.name,
                        }]),
                            {
                                headers: {
                                    "Content-type": "application/json",
                                }
                            })
                            .then(async (res) => {
                                await design.map(async (data: emailType) => {
                                    axios.put(`/designApplication/changeSendMail?sid=${data.sid}`)
                                        .then(async (res) => {
                                            await setMailMessage(`${data.name}님에게 합격 메일 전송 완료!`);
                                            await setMailButtonState(true);
                                        })
                                        .catch(async (error) => {
                                            alert(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                            await setMailMessage(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                            await setMailButtonState(true);
                                        })
                                })
                            })
                            .catch(async (error) => {
                                alert(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                await setMailMessage(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                await setMailButtonState(true);
                            })
                    }
                    )
                } else if (design.length === 0) {
                    alert("보낼 지원자가 존재하지 않아요!");
                }
            }
        }
    }

    // 메일 전송이 완료되면, 이 버튼을 통해 모달을 종료합니다.
    const ClearMail = async () => {
        await setMailState(false);
        await setMailButtonState(false);
        await setMailMessage(`메일 전송 중입니다..`);
        await dispatch(renderNewList({ newList: !newList }))
    }

    return (
        <>
            {mailState ?
                <Modal text={mailMessage} imgSrc={mailLoading} alt="최종제출">
                    {mailButtonState && <Button name="제출하기" onClick={ClearMail}>
                        돌아가기
                    </Button>}
                </Modal>
                : null
            }
            {
                !userModalState ?
                    <Content>
                        <PositionBox >
                            <Position name="백엔드" onClick={CheckPosition} state={position}>백엔드</Position>
                            <Position name="프론트엔드" onClick={CheckPosition} state={position}>프론트엔드</Position>
                            <Position name="디자인" onClick={CheckPosition} state={position}>디자인</Position>
                        </PositionBox >
                        <FailMailSend position={position} onClick={SendMail} />
                        <List check="체크 없음" name="이름" position="트랙" department="학과" id="학번" email="이메일" />
                        {/* 백엔드 로직 */}
                        {position === '백엔드' && backendState && <Loading />}
                        {
                            position === '백엔드' && backend.length >= 1 && backend.map((item: userType) => {
                                return (
                                    <List check="체크 없음" key={item.sid} name={item.name} position={position} department={item.department} id={item.sid} email={item.email} mailState={item.sendMail} onClick={() => onModal(item.sid)} />
                                )
                            })
                        }
                        {position === '백엔드' && backendState === false && <NotData />}

                        {/* 프론트엔드 로직 */}
                        {position === '프론트엔드' && frontendState && <Loading />}
                        {
                            position === '프론트엔드' && frontend.length >= 1 && frontend.map((item: userType) => {
                                return (
                                    <List check="체크 없음" key={item.sid} name={item.name} position={position} department={item.department} id={item.sid} email={item.email} mailState={item.sendMail} onClick={() => onModal(item.sid)} />
                                )
                            })
                        }
                        {position === '프론트엔드' && frontendState === false && <NotData />}

                        {/* 디자인 로직 */}
                        {position === '디자인' && designState && <Loading />}
                        {
                            position === '디자인' && design.length >= 1 && design.map((item: userType) => {
                                return (
                                    <List check="체크 없음" key={item.sid} name={item.name} position={position} department={item.department} id={item.sid} email={item.email} mailState={item.sendMail} onClick={() => onModal(item.sid)} />
                                )
                            })
                        }
                        {position === '디자인' && designState === false && <NotData />}
                    </Content >
                    : <Detail position={position} sid={sid} />
            }
        </>
    )
}