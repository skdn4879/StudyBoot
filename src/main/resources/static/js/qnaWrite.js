let fileCount = 0;
let fileLimit = 5;
let flag = true;

$("#fileAddBtn").click(function(){

    if(flag){
        let size = $("#fileList").attr("data-file-size");

        if(size == undefined){
            size = 0;
        }
        fileCount = size;
        flag = false;
    }

    if(fileCount >= fileLimit){
        return;
    }

    fileCount++;
    let fileTemp = $("#fileInputTemp").html();
    $("#fileList").append(fileTemp);
});

$("#fileList").on("click", ".fileRemoveBtn", function(){
    $(this).parent().remove();
    fileCount--;
});

// 글 수정 시 첨부파일을 삭제
$(".deleteFile").click(function(){
    // DB, HDD에 파일 삭제
    let check = confirm("삭제 시 복구 불가");
    let idx = $(this);

    if(check){
        // post
        // /qna/fileDelete
        // 파라미터 : fileNum

        $.ajax({
            type : "POST",
            url : "/qna/fileDelete",
            data : {
                fileNum : $(this).attr("data-num")
            },
            success : function(result){
                let complete = result.result;

                if(complete == 1){
                    $(idx).parent().remove();
                }

            }
        })

    }

});