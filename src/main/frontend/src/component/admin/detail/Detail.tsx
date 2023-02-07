/** @jsxImportSource @emotion/react */
import React, { useEffect, useState } from 'react'
import { Answer, Article, Quit, Section } from './emotion/component'
import { ButtonBox, Button } from './emotion/component'
import { useLocation, useNavigate, useParams } from 'react-router-dom'
import axios from 'axios';
import { Loading } from '../../emotion/component';
import { DetailType } from './Type';
import { useDispatch, useSelector } from 'react-redux';
import { TestState } from '../../../app/store';
import { onModalType } from '../emotion/component';
import { saveModalState } from '../../../features/fetcherSlice';
import { css, keyframes } from "@emotion/react";

export default function Detail(props: DetailType) {

    const [name, setName] = useState<string>('');
    const [sid, setSid] = useState<string>('');
    const [department, setDepartment] = useState<string>('');
    const [track, setTrack] = useState<string>('');
    const [phone, setPhone] = useState<string>('');
    const [state, setState] = useState<boolean>(false);
    const [email, setEmail] = useState<string>('');

    const [motive, setMotive] = useState('');
    const [hardwork, setHardwork] = useState('');
    const [keyword, setKeyword] = useState('');
    const [mostDeeplyWork, setMostDeeplyWork] = useState('');
    const [buttonState, setButtonState] = useState<boolean>(false);
    const [buttonCount, setButtonCount] = useState<number>(0);

    const dispatch = useDispatch();
    const navigate = useNavigate();

    // 프론트엔드
    const [whyFrontend, setWhyFrontend] = useState('');
    const [usingStack, setUsingStack] = useState('');
    const [teamProject, setTeamProject] = useState('');
    const [achieve, setAchieve] = useState('');
    const [portfolioLink, setPortfolioLink] = useState('');

    // 백엔드
    const [difficultAndOvercoming, setDifficultAndOvercoming] = useState('');
    const [studyFramework, setStudyFramework] = useState('');
    const [importantGroup, setImportantGroup] = useState('');

    // 디자인
    const [whyDesign, setWhyDesign] = useState('');
    const [toolExperience, setToolExperience] = useState('');
    const [teamworkExperience, setTeamworkExperience] = useState('');
    const [designGrowth, setDesignGrowth] = useState('');

    const userModalState = useSelector((state: TestState) => state.fetcher.userModalState);
    const adminState = useSelector((state: TestState) => (state.fetcher.adminState));


    useEffect(() => {
        // console.log(position);
        // console.log(location);
        // console.log(userSid);

        if (adminState === false) {
            navigate('/error');
        }

        if (props.position === '프론트엔드') {
            setTrack("프론트엔드")
            axios.get(`/frontendApplication?sid=${props.sid}`)
                .then((res) => {
                    // console.log(res);
                    setName(res.data.name);
                    setSid(res.data.sid);
                    setDepartment(res.data.department);
                    setPhone(res.data.phoneNumber);
                    setState(res.data.passOrNot);
                    setEmail(res.data.email);

                    setMotive(res.data.motive);
                    setHardwork(res.data.hardWork);
                    setKeyword(res.data.keyWord);
                    setMostDeeplyWork(res.data.mostDeeplyWork);

                    setWhyFrontend(res.data.whyFrontend);
                    setUsingStack(res.data.usingStack);
                    setTeamProject(res.data.teamProject);
                    setAchieve(res.data.achieve);
                    setPortfolioLink(res.data.portfolioLink);
                })
        }

        if (props.position === '백엔드') {
            setTrack("백엔드")
            axios.get(`/backendApplication?sid=${props.sid}`)
                .then((res) => {
                    // console.log(res);
                    setName(res.data.name);
                    setSid(res.data.sid);
                    setDepartment(res.data.department);
                    setPhone(res.data.phoneNumber);
                    setState(res.data.passOrNot);
                    setEmail(res.data.email);

                    setMotive(res.data.motive);
                    setHardwork(res.data.hardWork);
                    setKeyword(res.data.keyWord);
                    setMostDeeplyWork(res.data.mostDeeplyWork);

                    setDifficultAndOvercoming(res.data.difficultAndOvercoming);
                    setStudyFramework(res.data.studyFramework);
                    setImportantGroup(res.data.importantGroup);
                    setPortfolioLink(res.data.portfolioLink);
                })
        }

        if (props.position === '디자인') {
            setTrack("디자인")
            axios.get(`/designApplication?sid=${props.sid}`)
                .then((res) => {
                    // console.log("디자인", res);
                    setName(res.data.name);
                    setSid(res.data.sid);
                    setDepartment(res.data.department);
                    setPhone(res.data.phoneNumber);
                    setState(res.data.passOrNot);
                    setEmail(res.data.email);

                    setMotive(res.data.motive);
                    setHardwork(res.data.hardWork);
                    setKeyword(res.data.keyWord);
                    setMostDeeplyWork(res.data.mostDeeplyWork);

                    setWhyDesign(res.data.whyDesign);
                    setToolExperience(res.data.toolExperience);
                    setTeamworkExperience(res.data.teamworkExperience);
                    setDesignGrowth(res.data.designGrowth);
                    setPortfolioLink(res.data.portfolioLink);
                })
        }
    }, []);

    const PassLogic = () => {
        if (props.position === '백엔드') {
            if (state === false) {
                if (window.confirm(`${name}님을 정말 합격처리 하시겠어요?`)) {
                    axios.put(`/backendApplication/changePassOrNot?sid=${props.sid}`)
                        .then((res) => {
                            alert(`${name}님의 합격처리가 되었습니다!`)
                            setState(true);
                            setButtonCount(0);
                            setButtonState(false);
                        })
                } else {
                    setButtonCount(0);
                    setButtonState(false);
                }
            } else {
                alert("이미 합격된 사용자입니다!");
                setButtonCount(0);
                setButtonState(false);
            }
        }
        if (props.position === '프론트엔드') {
            if (state === false) {
                if (window.confirm(`${name}님을 정말 합격처리 하시겠어요?`)) {
                    axios.put(`/frontendApplication/changePassOrNot?sid=${props.sid}`)
                        .then((res) => {
                            alert(`${name}님의 합격처리가 되었습니다!`)
                            setState(true);
                            setButtonCount(0);
                            setButtonState(false);
                        })
                } else {
                    setButtonCount(0);
                    setButtonState(false);
                }
            } else {
                alert("이미 합격된 사용자입니다!");
                setButtonCount(0);
                setButtonState(false);
            }
        }
        if (props.position === '디자인') {
            if (state === false) {
                if (window.confirm(`${name}님을 정말 합격처리 하시겠어요?`)) {
                    axios.put(`/designApplication/changePassOrNot?sid=${props.sid}`)
                        .then((res) => {
                            alert(`${name}님의 합격처리가 되었습니다!`)
                            setState(true);
                            setButtonCount(0);
                            setButtonState(false);
                        })
                } else {
                    setButtonCount(0);
                    setButtonState(false);
                }
            } else {
                alert("이미 합격된 사용자입니다!");
                setButtonCount(0);
                setButtonState(false);
            }
        }
    }

    const changePass = async () => {
        await setButtonCount((prev) => (prev + 1));
        await setButtonState(true);
        await PassLogic();
    }

    const FailLogic = () => {
        if (props.position === '백엔드') {
            if (state === true) {
                if (window.confirm(`${name}님을 정말 불합격처리 하시겠어요?`)) {
                    axios.put(`/backendApplication/changePassOrNot?sid=${props.sid}`)
                        .then((res) => {
                            alert(`${name}님의 불합격처리가 되었습니다!`)
                            setState(false);
                            setButtonCount(0);
                            setButtonState(false);
                        })
                } else {
                    setButtonCount(0);
                    setButtonState(false);
                }
            } else {
                alert("이미 불합격된 사용자입니다!");
                setButtonCount(0);
                setButtonState(false);
            }
        }
        if (props.position === '프론트엔드') {
            if (state === true) {
                if (window.confirm(`${name}님을 정말 불합격처리 하시겠어요?`)) {
                    axios.put(`/frontendApplication/changePassOrNot?sid=${props.sid}`)
                        .then((res) => {
                            alert(`${name}님의 불합격처리가 되었습니다!`)
                            setState(false);
                            setButtonCount(0);
                            setButtonState(false);
                        })
                } else {
                    setButtonCount(0);
                    setButtonState(false);
                }
            } else {
                alert("이미 불합격된 사용자입니다!");
                setButtonCount(0);
                setButtonState(false);
            }
        }
        if (props.position === '디자인') {
            if (state === true) {
                if (window.confirm(`${name}님을 정말 불합격처리 하시겠어요?`)) {
                    axios.put(`/designApplication/changePassOrNot?sid=${props.sid}`)
                        .then((res) => {
                            alert(`${name}님의 불합격처리가 되었습니다!`)
                            setState(false);
                            setButtonCount(0);
                            setButtonState(false);
                        })
                } else {
                    setButtonCount(0);
                    setButtonState(false);
                }
            } else {
                alert("이미 불합격된 사용자입니다!");
                setButtonCount(0);
                setButtonState(false);
            }
        }
    }

    const changeFail = async () => {
        await setButtonCount((prev) => (prev + 1));
        await setButtonState(true);
        await FailLogic();
    }

    const closeModal = async () => {
        await dispatch(saveModalState({ userModalState: false }))
    }

    return (
        <Section>
            {name ?
                <Article>
                    <Quit onClick={closeModal} />
                    <span css={css`
                        font-family: 'Pretendard-Regular';
                        color: #333D4B;
                        letter-spacing: -0.03em;
                        font-size: 1.56vw;
                    `}>
                        <span css={css`
                            font-family: 'Pretendard-Medium';
                            letter-spacing: -0.03em;
                        `}>{name}</span>
                        님의
                        <span css={css`
                            font-family: 'Pretendard-Medium';
                            letter-spacing: -0.03em;
                        `}> {track} </span>
                        지원서
                    </span>
                    <span css={css`
                        font-family: 'Pretendard-Medium';
                        color: #333D4B;
                        letter-spacing: -0.03em;
                        font-size: 0.78vw;
                        margin-bottom: 3em;
                    `}> 지원서 상태 :
                        <span css={css`
                            font-family: 'Pretendard-Bold';
                        `}> {state ? "합격" : "불합격"}</span>
                    </span>

                    <Answer name="이름">
                        {name}
                    </Answer>
                    <Answer name="학번">
                        {sid}
                    </Answer>
                    <Answer name="학과">
                        {department}
                    </Answer>
                    <Answer name="지원 트랙">
                        {track}
                    </Answer>
                    <Answer name="이메일">
                        {email}
                    </Answer>
                    <Answer name="연락처">
                        {phone}
                    </Answer>
                    <Answer name="지원자분의 인생의 최종 목표는 무엇인가요?">
                        {motive}
                    </Answer>
                    <Answer name="학교 공부를 제외하고 본인의 인생에 있어서 가장 열심히 했던 활동은 무엇인가요?">
                        {hardwork}
                    </Answer>
                    <Answer name="자신을 설명할 수 있는 키워드 3개와 그 이유에 대하여 설명해주세요">
                        {keyword}
                    </Answer>
                    <Answer name="최근에 가장 감명 깊었던 책 · 영화 · 노래가 있다면 하나를 선택해주시고, 그 이유에 대하여 설명해주세요">
                        {mostDeeplyWork}
                    </Answer>
                    {track === "프론트엔드" &&
                        <>
                            <Answer name="프론트엔드 트랙을 선택하게 된 이유를 구체적으로 서술해주세요">
                                {whyFrontend}
                            </Answer>
                            <Answer name="프론트엔드 개발과 관련된 프레임워크나 html, css, js 등의 언어를 사용해 보신 적 있으신가요? 있으시다면 어디까지 사용해 보셨는지 구체적으로 적어주세요.">
                                {usingStack}
                            </Answer>
                            <Answer name="팀 활동이나 프로젝트를 경험해본 내용과 이를 통해 자신의 성장 경험에 대해서 서술해주세요">
                                {teamProject}
                            </Answer>
                            <Answer name="멋사 프론트엔드 아기사자로 활동하면서 얻어 가고 싶은 것은 무엇인가요?">
                                {achieve}
                            </Answer>
                            <Answer name="포트폴리오 링크가 있다면 첨부해주세요">
                                {portfolioLink === '' ? "포트폴리오 미첨부" :
                                    <a href={portfolioLink} target="_blank">
                                        {portfolioLink}
                                    </a>
                                }
                            </Answer>
                        </>
                    }
                    {track === "백엔드" &&
                        <>
                            <Answer name="개발 관련 공부를 하며 개인적으로 힘들었던 경험과 그걸 극복했던 자신만의 방법이 있나요?">
                                {difficultAndOvercoming}
                            </Answer>
                            <Answer name="웹 백앤드 프레임워크를 공부해보신적 있으신가요? 있으시다면 어디까지 공부해보셨나요?">
                                {studyFramework}
                            </Answer>
                            <Answer name="단체생활에서 가장 중요하다고 생각하는 것은 무엇인가요?">
                                {importantGroup}
                            </Answer>
                            <Answer name="포트폴리오 링크가 있다면 첨부해주세요">
                                {portfolioLink === '' ? "포트폴리오 미첨부" :
                                    <a href={portfolioLink} target="_blank">
                                        {portfolioLink}
                                    </a>
                                }
                            </Answer>
                        </>
                    }
                    {track === "디자인" &&
                        <>
                            <Answer name="디자인 트랙을 선택하게 된 이유를 구체적으로 서술해주세요">
                                {whyDesign}
                            </Answer>
                            <Answer name="피그마나 Adobe XD와 같은 목업 툴에 관련된 경험을 해본 적이 있다면 그 경험에 대해 자세히 설명을 해주세요">
                                {toolExperience}
                            </Answer>
                            <Answer name="본인이 협업과 팀워크를 진행해 보았던 경험과, 그 경험을 멋쟁이 사자처럼 대학에서 어떻게 적용시킬 수 있는지 알려주세요">
                                {teamworkExperience}
                            </Answer>
                            <Answer name="디자인 트랙을 통해 어떠한 성장을 희망하시는지 구체적으로 서술해주세요">
                                {designGrowth}
                            </Answer>
                            <Answer name="포트폴리오 링크가 있다면 첨부해주세요">
                                {portfolioLink === '' ? "포트폴리오 미첨부" :
                                    <a href={portfolioLink} target="_blank">
                                        {portfolioLink}
                                    </a>
                                }
                            </Answer>
                        </>
                    }
                    <ButtonBox>
                        <Button name="임시저장" onClick={closeModal}>{buttonCount >= 1 ? `잠시만 기다려주세요...` : `뒤로가기`}</Button>
                        <Button name="제출하기" disabled={buttonState} onClick={changePass}>{buttonCount >= 1 ? `잠시만 기다려주세요...` : `합격처리`}</Button>
                        <Button name="제출하기" disabled={buttonState} onClick={changeFail}>{buttonCount >= 1 ? `잠시만 기다려주세요...` : `불합격처리`}</Button>
                    </ButtonBox>
                </Article>
                : <Loading />
            }
        </Section >
    )
}
