console.log("memberAdd");

$("#all").click(function(){
    let ch = $(this).prop("checked");
    
    $(".check").prop("checked", ch);

});

$(".check").click(function(){
    let flag = true;
    $(".check").each(function(index, item){
        let ch = $(item).prop("checked");
        if(!ch){
            flag = false;
            return;
        }
        //console.log(index + 1, "번 째 : ", ch);
    });

    $("#all").prop("checked", flag);

});

function textLenCheck(item){
    let tag = $(item).attr("placeholder");
    let textLen = $(item).val().length;
    if(textLen < 2){
        $("#alertText").text(tag + " : 두글자 이상으로 적어주세요.");
        return false;
    } else {
        $("#alertText").text("");
        return true;
    }
}

// let idCheck = false;
// let pwCheck = false;
// let nameCheck = false;
// let emailCheck = false;
// let joinCheck = false;

// id, pw, pwcheck, name, email 체크
let results = [false, false, false, false, false];

$(".form-control").blur(function(){
    let item = $(this);
    let id = $(this).attr("id");
        
    if(id == "id"){
        results[0] = textLenCheck(item);
    } else if(id == "pw"){
        //results[1] = textLenCheck(item);
    } else if(id == "pwcheck"){
        results[2] = equals($("#pwcheck").val(), $("#pw").val(), $("#alertText"));
    } else if(id == "name"){
        results[3] = textLenCheck(item);
    } else if(id == "email"){
        results[4] = textLenCheck(item);
    }

    //joinCheck = idCheck && pwCheck && nameCheck && emailCheck;
    
});

$("#id").blur(function(){
    let result = nullCheck($("#id").val(), $("#alertText"), "ID");
})

/*$("#pw").change(function(){
    //results[2] = equals($("#pwcheck").val(), $("#pw").val(), $("#alertText"));

    $("#pwcheck").val(""); // pw 입력값이 변경되면 다시 입력하게끔
    results[2] = false;
})*/

$("#pw").on({
    blur : function(){
        results[1] = textLenCheck($(this));
    },
    change : function(){
        $("#pwcheck").val(""); // pw 입력값이 변경되면 다시 입력하게끔
        results[2] = false;
    }
})

$("#pwcheck").change(function(){
    //results[2] = equals($("#pwcheck").val(), $("#pw").val(), $("#alertText"));
})

$("#joinButton").click(function(){

    if(results.includes(false)){
        alert("필수 입력은 다 입력해");
    } else {
        alert("전송");
        //$("#joinForm").submit();
    }

    /*let c = true;

    $.each(results, function(index, item){
        if(!item){
            alert("필수 입력은 다 입력해");
            c = false;
            return false;
        }
    })

    if(c){
        $("#joinForm").submit();
    }*/

    /*if(joinCheck){
        $("#joinForm").submit();
    }*/
});


/*
    const all = document.querySelector("#all");
    let checks = document.querySelectorAll(".check");

    for(let i = 0; i < checks.length; i++){
        checks[i].addEventListener("click", function(){
            let ch = checks[i].getAttribute("checked");
            console.log(ch);
        })
    }

    for(let i = 0; i < checks.length; i++){
        checks[i].addEventListener("click", function(){
            let flag = true;
            checks.forEach(function(e){
                let ch = e.getAttribute("checked");

                if(!ch){
                    flag = false;
                    break;
                }

                //console.log(ch);
            })
            all.setAttribute("checked", flag);
        })
    }

    const joinButton = document.querySelector("#joinButton");
    const joinForm = document.querySelector("#joinForm");
    joinButton.addEventListener("click", function(){
        joinForm.submit();
    })

*/