$(document).ready(function () {
	let useridCheck = /^[a-zA-z0-9]{2,12}$/;
	let nameCheck = /^[a-zA-z0-9가-힣]{2,10}$/;
	let pwCheck = /^[a-zA-z0-9`~!@#\$%\^&\*\(\)\{\}\[\]\-_=\+\\|;:'"<>,\./\?]{8,16}$/;

	let userid = $("#userid");
	let name = $("#name");
	let pw = $("#pw");
	let pwValid = $("#pwValid");

	let isUseridCheck = false;
	let isNameCheck = false;

	// 전송 시 유효성 검사
	$("#registerForm").on("submit", function (event) {
		if (!isUseridCheck) {
			submitCkMsg(event, "아이디 중복확인이 필요합니다.", userid);
		} else if (!isNameCheck) {
			submitCkMsg(event, "닉네임 중복확인이 필요합니다.", name);
		} else if (!isValid(pwCheck, pw)) {
			submitCkMsg(event, "비밀번호를 확인해주세요.", pw);
		} else if (!isValidPw()) {
			submitCkMsg(event, "비밀번호와 확인을 일치해주세요.", pwValid);
		} 
	});

	// userid 입력시 중복검사 결과 초기화
	userid.on("ketdown keypress keyup change", function () {
		$(this).removeClass("is-invalid");
		$(this).removeClass("is-valid");
		isUseridCheck = false;
	});
	// name 입력시 중복검사 결과 초기화
	name.on("ketdown keypress keyup change", function () {
		$(this).removeClass("is-invalid");
		$(this).removeClass("is-valid");
		isNameCheck = false;
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

	$("#idCkBtn").on("click", function () {
		if (!isValid(useridCheck, $(userid))) {
			setInvalid(userid);
			return;
		}

		$.ajax({
			type: "GET",
			url: "useridCheck",
			dataType: "text",
			data: {
				userid: userid.val(),
			},
			success: function (data, status, xhr) {
				if (data == "success") {
					setValid(userid);
					isUseridCheck = true;
					alert("사용 가능한 아이디입니다.");
				} else {
					setInvalid(userid);
					isUseridCheck = false;
					alert("이미 존재하는 아이디입니다.");
				}
			},
		});
	});
	$("#nameCkBtn").on("click", function () {
		if (!isValid(nameCheck, name)) {
			setInvalid(name);
			return;
		}

		$.ajax({
			type: "GET",
			url: "nameCheck",
			dataType: "text",
			data: {
				name: name.val(),
			},
			success: function (data, status, xhr) {
				if (data == "success") {
					setValid(name);
					isNameCheck = true;
					alert("사용 가능한 닉네임입니다.");
				} else {
					setInvalid(name);
					isNameCheck = false;
					alert("이미 존재하는 닉네임입니다.");
				}
			},
		});
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
