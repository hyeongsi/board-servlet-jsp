function fn_edit() {
	$("#writterForm").attr("action", "postEditorUI");
	$("#writterForm").submit();
}

function fn_delete() {
	$("#writterForm").attr("action", "postDeletion");
	$("#writterForm").submit();
}
			
function toggleReCmtForm(parent_commentid) {
	const contentDivStr = "#content" + parent_commentid;
	const contentDiv = $(contentDivStr);
	
	const inputReCmtDivStr = "#inputReCmt" + parent_commentid;
	const inputReCmtDiv = $(inputReCmtDivStr);
	
	const inputReCmtDivClassAttr = inputReCmtDiv.attr("class");
	if(inputReCmtDivClassAttr === ""){
		inputReCmtDiv.attr("class", "d-none");
	}else{
		inputReCmtDiv.attr("class", "");
	}
	
	contentDiv.attr("class", "p-2");
			
	const updateCmtFormStr = "#updateCmtForm" + parent_commentid;
	const updateCmtForm = $(updateCmtFormStr);
	updateCmtForm.attr("class", "d-none");
}

function toggleEditModeComment(commentid) {
	const contentDivStr = "#content" + commentid;
	const contentDiv = $(contentDivStr);
	
	const updateCmtFormStr = "#updateCmtForm" + commentid;
	const updateCmtForm = $(updateCmtFormStr);
	
	const contentDivClassAttr = contentDiv.attr("class");
	if(contentDivClassAttr === "p-2"){
		contentDiv.attr("class", "p-2 d-none");
		updateCmtForm.attr("class", "");
	}else{
		contentDiv.attr("class", "p-2");
		updateCmtForm.attr("class", "d-none");
	}
	
	const inputReCmtDivStr = "#inputReCmt" + commentid;
	const inputReCmtDiv = $(inputReCmtDivStr);
	inputReCmtDiv.attr("class", "d-none");
}
