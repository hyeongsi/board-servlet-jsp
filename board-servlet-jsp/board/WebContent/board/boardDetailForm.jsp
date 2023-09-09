<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %>

<section class="container">
	<div class="text-end mb-3">
		<c:choose>
			<c:when test="${not empty login and login.id == BoardDTO.id}">
				<div class="col-12 mt-5">
					<button class="btn btn-outline-primary rounded-4" type="button">수정하기</button>
					<button class="btn btn-outline-danger rounded-4" type="button">삭제하기</button>
				</div>
			</c:when>
		</c:choose>
	</div>
	<div class="card mb-5">
		<div class="card-body p-5">
			<div class="card-title mb-5 fs-2" id="title">
				<c:set var="CRLF" value="\r\n" />
				<c:set var="titleData" value="${BoardDTO.title}" />
				<c:set var="titleWords" value="${fn:split(titleData, CRLF)}" />
				<c:forEach items="${titleWords}" var="word">
					<p style="white-space: pre-wrap"><c:out value="${word}" /></p>
				</c:forEach>
			</div>
			<div class="card-subtitle mb-2 text-body-secondary">
				<div class="text-end fs-6">
					<span class="me-3">작성자 <c:out value="${BoardDTO.name}" /></span>
					<span class="me-3">조회 <c:out value="${BoardDTO.viewcnt+1}" /></span>
					<span><c:out value="${BoardDTO.writetime}" /></span>
				</div>
				<hr />
				<div class="card-text fs-4" id="boardcontent">
					<c:set var="boardData" value="${BoardDTO.boardcontent}" />
					<c:set var="contentWords" value="${fn:split(boardData, CRLF)}" />
					<c:forEach items="${contentWords}" var="word">
						<p style="white-space: pre-wrap"><c:out value="${word}" /></p>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</section>
