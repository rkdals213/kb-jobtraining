import adapter from '@sveltejs/adapter-node';
import preprocessor from 'svelte-preprocess';


/** @type {import('@sveltejs/kit').Config} */
const config = {
  kit: {
    adapter: adapter(),
    env: {
      dir: "./config"
    }
  },
  // dir: "./config",
  preprocess: [preprocessor({
    scss: {
      prependData: ["@import \"./src/style/button\"; @import \"./src/style/box\";"]
    }
  })]
};

export default config;
