<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="container text-center">
	<div class="mt-5 py-5">
		<h1 class="fw-bold">내 정보</h1>
	</div>

	<form action="" method="" class="row g-3 w-75 m-auto justify-content-center">
		<div class="col-12 col-xl-10 text-end">
			<button class="btn btn-danger rounded-4" type="button">회원 탈퇴</button>
		</div>
		<div class="col-12 col-xl-10">
			<div class="form-floating">
				<input type="text" class="form-control rounded-4" name="userId" id="userId" placeholder="아이디" maxlength="12" disabled />
				<label for="userId">아이디</label>
				<div class="invalid-feedback">아이디는 2~12자, 영문 대소문자, 숫자만 사용 가능합니다.</div>
			</div>
		</div>
		<div class="col-12 col-xl-10">
			<div class="form-floating">
				<input type="text" class="form-control rounded-4" name="name" id="name" placeholder="이름" maxlength="10" required />
				<label for="name">이름</label>
				<div class="invalid-feedback">닉네임은 2 ~10자, 특수문자를 제외한 한글,영문 대소문자, 숫자만 사용 가능합니다.</div>
			</div>
		</div>
		<div class="col-md-6 col-xl-5">
			<div class="form-floating">
				<input type="password" class="form-control rounded-4" name="pw" id="pw" placeholder="비밀번호" maxlength="16" required />
				<label for="pw">비밀번호</label>
				<div class="invalid-feedback">비밀번호는 8~16자, 영문 대소문자, 숫자, 특수문자만 사용 가능합니다.</div>
			</div>
		</div>
		<div class="col-md-6 col-xl-5">
			<div class="form-floating">
				<input type="password" class="form-control rounded-4" name="pwValid" id="pwValid" placeholder="비밀번호 확인" maxlength="16" required />
				<label for="pwValid">비밀번호 확인</label>
				<div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
			</div>
		</div>
		<div class="col-12 mt-5">
			<button class="btn btn-primary rounded-4" type="submit">수정하기</button>
			<button class="btn btn-outline-primary rounded-4" type="reset">취소하기</button>
		</div>
	</form>
</section>