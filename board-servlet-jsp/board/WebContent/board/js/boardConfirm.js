$(document).ready(function () {
	$("#title").on("keydown keypress keyup change", function () {
		fn_checkByte(this, 200);
	});

	$("#boardcontent").on("keydown keypress keyup change", function () {
		fn_checkByte(this, 4000);
	});
});

function fn_checkByte(obj, maxByte) {
	const text_val = obj.value; //입력한 문자
	const text_len = text_val.length; //입력한 문자수

	let totalByte = 0;
	let len = 0;
	for (let i = 0; i < text_len; i++) {
		const each_char = text_val.charAt(i);
		const uni_char = escape(each_char); //유니코드 형식으로 변환
		if (uni_char.length > 4) {
			// 한글 : 3Byte
			totalByte += 3;
		} else {
			// 영문,숫자,특수문자 : 1Byte
			totalByte += 1;
		}

		if (totalByte > maxByte) {
			alert("최대 " + maxByte + "Byte까지만 입력가능합니다.");
			obj.value = text_val.substr(0, len);
			break;
		} else {
			len++;
		}
	}
}
