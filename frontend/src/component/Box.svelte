<script>
  export let question
  export let content1
  export let content2
  export let content3
  export let content4
  export let answer

  let currentAnswer = 0

  const ContentClass = {
    CONTENT_ONE: '',
    CONTENT_TWO: '',
    CONTENT_THREE: '',
    CONTENT_FOUR: ''
  }

  const ContentNumber = {
    1: 'CONTENT_ONE',
    2: 'CONTENT_TWO',
    3: 'CONTENT_THREE',
    4: 'CONTENT_FOUR'
  }

  function test(content, number) {
    ContentClass['CONTENT_ONE'] = ''
    ContentClass['CONTENT_TWO'] = ''
    ContentClass['CONTENT_THREE'] = ''
    ContentClass['CONTENT_FOUR'] = ''

    if (currentAnswer === answer && answer === number) {
      ContentClass[content] = 'correct'
      return
    }

    if (answer === number) {
      ContentClass[content] = 'correct'
      return
    }

    ContentClass[content] = 'wrong'
    ContentClass[ContentNumber[answer]] = 'correct'
  }
</script>

<div>
  <h2>
    {question} 정답 : {answer}
  </h2>
  <ul>
    <li class="{ContentClass['CONTENT_ONE']}" on:click="{() => {test('CONTENT_ONE', 1)}}">
      {content1}
    </li>
    <li class="{ContentClass['CONTENT_TWO']}" on:click="{() => { test('CONTENT_TWO', 2)}}">
      {content2}
    </li>
    <li class="{ContentClass['CONTENT_THREE']}" on:click="{() => { test('CONTENT_THREE', 3)}}">
      {content3}
    </li>
    <li class="{ContentClass['CONTENT_FOUR']}" on:click="{() => { test('CONTENT_FOUR', 4)}}">
      {content4}
    </li>
  </ul>
</div>

<style>
    li {
        position: relative;
        height: 100%;
    }

    .correct {
        background-color: cadetblue;
        color: white;
    }

    .wrong {
        background-color: crimson;
        color: white;
    }
</style>