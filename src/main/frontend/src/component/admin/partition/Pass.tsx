/** @jsxImportSource @emotion/react */

import React from 'react'
import { Content, List, NotData, PassMailSend, PassUser, PassUserContent, Section, onModalType } from '../emotion/component'
import { Position, PositionBox } from '../emotion/component';
import { frontendDummy, backendDummy, designDummy } from './dummy';
import { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
import axios from 'axios';
import { Button, ButtonBox, Loading, Modal, ModalInput, Quit } from '../../emotion/component';
import { emailType, mailUserType, userType } from './Type';
import Header from '../common/Header';
import { css, keyframes } from "@emotion/react";
import { useDispatch, useSelector } from 'react-redux';
import { TestState } from '../../../app/store';
import { renderNewList, saveModalState, updatePassMailList } from '../../../features/fetcherSlice';
import Detail from '../detail/Detail';
import checkBox from '../images/checkBox.svg';
import checkedBox from '../images/checkedBox.svg';
import mailLoading from '../../../images/mailLoading.gif';

export default function Pass() {


    const [position, setPosition] = useState<string>('백엔드');
    const [frontend, setFrontend] = useState<[]>([]);
    const [backend, setBackend] = useState<[]>([]);
    const [design, setDesign] = useState<[]>([]);

    const [mailState, setMailState] = useState<boolean>(false);
    const [pendingState, setPendingState] = useState<boolean>(false);
    const [mailMessage, setMailMessage] = useState<string>("메일 전송 중입니다..");
    const [mailButtonState, setMailButtonState] = useState<boolean>(false);
    const [inputMail, setInputMail] = useState<boolean>(true);

    const [time, setTime] = useState<string>('');
    const [place, setPlace] = useState<string>('');
    const [playTime, setPlayTime] = useState<string>('');

    const [backendState, setBackendState] = useState<boolean | null>(true);
    const [frontendState, setFrontendState] = useState<boolean | null>(true);
    const [designState, setDesignState] = useState<boolean | null>(true);
    const [sid, setSid] = useState<string>('');
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const userModalState = useSelector((state: TestState) => state.fetcher.userModalState);
    const adminState = useSelector((state: TestState) => (state.fetcher.adminState));
    const passMailList = useSelector((state: TestState) => (state.fetcher.passMailList));
    const newList = useSelector((state: TestState) => (state.fetcher.newList));

    useEffect(() => {
        if (adminState === false) {
            navigate('/error');
        }

        dispatch(saveModalState(false));
        axios.get('/backendApplication/getApplicationWithPassOrNotAndSubmission?passOrNot=true&submission=true')
            .then((res) => {
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
        dispatch(updatePassMailList([]));
        if (position === "백엔드") {
            axios.get('/backendApplication/getApplicationWithPassOrNotAndSubmission?passOrNot=true&submission=true')
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
            axios.get('/frontendApplication/getApplicationsWithPassOrNotAndSubmission?passOrNot=true&submission=true')
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
            axios.get('/designApplication/getApplicationsWithPassOrNotAndSubmission?passOrNot=true&submission=true')
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

    function CheckPosition(event: React.MouseEvent<HTMLButtonElement>): void {
        const name = (event.target as HTMLButtonElement).name;
        dispatch(updatePassMailList([]));
        setPosition(name);

        if (name === "백엔드") {
            axios.get('/backendApplication/getApplicationWithPassOrNotAndSubmission?passOrNot=true&submission=true')
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
            axios.get('/frontendApplication/getApplicationsWithPassOrNotAndSubmission?passOrNot=true&submission=true')
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
            axios.get('/designApplication/getApplicationsWithPassOrNotAndSubmission?passOrNot=true&submission=true')
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

    const onModal: onModalType = async (userID: string) => {
        await dispatch(updatePassMailList([]));
        await setSid(userID);
        await dispatch(saveModalState({ userModalState: true }))
    }

    const Send = async () => {
        if (window.confirm("정말로 메일 전송을 하시겠어요?")) {
            if (passMailList.length >= 1) {
                setMailState(!mailState);
            } else if (passMailList.length === 0) {
                alert("먼저 리스트를 체크해주세요!");
            }
        }
    }

    const SendMail = async () => {
        setMailState(false);
        setPendingState(!pendingState);
        await passMailList.map(async (data: emailType) => {
            await axios.post(`/emailSender/sendAcceptMail`, JSON.stringify([{
                email: data.email,
                interviewDate: time,
                interviewLocation: place,
                interviewTime: playTime,
                name: data.name,
            }]),
                {
                    headers: {
                        "Content-type": "application/json",
                    }
                })
                .then(async (res) => {
                    if (position === "디자인") {
                        await passMailList.map(async (data: emailType) => {
                            axios.put(`/designApplication/changeSendMail?sid=${data.id}`)
                                .then(async (res) => {
                                    await setMailMessage(`${data.name}님에게 합격 메일 전송 완료!`);
                                    await setMailButtonState(true);
                                })
                                .catch(async (error) => {
                                    await setMailMessage(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                    alert(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                    await setMailButtonState(true);
                                })
                        })
                    } else if (position === "프론트엔드") {
                        await passMailList.map(async (data: emailType) => {
                            axios.put(`/frontendApplication/changeSendMail?sid=${data.id}`)
                                .then(async (res) => {
                                    await setMailMessage(`${data.name}님에게 합격 메일 전송 완료!`);
                                    await setMailButtonState(true);
                                })
                                .catch(async (error) => {
                                    await setMailMessage(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                    alert(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                    await setMailButtonState(true);
                                })
                        })

                    } else if (position === "백엔드") {
                        await passMailList.map(async (data: emailType) => {
                            axios.put(`/backendApplication/changeSendMail?sid=${data.id}`)
                                .then(async (res) => {
                                    await setMailMessage(`${data.name}님에게 합격 메일 전송 완료!`);
                                    await setMailButtonState(true);
                                })
                                .catch(async (error) => {
                                    await setMailMessage(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                    alert(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                                    await setMailButtonState(true);
                                })
                        })
                    }
                })
                .catch(async (error) => {
                    alert(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                    await setMailMessage(`${data.name}님에게 메일을 보내는 과정에서 에러가 발생했어요!`);
                    await setMailButtonState(true);
                })
        })
    }

    // 메일 전송이 완료되면, 이 버튼을 통해 모달을 종료합니다.
    const ClearMail = async () => {
        await setMailState(false);
        await setPendingState(false);
        await setTime("");
        await setPlayTime("");
        await setPlace("");
        await setMailButtonState(false);
        await setMailMessage(`메일 전송 중입니다..`);
        await dispatch(renderNewList({ newList: !newList }))
    }

    const ChangeValue = (event: React.ChangeEvent<HTMLInputElement>) => {
        if (event.target.name === "인터뷰_시간") {
            setTime(event.target.value);
        }
        if (event.target.name === "인터뷰_장소") {
            setPlace(event.target.value);
        }

        if (event.target.name === "인터뷰_소요시간") {
            setPlayTime(event.target.value);
        }

        // time, place, playTime에 정보가 들어와야 버튼이 활성화 됩니다!
        if (time && place && playTime) {
            setInputMail(false);
        } else {
            setInputMail(true);
        }
    }

    return (
        <>
            {pendingState ?
                <Modal text={mailMessage} imgSrc={mailLoading} alt="최종제출">
                    {mailButtonState && <Button name="제출하기" onClick={ClearMail}>
                        돌아가기
                    </Button>}
                </Modal>
                : null
            }
            {mailState ?
                <Modal text="면접에 관한 내용을 시간, 장소, 소요시간으로 자세히 입력해주세요" alt="메일_합격">
                    <ButtonBox alt="임시저장_모달">
                        <div css={css`
                                display: flex;
                                flex-direction: column;
                                width: 100%;
                                align-items: center;
                                row-gap: 1em;
                            `}>
                            <PassUser>
                                {passMailList.map((item: mailUserType) => {
                                    return (
                                        <PassUserContent>
                                            {item.name}
                                        </PassUserContent>
                                    )
                                })}
                            </PassUser>
                            <ModalInput type="text" placeholder="인터뷰 시간을 입력해주세요 (예시 : 2023년 01월 20일)" name="인터뷰_시간" onChange={ChangeValue} value={time} />
                            <ModalInput type="text" placeholder="인터뷰 장소를 입력해주세요 (예시 : 이공관 B106호)" name="인터뷰_장소" onChange={ChangeValue} value={place} />
                            <ModalInput type="text" placeholder="인터뷰 소요 시간을 입력해주세요 (예시 : 30분 또는 15분 ~ 30분 소요)" name="인터뷰_소요시간" maxLength={9} onChange={ChangeValue} value={playTime} />
                            <div css={css`
                                margin-top: 1em;
                                display: flex;
                                width: 100%;
                                align-items: center;
                                column-gap: 1em;
                                align-items: center;
                                justify-content: center;
                            `}>
                                <Button name="임시저장" onClick={ClearMail}>닫기</Button>
                                <Button name="제출하기" onClick={SendMail} disabled={inputMail}>메일 전송</Button>
                            </div>
                        </div>
                    </ButtonBox>
                </Modal>
                : null
            }
            {
                !userModalState ?
                    <Content>
                        <PositionBox>
                            <Position name="백엔드" onClick={CheckPosition} state={position}>백엔드</Position>
                            <Position name="프론트엔드" onClick={CheckPosition} state={position}>프론트엔드</Position>
                            <Position name="디자인" onClick={CheckPosition} state={position}>디자인</Position>
                        </PositionBox >
                        <PassMailSend position={position} onClick={Send} />
                        <List check="전송 체크" name="이름" position="트랙" department="학과" id="학번" email="이메일" />
                        {/* 백엔드 로직 */}
                        {position === '백엔드' && backendState && <Loading />}
                        {
                            position === '백엔드' && backend.length >= 1 && backend.map((item: userType) => {
                                return (
                                    <List key={item.sid} name={item.name} position={position} department={item.department} id={item.sid} email={item.email} mailState={item.sendMail} onClick={() => onModal(item.sid)} />
                                )
                            })
                        }
                        {position === '백엔드' && backendState === false && <NotData />}

                        {/* 프론트엔드 로직 */}
                        {position === '프론트엔드' && frontendState && <Loading />}
                        {
                            position === '프론트엔드' && frontend.length >= 1 && frontend.map((item: userType) => {
                                return (
                                    <List key={item.sid} name={item.name} position={position} department={item.department} id={item.sid} email={item.email} mailState={item.sendMail} onClick={() => onModal(item.sid)} />
                                )
                            })
                        }
                        {position === '프론트엔드' && frontendState === false && <NotData />}

                        {/* 디자인 로직 */}
                        {position === '디자인' && designState && <Loading />}
                        {
                            position === '디자인' && design.length >= 1 && design.map((item: userType) => {
                                return (
                                    <List key={item.sid} name={item.name} position={position} department={item.department} id={item.sid} email={item.email} mailState={item.sendMail} onClick={() => onModal(item.sid)} />
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