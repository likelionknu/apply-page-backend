export { };

declare global {
    interface Window {
        Keyboard: any; // 👈️ turn off type checking
    }
}