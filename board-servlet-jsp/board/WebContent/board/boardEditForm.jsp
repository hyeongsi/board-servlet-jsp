<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section class="container text-center">
	<div class="mt-5 py-3">
		<h1 class="fw-bold">글 수정</h1>
	</div>

	<form action="#" method="post"
		class="row g-3 w-75 m-auto justify-content-center">
		<div class="col-12 col-xl-10 text-end">
			<button class="btn btn-danger rounded-4">글 삭제</button>
		</div>
		<div class="col-12 col-xl-10">
			<div class="text-start">
				<textarea style="resize: none;"
					class="form-control rounded-4" name="title" id="title"
					placeholder="제목" required></textarea>
			</div>
		</div>
		<div class="col-12 col-xl-10">
			<textarea style="height: 16rem; resize: none;"
				class="form-control rounded-4" name="content" id="content"
				placeholder="내용" required></textarea>
		</div>
		<div class="col-12 mt-5">
			<button class="btn btn-primary rounded-4" type="submit">수정하기</button>
			<button class="btn btn-outline-primary rounded-4" type="reset">취소하기</button>
		</div>
	</form>
</section>