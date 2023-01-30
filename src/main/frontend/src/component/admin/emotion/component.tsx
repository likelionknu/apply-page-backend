/** @jsxImportSource @emotion/react */
import React, { useEffect, useState } from 'react'
import { WrapperProps } from '../../../App'
import { css, keyframes } from "@emotion/react";
import { AgreeType, ButtonType, InputType } from '../../emotion/component';
import { PositionType } from '../../emotion/component';
import { Link, useLocation } from 'react-router-dom';
import oops from '../../../images/oops.png';
import { fadeUp } from '../../../styles/Keyframes';

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

export const Button = (props: ButtonType) => {
    return (
        <button css={css`
            font-size: 15px;
            width: 26em;
            height: 3.5em;
            border-radius: 7px;
            font-size: 15px;
            border: none;
            font-family: 'Pretendard-Bold';
            letter-spacing: -0.03em;
            padding-left: 1em;
            color: white;
            transition: 0.5s all;
            cursor: pointer;

            background-color: #ff7828;

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
            font-family: 'Pretendard-Bold';
            letter-spacing: -0.03em;
            width: 9em;
            border:none;
            padding-bottom: 0.7em;
            border-width: 0.17em;
            font-size: 17px;
            text-decoration: none;
            color: white;
            cursor: pointer;

            &:hover {
                border:solid;
                border-top: 0;
                border-left: 0;
                border-right: 0;
                border: color;
                border-bottom: 0.12em solid white;
                margin-bottom: -0.12em;
            }

            ${props.path === props.url && css`
                border:solid;
                border-top: 0;
                border-left: 0;
                border-right: 0;
                border: color;
                color: #ff7828;
                border-bottom: 0.12em solid #ff7828;
                margin-bottom: -0.12em;

                &:hover {
                    border:solid;
                    border-top: 0;
                    border-left: 0;
                    border-right: 0;
                    border: color;
                    border-bottom: 0.12em solid #ff7828;
                    margin-bottom: -0.12em;
                }
            `}
        `}>{props.children}</div>
    )
}

interface ImgType {
    src?: string;
}

export const Img = (props: ImgType) => {
    return (
        <img css={css`
            width: 9em;
        `} alt="어드민 이미지" src={props.src} />
    )
}

export const Position = (props: PositionType) => {
    return (
        <button css={css`
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            height: 3.7em;
            ${props.alt === "모달" && css`height: 3em;`} 
            ${props.alt === "모달" && css`font-size: 14px;`} 
            border-radius: 50px;
            border: solid;
            border-width: 1px;
            border-color: #707070;
            transition: 0.5s all;
            cursor: pointer;

            ${props.name === props.state ? css`
            color: white;
            background-color: #ff7828;
            border: none;
            ` : css`
            background-color: transparent;
            color: white;
            border-color: white;

            &:hover {
                border-color: #ff7828;
                color:  #ff7828;
            }
            &:focus {
                outline: none;
                border-color: #ff7828;
                color:  #ff7828;
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
            font-size: 12px;
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
            width: 25em;
            height: 3.5em;
            border-radius: 7px;
            font-size: 15px;
            border: none;
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
                outline-width: 2.5px;
                outline-color: #ff7828;
            }
    
            &::placeholder {
                font-family: 'Pretendard-Regular';
                margin-left: 0.4em;
            }
        `} {...props} />
    )
}

export interface ListType {
    name?: string;
    id?: string;
    department?: string;
    email?: string;
    position?: string;
    onClick?: (event: React.MouseEvent<HTMLDivElement>) => void;
    children?: React.ReactNode;
}

export interface onModalType {
    (userID: string): void;
}

export const List = (props: ListType) => {
    return (
        <div css={css`
            font-family: 'Pretendard-Bold';
            font-size: 14px;
            letter-spacing: -0.03em;
            color: white;

            display: flex;
            justify-content: center;
            border: solid;
            border-top: 0;
            border-left: 0;
            border-right: 0;
            margin-bottom: 1em;
            padding-bottom: 1em;
            box-sizing: border-box;

            ${props.name !== "이름" && css`
                &:hover {
                    color: #ff7828;
                    border-color: white;
                    cursor: pointer;
                }
            `}
        `} onClick={props.onClick}>
            <ListText onClick={props.onClick}>{props.name}</ListText>
            <ListText onClick={props.onClick}>{props.position}</ListText>
            <ListText onClick={props.onClick}>{props.department}</ListText>
            <ListText onClick={props.onClick}>{props.id}</ListText>
            <ListText onClick={props.onClick}>{props.email}</ListText>
        </div>
    )
}

export const ListText = (props: ListType) => {
    return (
        <div css={css`
            width: 18em;
            display: flex;
            align-items: center;
            justify-content: center;
        `} {...props}>
            {props.children}
        </div>
    )
}
