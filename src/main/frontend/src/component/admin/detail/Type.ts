import React from "react";

export interface DetailType {
    position?: string;
    sid?: string;
}

export interface ImgClickType {
    onClick?: () => void;
    alt?: string;
}