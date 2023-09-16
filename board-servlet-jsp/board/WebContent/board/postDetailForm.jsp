<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="my-1 text-center">
	<h5 class="fw-bold">글 상세</h5>
</div>
		
<section class="container">
	<div class="row w-75 m-auto justify-content-center mb-4">

			
		<div class="text-end mb-3 col-10">
			<c:choose>
				<c:when test="${not empty login and login.id == boardDTO.id}">
					<form action="#" method="post" id="writterForm"><input type="hidden" name="boardid" value="${boardDTO.boardid}"></form>
					<a href="#" class="text-secondary" style="font-size: 0.7rem" onclick="fn_edit()">수정하기</a>
					<a href="#" class="text-secondary" style="font-size: 0.7rem" onclick="fn_delete()">삭제하기</a>
				</c:when>
			</c:choose>
		</div>
	
		<div class="col-10">
			<div class="border mb-3 p-3">
				<div name="title" class="mb-3" id="title">${boardDTO.title}</div>
				<div class="text-end" style="font-size: 0.7rem">
					<span class="me-3">작성자 <c:out value="${boardDTO.name}" /></span>
					<span class="me-3">조회 <c:out value="${boardDTO.viewcnt+1}" /></span>
					<span><c:out value="${boardDTO.writetime}" /></span>
				</div>
			</div>
					
			<div class="border p-3">
				<div>${boardDTO.boardcontent}</div>
			</div>
			
		</div>
	</div>
</section>
