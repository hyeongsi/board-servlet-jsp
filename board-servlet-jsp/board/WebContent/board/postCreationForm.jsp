<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/translations/ko.js"></script>
		
<style>
.ck-editor__editable {
	min-height: 300px;
}
</style>

<div class="py-1 text-center">
	<h5 class="fw-bold">글 작성</h5>
</div>	

<section class="container text-center mb-4">
	<form action="postCreation" method="post" class="row g-3 w-75 m-auto justify-content-center">
		<div class="col-10">
			<div class="input-group">
				<span class="input-group-text">제목</span>
				<input type="text" class="form-control" name="title" id="title" required>
			</div>
		</div>
		<div class="col-10">
			<textarea name="boardcontent" id="boardcontent"></textarea>
			<script>
				ClassicEditor.create(document.querySelector("#boardcontent"), {
					language: "ko",
					ckfinder: {
						uploadUrl: "",
					},
				})
					.then((editor) => {
						console.log("Editor was initialized");
					})
					.catch((error) => {
						console.error(error);
					});
			</script>
		</div>
		<div class="col-10 mt-3">
			<button class="btn btn-outline-primary" type="submit">작성하기</button>
		</div>
	</form>
</section>
