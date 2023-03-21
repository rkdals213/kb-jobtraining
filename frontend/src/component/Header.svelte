<script></script>

<header>
  <div>
  </div>
  <nav>
    <ul>
      <li>
        <a data-sveltekit-preload-data="tap" href="/">Home</a>
      </li>
      <li>
        <a data-sveltekit-preload-data="tap" href="/subject-one">1. 상품판매</a>
      </li>
      <li>
        <a data-sveltekit-preload-data="tap" href="/subject-two">2. 외환</a>
      </li>
      <li>
        <a data-sveltekit-preload-data="tap" href="/subject-three">3. 다른거</a>
      </li>
      <li>
        <a data-sveltekit-preload-data="tap" href="/subject-four">4. 다른거</a>
      </li>
    </ul>
  </nav>
  <div>
  </div>
</header>

<style>
    header {
        display: flex;
        justify-content: space-between;
    }

    ul {
        position: relative;
        padding: 0;
        margin: 0;
        height: 3rem;
        display: flex;
        justify-content: center;
        align-items: center;
        list-style: none;
        background: var(--background);
        background-size: contain;
    }

    li {
        position: relative;
        height: 100%;
        display: flex;
        align-items: center;
        padding: 0 0.5rem;
        color: var(--color-text);
        font-weight: 700;
        font-size: 0.8rem;
        text-transform: uppercase;
        letter-spacing: 0.1em;
        text-decoration: none;
        transition: color 0.2s linear;
    }

</style>