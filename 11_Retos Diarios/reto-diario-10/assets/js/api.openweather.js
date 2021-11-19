/* eslint-disable no-unused-expressions */
async function data(...params) {
  const key = '3a1f47b82d0214894bc04af03ff4beef';
  try {
    const response = await fetch(
      'http://api.openweathermap.org/data/2.5/weather?q=${params[0]}&units=${params[1]}&appid=${key}',
      { mode: 'cors' },
    );
    if (response.ok) {
      const getData = await response.json();
			params[1] = 'metric';
      //params[1] === 'metric'
			//? (getData.units = '°C');
      return getData;
    }
    return { error: 'Please type in a valid city or zip code' };
  } catch (e) {
    return { error: e };
  }
}

async function callApi() {
  const input = document.getElementById('location');
  const units = '°C';
//	document.querySelector('input[name="unitRadios"]:checked').value;
  const datum = await data(input.value, units);
  return datum;
}

export default callApi;
