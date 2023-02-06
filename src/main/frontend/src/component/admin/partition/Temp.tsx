import React, { useMemo } from 'react'
import { Content, List, ListType, NotData, Section, onModalType } from '../emotion/component'
import { Position, PositionBox } from '../emotion/component';
import { frontendDummy, backendDummy, designDummy } from './dummy';
import { useState } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
import axios from 'axios';
import { userType } from './Type';
import { Loading, Modal } from '../../emotion/component';
import Header from '../common/Header';
import Detail from '../detail/Detail';
import { useDispatch, useSelector } from 'react-redux';
import { TestState } from '../../../app/store';
import { saveModalState } from '../../../features/fetcherSlice';

export default function Temp() {

    const [position, setPosition] = useState<string>('백엔드');
    const [frontend, setFrontend] = useState<[]>([]);
    const [backend, setBackend] = useState<[]>([]);
    const [design, setDesign] = useState<[]>([]);

    const [backendState, setBackendState] = useState<boolean | null>(true);
    const [frontendState, setFrontendState] = useState<boolean | null>(true);
    const [designState, setDesignState] = useState<boolean | null>(true);
    const [clickState, setClickState] = useState<boolean>(false);
    const [sid, setSid] = useState<string>('');
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const userModalState = useSelector((state: TestState) => state.fetcher.userModalState);
    const adminState = useSelector((state: TestState) => (state.fetcher.adminState));

    useEffect(() => {

        if (adminState === false) {
            navigate('/error');
        }

        dispatch(saveModalState(false));
        axios.get('/backendApplication/getSubmissionApplications?bool=false')
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

    function CheckPosition(event: React.MouseEvent<HTMLButtonElement>): void {
        const name = (event.target as HTMLButtonElement).name;
        setPosition(name);

        if (name === "백엔드") {
            axios.get('/backendApplication/getSubmissionApplications?bool=false')
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
            axios.get('/frontendApplication/getSubmissionApplications?bool=false')
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
            axios.get('/designApplication/getSubmissionApplications?bool=false')
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
        await setSid(userID);
        await dispatch(saveModalState({ userModalState: true }))
    }

    return (
        <>
            {
                !userModalState ?
                    <Content>
                        < PositionBox >
                            <Position name="백엔드" onClick={CheckPosition} state={position}>백엔드</Position>
                            <Position name="프론트엔드" onClick={CheckPosition} state={position}>프론트엔드</Position>
                            <Position name="디자인" onClick={CheckPosition} state={position}>디자인</Position>
                        </PositionBox >
                        <List check="체크 없음" name="이름" position="트랙" department="학과" id="학번" email="이메일" />
                        {/* 백엔드 로직 */}
                        {position === '백엔드' && backendState && <Loading />}
                        {
                            position === '백엔드' && backend.length >= 1 && backend.map((item: userType) => {
                                return (
                                    <List check="체크 없음" key={item.sid} name={item.name} position={position} department={item.department} id={item.sid} email={item.email} onClick={() => onModal(item.sid)} />
                                )
                            })
                        }
                        {position === '백엔드' && backendState === false && <NotData />}

                        {/* 프론트엔드 로직 */}
                        {position === '프론트엔드' && frontendState && <Loading />}
                        {
                            position === '프론트엔드' && frontend.length >= 1 && frontend.map((item: userType) => {
                                return (
                                    <List check="체크 없음" key={item.sid} name={item.name} position={position} department={item.department} id={item.sid} email={item.email} onClick={() => onModal(item.sid)} />
                                )
                            })
                        }
                        {position === '프론트엔드' && frontendState === false && <NotData />}

                        {/* 디자인 로직 */}
                        {position === '디자인' && designState && <Loading />}
                        {
                            position === '디자인' && design.length >= 1 && design.map((item: userType) => {
                                return (
                                    <List check="체크 없음" key={item.sid} name={item.name} position={position} department={item.department} id={item.sid} email={item.email} onClick={() => onModal(item.sid)} />
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
