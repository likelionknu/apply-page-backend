import React, { ChangeEvent } from 'react'
import { ButtonBox, Section, Button, Require, Article, InputTitle, TextAreaBox, InputBox, Banner, WordLength, Modal, Footer } from '../emotion/component'
import { useNavigate } from 'react-router-dom'
import { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, TestState } from '../../app/store';
import { saveCommon, saveIndex, view, saveBackEnd } from '../../features/fetcherSlice';
import { useEffect, useMemo } from 'react';
import axios from 'axios';
import tempImg from '../../images/temp.png';
import completeImg from '../../images/complete.png';
import Confetti from '../../hooks/Confetti';
import { currentTime, endTime } from '../time/time';

export default function Backend() {

    const navigate = useNavigate();
    const dispatch = useDispatch<AppDispatch>();
    const [difficultAndOvercoming, setDifficultAndOvercoming] = useState('');
    const [studyFramework, setStudyFramework] = useState('');
    const [importantGroup, setImportantGroup] = useState('');
    const [portfolioLink, setPortfolioLink] = useState('');
    const [buttonState, setButtonState] = useState(false);
    const [backButtonState, setBackButtonState] = useState(false);
    const [submitCount, setSubmitCount] = useState<number>(0);
    const [tempState, setTempState] = useState<boolean>(false);
    const [temp, setTemp] = useState<boolean>(false);
    const [complete, setComplete] = useState<boolean>(false);

    const userName = useSelector((state: TestState) => state.fetcher.userName);
    const userID = useSelector((state: TestState) => state.fetcher.userID);
    const userPhone = useSelector((state: TestState) => state.fetcher.userPhone);
    const userEmail = useSelector((state: TestState) => state.fetcher.userEmail);
    const userPosition = useSelector((state: TestState) => state.fetcher.userPosition);
    const userDepartment = useSelector((state: TestState) => state.fetcher.userDepartment);

    const userMotiv = useSelector((state: TestState) => state.fetcher.userMotiv);
    const userHardWork = useSelector((state: TestState) => state.fetcher.userHardWork);
    const userKeyWord = useSelector((state: TestState) => state.fetcher.userKeyWord);
    const userMostDeeplyWork = useSelector((state: TestState) => state.fetcher.userMostDeeplyWork);

    const userDifficultAndOvercoming = useSelector((state: TestState) => state.fetcher.userDifficultAndOvercoming);
    const userStudyFramework = useSelector((state: TestState) => state.fetcher.userStudyFramework);
    const userImportantGroup = useSelector((state: TestState) => state.fetcher.userImportantGroup);
    const userPortfolioLink = useSelector((state: TestState) => state.fetcher.userPortfolioLinkBack);

    const [name, setName] = useState<string>('');

    useEffect(() => {
        document.body.style.overflow = "unset";

        if (!userName && !userID && !userPhone && !userEmail && !userPosition) {
            navigate('/404')
        }

        if (currentTime > endTime) {
            alert("제출 기간이 마감되었습니다!");
            navigate('/notTime');
        }

        // 이전 값들을 저장하기 위해서 Redux 사용
        if (userDifficultAndOvercoming) {
            setDifficultAndOvercoming(userDifficultAndOvercoming);
        }

        if (userStudyFramework) {
            setStudyFramework(userStudyFramework);
        }

        if (userImportantGroup) {
            setImportantGroup(userImportantGroup);
        }

        if (userPortfolioLink) {
            setPortfolioLink(userPortfolioLink)
        }

        if (userName) {
            setName(userName)
        }
    }, [])

    useMemo(() => {

        // 백엔드 파트로 들어왔을 때는 공통 질문이 하나라도 작성된 상태이기 때문에 바로 임시저장이 가능함
        if (userMotiv || userHardWork || userKeyWord || userMostDeeplyWork) {
            setTempState(false);
        } else {
            setTempState(true);
        }

        if (difficultAndOvercoming && studyFramework && importantGroup) {
            setButtonState(false)
        } else {
            setButtonState(true)
        }
        if (submitCount >= 1) {
            setButtonState(true);
            setBackButtonState(true);
        }
    }, [difficultAndOvercoming, studyFramework, importantGroup, submitCount])


    const Back = () => {
        setSubmitCount((prev) => (prev + 1))
        dispatch(saveBackEnd({ userDifficultAndOvercoming: difficultAndOvercoming, userStudyFramework: studyFramework, userImportantGroup: importantGroup, userPortfolioLinkBack: portfolioLink }));
        navigate('/common');
    }

    const TempSave = () => {
        setSubmitCount((prev) => (prev + 1))
        axios.post('/backendApplication', JSON.stringify({
            department: userDepartment,
            difficultAndOvercoming: difficultAndOvercoming,
            email: userEmail,
            hardWork: userHardWork,
            importantGroup: importantGroup,
            keyWord: userKeyWord,
            mostDeeplyWork: userMostDeeplyWork,
            motive: userMotiv,
            name: userName,
            passOrNot: false,
            sendMail: false,
            phoneNumber: userPhone,
            portfolioFile: "",
            portfolioLink: portfolioLink,
            sid: userID,
            studyFramework: studyFramework,
            submissionStatus: false,
        }),
            {
                headers: {
                    "Content-type": "application/json",
                }
            }
        )
            .then((res) => {
                dispatch(saveBackEnd({
                    userDifficultAndOvercoming: '',
                    userImportantGroup: '',
                    userPortfolioLink: '',
                    userStudyFramework: '',
                }));
                dispatch(saveCommon({
                    userMotiv: '',
                    userHardWork: '',
                    userKeyWord: '',
                    userMostDeeplyWork: '',
                }))
                dispatch(saveIndex({
                    userName: '',
                    userID: '',
                    userDepartment: '',
                    userEmail: '',
                    userPhone: '',
                    userPosition: '',
                }))
                setTemp(!temp);
                document.body.style.overflow = "hidden";
            })
    }

    const Submit = () => {

        const time = new Date();

        if (time > endTime) {
            alert("제출 기간이 마감되었습니다!");
            navigate('/notTime');
        }

        else if (window.confirm("최중 제출을 하면 수정이 불가해요, 제출하시겠어요?")) {
            setSubmitCount((prev) => (prev + 1))
            axios.post('/backendApplication', JSON.stringify({
                department: userDepartment,
                difficultAndOvercoming: difficultAndOvercoming,
                email: userEmail,
                hardWork: userHardWork,
                importantGroup: importantGroup,
                keyWord: userKeyWord,
                mostDeeplyWork: userMostDeeplyWork,
                motive: userMotiv,
                name: userName,
                passOrNot: false,
                sendMail: false,
                phoneNumber: userPhone,
                portfolioFile: "",
                portfolioLink: portfolioLink,
                sid: userID,
                studyFramework: studyFramework,
                submissionStatus: true,
            }),
                {
                    headers: {
                        "Content-type": "application/json",
                    }
                }
            )
                .then((res) => {
                    setComplete(!complete);
                    document.body.style.overflow = "hidden";
                })
        }
    }

    const handleChange = (event: ChangeEvent<HTMLTextAreaElement> | ChangeEvent<HTMLInputElement>) => {
        if (event.target.name === "극복") {
            if (event.target.value.length <= 1000) {
                setDifficultAndOvercoming(event.target.value);
            }
        }

        if (event.target.name === "경험") {
            if (event.target.value.length <= 1000) {
                setStudyFramework(event.target.value);
            }
        }

        if (event.target.name === "팀워크") {
            if (event.target.value.length <= 1000) {
                setImportantGroup(event.target.value);
            }
        }

        if (event.target.name === "포트폴리오") {
            setPortfolioLink(event.target.value);
        }
    }

    const TempBack = async () => {
        setTemp(false);
        setSubmitCount(0);
        setTempState(false);
        setButtonState(false);
        document.body.style.overflow = "unset";
    }

    /* 처음에는 임시 저장에서 메인화면으로 가는 용도로 만들었지만, 최종 제출 후 redux를 초기화하는 로직이 동일해 최종 제출 후 홈으로 갈 때도 같이 사용*/
    const TempHome = async () => {
        await dispatch(saveBackEnd({
            userDifficultAndOvercoming: '',
            userImportantGroup: '',
            userPortfolioLink: '',
            userStudyFramework: '',
        }));
        await dispatch(saveCommon({
            userMotiv: '',
            userHardWork: '',
            userKeyWord: '',
            userMostDeeplyWork: '',
        }))
        await dispatch(saveIndex({
            userName: '',
            userID: '',
            userDepartment: '',
            userEmail: '',
            userPhone: '',
            userPosition: '',
        }))
        await navigate('/');
    }

    return (
        <Section>
            {complete && <Confetti />}
            {complete ?
                <Modal text={`${name}님의 소중한 지원서가 정상적으로 제출되었어요!`} imgSrc={completeImg} alt="최종제출">
                    <Button name="제출하기" onClick={TempHome}>메인 화면으로 이동</Button>
                </Modal>
                : null
            }
            {temp ?
                <Modal text="소중한 지원서가 학번으로 지원서가 저장이 되었어요!" imgSrc={tempImg}>
                    <Button name="임시저장" onClick={TempHome}>메인 화면으로 이동</Button>
                    <Button name="제출하기" onClick={TempBack}>이어서 작성하기</Button>
                </Modal>
                : null
            }
            <Banner />
            <Article>
                <InputTitle>개발 관련 공부를 하며 개인적으로 힘들었던 경험과 그걸 극복했던 자신만의 방법이 있나요?<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="극복" onChange={handleChange} value={difficultAndOvercoming} />
                <WordLength>{difficultAndOvercoming.length}</WordLength>
            </Article>
            <Article>
                <InputTitle>웹 백앤드 프레임워크를 공부해보신적 있으신가요? 있으시다면 어디까지 공부해보셨나요?<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="경험" onChange={handleChange} value={studyFramework} />
                <WordLength>{studyFramework.length}</WordLength>
            </Article>
            <Article>
                <InputTitle>단체생활에서 가장 중요하다고 생각하는 것은 무엇인가요?<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="팀워크" onChange={handleChange} value={importantGroup} />
                <WordLength>{importantGroup.length}</WordLength>
            </Article>
            <Article>
                <InputTitle>포트폴리오 링크가 있다면 첨부해주세요 </InputTitle>
                <InputBox type="text" placeholder="포트폴리오 링크를 입력해주세요" maxLength={200} name="포트폴리오" onChange={handleChange} value={portfolioLink} />
            </Article>
            <ButtonBox>
                <Button name="임시저장" onClick={TempSave} disabled={tempState}>{submitCount >= 1 ? `잠시만 기다려주세요...` : `임시저장`}</Button>
                <Button name="제출하기" onClick={Back} disabled={backButtonState}>{submitCount >= 1 ? `잠시만 기다려주세요...` : `뒤로가기`}</Button>
                <Button name="제출하기" onClick={Submit} disabled={buttonState}>{submitCount >= 1 ? `잠시만 기다려주세요...` : `제출하기`}</Button>
            </ButtonBox>
            <Footer />
        </Section>
    )
}
