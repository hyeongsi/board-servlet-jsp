<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script
	src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>

<div class="my-1 text-center">
	<h5 class="fw-bold">글 상세</h5>
</div>

<section class="container">
	<div class="row w-75 m-auto justify-content-center mb-4">
		<div class="text-end mb-3 col-10">
			<a href="boardUI" class="btn btn-outline-primary btn-sm">목록</a>
			<c:choose>
				<c:when test="${not empty login and login.id == boardDTO.id}">
					<form action="#" method="post" id="writterForm">
						<input type="hidden" name="boardid" value="${boardDTO.boardid}">
					</form>
					<a href="#" class="text-secondary"
						style="font-size: 0.7rem; text-decoration: none"
						onclick="fn_edit()">수정하기</a>
					<a href="#" class="text-secondary"
						style="font-size: 0.7rem; text-decoration: none"
						onclick="fn_delete()">삭제하기</a>
				</c:when>
			</c:choose>
		</div>

		<div class="mb-3 col-10">
			<div class="border mb-3 p-3">
				<div name="title" class="mb-3" id="title"><c:out value="${boardDTO.title}" /></div>
				<div class="text-end" style="font-size: 0.7rem">
					<span class="me-3">작성자 <c:out value="${boardDTO.name}" /></span> <span
						class="me-3">조회 <c:out value="${boardDTO.viewcnt+1}" /></span> <span><c:out
							value="${boardDTO.writetime}" /></span>
				</div>
			</div>

			<div class="border mb-3 p-3">
				<div class="ck-content" style="min-height:250px">${boardDTO.boardcontent}</div>
			</div>

			<div class="border mb-3 p-3 ">

				<c:forEach var="commentDTO" items="${commentDTOList}">
					<div class="mb-3 d-flex">
						<div>
							<c:forEach var="i" begin="2" end="${commentDTO.level}">
								&nbsp&nbsp
								<c:if test="${i eq commentDTO.level}">
									<c:if test="${i%2 eq 0}">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right" viewBox="0 0 16 16">
										  <path d="M6 12.796V3.204L11.481 8 6 12.796zm.659.753 5.48-4.796a1 1 0 0 0 0-1.506L6.66 2.451C6.011 1.885 5 2.345 5 3.204v9.592a1 1 0 0 0 1.659.753z"/>
										</svg>
									</c:if>
									<c:if test="${i%2 eq 1}">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-caret-right-fill" viewBox="0 0 16 16">
										  <path d="m12.14 8.753-5.482 4.796c-.646.566-1.658.106-1.658-.753V3.204a1 1 0 0 1 1.659-.753l5.48 4.796a1 1 0 0 1 0 1.506z"/>
										</svg>
									</c:if>
								</c:if>
								&nbsp
							</c:forEach>
						</div>
						<div class="flex-fill">
							<div class="d-flex justify-content-between">
								<div>
									<span class="me-3"><b><c:out value="${commentDTO.name}" /></b></span>
												<span class="text-secondary" style="font-size: 0.7rem"><c:out value="${commentDTO.writetime}" /></span>
								</div>
								<div>
									<c:if test="${not empty login}">
										<a href="javascript:;" class="text-secondary"
											style="font-size: 0.7rem; text-decoration: none"
											onclick="toggleReCmtForm(${commentDTO.commentid})">댓글달기</a>
										<span class="vr"></span>
									</c:if>
									<c:if test="${login.id eq commentDTO.id}">
										<a href="javascript:;" class="text-secondary"
											style="font-size: 0.7rem; text-decoration: none"
											onclick="toggleEditModeComment(${commentDTO.commentid})">수정하기</a>
										<span class="vr"></span>
										<a
											href="CommentDeletion?commentid=${commentDTO.commentid}&boardid=${commentDTO.boardid}&id=${commentDTO.id}"
											class="text-secondary"
											style="font-size: 0.7rem; text-decoration: none">삭제하기</a>
									</c:if>
								</div>
							</div>

							<div class="p-2" style="white-space: pre-wrap" id="content${commentDTO.commentid}"><c:out value="${commentDTO.content}" /></div>
							
							<!-- 수정 입력창 -->
							<div id="updateCmtForm${commentDTO.commentid}" class="d-none">
								<form action="CommentEditor" method="post">
									<div class="input-group">
										<input type="hidden" name="commentid"
											value="${commentDTO.commentid}">
										<input type="hidden" name="boardid" id="boardid"
											value="${boardDTO.boardid}"> <input type="hidden"
											name="writerid" value="${boardDTO.id}">
										<textarea class="form-control" name="content">${commentDTO.content}</textarea>
									</div>
									<div class="mt-2 text-end">
										<button class="btn btn-outline-secondary btn-sm" type="submit">등록</button>
										<button class="btn btn-outline-secondary btn-sm" type="button" onclick="">취소</button>
									</div>
									
								</form>
							</div>
							
							<!-- 대댓글 입력창 -->
							<div id="inputReCmt${commentDTO.commentid}" class="d-none">
								<form action="CommentUploader" method="post">
									<div class="input-group">
										<input type="hidden" name="parent_commentid"
											 value="${commentDTO.commentid}">
										<input type="hidden" name="boardid" 
											value="${boardDTO.boardid}"> <input type="hidden"
											name="id"  value="${boardDTO.id}">
										<textarea class="form-control" name="content"></textarea>
										<button class="btn btn-outline-secondary" type="submit">입력</button>
									</div>
								</form>
							</div>
							<hr class="my-1">
						</div>

					</div>

				</c:forEach>

				<c:choose>
					<c:when test="${not empty login}">
						<form action="CommentUploader" method="post">
							<div class="input-group">
								<input type="hidden" name="boardid" id="boardid"
									value="${boardDTO.boardid}"> <input type="hidden"
									name="id" id="id" value="${boardDTO.id}">
								<textarea class="form-control" name="content"></textarea>
								<button class="btn btn-outline-secondary" type="submit">입력</button>
							</div>
						</form>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</section>
