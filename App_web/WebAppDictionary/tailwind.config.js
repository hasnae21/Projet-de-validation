const withMT = require("@material-tailwind/react/utils/withMT");

module.exports = withMT({
    content: [
        "./resources/**/*.{js,ts,jsx,tsx}",
    ],
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
});
