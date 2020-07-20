var j1 = 89, j2 =120, j3 = 103; //John's team
var m1 = 116, m2 = 94, m3 = 123; //Mike's team

jAvg = (j1 + j2 + j3)/3;
mAvg = (m1 + m2 + m3)/3;

if(jAvg > mAvg){
	console.log("John is the winner with " + jAvg + " points.");
else if(jAvg === mAvg){
	console.log("Both theteams are at a tie with " + mAvg + " points.");
}else{
	console.log("Mike is the winner with " + mAvg + " points.");
}