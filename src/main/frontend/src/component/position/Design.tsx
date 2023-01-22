import React, { ChangeEvent } from 'react'
import { ButtonBox, Section, Button, Require, Article, InputTitle, TextAreaBox, InputBox, Banner, WordLength, Modal } from '../emotion/component'
import { useNavigate } from 'react-router-dom'
import { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, TestState } from '../../app/store';
import { saveCommon, saveIndex, view, saveDesign } from '../../features/fetcherSlice';
import { useEffect, useMemo } from 'react';
import axios from 'axios';
import tempImg from '../../images/temp.png';
import completeImg from '../../images/complete.png';


export default function Design() {

    const navigate = useNavigate();
    const dispatch = useDispatch<AppDispatch>();
    const [whyDesign, setWhyDesign] = useState('');
    const [toolExperience, setToolExperience] = useState('');
    const [teamworkExperience, setTeamworkExperience] = useState('');
    const [designGrowth, setDesignGrowth] = useState('');
    const [buttonState, setButtonState] = useState(false);
    const [portfolioLink, setPortfolioLink] = useState('');
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

    const userWhyDesign = useSelector((state: TestState) => state.fetcher.userWhyDesign);
    const userToolExperience = useSelector((state: TestState) => state.fetcher.userToolExperience);
    const userTeamworkExperience = useSelector((state: TestState) => state.fetcher.userTeamworkExperience);
    const userDesignGrowth = useSelector((state: TestState) => state.fetcher.userDesignGrowth);
    const userPortfolioLink = useSelector((state: TestState) => state.fetcher.userPortfolioLinkDesign);


    useEffect(() => {
        document.body.style.overflow = "unset";
        if (!userName && !userID && !userPhone && !userEmail && !userPosition) {
            alert('잘못된 접근입니다!');
            navigate('/')
        }

        // 이전 값들을 저장하기 위해서 Redux 사용
        if (userWhyDesign) {
            setWhyDesign(userWhyDesign);
        }

        if (userToolExperience) {
            setToolExperience(userToolExperience);
        }

        if (userTeamworkExperience) {
            setTeamworkExperience(userTeamworkExperience);
        }

        if (userDesignGrowth) {
            setDesignGrowth(userDesignGrowth);
        }

        if (userPortfolioLink) {
            setPortfolioLink(userPortfolioLink)
        }

    }, [])

    useMemo(() => {
        // 디자인 파트로 들어왔을 때는 공통 질문이 하나라도 작성된 상태이기 때문에 바로 임시저장이 가능함
        if (userMotiv || userHardWork || userKeyWord || userMostDeeplyWork) {
            setTempState(false);
        } else {
            setTempState(true);
        }

        if (whyDesign && toolExperience && teamworkExperience && designGrowth) {
            setButtonState(false)
        } else {
            setButtonState(true)
        }
        if (submitCount >= 1) {
            setButtonState(true);
        }
    }, [whyDesign, toolExperience, teamworkExperience, designGrowth, submitCount])


    const Back = () => {
        setSubmitCount((prev) => (prev + 1))
        dispatch(saveDesign({ userWhyDesign: whyDesign, userToolExperience: toolExperience, userTeamworkExperience: teamworkExperience, userDesignGrowth: designGrowth, userPortfolioLinkDesign: portfolioLink }));
        navigate('/common');
    }

    const TempSave = () => {
        setSubmitCount((prev) => (prev + 1))
        axios.post('/designApplication', JSON.stringify({
            department: userDepartment,
            whyDesign: whyDesign,
            email: userEmail,
            hardWork: userHardWork,
            toolExperience: toolExperience,
            keyWord: userKeyWord,
            mostDeeplyWork: userMostDeeplyWork,
            motive: userMotiv,
            name: userName,
            passOrNot: true,
            phoneNumber: userPhone,
            portfolioFile: "",
            portfolioLink: portfolioLink,
            sid: userID,
            teamworkExperience: teamworkExperience,
            designGrowth: designGrowth,
            submissionStatus: false,
        }),
            {
                headers: {
                    "Content-type": "application/json",
                }
            }
        )
            .then((res) => {
                console.log(res);
                dispatch(saveDesign({
                    userWhyDesign: '',
                    userToolExperience: '',
                    userTeamworkExperience: '',
                    userPortfolioLinkDesign: '',
                    userDesignGrowth: '',
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

    const Submit = async () => {
        setSubmitCount((prev) => (prev + 1))
        axios.post('/designApplication', JSON.stringify({
            department: userDepartment,
            whyDesign: whyDesign,
            email: userEmail,
            hardWork: userHardWork,
            toolExperience: toolExperience,
            keyWord: userKeyWord,
            mostDeeplyWork: userMostDeeplyWork,
            motive: userMotiv,
            name: userName,
            passOrNot: true,
            phoneNumber: userPhone,
            portfolioFile: "",
            portfolioLink: portfolioLink,
            sid: userID,
            teamworkExperience: teamworkExperience,
            designGrowth: designGrowth,
            submissionStatus: true,
        }),
            {
                headers: {
                    "Content-type": "application/json",
                }
            }
        )
            .then((res) => {
                console.log(res);
                dispatch(saveDesign({
                    userWhyDesign: '',
                    userToolExperience: '',
                    userTeamworkExperience: '',
                    userPortfolioLinkDesign: '',
                    userDesignGrowth: '',
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

    const handleChange = (event: ChangeEvent<HTMLTextAreaElement> | ChangeEvent<HTMLInputElement>) => {
        if (event.target.name === "동기") {
            if (event.target.value.length <= 1000) {
                setWhyDesign(event.target.value);
            }
        }

        if (event.target.name === "경험") {
            if (event.target.value.length <= 1000) {
                setToolExperience(event.target.value);
            }
        }

        if (event.target.name === "팀워크") {
            if (event.target.value.length <= 1000) {
                setTeamworkExperience(event.target.value);
            }
        }

        if (event.target.name === "성장") {
            if (event.target.value.length <= 1000) {
                setDesignGrowth(event.target.value);
            }
        }

        if (event.target.name === "포트폴리오") {
            setPortfolioLink(event.target.value);
        }
    }

    return (
        <Section>
            {complete ?
                <Modal text="지원서가 정상적으로 제출되었습니다!" imgSrc={completeImg} alt="최종제출">
                    <Button name="제출하기" onClick={() => navigate('/')}>메인 화면으로 이동</Button>
                </Modal>
                : null
            }
            {temp ?
                <Modal text="지원하신 학번으로 지원서가 저장이 되었어요!" imgSrc={tempImg}>
                    <Button name="제출하기" onClick={() => navigate('/')}>메인 화면으로 이동</Button>
                </Modal>
                : null
            }
            <Banner />
            <Article>
                <InputTitle>디자인 트랙을 선택하게 된 이유를 구체적으로 서술해주세요<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="동기" onChange={handleChange} value={whyDesign} />
                <WordLength>{whyDesign.length}</WordLength>
            </Article>
            <Article>
                <InputTitle>피그마나 Adobe XD와 같은 목업 툴에 관련된 경험을 해본 적이 있다면 그 경험에 대해 자세히 설명을 해주세요<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="경험" onChange={handleChange} value={toolExperience} />
                <WordLength>{toolExperience.length}</WordLength>
            </Article>
            <Article>
                <InputTitle>본인이 협업과 팀워크를 진행해 보았던 경험과, 그 경험을 멋쟁이 사자처럼 대학에서 어떻게 적용시킬 수 있는지 알려주세요<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="팀워크" onChange={handleChange} value={teamworkExperience} />
                <WordLength>{teamworkExperience.length}</WordLength>
            </Article>
            <Article>
                <InputTitle>디자인 트랙을 통해 어떠한 성장을 희망하시는지 구체적으로 서술해주세요<Require /> </InputTitle>
                <TextAreaBox placeholder="텍스트를 입력해주세요" name="성장" onChange={handleChange} value={designGrowth} />
                <WordLength>{designGrowth.length}</WordLength>
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
