import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route, useLocation } from 'react-router-dom';
import Index from './component/Index'
import GlobalStyles from './styles/GlobalFont';
import Common from './component/Common';
import Frontend from './component/position/Frontend';
import Design from './component/position/Design';
import Backend from './component/position/Backend';
import ScrollToTop from './hooks/ScrollToTop';
import Admin from './component/admin/Index';
import Main from './component/admin/partition/Main';
import Fail from './component/admin/partition/Fail';
import Pass from './component/admin/partition/Pass';
import Header from './component/admin/common/Header';
import Detail from './component/admin/detail/Detail';
import Error from './component/404/Error';
import { useSelector } from 'react-redux';
import { TestState } from './app/store';
import { IndexHeader } from './component/emotion/component';
import Temp from './component/admin/partition/Temp';
import NotTime from './component/404/NotTime';

export interface WrapperProps {
  children?: React.ReactNode;
  name?: string;
  text?: string;
  imgSrc?: string;
  alt?: string;
}

function App() {

  return (
    <div className="App">
      <BrowserRouter>
        <GlobalStyles />
        <ScrollToTop />
        <Routes>
          <Route element={<IndexHeader />}>
            <Route path='/' element={<Index />} />
            <Route path='/common' element={<Common />} />
            <Route path='/frontend' element={<Frontend />} />
            <Route path='/backend' element={<Backend />} />
            <Route path='/design' element={<Design />} />
          </Route>

          <Route path='/admin' element={<Admin />} />
          <Route path='/404' element={<Error />} />
          <Route path='/*' element={<Error />} />
          <Route path='/notTime' element={<NotTime/>} />

          <Route element={<Header />}>
            <Route path='/admin/main' element={<Main />} />
            <Route path='/admin/pass' element={<Pass />} />
            <Route path='/admin/temp' element={<Temp />} />
            <Route path='/admin/fail' element={<Fail />} />
            {/* <Route path='/admin/detail/:position' element={<Detail />} /> */}
          </Route>
        </Routes>
      </BrowserRouter >
    </div >

  );
}

export default App;
