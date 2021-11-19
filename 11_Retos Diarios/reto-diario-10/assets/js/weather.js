async function data(...params) {
  const key = "3a1f47b82d0214894bc04af03ff4beef";
  try {
    console.log("Trying to fetch json...");
    const response = await fetch(
      "https://api.openweathermap.org/data/2.5/weather?q=" +
        params[0] +
        "&units=" +
        params[1] +
        "&lang=es&appid=" +
        key,
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
  const units = "metric";
  var input;
  var datum;

  // Check whether location was passed or not
  if (arguments.length === 0) {
    input = document.getElementById("search");
    console.log("Location: " + input.value);
    datum = await data(input.value, units);
  } else {
    input = arguments[0]; // take argument
    console.log("Location: " + input);
    datum = await data(input, units);
  }

  console.log(datum);
  return datum;
}

//export default callApi();

// import { callApi } from "./api.openweather";

//var location = document.getElementById("location");

async function initWidget() {
  console.log("Initializing Widget...");
  updateWidget(await callApi("Santander"));
}

function getWeather() {}

async function updateWidget(data) {
  var location = `${data.name},  ${data.sys.country}`;
  var temp = `${data.main.temp} ${data.units}`;
  var sensation = `Sensación térmica: ${data.main.feels_like} ${data.units}`;
  var weather = data.weather[0].description;
  var wind = `${data.wind.speed} m/s`;
  var pressure = `${data.main.pressure} hPa`;
  var humidity = `${data.main.humidity} %`;
  var sunriseTimestamp = `${data.sys.sunrise}`;
  var sunsetTimestamp = `${data.sys.sunset}`;
  var sunrise = convertToTime(sunriseTimestamp);
  var sunset = convertToTime(sunsetTimestamp);
  var timezone = `${data.timezone}`;
  var localTimestamp = getLocalTimestamp(timezone);
  var localTime = convertToTime(localTimestamp);
  console.log(localTime);

  var ampm;
  var day;
  if (isPM(localTime)) {
    ampm = " PM";
  } else {
    ampm = " AM";
  }

  isNight(localTimestamp, sunriseTimestamp, sunsetTimestamp);

  var imgSrc = `https://openweathermap.org/img/wn/${data.weather[0].icon}@4x.png`;

  document.getElementById("location").textContent = location.toUpperCase();
  document.getElementById("time").textContent =
    "Hora local: " + timeToString(localTime) + ampm;
  document.getElementById("temp").textContent = temp;
  document.getElementById("sensation").textContent = sensation;
  document.getElementById("weather").textContent = weather.toUpperCase();
  document.getElementById("wind").textContent = wind;
  document.getElementById("pressure").textContent = pressure;
  document.getElementById("humidity").textContent = humidity;
  document.getElementById("sunrise").textContent = timeToString(sunrise);
  document.getElementById("sunset").textContent = timeToString(sunset);

  document.getElementById("weather-icon").src = imgSrc;
}

function convertToTime(timestamp) {
  var date = new Date(timestamp * 1000),
    datevalues = [
      date.getFullYear(),
      date.getMonth() + 1,
      date.getDate(),
      date.getHours(),
      date.getMinutes(),
      date.getSeconds()
    ];
  return datevalues;
}

function getLocalTimestamp(timezone) {
  var date = new Date();
  var dateUTC = new Date(
    date.getUTCFullYear(),
    date.getUTCMonth(),
    date.getUTCDate(),
    date.getUTCHours(),
    date.getUTCMinutes(),
    date.getUTCSeconds()
  );

  // Calculate timestamp in seconds
  var timestampUTC = Math.floor(dateUTC / 1000);
  // Add timezone
  var localTimestamp = timestampUTC + Math.floor(timezone);
  return localTimestamp;
}

function timeToString(time) {
  var hours = time[3];
  var minutes = time[4];
  hours = ("0" + hours).slice(-2);
  minutes = ("0" + minutes).slice(-2);

  return hours + ":" + minutes;
}

function isPM(time) {
  var pm = time[3] >= 12 ? true : false;
  return pm;
}

function isNight(currentTime, sunrise, sunset) {
  let day;
  currentTime = new Date(currentTime);
  sunrise = new Date(sunrise * 1000);
  sunset = new Date(sunset * 1000);

  console.log(currentTime + " " + sunset);
  if (sunset > currentTime > sunset) {
    day = "bg-night";
  } else if (sunrise < currentTime < sunset) {
    day = "bg-day";
  } else if (currentTime > sunset) {
    day = "bg-night";
  } else {
    day = "bg-day";
  }
  document.body.className = day;
}
