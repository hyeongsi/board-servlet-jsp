<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %>

<section class="container">
	<div class="w-75 m-auto">
		<div class="text-end mb-3">
			<c:choose>
				<c:when test="${not empty login and login.id == boardDTO.id}">
					<div class="col-12 mt-5">
						<form action="#" method="post" id="writterForm"><input type="hidden" name="boardid" value="${boardDTO.boardid}"></form>
						<button class="btn btn-outline-primary rounded-4" type="button" onclick="fn_edit()">수정하기</button>
						<button class="btn btn-outline-danger rounded-4" type="button" onclick="fn_delete()">삭제하기</button>
					</div>
				</c:when>
			</c:choose>
		</div>
		<div class="card mb-5">
			<div class="card-body p-5">
				<div class="card-title mb-5 fw-bold" style="font-size: 1.2rem">
					<c:set var="CRLF" value="\r\n" />
					<c:set var="titleData" value="${boardDTO.title}" />
					<c:set var="titleWords" value="${fn:split(titleData, CRLF)}" />
					<c:forEach items="${titleWords}" var="word">
						<p style="white-space: pre-wrap"><c:out value="${word}" /></p>
					</c:forEach>
				</div>
				<div class="card-subtitle mb-2 text-body-secondary">
					<div class="text-end" style="font-size: 0.7rem">
						<span class="me-3">작성자 <c:out value="${boardDTO.name}" /></span>
						<span class="me-3">조회 <c:out value="${boardDTO.viewcnt+1}" /></span>
						<span><c:out value="${boardDTO.writetime}" /></span>
					</div>
					<hr />
					<div class="card-text">
						<c:set var="boardData" value="${boardDTO.boardcontent}" />
						<c:set var="contentWords" value="${fn:split(boardData, CRLF)}" />
						<c:forEach items="${contentWords}" var="word">
							<p style="white-space: pre-wrap"><c:out value="${word}" /></p>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
