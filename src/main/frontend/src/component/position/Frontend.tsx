import React, { ChangeEvent } from 'react'
import { ButtonBox, Section, Button, Require, Article, InputTitle, TextAreaBox, InputBox, Banner, WordLength, Modal } from '../emotion/component'
import { useNavigate } from 'react-router-dom'
import { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, TestState } from '../../app/store';
import { saveCommon, saveIndex, view, saveFrontEnd } from '../../features/fetcherSlice';
import { useEffect, useMemo } from 'react';
import axios from 'axios';
import tempImg from '../../images/temp.png';
import completeImg from '../../images/complete.png';
import Confetti from '../../hooks/Confetti';
import { currentTime, endTime } from '../time/time';

export default function Frontend() {

    const navigate = useNavigate();
    const dispatch = useDispatch<AppDispatch>();

    const [buttonState, setButtonState] = useState(false);
    const [submitCount, setSubmitCount] = useState<number>(0);
    const [tempState, setTempState] = useState<boolean>(false);
    const [temp, setTemp] = useState<boolean>(false);
    const [complete, setComplete] = useState<boolean>(false);

    const [whyFrontend, setWhyFrontend] = useState('');
    const [usingStack, setUsingStack] = useState('');
    const [teamProject, setTeamProject] = useState('');
    const [achieve, setAchieve] = useState('');
    const [portfolioLink, setPortfolioLink] = useState('');

    const [name, setName] = useState<string>('');


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

    const userWhyFrontend = useSelector((state: TestState) => state.fetcher.userWhyFrontend);
    const userUsingStack = useSelector((state: TestState) => state.fetcher.userUsingStack);
    const userTeamProject = useSelector((state: TestState) => state.fetcher.userTeamProject);
    const userAchieve = useSelector((state: TestState) => state.fetcher.userAchieve);
    const userPortfolioLink = useSelector((state: TestState) => state.fetcher.userPortfolioLinkFront);

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

        if (userWhyFrontend) {
            setWhyFrontend(userWhyFrontend)
        }
        if (userUsingStack) {
            setUsingStack(userUsingStack)
        }
        if (userTeamProject) {
            setTeamProject(userTeamProject)
        }
        if (userAchieve) {
            setAchieve(userAchieve)
        }
        if (userPortfolioLink) {
            setPortfolioLink(userPortfolioLink)
        }

        if (userName) {
            setName(userName)
        }
    }, [])

    useMemo(() => {

        // 프론트엔드 파트로 들어왔을 때는 공통 질문이 하나라도 작성된 상태이기 때문에 바로 임시저장이 가능함
        if (userMotiv || userHardWork || userKeyWord || userMostDeeplyWork) {
            setTempState(false);
        } else {
            setTempState(true);
        }

        if (whyFrontend && usingStack && teamProject && achieve) {
            setButtonState(false)
        } else {
            setButtonState(true)
        }
        if (submitCount >= 1) {
            setButtonState(true);
        }
    }, [whyFrontend, usingStack, teamProject, achieve, submitCount])


    const Back = () => {
        setSubmitCount((prev) => (prev + 1))
        dispatch(saveFrontEnd({ userWhyFrontend: whyFrontend, userUsingStack: usingStack, userTeamProject: teamProject, userAchieve: achieve, userPortfolioLinkFront: portfolioLink }));
        navigate('/common');
    }


    const TempSave = () => {
        setSubmitCount((prev) => (prev + 1));
        if (userPosition === "프론트엔드") {
            axios.post('/frontendApplication', JSON.stringify({
                department: userDepartment,
                whyFrontend: whyFrontend,
                email: userEmail,
                hardWork: userHardWork,
                usingStack: usingStack,
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
                teamProject: teamProject,
                achieve: achieve,
                submissionStatus: false,
            }),
                {
                    headers: {
                        "Content-type": "application/json",
                    }
                }
            )
                .then((res) => {
                    setTemp(!temp);
                    document.body.style.overflow = "hidden";
                })
        }
    }

    const OpenSubmit = () => {
        setComplete(!complete);
    }

    const Submit = () => {

        const time = new Date();

        if (time > endTime) {
            alert("제출 기간이 마감되었습니다!");
            navigate('/notTime');
        }

        else if (window.confirm("제출하면 수정이 불가해요, 제출하시겠어요?")) {
            setSubmitCount((prev) => (prev + 1))
            axios.post('/frontendApplication', JSON.stringify({
                department: userDepartment,
                whyFrontend: whyFrontend,
                email: userEmail,
                hardWork: userHardWork,
                usingStack: usingStack,
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
                teamProject: teamProject,
                achieve: achieve,
                submissionStatus: true,
            }),
                {
                    headers: {
                        "Content-type": "application/json",
                    }
                }
            )
                .then((res) => {
                    dispatch(saveFrontEnd({
                        userWhyFrontend: '',
                        userUsingStack: '',
                        userAchieve: '',
                        userPortfolioLinkFront: '',
                        userTeamProject: '',
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
                    setComplete(!complete)
                    document.body.style.overflow = "hidden";
                })
        }
    }

    const handleChange = (event: ChangeEvent<HTMLTextAreaElement> | ChangeEvent<HTMLInputElement>) => {
        if (event.target.name === "동기") {
            if (event.target.value.length <= 1000) {
                setWhyFrontend(event.target.value);
            }
        }

        if (event.target.name === "프레임워크") {
            if (event.target.value.length <= 1000) {

                setUsingStack(event.target.value);
            }
        }

        if (event.target.name === "경험") {
            if (event.target.value.length <= 1000) {
                setTeamProject(event.target.value);
            }
        }

        if (event.target.name === "성장") {
            if (event.target.value.length <= 1000) {
                setAchieve(event.target.value);
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
        await dispatch(saveFrontEnd({
            userWhyFrontend: '',
            userUsingStack: '',
            userAchieve: '',
            userPortfolioLinkFront: '',
            userTeamProject: '',
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
                <Modal text="지원하신 학번으로 지원서가 저장이 되었어요!" imgSrc={tempImg}>
                    <Button name="임시저장" onClick={TempHome}>메인 화면으로 이동</Button>
                    <Button name="제출하기" onClick={TempBack}>이어서 작성하기</Button>
                </Modal>
                : null
            }
            <Banner />
            <Article>
                <InputTitle>프론트엔드 트랙을 선택하게 된 이유를 구체적으로 서술해주세요<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="동기" onChange={handleChange} value={whyFrontend} />
                <WordLength>{whyFrontend.length}</WordLength>
            </Article>
            <Article>
                <InputTitle>프론트엔드 개발과 관련된 프레임워크나 html, css, js 등의 언어를 사용해 보신 적 있으신가요? 있으시다면 어디까지 사용해 보셨는지 구체적으로 적어주세요<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="프레임워크" onChange={handleChange} value={usingStack} />
                <WordLength>{usingStack.length}</WordLength>
            </Article>
            <Article>
                <InputTitle>팀 활동이나 프로젝트를 경험해본 내용과 이를 통해 자신의 성장 경험에 대해서 서술해주세요<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="경험" onChange={handleChange} value={teamProject} />
                <WordLength>{teamProject.length}</WordLength>
            </Article>
            <Article>
                <InputTitle>멋사 프론트엔드 아기사자로 활동하면서 얻어 가고 싶은 것은 무엇인가요?<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="성장" onChange={handleChange} value={achieve} />
                <WordLength>{achieve.length}</WordLength>
            </Article>
            <Article>
                <InputTitle>포트폴리오 링크가 있다면 첨부해주세요 </InputTitle>
                <InputBox type="text" placeholder="포트폴리오 링크를 입력해주세요" maxLength={200} name="포트폴리오" onChange={handleChange} value={portfolioLink} />
            </Article>
            <ButtonBox>
                <Button name="임시저장" onClick={TempSave} disabled={tempState}>{submitCount >= 1 ? `잠시만 기다려주세요...` : `임시저장`}</Button>
                <Button name="제출하기" onClick={Back}>{submitCount >= 1 ? `잠시만 기다려주세요...` : `뒤로가기`}</Button>
                <Button name="제출하기" onClick={Submit} disabled={buttonState}>{submitCount >= 1 ? `잠시만 기다려주세요...` : `제출하기`}</Button>
            </ButtonBox>
        </Section>
    )
}