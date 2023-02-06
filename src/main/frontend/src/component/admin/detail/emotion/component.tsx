/** @jsxImportSource @emotion/react */
import React, { useEffect, useState } from 'react'
import { css, keyframes } from "@emotion/react";
import { Link, useLocation } from 'react-router-dom';
import oops from '../../../images/oops.png';
import { WrapperProps } from '../../../../App';
import { InputType } from '../../../emotion/component';
import { ButtonType } from '../../../emotion/component';
import quit from '../../../../images/quit.png';
import { ImgClickType } from '../Type';


export const Section = ({ children }: WrapperProps) => {
    return (
        <div
            css={css`
                position: absolute;
                left: 50%;
                transform: translate(-50%);
                font-size: 0.95vw;
                display: flex;
                flex-direction: column;
                align-items: center;          
                width: 60em;
                height: 100%;
                background-color: white;
                border-radius: 0.93em;
                margin-top: 4em;
            `}>
            {children}
        </div>
    )
}

export const Quit = (props: ImgClickType) => {
    return (
        <img alt="뒤로가기" onClick={props.onClick} src={quit} css={css`
            width: 2em;
            cursor: pointer;
            transition: 0.4s all;
            margin-bottom: 1em;

            &:hover {
                opacity: 60%;
            }
        `} />
    )
}

export const Article = ({ children }: WrapperProps) => {
    return (
        <article css={css`
            padding-top: 3em;
            padding-bottom: 5em;
            background-color: white;
            width: 100%;
            border: solid;
            display: flex;
            border-color: #4e5968;
            flex-direction: column;
            align-items: center;
            row-gap: 2em;
            border-radius: 0.625em;
        `}>
            {children}
        </article>
    )
}

export interface AnswerType {
    name?: string;
    children?: React.ReactNode;
}

export const Answer = (props: AnswerType) => {
    return (
        <div css={css`
            display: flex;
            flex-direction: column;
            text-align: left;
            row-gap: 0.5em;
        `}>
            <span css={css`
                    font-family: 'Pretendard-Medium';
                    letter-spacing: -0.03em;
                    font-size: 0.83vw;
                    color: #4e5968;
            `}> {props.name}</span>
            <div css={css`
        font-family: 'Pretendard-Medium';
        letter-spacing: -0.03em;
        padding: 0;
        padding-left: 1em;
        width: 60em;
        padding: 1em;
        border: solid;
        border-color: #e6e8ea;
        font-size: 0.83vw;
        border-radius: 0.57em;
        line-height: 1.5em;
        border-width: 0.07em;
        box-sizing: border-box;
        white-space: pre-wrap;

        display: flex;
        align-items: center;
        justify-content: left;

        `}>
                {props.children}
            </div>
        </div>
    )
}

export const ButtonBox = (props: WrapperProps) => {
    return (
        <div css={css`
            display: flex;
            column-gap: 1em;
            margin-top: 1em;
            ${props.alt === "임시저장_모달" && css`margin-top: 2em;`}
        `}>
            {props.children}
        </div>
    )
}


export const Button = (props: ButtonType) => {
    return (
        <button css={css`
            font-family: 'Pretendard-Bold';
            letter-spacing: -0.03em;
            font-size: 0.83vw;
            width: 15em;
            height: 3.5em;
            transition: 0.5s all;
            ${props.alt === "불러오기" && css`
                width: 7.5em;
                font-size: 0.83vw;
            `}
            border: none;
            border-radius: 0.5em;
            color: white;
            transition: 0.5s all;
            ${props.name === "임시저장" && `background-color : #262626;`}
            ${props.name === "제출하기" && `background-color : #4F85E8;`}
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
        `} tabIndex={-1} {...props}>
            {props.children}
        </button>
    )
}