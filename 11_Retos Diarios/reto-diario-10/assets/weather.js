import { callApi } from "./api/api.openweathermap";

function weatherApp() {
  initWidget();
  const button = document.getElementById("button");
  const form = document.querySelector("form");
  // Call API
  button.onclick = async () => {
    updateWidget(await callApi());
  };

  form.onclick = async () => {
    updateWidget(await callApi());
  };

  form.addEventListener("submit", (event) => {
    event.preventDefault();
    callApi().then((response) => updateWidget(response));
  });
}

async function initWidget() {
  console.log("Initializing Widget for Santander...");
  updateWidget(await callApi("Santander"));
}

async function updateWidget(data) {
  var location = `${data.name},  ${data.sys.country}`;
  var temp = `${data.main.temp} ${data.units}`;
  var sensation = `Sensación térmica: ${data.main.feels_like} ${data.units}`;
  var weather = data.weather[0].description;
  var wind = `${data.wind.speed} km/h`;
  var pressure = `${data.main.pressure} kPa`;
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

export default weatherApp;
