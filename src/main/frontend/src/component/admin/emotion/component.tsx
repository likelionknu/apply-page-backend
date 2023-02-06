/** @jsxImportSource @emotion/react */
import React, { useCallback, useEffect, useMemo, useState } from 'react'
import { WrapperProps } from '../../../App'
import { css, keyframes } from "@emotion/react";
import { AgreeType, ButtonType, InputType } from '../../emotion/component';
import { PositionType } from '../../emotion/component';
import { Link, useLocation } from 'react-router-dom';
import oops from '../../../images/oops.png';
import { fadeUp } from '../../../styles/Keyframes';
import { MailType, mailUserType } from '../partition/Type';
import checkBox from '../../../images/checkBox.svg';
import checkedBox from '../../../images/checkedBox.svg';
import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch, TestState } from '../../../app/store';
import { updatePassMailList } from '../../../features/fetcherSlice';

export const Section = ({ children }: WrapperProps) => {
    return (
        <div
            css={css`
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);

                display: flex;
                flex-direction: column;
                align-items: center;
            `}>
            {children}
        </div>
    )
}

export const LoginBox = ({ children }: WrapperProps) => {
    return (
        <div css={css`
            display: flex;
            flex-direction: column;
            row-gap: 1em;
            align-items: center;
        `}>
            {children}
        </div>
    )
}

export const PassUserContent = ({ children }: WrapperProps) => {
    return (
        <div css={css`
        border: solid;

        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 0.77vw;

        height: 2em;
        padding: 0.2em 1.6em 0.2em 1.6em;
        border-radius: 3.07em;

        border-color: #4F85E8;
        color: #4F85E8;
    `}>
            {children}
        </div>

    )
}

export const PassUser = ({ children }: WrapperProps) => {
    return (
        <div css={css`
                display: flex;
                justify-content: left;
                align-items: center;
                width: 34em;
                flex-wrap: wrap;
                white-space:normal;
                font-size: 0.77vw;  
                white-space: pre-line; 
                column-gap: 1em;
                row-gap: 1em;
                margin-bottom: 1.7em;
            `}>
            {children}
        </div>
    )
}

export const Content = ({ children }: WrapperProps) => {
    return (
        <section css={css`
            display: flex;
            flex-direction: column;
            align-items: center;
        `}>
            {children}
        </section>
    )
}


export const FailMailSend = (props: MailType) => {
    return (
        <div css={css`
            margin-top: -3em;
            margin-bottom: 3em;
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            font-size: 0.83vw;
            color: #4F85E8;
            cursor: pointer;
            transition: 0.4s all;

            &:hover {
                opacity: 80%;
            }

        `} {...props}> <span css={css`
            font-family: 'Pretendard-Bold';
        `}>{props.position}</span> 포지션의 불합격 메일 전체 전송을 하고싶으신가요? </div>
    )
}

export const PassMailSend = (props: MailType) => {

    const passMailList = useSelector((state: TestState) => state.fetcher.passMailList);

    return (
        <div css={css`
            margin-top: -3em;
            margin-bottom: 3em;
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            font-size: 0.83vw;
            color: #4F85E8;
            cursor: pointer;
            transition: 0.4s all;

            &:hover {
                opacity: 80%;
            }

        `} {...props}> <span css={css`
            font-family: 'Pretendard-Bold';
        `}>{props.position}</span> 포지션의 합격 메일 전송을 하고싶으신가요?</div>
    )
}

export const Button = (props: ButtonType) => {
    return (
        <button css={css`
            font-size: 0.77vw;
            width: 26em;
            height: 3.5em;
            border-radius: 0.53em;
            border: none;
            font-family: 'Pretendard-Bold';
            letter-spacing: -0.03em;
            padding-left: 1em;
            color: white;
            transition: 0.5s all;
            cursor: pointer;

            background-color: #4F85E8;

            &:hover {
                opacity: 80%;
            }
        `}{...props}>{props.children}</button>
    )
}

export interface HeaderType {
    path?: string;
    children?: React.ReactNode;
    url?: string;
}

export const HeaderText = (props: HeaderType) => {
    return (
        <div css={css`
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            width: 9em;
            border:none;
            padding-bottom: 0.7em;
            border-width: 0.17em;
            font-size: 1.01vw;
            text-decoration: none;
            color: #4e5968;
            cursor: pointer;

            &:hover {
                border:solid;
                border-top: 0;
                border-left: 0;
                border-right: 0;
                border: color;
                border-bottom: 0.12em solid #4e5968;
                margin-bottom: -0.12em;
            }

            ${props.path === props.url && css`
                border:solid;
                border-top: 0;
                border-left: 0;
                border-right: 0;
                border: color;
                color: #4F85E8;
                border-bottom: 0.12em solid #4F85E8;
                margin-bottom: -0.12em;

                &:hover {
                    border:solid;
                    border-top: 0;
                    border-left: 0;
                    border-right: 0;
                    border: color;
                    border-bottom: 0.12em solid #4F85E8;
                    margin-bottom: -0.12em;
                }
            `}
        `} tabIndex={-1}>{props.children}</div>
    )
}

interface ImgType {
    src?: string;
}

export const Img = (props: ImgType) => {
    return (
        <img css={css`
            font-size: 0.95vw;
            width: 16em;
            margin-bottom: 1em;
        `} alt="어드민 이미지" src={props.src} />
    )
}

export const Position = (props: PositionType) => {
    return (
        <button css={css`
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            height: 3.7em;
            font-size: 0.77vw;
            ${props.alt === "모달" && css`height: 3em;`} 
            ${props.alt === "모달" && css`font-size: 0.83vw;`} 
            border-radius: 50px;
            border: solid;
            border-width: 1px;
            border-color: #e6e8ea;
            transition: 0.5s all;
            cursor: pointer;

            ${props.name === props.state ? css`
            color: white;
            background-color: #4F85E8;
            border: none;
            ` : css`
            background-color: transparent;
            color: #707070;
            border-color: #e6e8ea;

            &:hover {
                border-color: #4F85E8;
                color:  #4F85E8;
            }
            &:focus {
                outline: none;
                border-color: #4F85E8;
                color:  #4F85E8;
            }
            `}
        `}{...props} tabIndex={-1}>{props.children}</button>
    )
}

export const NotData = () => {
    return (
        <>
            <img src={oops} alt="Oops!" css={css`
                margin-top: 3em;
                width: 7em;
                animation: ${fadeUp} 1s ease-in-out;
            `} />
            <span css={css`
        font-family: 'Pretendard-Bold';
        letter-spacing: -0.03em;
        color: white;
        font-size: 14px;
        margin-top: 1em;
        animation: ${fadeUp} 1s ease-in-out;
        `}>
                데이터가 존재하지 않아요!
            </span>
        </>
    )
}

export const PositionBox = (props: WrapperProps) => {
    return (
        <div css={css`
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            column-gap: 2em;
            font-size: 0.71vw;
            width: 55.5em;
            margin-top: 4em;
            margin-bottom: 8em;
            ${props.alt === "모달" && css`width: 30em;`} 
        `}>
            {props.children}
        </div>
    )
}

export const Input = (props: InputType) => {
    return (
        <input placeholder={props.placeholder} css={css`
            font-size: 0.77vw;
            width: 25em;
            height: 3.5em;
            border-radius: 0.53em;
            border: solid;
            border-color: #e6e8ea;
            border-width: 0.0714em;
            font-family: 'Pretendard-Regular';
            letter-spacing: -0.03em;
            padding-left: 1em;

            &::-webkit-outer-spin-button,
            &::-webkit-inner-spin-button {
                -webkit-appearance: none;
                margin: 0;
            }
    
            &:focus {
                outline-style: solid;
                outline-width: 0.15em;
                outline-color: #4F85E8;
            }
    
            &::placeholder {
                font-family: 'Pretendard-Regular';
                margin-left: 0.4em;
            }
        `} {...props} />
    )
}

export interface ChangeCheckStateType {
    (userName: string, userEmail: string, userId: string): void;
}

export interface ListType {
    name?: string;
    id?: string;
    department?: string;
    email?: string;
    position?: string;
    check?: string;
    onClick?: (event: React.MouseEvent<HTMLDivElement>) => void;
    children?: React.ReactNode;
    mailState?: boolean;
}

export interface onModalType {
    (userID: string): void;
}

export const List = React.memo(function List(props: ListType) {

    const [checkState, setCheckState] = useState<boolean>(false);
    const [checkList, setCheckList] = useState<mailUserType[]>([]);
    const [userEmail, setEmail] = useState<string>('');
    const [userName, setName] = useState<string>('');
    const [userId, setId] = useState<string>('');

    const dispatch = useDispatch<AppDispatch>();
    const passMailList = useSelector((state: TestState) => state.fetcher.passMailList);
    const newList = useSelector((state: TestState) => (state.fetcher.newList));

    const ChangeCheckState: ChangeCheckStateType = useCallback((userEmail: string, userName: string, userId: string) => {
        setCheckState(!checkState);
        setEmail(userEmail);
        setName(userName);
        setId(userId);
        // await setCheckList(user)
        // 전역 상태로 업데이트 할 것!
    }, [checkState]);

    useEffect(() => {
        setCheckState(false);
    }, [newList])

    useEffect(() => {
        if (checkState) {
            dispatch(updatePassMailList([...passMailList, { id: userId as string, name: userName as string, email: userEmail as string }]))
        } else if (!checkState) {
            dispatch(updatePassMailList(passMailList.filter((items: mailUserType) => { return items.id !== userId })))
        }
    }, [checkState])

    return (
        <div css={css`
            font-family: 'Pretendard-Medium';
            font-size: 0.83vw;
            letter-spacing: -0.03em;
            color: #4e5968;

            display: flex;
            justify-content: center;
            border: solid;
            border-top: 0;
            border-left: 0;
            border-right: 0;
            margin-bottom: 1em;
            padding-bottom: 1em;
            box-sizing: border-box;
            transition: 0.4s all;
            border-width: 0.08em;

            ${props.name !== "이름" && css`
                &:hover {
                    opacity: 80%;
                    cursor: pointer;
                }
            `}

            ${checkState && css`
                color: #4F85E8;
                border-color: #4F85E8;
                cursor: pointer;
            `}
        `}>
            <ListText onClick={props.onClick}>{props.name}</ListText>
            <ListText onClick={props.onClick}>{props.position}</ListText>
            <ListText onClick={props.onClick}>{props.department}</ListText>
            <ListText onClick={props.onClick}>
                {props.id !== "학번" && props.mailState ? <span css={css` color: #11BD7E `}> {props.id} </span> : props.id}
            </ListText>
            {/* <ListText onClick={props.onClick}>{props.email}</ListText> */}
            {props.check === "체크 없음" && null}
            {props.check === "전송 체크" ? <ListText> {props.check} </ListText> : !props.check && <ListText onClick={() => ChangeCheckState(props.email as string, props.name as string, props.id as string)}> <img src={checkState ? checkedBox : checkBox} css={css` width : 1.2em; `} /> </ListText>}
        </div>
    )
});

export const ListText = (props: ListType) => {
    return (
        <div css={css`
            width: 16em;
            display: flex;
            align-items: center;
            justify-content: center;
        `} {...props}>
            {props.children}
        </div>
    )
}
