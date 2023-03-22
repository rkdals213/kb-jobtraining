<script></script>

<header>
  <nav class="navbar">
    <div></div>
    <ul class="navbar_menu">
      <li>
        <a data-sveltekit-preload-data="tap" href="/">Home</a>
      </li>
      <li>
        <a data-sveltekit-preload-data="tap" href="/subject-one">상품판매</a>
      </li>
      <li>
        <a data-sveltekit-preload-data="tap" href="/subject-two">외환</a>
      </li>
      <li>
        <a data-sveltekit-preload-data="tap" href="/subject-three">다른거</a>
      </li>
      <li>
        <a data-sveltekit-preload-data="tap" href="/subject-four">다른거</a>
      </li>
    </ul>
    <div></div>
  </nav>
  <hr/>
</header>

<style lang="scss">
  @import "../style/_color.scss";

  a {
    text-decoration: none;
    color: black;
  }

  .navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0.5rem;
  }

  .navbar_menu {
    list-style: none;
    display: flex;
    margin: 0;
    padding-left: 0;
  }

  .navbar_menu li {
    padding: 1.5rem 1rem;
  }

  .navbar_menu li:hover {
    background-color: $color-primary;
    border-radius: 3px;
  }

  @media screen and (max-width: 700px) {
    .navbar {
      flex-direction: column;
      align-items: flex-start;
    }

    .navbar_menu {
      flex-direction: column;
      align-items: center;
      width: 100%;
    }

    .navbar_menu li {
      width: 100%;
      text-align: center;
      padding: 0.5rem;
    }
  }

</style>