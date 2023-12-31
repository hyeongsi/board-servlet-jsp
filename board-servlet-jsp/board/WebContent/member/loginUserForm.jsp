<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="py-1 text-center">
	<h5 class="fw-bold">로그인</h5>
</div>

<section class="container text-center">
	<form action="loginUser" method="post" class="row g-3 w-75 m-auto justify-content-center">
		<div class="col-12 col-xl-10">
			<div class="form-floating">
				<input type="text" class="form-control rounded-4" name="userid" id="userid" placeholder="아이디" maxlength="12" required />
				<label for="userid">아이디</label>
				<div class="invalid-feedback">아이디는 2~12자, 영문 대소문자, 숫자만 사용 가능합니다.</div>
			</div>
		</div>
		<div class="col-12 col-xl-10">
			<div class="form-floating">
				<input type="password" class="form-control rounded-4" name="pw" id="pw" placeholder="비밀번호" maxlength="16" required />
				<label for="pw">비밀번호</label>
				<div class="invalid-feedback">비밀번호는 8~16자, 영문 대소문자, 숫자, 특수문자만 사용 가능합니다.</div>
			</div>
		</div>
		<div class="col-12 mt-5">
			<button class="btn btn-primary rounded-4" type="submit">로그인</button>
		</div>
	</form>
</section>