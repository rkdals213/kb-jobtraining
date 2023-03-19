import {PUBLIC_SERVER_URL} from '$env/static/public'

export async function load({fetch}) {
  const res = await fetch(PUBLIC_SERVER_URL + '/question?subject=SUBJECT_TWO')
  return await res.json()
}