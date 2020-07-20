
var dispMessage = document.querySelector(".time");

function exDateTime(){

	var today = new Date();
	
	var day = today.getDay();
	var weekdays = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
	console.log("Today is " + weekdays[day]);

	var hr = today.getHours();
	var min = today.getMinutes();
	var sec = today.getSeconds();
	var ampm ;
	if(hr >= 12){
		ampm = "PM"
	}else{
		ampm = "AM"
	}

	var results = 'Current Time is : '+ hr + ' '+ ampm + ' : '+ min + ' : ' + sec;

	console.log(results);
	
	dispMessage.innerText = results;
}

console.log("hi");
exDateTime();