<script>
  import QuestionBox from "./QuestionBox.svelte"

  export let data
  export let title

  let clickedStudyMode = false
  $: study = clickedStudyMode;

  function click() {
    clickedStudyMode = !clickedStudyMode
  }

</script>


<div class="study-button">
  <h1>{title}  </h1>
  <button class="btn btn-nothing" on:click={() => {click()}}>공부모드
    {#if (study)}O{:else }X{/if}
  </button>
</div>

{#each data.result as question}
  <div class="boxes">
    <QuestionBox question="{question.question}"
                 content1="{question.content1}"
                 content2="{question.content2}"
                 content3="{question.content3}"
                 content4="{question.content4}"
                 answer="{question.answer}"
                 comment="{question.comment}"
                 studyMode="{study}"
    />
  </div>
{/each}

<style lang="scss">
  .study-button {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;

    & .btn {
      float: right;
      display: flex;
      width: 30%;
      margin: 1rem;
      padding: 0.6rem 0.8rem;
      border-radius: 0.5rem;
      font-size: 1rem;
      justify-content: center;
      text-align: left;
      align-items: center;

      &:hover {
        opacity: .85;
        cursor: pointer;
      }

      &:active {
        opacity: .75;
      }

      &:focus {
        outline: none;
      }

      &-nothing {
        background: $color-light;
        color: $color-dark;
        border: 1px solid $color-dark;
      }
    }
  }
</style>