<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="py-1 text-center">
	<h5 class="fw-bold">내정보</h5>
</div>

<section class="container text-center mb-4">
	<form action="memberDeletion" method="post" class="row g-3 w-75 m-auto justify-content-center" id="deleteMemberForm">
		<div class="col-12 col-xl-10 text-end">
			<input type="hidden" name="userid" value="${login.userid}" />
			<button class="btn btn-outline-danger btn-sm rounded-3" type="button" id="deleteMemberBtn">회원 탈퇴</button>
		</div>
	</form>
	<form action="memberEditor" method="post" class="row g-3 w-75 m-auto justify-content-center" id="editMemberForm">
		<div class="col-12 col-xl-10">
			<div class="form-floating">
				<input type="text" class="form-control rounded-4" value="<c:out value='${login.userid}' />" placeholder="아이디" maxlength="12" disabled />
				<input type="hidden" name="userid" value="<c:out value='${login.userid}' />" />
				<label for="userid">아이디</label>
				<div class="invalid-feedback">아이디는 2~12자, 영문 대소문자, 숫자만 사용 가능합니다.</div>
			</div>
		</div>
		<div class="col-12 col-xl-10">
			<div class="form-floating">
				<input type="text" class="form-control rounded-4" value="<c:out value='${login.name}' />" placeholder="이름" maxlength="10" disabled />
				<input type="hidden" name="name" value="<c:out value='${login.name}' />" />
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
		<div class="col-12 mt-3">
			<button class="btn btn-outline-primary btn-sm rounded-3" type="submit">수정하기</button>
		</div>
	</form>
</section>
