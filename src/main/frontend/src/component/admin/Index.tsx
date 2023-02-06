import React, { useState } from 'react'
import { Button, Img, Input, LoginBox, Section } from './emotion/component'
import person from '../../images/logo.png';
import { useNavigate } from 'react-router-dom';
import { Loading } from '../emotion/component';
import axios from 'axios';
import { useDispatch, useSelector } from 'react-redux';
import { TestState } from '../../app/store';
import { saveAdminState } from '../../features/fetcherSlice';

export default function Index() {

    const navigate = useNavigate();
    const [id, setId] = useState('');
    const [pw, setPw] = useState('');
    const dispatch = useDispatch();
    const adminState = useSelector((state: TestState) => (state.fetcher.adminState));

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        if (event.target.name === "아이디") {
            setId(event.target.value);
        }

        if (event.target.name === "비밀번호") {
            setPw(event.target.value);
        }
    }

    const handleClick = () => {
        axios.post(`/adminLogin?id=${id}&pw=${pw}`)
            .then(async (res) => {
                console.log(res);
                if (res.data === true) {
                    await dispatch(saveAdminState({ adminState: true }));
                    await navigate('/admin/main');
                } else {
                    alert("잘못된 접근입니다!");
                }
            })
            .catch((error) => {
                alert(error!);
            })
    }

    return (
        <Section>
            <LoginBox>
                <Img src={person} />
                <Input type="text" placeholder='아이디를 입력해주세요' name="아이디" onChange={handleChange} value={id} />
                <Input type="password" placeholder='비밀번호를 입력해주세요' name="비밀번호" onChange={handleChange} value={pw} />
                <Button onClick={handleClick}>관리자 로그인</Button>
            </LoginBox>
        </Section>
    )
}
