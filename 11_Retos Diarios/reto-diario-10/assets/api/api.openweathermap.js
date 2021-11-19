async function data(...params) {
  const key = "3a1f47b82d0214894bc04af03ff4beef";
  try {
    console.log("Trying to fetch json...");
    const response = await fetch(
      `https://api.openweathermap.org/data/2.5/weather?q=${params[0]}&units=${params[1]}&lang=es&appid=${key}`,
      { mode: "cors" }
    );
    if (response.ok) {
      console.log("Recieving json...");
      const getData = await response.json();
      params[1] === "metric" ? (getData.units = "°C") : (getData.units = "°F");
      return getData;
    }
    console.log("Error recieving json!");
    return { error: "Please type in a valid city or zip code" };
  } catch (e) {
    return { error: e };
  }
}

async function callApi() {
  console.log("Calling OpenWeatherMap API...");
  var input;

  // Check whether location was passed or not
  if (arguments.length === 0) {
    input = document.getElementById("search");
  } else {
    input = arguments[1]; // take argument
  }
  const units = "metric";
  console.log(input.value);
  //	document.querySelector('input[name="unitRadios"]:checked').value;
  const datum = await data(input.value, units);
  console.log(datum);
  return datum;
}

export default callApi();
