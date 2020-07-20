console.log("Hi");

var button = document.querySelector("input");
var bColor = document.querySelector("body");

button.addEventListener("click", function change(){
	bColor.classList.toggle("bodyColor");
});
