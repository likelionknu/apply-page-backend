/** @jsxImportSource @emotion/react */
import { css, keyframes } from "@emotion/react";
import React, { useState } from 'react'
import { useEffect } from 'react';
import { HeaderDescription, HeaderType } from '../emotion/component';
import { Outlet, useLocation } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { HeaderText } from '../emotion/component';

export default function Header() {

    const location = useLocation();

    return (
        <>
            <div css={css`

        @media (max-width:768px) { 
            width: 100%;
            font-size: 11px;
            column-gap: .2em;
        }; 


        width: 100%;
        height: 7em;
        display: flex;
        justify-content: center;
        align-items: center;
        column-gap: 4em;
    `}>
                <Link to="/admin/main" tabIndex={-1}>
                    <HeaderText path={location.pathname} url={"/admin/main"}>전체 지원서</HeaderText>
                </Link>
                <Link to="/admin/temp" tabIndex={-1}>
                    <HeaderText path={location.pathname} url={"/admin/temp"}>임시 지원서</HeaderText>
                </Link>
                <Link to="/admin/pass" tabIndex={-1}>
                    <HeaderText path={location.pathname} url={"/admin/pass"}>합격 지원서</HeaderText>
                </Link>
                <Link to="/admin/fail" tabIndex={-1}>
                    <HeaderText path={location.pathname} url={"/admin/fail"}>불합 지원서</HeaderText>
                </Link>
            </div>
            <p css={css`
            font-size: 24.5px;

            @media (max-width:768px) { 
                font-size: 14.5px;
            }; 
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 21px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 24.5px;
            }; 

            font-family: 'Pretendard-Bold';
            letter-spacing: -0.03em;
            color: rgb(51, 61, 75);
        `}> 멋쟁이사자처럼과 함께할 인재들을 선정해주세요 </p>
            <div css={css`
                margin-top: -1em;
                display: flex;
                flex-direction: column;
                row-gap: 0.2em;
                margin-bottom: 1em;

                @media (max-width:768px) { 
                    margin-top: -.5em;
                }; 
                
            `}>
                <HeaderDescription> 정직함으로 올바른 멋쟁이사자처럼 합류 여정을 만들어주세요 </HeaderDescription>
                {location.pathname === "/admin/main" && <HeaderDescription> 현재 페이지는 지원자분들의 최종 제출된 지원서를 볼 수 있어요 </HeaderDescription>}
                {location.pathname === "/admin/temp" && <HeaderDescription> 현재 페이지는 지원자분들의 임시 저장된 지원서를 볼 수 있어요 </HeaderDescription>}
                {location.pathname === "/admin/pass" && <HeaderDescription> 현재 페이지는 지원자분들의 합격된 지원서를 볼 수 있어요 </HeaderDescription>}
                {location.pathname === "/admin/fail" && <HeaderDescription> 현재 페이지는 지원자분들의 불합격된 지원서를 볼 수 있어요 </HeaderDescription>}
            </div>
            <Outlet />
        </>
    )
}
