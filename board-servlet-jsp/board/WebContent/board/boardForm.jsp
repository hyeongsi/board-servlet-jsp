<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<div class="py-1 text-center">
	<h5 class="fw-bold">게시판</h5>
</div>

<section class="container text-center">
	<div class="row w-75 m-auto justify-content-center mb-4">
		<c:choose>
			<c:when test="${not empty login}">
				<div class="mb-3 text-end">
					<a href="postCreationUI" class="btn btn-sm btn-outline-primary rounded-3" type="button">글 작성</a>
				</div>
			</c:when>
		</c:choose>
		
		<table class="table table-striped">
			<thead>
				<tr class="table-secondary">
					<th class="col py-3">번호</th>
					<th class="w-50 col py-3">제목</th>
					<th class="col py-3">작성자</th>
					<th class="col py-3">작성일</th>
					<th class="col py-3">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${pageDTO.list}">
					<tr style="cursor: pointer" onclick="location.href='postDetailUI?boardid=${dto.boardid}'">
						<td class="py-3"><c:out value="${dto.boardid}" /></td>
						<td class="py-3"><c:out value="${dto.title}" /></td>
						<td class="py-3"><c:out value="${dto.name}" /></td>
						<td class="py-3"><c:out value="${dto.getPageRenderingWritetime()}" /></td>
						<td class="py-3"><c:out value="${dto.viewcnt}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="col-8 mb-3">
			<form action="boardUI" method="get" class="row">
				<div class="col-4" style="min-width:110px;">
					<select name="searchType" class="form-select" id="select_searchType" data-searchType=${searchDTO.searchType}>
					  <option value="title" id="opt_title">제목</option>
					  <option value="content" id="opt_content">내용</option>
					  <option value="name" id="opt_name">작성자</option>
					</select>
				</div>
				<div class="input-group col">
			        <input class="form-control flex-grow-1" name="search" type="search" value="${searchDTO.search}"placeholder="Search">
			        <button class="btn btn-outline-secondary" type="submit">
			        	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
							  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
						</svg>
					</button>
				</div>
			</form>
		</div>
		
		<div class="d-flex justify-content-center mb-4">
			<ul class="pagination pagination-sm m-auto">
				<c:if test="${pageDTO.curPage eq 1}" >
					<li class="page-item"><a class="page-link disabled" href="#">이전</a></li>	
				</c:if>
				<c:if test="${pageDTO.curPage ne 1}" >
					<li class="page-item"><a class="page-link" href="boardUI?searchType=${searchDTO.searchType}&search=${searchDTO.search}&curPage=${pageDTO.curPage-1}">이전</a></li>	
				</c:if>
				
				<!-- 현재 페이지 active 상태 토글 -->
				<c:forEach begin="${pageDTO.startPage}" end="${pageDTO.endPage}" varStatus="status">
					<c:if test="${pageDTO.curPage eq status.index}" >
						<li class="page-item"><a class="page-link active" href="boardUI?searchType=${searchDTO.searchType}&search=${searchDTO.search}&curPage=${status.index}">${status.index}</a></li>
					</c:if>
					<c:if test="${pageDTO.curPage ne status.index}" >
						<li class="page-item"><a class="page-link" href="boardUI?searchType=${searchDTO.searchType}&search=${searchDTO.search}&curPage=${status.index}">${status.index}</a></li>
					</c:if>
				</c:forEach>
				
				<c:if test="${pageDTO.curPage eq pageDTO.totalPage}" >
					<li class="page-item"><a class="page-link disabled" href="#">다음</a></li>
				</c:if>
				<c:if test="${pageDTO.curPage ne pageDTO.totalPage}" >
					<li class="page-item"><a class="page-link" href="boardUI?searchType=${searchDTO.searchType}&search=${searchDTO.search}&curPage=${pageDTO.curPage+1}">다음</a></li>
				</c:if>
			</ul>
		</div>
	
	</div>
</section>
