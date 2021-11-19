async function data(...params) {
  // Get data from OpenWeatherMap
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
  // Function to call OpenWeatherMap API
  console.log("Calling OpenWeatherMap API...");
  const units = "metric";
  let input;
  let datum;

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

async function initWidget() {
  // Initialize Widget
  console.log("Initializing Widget...");
  updateWidget(await callApi("Santander"));
}

async function updateWidget(data) {
  // Update Widget data
  let location = `${data.name},  ${data.sys.country}`;
  let temp = `${Math.round(data.main.temp, 2)} ${data.units}`;
  let sensation = `Sensación térmica:
    ${Math.round(data.main.feels_like, 2)}
    ${data.units}`;
  let weather = data.weather[0].description;
  let wind = `${data.wind.speed} m/s`;
  let pressure = `${data.main.pressure} hPa`;
  let humidity = `${data.main.humidity} %`;
  let sunriseTimestamp = `${data.sys.sunrise}`;
  let sunsetTimestamp = `${data.sys.sunset}`;
  let sunrise = convertToTime(sunriseTimestamp);
  let sunset = convertToTime(sunsetTimestamp);
  let timezone = `${data.timezone}`;
  let localTimestamp = getLocalTimestamp(timezone);
  let localTime = convertToTime(localTimestamp);
  console.log("Local time: " + localTime);

  let ampm;
  let day;
  if (isPM(localTime)) {
    ampm = " PM";
  } else {
    ampm = " AM";
  }

  isNight(localTimestamp, sunriseTimestamp, sunsetTimestamp);

  let imgSrc = `https://openweathermap.org/img/wn/${data.weather[0].icon}@4x.png`;

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
  // Convert timestamp to date format
  let date = new Date(timestamp * 1000),
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
  // format timestamp to UTC
  let date = new Date();
  let dateUTC = new Date(
    date.getUTCFullYear(),
    date.getUTCMonth(),
    date.getUTCDate(),
    date.getUTCHours(),
    date.getUTCMinutes(),
    date.getUTCSeconds()
  );

  // Calculate timestamp in seconds
  let timestampUTC = Math.floor(dateUTC / 1000);
  // Add timezone offset
  let localTimestamp = timestampUTC + Math.floor(timezone);
  return localTimestamp;
}

function timeToString(time) {
  // Converto current time to HH:MM string
  let hours = time[3];
  let minutes = time[4];
  hours = ("0" + hours).slice(-2);
  minutes = ("0" + minutes).slice(-2);

  return hours + ":" + minutes;
}

function isPM(time) {
  // Check if time is AM or PM
  let pm = time[3] >= 12 ? true : false;
  return pm;
}

function isNight(localTime, sunrise, sunset) {
  // Check if it's day or night
  let day;
  localTime = new Date(localTime * 1000);
  sunrise = new Date(sunrise * 1000);
  sunset = new Date(sunset * 1000);

  if (
    localTime.getTime() >= sunrise.getTime() &&
    localTime.getTime() < sunset.getTime()
  ) {
    console.log("It's day");
    day = "bg-day";
  } else if (localTime.getTime() > sunset.getTime()) {
    console.log("It's night");
    day = "bg-night";
  } else {
    day = "bg-day";
  }
  // Add css class to body
  document.body.className = day;
}
