import { configureStore } from "@reduxjs/toolkit";
import fetcherSlice from "../features/fetcherSlice";

export const store = configureStore({
    reducer: {
        fetcher: fetcherSlice
    },
})

export type AppDispatch = typeof store.dispatch
export type TestState = ReturnType<typeof store.getState>