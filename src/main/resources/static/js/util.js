function nullCheck(data, dest, kind){
    if(data == null || data == ''){
        $(dest).html(kind + " 필수입니다.");
        return false;
    } else {
        $(dest).html("정상");
        return true;
    }
}

function equals(data, checkData, dest){
    if(data == checkData){
        $(dest).html("일치합니다.");
        return true;
    } else {
        $(dest).html("일치하지 않습니다.");
        return false;
    }
}

$("#idCheckBtn").click(function(){
    if($("#id").val().length < 1){
        alert("아이디를 입력하세요");
        return;
    }

    /*$.ajax({
        url : "/member/idCheck?id=" + $("#id").val(),
        success : function(result){
            console.log(result);
        }
    });*/

    const xhttp = new XMLHttpRequest();

    xhttp.open("GET", "/member/idCheck?id=" + $("#id").val());

    xhttp.send();

    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            let result = this.responseText.trim();
            result = JSON.parse(result);
            console.log(result);
        }
    }

});