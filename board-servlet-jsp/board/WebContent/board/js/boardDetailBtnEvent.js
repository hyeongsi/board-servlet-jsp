"use strict"

function fn_edit() {
	$("#writterForm").attr("action", "postEditorUI");
	$("#writterForm").submit();
}

function fn_delete() {
	$("#writterForm").attr("action", "postDeletion");
	$("#writterForm").submit();
}
