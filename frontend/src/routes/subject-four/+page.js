export async function load({fetch}) {
  const res = await fetch('http://localhost:8080/question?subject=SUBJECT_FOUR')
  return await res.json()
}