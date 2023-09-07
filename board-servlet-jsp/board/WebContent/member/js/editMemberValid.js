$(document).ready(function () {
	let pwCheck = /^[a-zA-z0-9`~!@#\$%\^&\*\(\)\{\}\[\]\-_=\+\\|;:'"<>,\./\?]{8,16}$/;

	let pw = $("#pw");
	let pwValid = $("#pwValid");

	// 전송 시 유효성 검사
	$("#editMemberForm").on("submit", function (event) {
		if (!isValid(pwCheck, pw)) {
			submitCkMsg(event, "비밀번호를 확인해주세요.", pw);
		} else if (!isValidPw()) {
			submitCkMsg(event, "비밀번호와 확인을 일치해주세요.", pwValid);
		}
	});

	// pw 유효성 체크 후 유효성 여부에 맞는 클래스 추가
	pw.on("ketdown keypress keyup change", function () {
		if (isValid(pwCheck, $(this))) {
			setValid($(this));
		} else {
			setInvalid($(this));
		}

		pwValid.trigger("change");
	});
	// pw 유효성 체크 후 유효성 여부에 맞는 클래스 추가
	pwValid.on("ketdown keypress keyup change", function () {
		if (isValidPw(pwCheck, $(this))) {
			setValid($(this));
		} else {
			setInvalid($(this));
		}
	});
});
// 유효성 통과 여부 반환
function isValid(objCheck, obj) {
	return objCheck.test(obj.val());
}
// 유효성 통과 여부 반환 (비밀번호 확인 전용)
function isValidPw() {
	return $("#pw").val() == $("#pwValid").val();
}
// 유효하다는 클래스 추가
function setValid(obj) {
	obj.removeClass("is-invalid");
	obj.addClass("is-valid");
}
// 유효하지 않다는 클래스 추가
function setInvalid(obj) {
	obj.removeClass("is-valid");
	obj.addClass("is-invalid");
}

// submit 확인 메시지 부분
function submitCkMsg(event, msg, obj) {
	event.preventDefault();
	alert(msg);
	obj.focus();
}
