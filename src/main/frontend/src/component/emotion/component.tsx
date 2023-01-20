/** @jsxImportSource @emotion/react */
import React, { ChangeEvent, useState } from 'react'
import banner from '../../images/banner.png';
import loading from '../../images/loading.gif';
import axios from 'axios';
import checkBox from '../images/checkBox.svg';
import checkedBox from '../images/checkedBox.svg';
import { useMemo } from 'react';
import { css, keyframes } from "@emotion/react";
import { fadeLeft, fadeUp } from "../../styles/Keyframes";
import { WrapperProps } from "../../App"
import human from '../../images/human.png';


export const TextAreaBox = (props: TextAreaType) => {
    return (
        <textarea css={css`
        font-family: 'Pretendard-Medium';
        letter-spacing: -0.03em;
        line-height: 1.5em;
        padding: 0;
        padding-left: 1em;
        padding-bottom: 1em;
        padding-right: 1em;
        padding-top: 1em;
        width: 62.5em;
        height: 15em;
        border: solid;
        border-radius: 15px;
        border-color: #707070;
        border-width: 1px;
        font-size: 16px;
        box-sizing: border-box;
        resize: none;

        &:focus {
            outline-color: #ff7828;
        }

        &::placeholder {
            font-family: 'Pretendard-Regular';
            margin-left: 0.4em;
        }
        `} maxLength={1000} {...props} />
    )
}

export const UploadButton = () => {
    return (
        <div css={css`
            position: absolute;
            font-family: 'Pretendard-Bold';
            letter-spacing: -0.03em;
            font-size: 15px;
            border: none;
            border-radius: 7px;
            width: 5.8em;
            height: 2em;       
            background-color: #ff7828;     
            margin-left: 59em;

            display: flex;
            align-items: center;
            justify-content: center;

            cursor: pointer;
            transition: 0.5s all;

            &:hover {
                opacity: 80%;
            }
        `}>
            <span css={css`
                color: white;
            `}>업로드</span>
        </div>
    )
}

export const InputBox = (props: InputType) => {
    return (
        <input css={css`
        font-family: 'Pretendard-Medium';
        letter-spacing: -0.03em;
        padding: 0;
        padding-left: 1em;
        width: 62.5em;
        height: 3.7em;
        border: solid;
        border-radius: 15px;
        border-color: #707070;
        border-width: 1px;
        font-size: 16px;
        box-sizing: border-box;

        &::-webkit-outer-spin-button,
        &::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        &:focus {
            outline-color: #ff7828;
        }

        &::placeholder {
            font-family: 'Pretendard-Regular';
            margin-left: 0.4em;
        }
        `} maxLength={30} {...props} />
    )
}

export interface PositionType {
    name: string;
    onClick: (event: React.MouseEvent<HTMLButtonElement>) => void;
    children: React.ReactNode;
    state: string;
}

export const Position = (props: PositionType) => {
    return (
        <button css={css`
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            font-size: 16px;
            height: 3.7em;
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
            background-color: white;
            color: #707070;

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
        `}{...props}>{props.children}</button>
    )
}

export const ModalFrame = ({ children }: WrapperProps) => {
    return (
        <div css={css`
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.4);
        z-index: 999;
        cursor: pointer;
        display: block;
        `}>
            {children}
        </div>
    )
}

export const Modal = ({ children }: WrapperProps) => {
    return (
        <ModalFrame>
            <div css={css`
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
            `}>
                <div css={css`
                    font-family: 'Pretendard-Bold';
                    letter-spacing: -0.03em;
                    border-radius: 20px;
                    background-color: white;
                    display: fixed;
                    font-size: 18px;
                    width: 40em;
                    height: 30em;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    animation: ${fadeUp} 1s ease-in-out;
                `}>
                    <div css={css`
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        animation: ${fadeUp} 1.3s ease-in-out;
                    `}>
                        <img alt="사람" src={human} css={css`
                            width: 10em;
                            margin-bottom: 2em;
                            animation: ${fadeUp} 1.5s ease-in-out;
                        `} />
                        <span css={css`
                            animation: ${fadeUp} 1.5s ease-in-out;
                        `}>앗, 임시저장된 지원서가 발견되었어요 다시 작성할까요?</span>
                        <ButtonBox>
                            {children}
                        </ButtonBox>
                    </div>
                </div>
            </div>
        </ModalFrame>
    )
}

export const Precautions = () => {
    return (
        <div css={css`
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            display: flex;
            flex-direction: column;
            text-align: left;
            font-size: 16px;
            width: 62.5em;
        `}>
            <InputTitle>주의사항 <Require /> </InputTitle>
            <div css={css`
                display: flex;
                flex-direction: column;
                row-gap: 0.5em;
            `}>
                <span>· 지원서 최종 제출 후에도 지원서의 수정은 가능합니다.</span>
                <span>· 지원서의 정보 저장을 위해 제출 전 임시저장을 통해 데이터를 저장해주시기 바랍니다.</span>
                <span>· 지원서 접수 마감일에는 지원자가 몰려 지원이 어려울 수 있으니, 여유있게 미리 제출해주시기바랍니다.</span>
                <span>· 지원서의 내용이 사실과 다를 경우, 합격이 취소되거나 전형 상의 불이익을 받을 수 있습니다.</span>
                <span>· 지원서는 문항별 최대 1000자의 제한을 두고 있으나, 문항을 다 채우실 필요는 없습니다.</span>
                <span>· 문의사항은 <strong>kangnam@likelion.org</strong> 으로 문의해주시면 최대한 빠르게 도와드리겠습니다.</span>
            </div>
        </div >
    )
}

export const PositionBox = ({ children }: WrapperProps) => {
    return (
        <div css={css`
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            column-gap: 1em;
            font-size: 16px;
            width: 62.5em;
        `}>
            {children}
        </div>
    )
}

// 로딩중을 표시하는 컴포넌트
export const Loading = () => {
    return (
        <img alt="로딩 이미지" src={loading} css={css`
            width: 12em;
        `} />
    )
}

export const WordLength = ({ children }: WrapperProps) => {
    return (
        <div css={css`
            width: 10em;
            position: absolute;
            text-align:center;
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            font-size: 15px;
            color: #ff7828;
            margin-top: 16em;
            margin-left: 57em;

            display:flex;
            justify-content: center;
            align-items: center;
        `}>
            <div css={css`
                width: 2.5em;
                border-box: box-sizing;
            `}>
                {children}
            </div>
            <span css={css`
                margin-right: 0.5em;
            `}>/</span>
            <span css={css`
            `}>1000</span>
        </div>
    )
}

export const Require = () => {
    return (
        <span css={css`
            margin-left: 0.4em;
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.02em;
            font-size: 15px;
            color: #ff0000;
        `}>* </span>
    )
}

export interface AgreeType {
    src: string;
    text: string;
    onClick?: (event: React.MouseEvent<HTMLImageElement>) => void;
    name: string;
}

export const ArgreeBox = ({ children }: WrapperProps) => {
    return (
        <div css={css`
            display: flex;
            flex-direction: column;
            margin-top: 1.3em;
            row-gap: 0.6em;
        `}>
            {children}
        </div>
    )
}

export const Argree = ((props: AgreeType) => {
    return (
        <div css={css`
            display: flex;
            flex-direction: column;
            width: 62.5em;
        `}>
            <div css={css`
                display: flex;
                align-items: center;
            `}>
                <img alt={props.name} onClick={props.onClick} src={props.src} css={css`
                    width: 1.2em;
                    cursor: pointer;
                `} />
                <span css={css`
                    font-size: 16px;
                    font-family: 'Pretendard-Medium';
                    letter-spacing: -0.03em;
                    margin-left: 0.4em;
                `}>{props.text}<Require /></span>
            </div>
        </div>
    )
})

export const Banner = () => {
    return (
        <img alt="배너 이미지" src={banner} css={css`
            margin-top: 40px;
            max-width: 1000px;
            border-radius: 12px;
            margin-bottom: 1em;
            animation: ${fadeLeft} 1.8s ease-in-out;
        `} />
    )
}

export const Section = ({ children }: WrapperProps) => {
    return (
        <section css={css`
            position: absolute;
            left: 50%;
            transform: translate(-50%);
            max-width: 75em;
            width: 100%;
            background-color: white;

            display: flex;
            flex-direction: column;
            align-items: center;
            padding-bottom: 5em;
            row-gap: 1.2em;
        `}>
            {children}
        </section>
    )
}

export const InputTitle = ({ children }: WrapperProps) => {
    return (
        <p css={css`
            font-family: 'Pretendard-Bold';
            letter-spacing: -0.03em;
            font-size: 16px;

            display: flex;
            align-items: center;
        `}>
            {children}
        </p>
    )
}

export const Article = ({ children }: WrapperProps) => {
    return (
        <article css={css`
            display: flex;
            flex-direction: column;
            text-align: left;
            justify-content: center;
            animation: ${fadeUp} 2s ease-in-out;
        `}>
            {children}
        </article>
    )
}

export interface ButtonType {
    name: string;
    children: React.ReactNode;
    disabled?: boolean;
    onClick?: () => void;
}

export const Button = (props: ButtonType) => {
    return (
        <button css={css`
            font-family: 'Pretendard-Bold';
            letter-spacing: -0.03em;
            font-size: 16px;
            width: 15em;
            height: 3.5em;
            border: none;
            border-radius: 7px;
            color: white;
            transition: 0.5s all;
            ${props.name === "임시저장" && `background-color : #262626;`}
            ${props.name === "제출하기" && `background-color : #ff7828;`}
            ${props.disabled ?
                css`
                    cursor: auto;
                    filter: grayscale(100%);
                ` :
                css`
                    cursor: pointer;
                    &:hover {
                        opacity: 80%;
                    }
                    `
            }
        `} {...props}>
            {props.children}
        </button>
    )
}

export const ButtonBox = ({ children }: WrapperProps) => {
    return (
        <div css={css`
            display: flex;
            column-gap: 1em;
            margin-top: 3em;
            animation: ${fadeUp} 2s ease-in-out;
        `}>
            {children}
        </div>
    )
}

export interface InputType {
    type?: string;
    placeholder?: string;
    value?: string | number;
    disabled?: boolean;
    maxLength?: number;
    name?: string;
    onChange?: (event: ChangeEvent<HTMLInputElement>) => void;
}

export interface TextAreaType {
    type?: string;
    placeholder?: string;
    value?: string;
    disabled?: boolean;
    maxLength?: number;
    name?: string;
    onChange?: (event: ChangeEvent<HTMLTextAreaElement>) => void;
}
