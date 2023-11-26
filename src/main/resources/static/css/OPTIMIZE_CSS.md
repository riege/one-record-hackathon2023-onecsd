!NOTE: This project no longer uses tailwind but bootstrap!

Follow the tailwind instruction on https://tailwindcss.com/docs/optimizing-for-production to optimize the file size:

Create a file `tailwind.config.js` in project directory, content:

    module.exports = {
        purge: {
            mode: 'all',
            preserveHtmlElements: false,
            options: {
                keyframes: true,
            },
            content: [
                './src/main/resources/**/*.html',
            ],
        },
        darkMode: false, // or 'media' or 'class'
        theme: {
            extend: {},
        },
        variants: {
            extend: {},
        },
        plugins: [],
    }

then run command to generate production css:

    NODE_ENV=production npx tailwindcss -i src/main/resources/static/css/tailwind-original.css -o src/main/resources/static/css/tailwind-production.css --minify

Note that the `--minify` would even shrink the size of the file further,
but file is more difficult to read 

    NODE_ENV=production npx tailwindcss -i src/main/resources/static/css/tailwind-original.css -o src/main/resources/static/css/tailwind-production.css

Original: 3.900KB
Optimization but not for production: 3.100KB
NODE_ENV=production, no --minify: about 13KB
NODE_ENV=production, with --minify: about 5KB

| config     | no --minify | with --minify |
|------------|-------------|---------------|
| dev-mode   | 3.900KB     | 3.100KB       |
| production | 13KB        | 5 KB          |


