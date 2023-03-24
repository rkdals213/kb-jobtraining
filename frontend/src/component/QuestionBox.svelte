<script>
  export let question
  export let content1
  export let content2
  export let content3
  export let content4
  export let answer

  const ContentClass = {
    CONTENT_ONE: 'btn btn-nothing btn-layer-1_2',
    CONTENT_TWO: 'btn btn-nothing btn-layer-1_2',
    CONTENT_THREE: 'btn btn-nothing btn-layer-1_2',
    CONTENT_FOUR: 'btn btn-nothing btn-layer-1_2'
  }

  const ContentNumber = {
    1: 'CONTENT_ONE',
    2: 'CONTENT_TWO',
    3: 'CONTENT_THREE',
    4: 'CONTENT_FOUR'
  }

  function test(content, number) {
    ContentClass['CONTENT_ONE'] = 'btn btn-nothing btn-layer-1_2'
    ContentClass['CONTENT_TWO'] = 'btn btn-nothing btn-layer-1_2'
    ContentClass['CONTENT_THREE'] = 'btn btn-nothing btn-layer-1_2'
    ContentClass['CONTENT_FOUR'] = 'btn btn-nothing btn-layer-1_2'

    if (answer === number) {
      ContentClass[content] = 'btn btn-correct btn-layer-2_1'
      return
    }

    ContentClass[content] = 'btn btn-wrong btn-layer-1_2'
    ContentClass[ContentNumber[answer]] = 'btn btn-correct btn-layer-1_1'
  }
</script>

<div class="square box">
  <p>
    {question}
  </p>
  <div class="button-container">
    <button class="{ContentClass['CONTENT_ONE']}" on:click="{() => {test('CONTENT_ONE', 1)}}">{content1}</button>
    <button class="{ContentClass['CONTENT_TWO']}" on:click="{() => {test('CONTENT_TWO', 2)}}">{content2}</button>
    <button class="{ContentClass['CONTENT_THREE']}" on:click="{() => {test('CONTENT_THREE', 3)}}">{content3}</button>
    <button class="{ContentClass['CONTENT_FOUR']}" on:click="{() => {test('CONTENT_FOUR', 4)}}">{content4}</button>
  </div>
</div>

<style lang="scss">

</style>