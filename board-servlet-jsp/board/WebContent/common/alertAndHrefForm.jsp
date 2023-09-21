<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	const msg = "${mesg}";
	if(msg != '')
		alert(msg);
	location.href ="${path}";
</script>
