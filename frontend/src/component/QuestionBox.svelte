<script>
  export let question
  export let content1
  export let content2
  export let content3
  export let content4
  export let answer

  export let comment

  const ContentClass = {
    CONTENT_ONE: 'btn btn-nothing',
    CONTENT_TWO: 'btn btn-nothing',
    CONTENT_THREE: 'btn btn-nothing',
    CONTENT_FOUR: 'btn btn-nothing'
  }

  const ContentNumber = {
    1: 'CONTENT_ONE',
    2: 'CONTENT_TWO',
    3: 'CONTENT_THREE',
    4: 'CONTENT_FOUR'
  }

  let submitted = false

  function submitAnswer(content, number) {
    submitted = true
    ContentClass['CONTENT_ONE'] = 'btn btn-nothing'
    ContentClass['CONTENT_TWO'] = 'btn btn-nothing'
    ContentClass['CONTENT_THREE'] = 'btn btn-nothing'
    ContentClass['CONTENT_FOUR'] = 'btn btn-nothing'

    if (answer === number) {
      ContentClass[content] = 'btn btn-correct'
      return
    }

    ContentClass[content] = 'btn btn-wrong'
    ContentClass[ContentNumber[answer]] = 'btn btn-correct'
  }
</script>

<div class="square box">
  <p>
    {question}
  </p>
  <div class="button-container">
    <button class="{ContentClass['CONTENT_ONE']}" on:click="{() => {submitAnswer('CONTENT_ONE', 1)}}">{content1}</button>
    <button class="{ContentClass['CONTENT_TWO']}" on:click="{() => {submitAnswer('CONTENT_TWO', 2)}}">{content2}</button>
    <button class="{ContentClass['CONTENT_THREE']}" on:click="{() => {submitAnswer('CONTENT_THREE', 3)}}">{content3}</button>
    <button class="{ContentClass['CONTENT_FOUR']}" on:click="{() => {submitAnswer('CONTENT_FOUR', 4)}}">{content4}</button>
  </div>
  {#if submitted}
    <hr />
    해설 : {comment}
  {/if}
</div>

<style lang="scss">

</style>