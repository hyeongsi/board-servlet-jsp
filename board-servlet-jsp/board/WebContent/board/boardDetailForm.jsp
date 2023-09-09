<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<section class="container text-center">
	<form action="boardWrite" method="post" class="row g-3 w-75 m-auto justify-content-center">
		<div class="col-12 col-xl-10">
			<div class="text-start">
				<textarea style="resize: none" class="form-control rounded-4" name="title" id="title" readonly></textarea>
			</div>
		</div>
		<div class="col-12 col-xl-10">
			<textarea
				style="height: 16rem; resize: none"
				class="form-control rounded-4"
				name="boardcontent"
				id="boardcontent"
				readonly
			></textarea>
		</div>
		<div class="col-12 mt-5">
			<button class="btn btn-primary rounded-4" type="submit">작성하기</button>
			<button class="btn btn-outline-primary rounded-4" type="reset">취소하기</button>
		</div>
	</form>
</section>
