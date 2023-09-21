<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>

<div class="my-1 text-center">
	<h5 class="fw-bold">글 상세</h5>
</div>
		
<section class="container">
	<div class="row w-75 m-auto justify-content-center mb-4">

			
		<div class="text-end mb-3 col-10">
			<a href="boardUI" class="btn btn-outline-primary btn-sm">목록</a>
			<c:choose>
				<c:when test="${not empty login and login.id == boardDTO.id}">
					<form action="#" method="post" id="writterForm"><input type="hidden" name="boardid" value="${boardDTO.boardid}"></form>
					<a href="#" class="text-secondary" style="font-size: 0.7rem; text-decoration:none" onclick="fn_edit()">수정하기</a>
					<a href="#" class="text-secondary" style="font-size: 0.7rem; text-decoration:none" onclick="fn_delete()">삭제하기</a>
				</c:when>
			</c:choose>
		</div>
	
		<div class="mb-3 col-10">
			<div class="border mb-3 p-3">
				<div name="title" class="mb-3" id="title">${boardDTO.title}</div>
				<div class="text-end" style="font-size: 0.7rem">
					<span class="me-3">작성자 <c:out value="${boardDTO.name}" /></span>
					<span class="me-3">조회 <c:out value="${boardDTO.viewcnt+1}" /></span>
					<span><c:out value="${boardDTO.writetime}" /></span>
				</div>
			</div>
					
			<div class="border mb-3 p-3">
				<div class="ck-content">${boardDTO.boardcontent}</div>
			</div>
			
			<div class="border mb-3 p-3 ">
				<div class="mb-3">
					
					<c:forEach var="commentDTO" items="${commentDTOList}">
					<div class="mb-3">
						<div class="d-flex justify-content-between">
							<div>
								<span class="me-3"><b>${commentDTO.id}<b/></<span>
								<span class="text-secondary" style="font-size: 0.7rem">작성일</<span>
							</div>
							<div>
								<c:if test="${login.id eq commentDTO.id}">
									<a href="#" class="text-secondary" style="font-size: 0.7rem; text-decoration:none" onclick="">댓글달기</a>
									<span class="vr"></span>
									<a href="#" class="text-secondary" style="font-size: 0.7rem; text-decoration:none" onclick="">수정하기</a>
									<span class="vr"></span>
									<a href="CommentDelete?commentid=${commentDTO.commentid}&boardid=${commentDTO.boardid}&id=${commentDTO.id}" class="text-secondary" style="font-size: 0.7rem; text-decoration:none">삭제하기</a>
								</c:if>
							</div>
						</div>
						
						<div class="p-2" style="white-space:pre-wrap">${commentDTO.content}</div>
						<hr>
					</div>
					</c:forEach>

				</div>
			
				<c:choose>
					<c:when test="${not empty login}">
						<form action="CommentUpload" method="post">
							<div class="input-group">
								<input type="hidden" name="boardid" value="${boardDTO.boardid}">
								<input type="hidden" name="id" value="${boardDTO.id}">
								<label class="input-group-text" for="comment">댓글</label>
								<textarea class="form-control" id="comment" name="content"></textarea>
								<button class="btn btn-outline-secondary" type="submit">입력</button>
							</div>
						</form>
					</c:when>
				</c:choose>
				
			</div>
		</div>
	</div>
</section>
