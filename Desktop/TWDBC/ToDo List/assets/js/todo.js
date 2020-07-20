console.log("hello");

//check-off specific todo items
$("ul").on("click", "li", function(){

    //$(this).toggleClass("completed");

    //if color is grey
    if($(this).css("color") === "rgb(128, 128, 128)"){
        //turn it into black and remove the strike through
        $(this).css({
            color: "black",
            textDecoration: "none"
        })
    }else{
        //else strike through and turn color into gray
        $(this).css({
            color: "gray",
            textDecoration: "line-through"
        })
    }
    
});

//click on X to delete
$("ul").on("click", "span", function(event){
    $(this).parent().fadeOut(500, function(){
        $(this).remove();
    });
    event.stopPropagation();
})

//Creating new todo
$("input[type = 'text']").keypress(function(event){
    if(event.which === 13){
        //get the new todo task
        var newTodo = $(this).val();
        //append the new task into li
        $("ul").append("<li><span><i class='fas fa-trash-alt'></i></span> "+ newTodo +" </li>");
        //clear input text
        $(this).val("");
    }
});

//toggle input
$("#plus").on("click", function(){
    $("input[type = 'text']").fadeToggle();
})