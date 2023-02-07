/** @jsxImportSource @emotion/react */
import { css, keyframes } from "@emotion/react";
import React from 'react'
import { Button, Modal, Section } from '../emotion/component'
import oops from '../../images/oops.png';
import { Link } from "react-router-dom";
import { fadeUp } from "../../styles/Keyframes";

export default function NotWidth() {
    return (
        <div css={css`
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 60%;

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
                font-size: .88vw;
                animation: ${fadeUp} 1s ease-in-out;
            `}>원활한 지원환경을 PC 또는 태블릿으로 접속해주세요!</span>
        </div>
    )
}
