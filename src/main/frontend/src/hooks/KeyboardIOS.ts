import { useEffect } from "react";

export const KeyboardIOS = () => {
    useEffect(() => {
        const scrollToTopFn = () => {
            if (window.Keyboard && !window.Keyboard.isVisible) {
                window.scrollTo(0, 0);
                window.document.body.scrollTop = 0;
            }
        };
    
        window.addEventListener('keyboardDidHide', () => {
            window.setTimeout(scrollToTopFn, 100);
        });
    }, [])
}