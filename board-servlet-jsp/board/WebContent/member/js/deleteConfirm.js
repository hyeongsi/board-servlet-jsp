$(document).ready(function () {
	$("#deleteMemberBtn").on("mouseup ", function () {
		let result = confirm("회원을 탈퇴하시겠습니까?");

		if (result == false) {
			return;
		}

		$("#deleteMemberForm").submit();
	});
});
