<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="py-1 text-center">
	<h5 class="fw-bold">회원가입</h5>
</div>

<section class="container text-center">
	<form action="memberRegistration" method="post" class="row g-3 w-75 m-auto justify-content-center" id="registerForm">
		<div class="col-12 col-xl-10">
			<div class="input-group gap-3 align-items-center">
				<div class="form-floating">
					<input type="text" class="form-control rounded-4" name="userid" id="userid" placeholder="아이디" maxlength="12" /> <label for="userid">아이디</label>
					<div class="invalid-feedback">아이디는 2~12자, 영문 대소문자, 숫자만 사용 가능합니다.</div>
				</div>
				<button type="button" class="btn btn-outline-primary rounded-3 h-25" id="idCkBtn">중복확인</button>
			</div>
		</div>
		<div class="col-12 col-xl-10">
			<div class="input-group gap-3 align-items-center">
				<div class="form-floating">
					<input type="text" class="form-control rounded-4" name="name" id="name" placeholder="이름" maxlength="10" /> <label for="name">이름</label>
					<div class="invalid-feedback">닉네임은 2 ~10자, 특수문자를 제외한 한글,영문 대소문자, 숫자만 사용 가능합니다.</div>
				</div>
				<button type="button" class="btn btn-outline-primary rounded-3 h-25" id="nameCkBtn">중복확인</button>
			</div>
		</div>
		<div class="col-md-6 col-xl-5">
			<div class="form-floating">
				<input type="password" class="form-control rounded-4" name="pw" id="pw" placeholder="비밀번호" maxlength="16" />
				<label for="pw">비밀번호</label>
				<div class="invalid-feedback">비밀번호는 8~16자, 영문 대소문자, 숫자, 특수문자만 사용 가능합니다.</div>
			</div>
		</div>
		<div class="col-md-6 col-xl-5">
			<div class="form-floating">
				<input type="password" class="form-control rounded-4" name="pwValid" id="pwValid" placeholder="비밀번호 확인" maxlength="16" />
				<label for="pwValid">비밀번호 확인</label>
				<div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
			</div>
		</div>
		<div class="col-12 mt-5">
			<button class="btn btn-outline-success rounded-3" type="submit">가입하기</button>
			<button class="btn btn-outline-warning rounded-3" type="reset">취소하기</button>
		</div>
	</form>
</section>
