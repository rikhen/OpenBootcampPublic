// Get current date
let today = new Date();

// Get current day, month and year
let day = today.getDate();
let month = today.getMonth();
let year = today.getFullYear();

// Initialize calendar
function initCalender() {
  console.log("Initializing calendar...");
  showCalender(month, year);
}

// Show / Update calendar
function showCalender(month, year) {
  // Get year & month elements
  let obYear = document.getElementById("ob-year");
  let obMonth = document.getElementById("ob-month");

  // Get first date of current month
  var firstDay = new Date(year, month).getDay();
  // Get number of days of current month
  var days = daysOfMonth(month, year);

  // Set new dates
  obMonth.innerHTML = getMonthName(new Date(year, month));
  obYear.innerHTML = year;

  // Get table elements
  var table = document.getElementById("ob-days");
  var tbody = table.getElementsByTagName("tbody")[0];

  console.log("Current month: " + month);
  console.log("First day of month: " + firstDay);
  console.log("Days in month: " + days);

  // Loop through table cells and fill with date
  var date = 1;
  for (var i = 0; i < 6; i++) {
    var row = tbody.getElementsByTagName("tr")[i];
    for (var j = 0; j < 7; j++) {
      var cell = row.getElementsByTagName("td")[j];
      cell.innerHTML = "";
      if (i === 0 && j < firstDay) {
        cell.className = "ob-day-body ob-day-prev-month";
        cell.innerHTML = "";
        console.log(date);
      } else if (date > days) {
        cell.className = "ob-day-body ob-day-next-month";
        cell.innerHTML = "";
      } else {
        cell = row.getElementsByTagName("td")[j];
        cell.className = "ob-day-body";
        cell.innerHTML = date;
        // Check if day is today
        if (
          date === today.getDate() &&
          year === today.getFullYear() &&
          month === today.getMonth()
        ) {
          cell.className = "ob-day-body ob-today";
        }
        date++;
      }
    }
  }
}

// Get number days of given month
function daysOfMonth(month, year) {
  // Count days of month
  return new Date(year, month + 1, 0).getDate();
}

// Get previous month
function previous() {
  console.log("Updating calendar...");
  // Calculate previous month
  year = month === 0 ? year - 1 : year;
  month = month === 0 ? 11 : month - 1;
  showCalender(month, year);
}

// Get next month
function next() {
  console.log("Updating calendar...");
  // Calculate next month
  year = month === 11 ? year + 1 : year;
  month = (month + 1) % 12;
  showCalender(month, year);
}

// Get name of month
function getMonthName(date) {
  // Get name of month
  let monthName = date.toLocaleString("es-Es", { month: "long" });
  // Convert to Uppercase
  return monthName.charAt(0).toUpperCase() + monthName.slice(1);
}
