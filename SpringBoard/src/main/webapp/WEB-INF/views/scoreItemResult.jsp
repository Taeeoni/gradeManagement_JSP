<%@ page language="java" contentType="text/html; charset=utf-8;"
	pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="kr.ac.kopo.kopo11.domain.ScoreItem"%>
<%@ page import="kr.ac.kopo.kopo11.domain.ScoreList"%>
<%@ page import="kr.ac.kopo.kopo11.repository.ScoreListRepository"%>
<%@ page import="kr.ac.kopo.kopo11.repository.ScoreItemRepository"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>

<style>
th {
	background: cornflowerblue;
}

table {
	margin-left: auto;
	margin-right: auto;
}

h1, h3, input, div {
	text-align: center;
}

a {
	font-size: 20px;
	margin-left: 5px;
	color: black;
	text-decoration: none;
}

.nowRed {
	color: red;
	text-decoration: underline;
}

.button-28 {
	appearance: none;
	background-color: transparent;
	border: 2px solid #1A1A1A;
	border-radius: 15px;
	box-sizing: border-box;
	color: #3B3B3B;
	cursor: pointer;
	display: inline-block;
	font-family: Roobert, -apple-system, BlinkMacSystemFont, "Segoe UI",
		Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji",
		"Segoe UI Symbol";
	font-size: 16px;
	font-weight: 600;
	line-height: normal;
	margin: 0;
	min-height: 60px;
	min-width: 0;
	outline: none;
	padding: 16px 24px;
	text-align: center;
	text-decoration: none;
	transition: all 300ms cubic-bezier(.23, 1, 0.32, 1);
	user-select: none;
	-webkit-user-select: none;
	touch-action: manipulation;
	width: 30%;
	will-change: transform;
}

.button-28:disabled {
	pointer-events: none;
}

.button-28:hover {
	color: #fff;
	background-color: #1A1A1A;
	box-shadow: rgba(0, 0, 0, 0.25) 0 8px 15px;
	transform: translateY(-2px);
}

.button-28:active {
	box-shadow: none;
	transform: translateY(0);
}
</style>

<%

%>
<body>
</br>
<div>
	<button class="button-28" role="button" onclick="location.href='http://localhost:8888/score'">전체 학생 조회</button>
	<button class="button-28" role="button" onclick="location.href='http://localhost:8888/add'">학생 성적 추가</button>
	<button class="button-28" role="button" onclick="location.href='http://localhost:8888/ud'">학생 성적 수정/삭제</button>	
</div>
	<h1>성적표</h1>

	<table cellspacing=1 width=600 border=1>
			<tr>
				<th width=50><p align=center>이름</p></th>
				<th width=50><p align=center>학번</p></th>
				<th width=50><p align=center>국어</p></th>
				<th width=50><p align=center>영어</p></th>
				<th width=50><p align=center>수학</p></th>
			</tr>
		<c:forEach var="scoreItem" items="${scoreItemResult}">
			<tr>
				<td width=50><p align=center>${scoreItem.name}</p></td>
				<td width=50><p align=center>${scoreItem.studentid}</p></td>
				<td width=50><p align=center>${scoreItem.kor}</p></td>
				<td width=50><p align=center>${scoreItem.eng}</p></td>
				<td width=50><p align=center>${scoreItem.mat}</p></td>
			</tr>
		</c:forEach>
	</table>
	</br>
			<div>
		
		<c:if test="${p.pageStart != 1}">
		<a href='index.jsp?key=${p.ppPage}'>&#11244</a>
		<a href='index.jsp?key=${p.pPage}'>&#11164</a>
		</c:if>
		
		<c:set var="isBreak" value="false"/>
		<c:set var="nowRed" value=""/>
		<c:forEach var="i" begin="0" end ="9" step="1">	
			<c:if test="${isBreak != true}">
				<c:if test="${p.pageStart + i == p.cPage}">
					<c:set var="nowRed" value="class='nowRed'"/>
				</c:if>
				<a href='index.jsp?key=${p.pageStart + i}' ${nowRed}>${p.pageStart + i}</a>
				<c:set var="nowRed" value=""/>
				<c:if test="${p.pageStart + i == p.nnPage}">				
					<c:set var="isBreak" value="true"/>
				</c:if>
			</c:if>
		</c:forEach>
		
		<c:if test="${p.isLast == 0}">
		<a href='index.jsp?key=${p.npage}'>&#11166</a>
		<a href='index.jsp?key=${p.nnPage}'>&#11246</a>
		</c:if>

		</div>


</body>
</html>