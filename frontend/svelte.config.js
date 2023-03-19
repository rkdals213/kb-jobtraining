import adapter from '@sveltejs/adapter-auto';
import preprocessor from 'svelte-preprocess';


/** @type {import('@sveltejs/kit').Config} */
const config = {
  kit: {
    adapter: adapter()
  },
  preprocess: [preprocessor({
    scss: {
      prependData: ["@import \"./src/style/button\"; @import \"./src/style/box\";"]
    }
  })]
};

export default config;
