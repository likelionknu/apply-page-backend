/** @jsxImportSource @emotion/react */
import { css, keyframes } from "@emotion/react";
import React from 'react'
import { Button, Modal, Section } from '../emotion/component'
import oops from '../../images/oops.png';
import { Link } from "react-router-dom";
import { fadeUp } from "../../styles/Keyframes";

export default function Error() {
    return (
        <div css={css`
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);

            display: flex;
            flex-direction: column;
            align-items: center;
        `}>
            <img alt="404" src={oops} css={css`
                width: 8.5em;
                animation: ${fadeUp} 1s ease-in-out;
            `} />
            <span css={css`
                font-family: 'Pretendard-Bold';
                letter-spacing: -0.03em;
                color: #333d4b;
                margin-top: 1em;
                font-size: 15px;
                animation: ${fadeUp} 1s ease-in-out;
            `}>웁스웁스, 잘못된 접근을 하셨어요!</span>
            <Link to='/'>
                <button css={css`
                font-family: 'Pretendard-Bold';
                letter-spacing: -0.03em;
                font-size: 14px;
                width: 16em;
                height: 3.5em;
                border: none;
                border-radius: 7px;
                color: white;
                background-color: #4F85E8;
                cursor: pointer;
                transition: 0.5s all;
                margin-top: 2em;
                animation: ${fadeUp} 1s ease-in-out;

                &:hover {
                    opacity: 80%;
                }
            `}> 메인화면으로 </button>
            </Link>
        </div>
    )
}
