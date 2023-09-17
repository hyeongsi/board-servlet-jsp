"use strict";

$(document).ready(function () {
	setSearchTypeChecked();
});

function setSearchTypeChecked() {
	const title = "title";
	const content = "content";
	const name = "name";

	const searchType = $("#select_searchType").attr("data-searchType");
	switch (searchType) {
		case title:
			$("#opt_title").prop("selected", true);
			return;
		case content:
			$("#opt_content").prop("selected", true);
			return;
		case name:
			$("#opt_name").prop("selected", true);
			return;
		default:
			return;
	}
}
