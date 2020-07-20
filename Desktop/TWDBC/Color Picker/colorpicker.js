console.log("Welcome");

var colors = generateRandomColors(6);
var squares = document.querySelectorAll(".square");
var colorDisplay = document.querySelector("#rgbDisplay");
var pickColor = randomColor();
var messageDisplay = document.querySelector("#message");
var h1Color = document.querySelector("h1");
var refreshButton = document.querySelector("#resetBtn");
var easyMode = document.querySelector("#easyBtn");
var hardMode = document.querySelector("#hardBtn")


//Display pickColor in colorDisplay.
colorDisplay.textContent = pickColor;

for(var i = 0; i < squares.length; i++){
	//assign colors to the square.
	squares[i].style.backgroundColor = colors[i];

	//add click listeners to squares
	squares[i].addEventListener("click", function clicked(){
		var clickedColor = this.style.backgroundColor;
		console.log(clickedColor, pickColor);

		if(clickedColor === pickColor){
			messageDisplay.textContent = "Correct!";
			h1Color.style.backgroundColor = clickedColor;
			//set all tiles to same color.
			for(var i = 0; i < squares.length; i++){
				squares[i].style.backgroundColor = clickedColor;
			}
			refreshButton.textContent = "Play Again!"

		}else{
			this.style.backgroundColor = "#232323";
			messageDisplay.textContent = "Try Again";
		}
	});
}

//refresh button
refreshButton.addEventListener("click", function refresh(){
	//generate new colors
	colors = generateRandomColors(6);

	//pick new color
	pickColor = randomColor();

	//Display pickColor in colorDisplay.
	colorDisplay.textContent = pickColor;

	//change the h1 bg color
	h1Color.style.backgroundColor = "steelblue";

	//reset the message disp
	messageDisplay.textContent = "";

	//change button name
	refreshButton.textContent = "New Colors";

	//generate new colors for squares
	for(var i = 0; i < squares.length; i++){
	//assign colors to the square.
	squares[i].style.backgroundColor = colors[i];
	}
})

//easy button click
easyBtn.addEventListener("click", function easy(){

	easyBtn.classList.add("selection");
	hardBtn.classList.remove("selection");
	//generate new colors
	colors = generateRandomColors(3);

	//pick new color
	pickColor = randomColor();

	//Display pickColor in colorDisplay.
	colorDisplay.textContent = pickColor;

	//change the h1 bg color
	h1Color.style.backgroundColor = "steelblue";

	//reset the message disp
	messageDisplay.textContent = "";

	//change button name
	refreshButton.textContent = "New Colors";

	for (var i = 0; i < squares.length; i++) {
		 
		 if (colors[i]) {
		 	squares[i].style.backgroundColor = colors[i];
		 }else{
		 	squares[i].style.display = "none";
		 }
	}
});

// hard button
hardMode.addEventListener("click", function hard(){
	easyBtn.classList.remove("selection");
	hardBtn.classList.add("selection");

	//generate new colors
	colors = generateRandomColors(6);

	//pick new color
	pickColor = randomColor();

	//Display pickColor in colorDisplay.
	colorDisplay.textContent = pickColor;

	//change the h1 bg color
	h1Color.style.backgroundColor = "steelblue";

	//reset the message disp
	messageDisplay.textContent = "";

	//change button name
	refreshButton.textContent = "New Colors";

	for (var i = 0; i < squares.length; i++) {
		 
		 
		 	squares[i].style.backgroundColor = colors[i];
		 	squares[i].style.display = "block";
		 
	}
});

//< ***++**************functions *******************/
function randomColor(){

	var randomNum = Math.floor(Math.random() * colors.length);
	return colors[randomNum];
}

//Generate Random Colors.
function generateRandomColors(num){

	//make an array
	var arr = [];

	//repeat num times
	for(var i = 0; i < num; i++){

		arr.push(makeColors())

	}

	//return arr
	return arr;

}

function makeColors(){

	//pick a red
	var r = Math.floor(Math.random()*256);
	//pick a green
	var g = Math.floor(Math.random()*256);
	//pick a blue
	var b =Math.floor(Math.random()*256);

	//set and return in a string 
	return "rgb("+r+", "+g+", "+b+")";


} 

//refresh button
