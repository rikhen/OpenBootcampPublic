// Inputs
var inputAmount = document.getElementById("amountInput");
var sliderMonths = document.getElementById("monthsInput");
var sliderRate = document.getElementById("interestRateInput");

// Outputs
var amount = document.getElementById("amount");
var months = document.getElementById("months");
var interestRate = document.getElementById("interestRate");
var monthlyRate = document.getElementById("monthlyRate");

amount.innerHTML = inputAmount.value; // Display the default amount value
months.innerHTML = sliderMonths.value; // Display the default months slider value
interestRate.innerHTML = sliderRate.value; // Display the default interest rate slide value

// Update amount value (each time you enter a value)
inputAmount.oninput = function() {
  amount.innerHTML = this.value;
}

// Update months slider value (each time you drag the slider handle)
sliderMonths.oninput = function() {
  months.innerHTML = this.value;
}

// Update interset rate slider value (each time you drag the slider handle)
sliderRate.oninput = function() {
  interestRate.innerHTML = this.value;
} 

function calculateMonthlyRate() {
	var rate = 0;
	var amount = document.getElementById("amount").innerHTML;
	var months = document.getElementById("months").innerHTML;
	var interest = document.getElementById("interestRate").innerHTML;
	
	// Calculate monthly relatedTarget
	interest /= 100;
	interest /= 12;
	power = Math.pow(1+ interest, months);
	rate = (amount * interest * power) / (power - 1);
	var constantRate = (1 - (1 + (interest)**(-months))) / interest;

	// Change number precicion
	rate = rate.toFixed(2);
	console.log("Amount: " + amount);
	console.log("Months: " + months);
	console.log("Interest rate monthly: " + interest);
	console.log("Constant rate: " + constantRate);
	console.log("Calculated rate: " + rate);
	monthlyRate.innerHTML = rate;
}
