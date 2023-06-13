const withMT = require("@material-tailwind/react/utils/withMT");

module.exports = withMT({
    content: [
        "./resourcs/**/*.{js,ts,jsx,tsx}",
    ],
    theme: {
        extend: {},
    },
    plugins: [],
});
