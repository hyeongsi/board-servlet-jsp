function fn_edit() {
	$("#writterForm").attr("action", "postEditorUI");
	$("#writterForm").submit();
}

function fn_delete() {
	$("#writterForm").attr("action", "postDeletion");
	$("#writterForm").submit();
}
			
function toggleReCmtForm(parent_commentid) {
	const inputReCmtDivStr = "#inputReCmt" + parent_commentid;
	const inputReCmtDiv = $(inputReCmtDivStr);
	
	const inputReCmtDivClassAttr = inputReCmtDiv.attr("class");
	if(inputReCmtDivClassAttr === ""){
		inputReCmtDiv.attr("class", "d-none");
	}else{
		inputReCmtDiv.attr("class", "");
	}
	
}

function edtComment(parentid) {
	console.log(parentid);
}
