// const withMT = require("@material-tailwind/react/utils/withMT");

// module.exports = withMT({
//     content: [
//         "./resourcs/**/*.{js,ts,jsx,tsx}",
//     ],
//     theme: {
//         extend: {},
//     },
//     plugins: [],
// });

/** @type {import('tailwindcss').Config} */
module.exports = {
    darkMode: "class",
    content: ["./resourcs/**/*.{js,ts,jsx,tsx}"],
    theme: {
        extend: {
            colors: {
                "custom-blue": "#2563eb",
                "custom-gray": "#64748b",
                "custom-white": "#e2e8f0",
            },
        },
    },
    plugins: [],
};
