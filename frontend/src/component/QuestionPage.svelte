<script>
  import Box from "./Box.svelte"

  export let data
  export let title
</script>

<h1>{title}</h1>
{#each data.result as question}
  <Box question="{question.question}"
       content1="{question.content1}"
       content2="{question.content2}"
       content3="{question.content3}"
       content4="{question.content4}"
       answer="{question.answer}"
  />
{/each}

<style>
    li {
        position: relative;
        height: 100%;
    }
</style>