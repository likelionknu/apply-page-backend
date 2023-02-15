/** @jsxImportSource @emotion/react */
import { css, keyframes } from "@emotion/react";
import React, { ChangeEvent, useEffect, useRef, useState } from 'react'
import banner from '../../images/banner.png';
import loading from '../../images/loading.gif';
import axios from 'axios';
import checkBox from '../images/checkBox.svg';
import checkedBox from '../images/checkedBox.svg';
import { useMemo } from 'react';
import { fadeLeft, fadeUp, fadeIn } from "../../styles/Keyframes";
import { WrapperProps } from "../../App"
import { ImgClickType } from "../admin/detail/Type";
import back from '../../images/back.png';
import oops from '../../images/oops.png';
import logo from '../../images/logo.png';
import { Link, Outlet, useNavigate } from "react-router-dom";
import NotWidth from "../404/NotWidth";
import { KeyboardIOS } from "../../hooks/KeyboardIOS";


// 공통 질문, 각 포지션별 질문에 해당하는 textarea 태그
export const TextAreaBox = (props: TextAreaType) => {
    return (
        <textarea css={css`
        font-family: 'Pretendard-Regular';
        letter-spacing: -0.03em;
        line-height: 1.5em;
        padding: 0;
        padding-left: 1em;
        padding-bottom: 1em;
        padding-right: 1em;
        padding-top: 1em;
        width: 46.88vw;
        height: 15em;
        border: solid;
        border-radius: 1.07em;
        border-color: #e6e8ea;
        border-width: 0.0714em;
        @media all and (min-width:768px) and (max-width:1099px) { 
            font-size: 14px;
        }; 
        @media all and (min-width:1100px) and (max-width:2000px) { 
            font-size: 14px;
        }; 
        box-sizing: border-box;
        resize: none;

        // 익스플로러, 파이어폭스에서 우측 스크롤 없애기
        -ms-overflow-style: none;
        scrollbar-width: none;

        &:focus {
            outline-color: #4F85E8;
        }

        &::placeholder {
            font-family: 'Pretendard-Regular';
            color: #8B95A1;
            margin-left: 0.4em;
        }

        // 크롬에서 우측 스크롤 없애기
        &::-webkit-scrollbar {
            display: none;
          }

        `} {...props} maxLength={1000} />
    )
}

// 공통적인 헤더를 나타내주는 컴포넌트
export const IndexHeader = () => {

    const [scrollState, setScrollState] = useState<boolean>(false);

    const handleScroll = () => {
        if (window.scrollY || document.documentElement.scrollTop > 0) {
            setScrollState(true);
        } else {
            setScrollState(false);
        }
    };

    useMemo(() => {
        window.addEventListener('scroll', handleScroll);
        return () => {
            window.removeEventListener('scroll', handleScroll); //clean up
        };
    }, [window.scrollY || document.documentElement.scrollTop])

    return (
        <>
            <div css={css`
                position: fixed;
                z-index: 999;
                width: 100%;
                display: flex;
                justify-content: center;
                align-items: center;
                padding-top: 1.2em;
                padding-bottom: 1.2em;
                @media (max-width: 1099px) {
                    display: none;
                }
                @media all and (min-width:768px) and (max-width:1099px) { 
                    font-size: 18px;
                }; 
                @media all and (min-width:1100px) and (max-width:2000px) { 
                    font-size: 18px;
                }; 
                column-gap: 30em;
                background-color: white;

                ${scrollState && css`
                    border:solid;
                    border-top: 0;
                    border-left: 0;
                    border-right: 0;
                    border-bottom: 1;
                    border-color: #e6e8ea;
                    border-width: 1px;
                `}

                a {
                    @media all and (min-width:768px) and (max-width:1099px) { 
                        font-size: 14.8px;
                    }; 
                    @media all and (min-width:1100px) and (max-width:2000px) { 
                        font-size: 14.8px;
                    }; 
                    color: #4e5968;
                    font-family: 'Pretendard-Regular';
                    letter-spacing: -0.03em;
                }
            `}>
                <img alt="로고" src={logo} css={css`
                    height: auto;
                    width: 155px;
                    transition: 0.4s all;

                    &:hover {
                        opacity : 70%;
                    }
                `} />
                <nav css={css`
                    height: 100%;
                    display: flex;
                    column-gap: 2.5em;
                    transition: 0.4s all;
                `}>
                    <a href="https://ripe-launch-04b.notion.site/88de609dd84e4fcab616b1cf2cf491e2" target="_blank" tabIndex={-1}>조직 소개</a>
                    <a href="https://ripe-launch-04b.notion.site/24b3c0a0d41d4162b1c458055fe86dd8" target="_blank" tabIndex={-1}>합류 여정</a>
                    <a href="https://ripe-launch-04b.notion.site/2bde1551815e455ab4306ab5ca190519" target="_blank" tabIndex={-1}>강남멋사 조직도</a>
                </nav>


            </div>
            <Outlet />
        </>
    )
}

// 업로드 기능이 생기면 쓰려고 만들어놓은 업로드 컴포넌트
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
            background-color: #4F85E8;     
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

// 기본적인 입력 정보를 받기 위한 input 박스
export const InputBox = (props: InputType) => {
    return (
        <input css={css`
        @media all and (min-width:768px) and (max-width:1099px) { 
            font-size: 13px;
        }; 
        @media all and (min-width:1100px) and (max-width:2000px) { 
            font-size: 14.5px;
        }; 
        font-family: 'Pretendard-Regular';
        letter-spacing: -0.03em;
        padding: 0;
        padding-left: 1em;
        width: 46.88vw; // 900px;
        height: 3.7em; // 51.8px
        border: solid;
        border-radius: 0.614em; // 0.8596px;
        border-color: #e6e8ea;
        border-width: 0.0614em; // 1px 
        box-sizing: border-box;
        transition: .2s all;
        outline-color: #4F85E8;

        &::-webkit-outer-spin-button,
        &::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        &:focus {
            outline-color: #4F85E8;

            &:hover {
                box-shadow: none;
            }
            // box-shadow: inset 0 0 0 2px #4F85E8;
        }

        &:hover {
            box-shadow: inset 0 0 0 2px #90c2ff;
        }

        &::placeholder {
            font-family: 'Pretendard-Regular';
            color: #8B95A1;
            margin-left: 0.4em;
        }
        `} {...props} maxLength={props.maxLength} tabIndex={props.tabIndex} />
    )
}

// 추후 리팩토링에서 Type.ts 파일로 모아서 export 시키도록 하자
export interface PositionType {
    name?: string;
    onClick?: (event: React.MouseEvent<HTMLButtonElement>) => void;
    children?: React.ReactNode;
    state?: string;
    alt?: string;
}

// 사용자가 포지션을 선택하기 위해 만들어놓은 포지션 컴포넌트
export const Position = (props: PositionType) => {
    return (
        <button css={css`
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 13px;
                height: 40px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 14px;
            };  
            height: 56px;
            ${props.alt === "모달" && css`height: 3em;`} 
            ${props.alt === "모달" && css`
                @media all and (min-width:768px) and (max-width:1099px) { 
                    font-size: 12px;
                }; 
                @media all and (min-width:1100px) and (max-width:2000px) { 
                    font-size: 14px;
                }; 
            `} 
            border-radius: 3.57em;
            border: solid;
            border-width: 0.0714em;
            border-color: #e6e8ea;
            transition: 0.5s all;
            cursor: pointer;

            ${props.name === props.state ? css`
            color: white;
            background-color: #4F85E8;
            border: none;
            ` : css`
            background-color: white;
            color: #707070;

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

// 모달의 기본적인 프레임 틀을 짜놓은 컴포넌트
export const ModalFrame = ({ children }: WrapperProps) => {
    return (
        <div css={css`
        position: absolute;
        width: 100%;
        height: 100%;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        background-color: rgba(0, 0, 0, 0.4);
        z-index: 999;
        cursor: pointer;
        padding-bottom: 10em;
        `}>
            {children}
        </div>
    )
}

// 모달을 띄울 때 사용하는 모달 컴포넌트
export const Modal = (props: WrapperProps) => {

    const ModalRef = useRef<HTMLDivElement>(null);

    useEffect(() => {
        if (ModalRef.current != null) {
            // console.log("모달 등장!", ModalRef.current.style);
            ModalRef.current.style.top = `${(window.screen.height - 480) / 4 + window.scrollY}px`;
        }
    }, [])

    return (
        <ModalFrame>
            <div css={css`
                position: absolute;
                width: 100%;
                height: 100%;
                border: none;
                
                display: flex;
                justify-content: center;
                align-items: center;
            `}>
                <div css={css`
                    position: absolute;  
                    // top: ${(window.screen.height - 480) / 4 + window.scrollY}px;
                    -webkit-overflow-scrolling:touch;

                    font-family: 'Pretendard-Bold';
                    letter-spacing: -0.03em;
                    border-radius: 1.25em;
                    background-color: white;
                    @media (max-width:768px) { 
                        font-size: 11px;
                        width: ${window.screen.width / 2 + 140}px;
                        height: 15em;
                        padding-top: 6em;
                        padding-bottom: 6em;
                    }; 
                    @media all and (min-width:768px) and (max-width:1099px) { 
                        font-size: 13.5px;
                    }; 
                    @media all and (min-width:1100px) and (max-width:2000px) { 
                        font-size: 18px;
                    }; 
                    width: 38em;
                    height: 30em;
                    color: #333d4b;
                    ${props.alt === "찾기" && css`height: 35em`}
                    ${props.alt === "메일_합격" &&
                    css`
                        @media (max-width:768px) { 
                            font-size: 13px;
                            width: ${window.screen.width / 2 + 140}px;
                            height: 15em;
                            padding-top: 6em;
                            padding-bottom: 6em;
                        }; 
                            padding-top: 6em;
                            padding-bottom: 6em;
                        `
                    }
                    display: flex;
                    justify-content: center;    
                    align-items: center;
                    animation: ${fadeIn} 0.5s ease-in-out;
                `} ref={ModalRef}>
                    <div css={css`
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        justify-content: center;
                    `}>
                        {props.imgSrc &&
                            <img alt="사람" src={props.imgSrc}
                                css={css`
                            width: 9.4em;
                            ${props.alt === "찾기" &&
                                    'width: 9.5em;'
                                    }
                            ${props.alt === "최종제출" &&
                                    'width: 7.5em;'
                                    }
                            ${props.alt === "불러오기" &&
                                    'width: 7.5em;'
                                    }
                            margin-bottom: 2em;
                        `} />
                        }
                        <span css={css`
                            @media (max-width:768px) { 
                                padding: 1em;
                                font-size: 11px;
                                width: 100%;
                                margin-bottom: -2em;
                            }; 
                            @media all and (min-width:768px) and (max-width:1099px) { 
                                font-size: 14px;
                            }; 
                            @media all and (min-width:1100px) and (max-width:2000px) { 
                                font-size: 18px;
                            }; 
                            ${props.alt === "찾기" && css`margin-bottom: -1em;`}
                        `}>
                            {props.text}
                        </span>
                        <ButtonBox>
                            {props.children}
                        </ButtonBox>
                    </div>
                </div>
            </div>
        </ModalFrame>
    )
}

export const ModalInput = (props: InputType) => {
    return (
        <input css={css`
        font-family: 'Pretendard-Medium';
        letter-spacing: -0.03em;
        @media all and (min-width:768px) and (max-width:1099px) { 
            font-size: 14px;
        }; 
        @media all and (min-width:1100px) and (max-width:2000px) { 
            font-size: 18px;
        }; 
        padding: 0;
        padding-left: 1em;
        width: 22.5em;
        border: solid;
        border-radius: 0.43em;
        border-color: #e6e8ea;
        border-width: 0.0625em;
        ${props.name === "인터뷰_시간" && css`
        @media (max-width:768px) { 
            font-size: 8px;
        }; 
        @media all and (min-width:768px) and (max-width:1099px) { 
            font-size: 11px;
        }; 
        @media all and (min-width:1100px) and (max-width:2000px) { 
            font-size: 15px;
        }; 
        width: 33.5em;
        height: 3.5em;
        `}
        ${props.name === "인터뷰_장소" && css`
        @media (max-width:768px) { 
            font-size: 8px;
        }; 
        @media all and (min-width:768px) and (max-width:1099px) { 
            font-size: 11px;
        }; 
        @media all and (min-width:1100px) and (max-width:2000px) { 
            font-size: 15px;
        }; 
        width: 33.5em;
        height: 3.5em;
        `}
        ${props.name === "인터뷰_소요시간" && css`
        @media (max-width:768px) { 
            font-size: 8px;
        }; 
        @media all and (min-width:768px) and (max-width:1099px) { 
            font-size: 11px;
        }; 
        @media all and (min-width:1100px) and (max-width:2000px) { 
            font-size: 15px;
        }; 
        width: 33.5em;
        height: 3.5em;
        `}
        ${props.name === "저장된_학번" && css`
        @media all and (min-width:768px) and (max-width:1099px) { 
            font-size: 12px;
        }; 
        @media all and (min-width:1100px) and (max-width:2000px) { 
            font-size: 15px;
        }; 
        width: 37em;
        height: 3.5em;
        `}
        ${props.name === "저장된_이메일" && css`
        @media all and (min-width:768px) and (max-width:1099px) { 
            font-size: 12px;
        }; 
        @media all and (min-width:1100px) and (max-width:2000px) { 
            font-size: 15px;
        }; 
        width: 37em;
        height: 3.5em;
        `}
        box-sizing: border-box;

        &::-webkit-outer-spin-button,
        &::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }


        &:focus {
            outline-color: #4F85E8;

            &:hover {
                box-shadow: none;
            }
            // box-shadow: inset 0 0 0 2px #4F85E8;
        }

        &:hover {
            box-shadow: inset 0 0 0 2px #90c2ff;
        }

        &::placeholder {
            font-family: 'Pretendard-Regular';
            color: #8B95A1;
            margin-left: 0.4em;
        }
        `}{...props} onClick={() => { return false }} />
    )
}

// 지원 시간이 끝났을 때 사용자에게 나타내는 주의사항 컴포넌트
export const EndTime = () => {
    return (
        <section css={css`
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        `}>
            <div css={css`
                background-color: white;
                width: 30em;
                height: 25em;
                border-radius: 0.714em;
                border: none;
                @media all and (min-width:768px) and (max-width:1099px) { 
                    font-size: 16px;
                }; 
                @media all and (min-width:1100px) and (max-width:2000px) { 
                    font-size: 16px;
                }; 
                letter-spacing: -0.03em;
                line-height: 1.5em;

                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                row-gap: 2em;
            `}>
                <img alt="낫 지원기간" src={oops} css={css`
                    width: 8em;
                `} />
                <span css={css`
                    @media all and (min-width:768px) and (max-width:1099px) { 
                        font-size: 17px;
                    }; 
                    @media all and (min-width:1100px) and (max-width:2000px) { 
                        font-size: 17px;
                    }; 
                    letter-spacing: -0.03em;
                    
                    font-family: 'Pretendard-Medium';
                `}>
                    지원이 마감되었습니다<br />결과 발표를 위해 잠시만 기다려주세요
                </span>
            </div>
        </section>
    )
}

// 주의사항 컴포넌트
export const Precautions = () => {
    return (
        <div css={css`
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            display: flex;
            flex-direction: column;
            text-align: left;
            width: 46.88vw;

            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 14px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 14px;
            };


            span {
                @media all and (min-width:768px) and (max-width:1099px) { 
                    font-size: 14.5px;
                }; 
                @media all and (min-width:1100px) and (max-width:2000px) { 
                    font-size: 14.5px;
                }; 
            }
        `}>
            <InputTitle>주의사항 <Require /> </InputTitle>
            <div css={css`
                display: flex;

                @media all and (min-width:768px) and (max-width:1099px) { 
                    span {
                        font-size: 13px;
                    }
                    font-size: 14px;
                }; 
                @media all and (min-width:1100px) and (max-width:2000px) { 
                    font-size: 14px;
                }; 

                flex-direction: column;
                row-gap: 0.5em;
                flex-wrap: wrap;
                color: #333d4b;
            `}>
                <span>· 지원서 최종 제출 후에는 지원서의 수정이 불가능합니다.</span>
                <span>· 작성 중인 지원서는 임시저장 버튼을 통해 실시간으로 저장이 가능합니다.</span>
                <span>· 지원서 접수 마감일에는 지원자가 몰려 지원이 어려울 수 있으니, 여유있게 미리 제출해주시기 바랍니다.</span>
                <span>· 문항에 따른 올바른 입력을 해주셔야 지원서의 다음 단계로 이동하실 수 있습니다.</span>
                <span>· 지원서의 내용이 사실과 다를 경우, 합격이 취소되거나 전형 상의 불이익을 받을 수 있습니다.</span>
                <span>· 지원서는 문항별 최대 1000자의 제한을 두고 있으나, 문항을 다 채우실 필요는 없습니다.</span>
                <span>· 문의사항은 우측 하단 채널 톡으로 문의해주시면 최대한 빠르게 도와드리겠습니다.</span>
            </div>
        </div >
    )
}

// 포지션 컴포넌트의 컨테이너 틀
export const PositionBox = (props: WrapperProps) => {
    return (
        <div css={css`
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 12.7px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 16px;
            };  
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
            column-gap: 2em; // 32px
            width: 46.88vw; // 900px
            ${props.alt === "모달" && css`width: 35em;`} 
        `}>
            {props.children}
        </div>
    )
}

// 로딩중을 표시하는 컴포넌트
export const Loading = () => {
    return (
        <img alt="로딩 이미지" src={loading} css={css`
            @media (max-width:768px) { 
                font-size: 6px;
            }; 
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 12.7px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 14px;
            };  

            width: 12em;
        `} />
    )
}

// 뒤로가기 및 취소
export const Quit = (props: ImgClickType) => {
    return (
        <img alt="뒤로가기" onClick={props.onClick} src={back} css={css`
            width: .9em;
            transition: 0.4s all;
            margin-top: 2em;
            margin-bottom: 1em;
            cursor: pointer;

            ${props.alt === "찾기" && css`
                @media all and (min-width:768px) and (max-width:1099px) { 
                    font-size: 13px;
                    margin-top: -16.8em;
                }; 
                @media all and (min-width:1100px) and (max-width:2000px) { 
                    font-size: 17.5px;
                }; 

                position: absolute;
                margin-top: -17em;
                margin-left: 35em;
            `}

            &:hover {
                opacity: 60%;
            }
        `} />
    )
}

// textarea를 입력했을 때, 사용자가 몇자를 입력했는지 나타내주는 컴포넌트
export const WordLength = ({ children }: WrapperProps) => {
    return (
        <div css={css`
            width: 10em;
            position: relative;
            text-align:center;
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;

            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 13px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 13px;
            }; 

            color: #4F85E8;
            margin-left: auto;
            margin-top: -2.2em;
            margin-bottom: .5em;

            display:flex;
            justify-content: center;
            align-items: center;
        `}>
            <div css={css`
                width: 1.69vw;
                border-box: box-sizing;
            `}>
                {children}
            </div>
            <span css={css`
                margin-right: 0.3em;
            `}>/</span>
            <span css={css`
                @media all and (min-width:768px) and (max-width:1099px) { 
                    font-size: 13px;
                }; 
                @media all and (min-width:1100px) and (max-width:2000px) { 
                    font-size: 13px;
                }; 
            `}>1000</span>
        </div>
    )
}

// 필수로 작성해야하는 질문지를 표시해주는 컴포넌트
export const Require = () => {
    return (
        <span css={css`
            margin-left: 0.4em;
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.02em;
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 14px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 14px;
            }; 
            color: #ff0000;
        `}>* </span>
    )
}

// 주의사항 확인을 했음에 동의를 구하는 컴포넌트
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

export interface AgreeType {
    src: string;
    text: string;
    onClick: (event: React.MouseEvent<HTMLImageElement | HTMLDivElement>) => void;
    name: string;
}

// 체크박스 컴포넌트
export const Argree = ((props: AgreeType) => {
    return (
        <div css={css`
            display: flex;
            flex-direction: column;
            width: 46.88vw;
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 14.5px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 14.5px;
            };
        `}>
            <div css={css`
                display: flex;
                align-items: center;
            `}>
                <img alt={props.name} onClick={props.onClick} src={props.src} css={css`
                    width: 1.1em;
                    cursor: pointer;
                `} />
                <span css={css`
                    @media all and (min-width:768px) and (max-width:1099px) { 
                        font-size: 13px;
                    }; 
                    @media all and (min-width:1100px) and (max-width:2000px) { 
                        font-size: 14.5px;
                    }; 
                    font-family: 'Pretendard-Medium';
                    letter-spacing: -0.03em;
                    margin-left: 0.4em;
                    cursor: pointer;
                    color: #333d4b;
                `} onClick={props.onClick} id={props.name} >{props.text}<Require /></span>
            </div>
        </div>
    )
})

// 푸터 컴포넌트
export const Footer = () => {
    return (
        <section css={css`
            margin-top: 5em;
            width: 100%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f9fafb;
            padding-top: 4em;
            padding-bottom: 4em;
        `}>
            <div css={css`
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 14px;

                span {
                    font-size: 12px;
                }
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 14px;
            }; 
            width: 46.88vw;
            height: 100%;
            font-family: 'Pretendard-Regular';
            letter-spacing: -0.03em;
            margin-left: 0.4em;
            color: #8b95a1;

            text-align: left;

            display: flex;
            flex-direction: column;
            row-gap: .4em;

        `}>
                <span css={css`
                font-family: 'Pretendard-Bold';
                color: #333d4b;
                @media all and (min-width:768px) and (max-width:1099px) { 
                    font-size: 14.5px !important;

                }; 
                @media all and (min-width:1100px) and (max-width:2000px) { 
                    font-size: 15.7px !important;
                }; 
                margin-bottom: 0.6em;
            `}> 멋쟁이사자처럼 강남대학교 11기</span>
                <span>경기도 용인시 기흥구 강남로 40 강남대학교 이공관</span>
                <span>개발 팀 : 성창규 · 김현우</span>
                <span>QA 팀 : 배채은 · 이수아 · 이진아 · 이지현 · 구보선</span>
            </div>
        </section>
    )
}

export const Banner = () => {

    return (
        <img alt="배너 이미지" src={banner} css={css`
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 15px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 15px;
            }; 
            margin-top: 8em;
            width: 22em;  // 테스트
            height: auto;
            margin-bottom: 1em;
            // animation: ${fadeLeft} 1.8s ease-in-out;
        `} loading="lazy" />
    )
}

// 전체적인 내용이 섹션 안으로 들어가게 됩니다, 전체적인 틀 컴포넌트
export const Section = ({ children }: WrapperProps) => {
    return (
        <>
            <section css={css`
            position: absolute;
            left: 50%;
            transform: translate(-50%);
            // max-width: 73em;
            width: 100%;
            background-color: white;

            display: flex;
            flex-direction: column;
            align-items: center;
            row-gap: 1.5em;

            @media (max-width: 1024px) {
                display: none;
            }

        `}>
                {children}
                <Footer />
            </section>
            <NotWidth />
        </>
    )
}

// 기본 인적사항에서 input이 무엇을 받을지 알려주는 제목 컴포넌트
export const InputTitle = ({ children }: WrapperProps) => {
    return (
        <p css={css`
            font-family: 'Pretendard-Medium';
            letter-spacing: -0.03em;
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 14px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 15px;
            }; 
            color: #4e5968;
            width: 46.88vw;
            align-items: center;
            
            
        `}>
            {children}
        </p>
    )
}

// 학과를 검색할 때 네이버 검색창 처럼 보여주는 컴포넌트
export const SearchDepartment = ({ children }: WrapperProps) => {
    return (
        <div css={css`
            font-family: 'Pretendard-Regular';
            letter-spacing: -0.03em;
            background-color: white;
            border: none;
            border-radius: 0.769em;
            @media all and (min-width:768px) and (max-width:1099px) {
                margin-top: 0.18em; 
                font-size: 15px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 15px;
            }; 
            padding: 1em;
            row-gap: 0.5em;
            box-shadow: 0.15em 0.23em 0.38em 0em #707070;
            display: flex;
            flex-direction: column;
            height: 5em;
        `}>
            {children}
        </div>
    )
}

// 각 인적사항 별로 보기 쉽게 만들어놓은 컨테이너 틀
export const Article = ({ children }: WrapperProps) => {
    return (
        <article css={css`
            display: flex;
            flex-direction: column;
            text-align: left;
            justify-content: center;
            // animation: ${fadeUp} 2s ease-in-out;
        `}>
            {children}
        </article>
    )
}

// 사용자가 잘못된 입력을 했을 때 나타내주는 컴포넌트
export const ErrorDescription = ({ children }: WrapperProps) => {
    return (
        <span css={css`
            position: absolute;
            font-family: 'Pretendard-Regular';
            letter-spacing: -0.03em;
            font-size:13px;
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 13px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 13px;
            }; 
            margin-top: 10.2em;
            margin-left: .5em;
            color: red;
        `}>
            {children}
        </span>
    )
}

// 사용자가 정확한 입력을 했을 때 나타내주는 컴포넌트
export const CollectDescription = ({ children }: WrapperProps) => {
    return (
        <span css={css`
            position: absolute;
            font-family: 'Pretendard-Regular';
            letter-spacing: -0.03em;
            font-size: 13px;
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 13px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 13px;
            }; 
            margin-top: 10.2em;
            margin-left: .5em;
            color: #11BD7E;
        `}>
            {children}
        </span>
    )
}

export interface ButtonType {
    name?: string;
    children?: React.ReactNode;
    disabled?: boolean;
    onClick?: () => void;
    alt?: string;
}

// 기본 버튼 컴포넌트
export const Button = (props: ButtonType) => {
    return (
        <button css={css`
            font-family: 'Pretendard-Bold';
            letter-spacing: -0.03em;
            @media (max-width:768px) { 
                font-size: 6px;
                border-radius: 4px;
            }; 
            @media all and (min-width:768px) and (max-width:1099px) { 
                font-size: 11.5px;
            }; 
            @media all and (min-width:1100px) and (max-width:2000px) { 
                font-size: 15.5px;
            }; 
            width: 15em;
            height: 3.5em;
            border: none;
            border-radius: 8px;
            ${props.alt === "불러오기" && css`
                width: 40em;

                @media all and (min-width:768px) and (max-width:1099px) { 
                    font-size: 11px;
                }; 
                @media all and (min-width:1100px) and (max-width:2000px) { 
                    font-size: 14px;
                }; 
                height: 3.8em;
                border-radius: 0.58em;
            `}
            color: white;
            transition: 0.5s all;
            ${props.name === "임시저장" && `background-color : #2F353E;`}
            ${props.name === "제출하기" && `background-color : #4F85E8;`}
            ${props.disabled ?
                css`
                    cursor: auto;
                    filter: grayscale(100%);
                    background-color: #828282;
                ` :
                css`
                    cursor: pointer;
                    &:hover {
                        opacity: 80%;
                    }
                    `
            }
        `} {...props} tabIndex={-1}>
            {props.children}
        </button>
    )
}

// flex 속성의 버튼을 모아주는 큰 틀의 컨테이너 틀 
export const ButtonBox = (props: WrapperProps) => {
    return (
        <div css={css`
            display: flex;
            column-gap: 1em;
            margin-top: 3em;
            width: 46.88vw;
            display: flex;
            justify-content: center;
            align-items: center;
            ${props.alt === "임시저장_모달" && css`margin-top: 0em;`}
        `}>
            {props.children}
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
    tabIndex?: number;
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
