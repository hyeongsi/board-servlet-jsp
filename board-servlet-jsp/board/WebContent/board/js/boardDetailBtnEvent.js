function fn_edit() {
	$("#writterForm").attr("action", "boardEditUI");
	$("#writterForm").submit();
}

function fn_delete() {
	$("#writterForm").attr("action", "boardDelete");
	$("#writterForm").submit();
}
