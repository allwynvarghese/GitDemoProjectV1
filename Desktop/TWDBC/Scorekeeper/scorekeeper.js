console.log("Hi! Welcome to the console!");

var p1Button = document.getElementById("p1");
var p2Button = document.getElementById("p2");
var resetButton = document.getElementById("rst");
var p1Display = document.getElementById("p1D");
var p2Display = document.getElementById("p2D");
var p1Score = 0;
var p2Score = 0;
var winScore = 5;
var gameOver = false;
var winingScoreDisplay = document.getElementById("winDisplay");
var selectWinningScore = document.getElementById("numList");


selectWinningScore.addEventListener("change", function winner(){
	winingScoreDisplay.textContent = selectWinningScore.value;
	winScore = Number(selectWinningScore.value);
	reset();
})

p1Button.addEventListener("click", function changeP1(){
	if (!gameOver) {
	p1Score += 1;
	p1Display.textContent = p1Score;
		if(p1Score === winScore){
			console.log("Game Over");
			gameOver = true;
			p1Display.classList.add("winner");
		}
	}

});

p2Button.addEventListener("click", function changeP2(){
	if(!gameOver){
		p2Score += 1;
		p2Display.textContent = p2Score;
		if(p2Score === winScore){
			console.log("Game Over");
			gameOver = true;
			p2Display.classList.add("winner");
		}
	}
	
});

resetButton.addEventListener("click", reset);

function reset(){
	p1Score = 0;
		p1Display.textContent = p1Score;

		p2Score = 0;
		p2Display.textContent = p2Score;

		gameOver = false;
		p2Display.classList.remove("winner");
		p1Display.classList.remove("winner");
}
