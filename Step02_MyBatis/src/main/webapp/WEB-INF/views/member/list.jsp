<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/list.jsp</title>
</head>
<body>
<a href="insertform.do">회원추가</a>
<h3>회원 목록입니다.</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>삭제</th>
			<th>수정</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="tmp" items="${list }">
			<tr>
				<td>${tmp.num }</td>
				<td>${tmp.name }</td>
				<td>${tmp.addr }</td>
				<td><a href="delete.do?num=${tmp.num }">삭제</a></td>
				<td><a href="updateform.do?num=${tmp.num }">수정</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>





