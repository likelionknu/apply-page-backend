/** @jsxImportSource @emotion/react */
import { css, keyframes } from "@emotion/react";
import React, { useState } from 'react'
import { useEffect } from 'react';
import { HeaderType } from '../emotion/component';
import { Outlet, useLocation } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { HeaderText } from '../emotion/component';

export default function Header() {

    const location = useLocation();

    return (
        <>
            <div css={css`
            width: 100%;
            height: 7em;
            display: flex;
            justify-content: center;
            align-items: center;
            column-gap: 4em;
        `}>
                <Link to="/admin/main">
                    <HeaderText path={location.pathname} url={"/admin/main"}>전체 지원서</HeaderText>
                </Link>
                <Link to="/admin/pass">
                    <HeaderText path={location.pathname} url={"/admin/pass"}>합격 지원서</HeaderText>
                </Link>
                <Link to="/admin/fail">
                    <HeaderText path={location.pathname} url={"/admin/fail"}>불합 지원서</HeaderText>
                </Link>
            </div>
            <Outlet />
        </>
    )
}
