import { createAsyncThunk, createSlice, isFulfilled } from "@reduxjs/toolkit";

export const fetcherSlice = createSlice({
    name: 'fetcher',
    initialState: {
        userName: '',
        userID: '',
        userDepartment: '',
        userEmail: '',
        userPhone: '',
        userPosition: '',
        userMotiv: '',
        userHardWork: '',
        userKeyWord: '',
        userMostDeeplyWork: '',

        // 백엔드
        userDifficultAndOvercoming: '',
        userStudyFramework: '',
        userImportantGroup: '',

        // 프론트엔드
        userWhyFrontend: '',
        userUsingStack: '',
        userTeamProject: '',
        userAchieve: '',

        // 디자인
        userWhyDesign: '',
        userToolExperience: '',
        userTeamworkExperience: '',
        userDesignGrowth: '',

        // 공통 포트폴리오
        userPortfolioLinkFront: '',
        userPortfolioLinkBack: '',
        userPortfolioLinkDesign: '',


    },
    reducers: {
        saveIndex: (state, action) => {
            // console.log(action);
            // console.log(action.payload);
            state.userName = action.payload.userName;
            state.userID = action.payload.userID;
            state.userDepartment = action.payload.userDepartment;
            state.userEmail = action.payload.userEmail;
            state.userPhone = action.payload.userPhone;
            state.userPosition = action.payload.userPosition;
        },
        saveCommon: (state, action) => {
            state.userMotiv = action.payload.userMotiv;
            state.userHardWork = action.payload.userHardWork;
            state.userKeyWord = action.payload.userKeyword;
            state.userMostDeeplyWork = action.payload.userMostDeeplyWork;
        },
        saveDesign: (state, action) => {
            state.userWhyDesign = action.payload.userWhyDesign;
            state.userToolExperience = action.payload.userToolExperience;
            state.userTeamworkExperience = action.payload.userTeamworkExperience;
            state.userDesignGrowth = action.payload.userDesignGrowth;
            state.userPortfolioLinkDesign = action.payload.userPortfolioLinkDesign;
        },
        saveFrontEnd: (state, action) => {
            state.userWhyFrontend = action.payload.userWhyFrontend;
            state.userUsingStack = action.payload.userUsingStack;
            state.userTeamProject = action.payload.userTeamProject;
            state.userAchieve = action.payload.userAchieve;
            state.userPortfolioLinkFront = action.payload.userPortfolioLinkFront;
        },
        saveBackEnd: (state, action) => {
            state.userDifficultAndOvercoming = action.payload.userDifficultAndOvercoming;
            state.userStudyFramework = action.payload.userStudyFramework;
            state.userImportantGroup = action.payload.userImportantGroup;
            state.userPortfolioLinkBack = action.payload.userPortfolioLinkBack;
        },
        view: (state) => {
            console.log(state.userName);
            console.log(state.userID);
            console.log(state.userEmail);
            console.log(state.userPhone);
            console.log(state.userPosition);
            console.log(state.userMotiv);
            console.log(state.userHardWork);
            console.log(state.userKeyWord);
            console.log(state.userMostDeeplyWork);
            // console.log(state.userWhyDesign);
            // console.log(state.userToolExperience);
            // console.log(state.userTeamworkExperience);
            // console.log(state.userDesignGrowth);
            console.log(state.userWhyFrontend);
            console.log(state.userUsingStack);
            console.log(state.userTeamProject);
            console.log(state.userAchieve);
        },
    },
    extraReducers: {},
})

export const { saveIndex, saveCommon, saveBackEnd, saveFrontEnd, saveDesign, view } = fetcherSlice.actions;
export default fetcherSlice.reducer;