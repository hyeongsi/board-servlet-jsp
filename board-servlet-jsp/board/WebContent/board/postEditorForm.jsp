<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/29.1.0/classic/translations/ko.js"></script>

<style>
	.ck-editor__editable {
		min-height: 300px;
	}
</style>

<div class="py-1 text-center">
	<h5 class="fw-bold">글 수정</h5>
</div>

<section class="container text-center mb-4">
	<form action="postEditor" method="post" class="row g-3 w-75 m-auto justify-content-center">
		<div class="col-10">
			<div class="input-group">
				<input type="hidden" name="boardid" value="<c:out value='${boardDTO.boardid}'/>" />
				<span class="input-group-text">제목</span>
				<input type="text" class="form-control" name="title" id="title" value="${boardDTO.title}" required />
			</div>
		</div>

		<div class="col-10">
			<textarea name="boardcontent" id="boardcontent"><c:out value="${boardDTO.boardcontent}" /></textarea>
			<script>
				ClassicEditor.create(document.querySelector("#boardcontent"), {
					language: "ko",
				})
					.then((editor) => {
						console.log("Editor was initialized", editor);

						// 이미지 업로드 이벤트 처리
						editor.plugins.get("FileRepository").createUploadAdapter = (loader) => {
							return {
								upload: () => {
									return loader.file.then((file) => {
										return new Promise((resolve, reject) => {
											const formData = new FormData();
											formData.append("file", file);

											const xhr = new XMLHttpRequest();
											xhr.open("POST", "imageUploadServlet", true);
											xhr.onload = () => {
												if (xhr.status === 200) {
													const response = JSON.parse(xhr.responseText);
													if (response && response.url) {
														resolve({ default: response.url });
													} else {
														reject("Image upload failed");
													}
												} else {
													reject("Image upload failed");
												}
											};
											xhr.send(formData);
										});
									});
								},
								abort: () => {
									// 업로드 취소 처리
								},
							};
						};
					})
					.catch((error) => {
						console.error("Error initializing CKEditor", error);
					});
			</script>
		</div>
		<div class="col-10 mt-3">
			<button class="btn btn-outline-primary" type="submit">작성하기</button>
		</div>
	</form>
</section>
