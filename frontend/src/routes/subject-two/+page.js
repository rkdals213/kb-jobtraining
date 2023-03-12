export async function load({fetch}) {
  const res = await fetch('http://localhost:8080/question?subject=SUBJECT_TWO')
  return await res.json()
}