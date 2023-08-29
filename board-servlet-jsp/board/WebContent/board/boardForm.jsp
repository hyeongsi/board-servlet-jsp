<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="container text-center">
	<div class="mt-5 py-5">
		<h1 class="fw-bold">게시판</h1>
	</div>
	<div class="col-12 mb-3 text-end">
		<button class="btn btn-outline-success rounded-4 fw-bold"
			type="button">글 작성</button>
	</div>
	<table class="table table-striped">
		<thead>
			<tr class="table-secondary">
				<th scope="col">번호</th>
				<th class="w-50" scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>제목1</td>
				<td>이순신</td>
				<td>23.08.27</td>
				<td>0</td>
			</tr>
			<tr>
				<td>2</td>
				<td>제목2</td>
				<td>유관순</td>
				<td>23.08.28</td>
				<td>1</td>
			</tr>
		</tbody>
	</table>

	<ul class="pagination justify-content-center">
		<li class="page-item"><a class="page-link disabled" href="#">이전</a></li>
		<li class="page-item"><a class="page-link active" href="#">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<li class="page-item"><a class="page-link" href="#">4</a></li>
		<li class="page-item"><a class="page-link" href="#">다음</a></li>
	</ul>
</section>