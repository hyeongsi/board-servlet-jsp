<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="container text-center">
	<div class="mt-5 py-3">
		<h1 class="fw-bold">글 수정</h1>
	</div>

	<form action="postEditor" method="post" class="row g-3 w-75 m-auto justify-content-center">
		<div class="col-12 col-xl-10 text-end">
			<button class="btn btn-danger rounded-4">글 삭제</button>
		</div>
		<div class="col-12 col-xl-10">
			<div class="text-start">
				<input type="hidden" name="boardid" value="<c:out value='${boardDTO.boardid}' />" />
				<textarea style="resize: none" class="form-control rounded-4" name="title" id="title" placeholder="제목" required><c:out value="${boardDTO.title}" /></textarea>
			</div>
		</div>
		<div class="col-12 col-xl-10">
			<textarea style="height: 16rem; resize: none" class="form-control rounded-4" name="boardcontent" id="boardcontent" placeholder="내용" required>
				<c:out value="${boardDTO.boardcontent}" /></textarea
			>
		</div>
		<div class="col-12 mt-5">
			<button class="btn btn-primary rounded-4" type="submit">수정하기</button>
			<button class="btn btn-outline-primary rounded-4" type="reset">취소하기</button>
		</div>
	</form>
</section>
