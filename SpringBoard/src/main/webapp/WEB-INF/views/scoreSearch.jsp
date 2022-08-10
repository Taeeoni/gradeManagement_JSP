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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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

<script type='text/javascript'>
	$(function () {
		
		
		if($("[name=name]").val() == null){
			alert("찾는 학번이 없습니다..")
			return window.location.href='http://localhost:8888/ud';
		}
		
	
		$("#submit").click(function () {
		
		if($("[name=kor]").val() < 0 || $("[name=kor]").val() > 100 ){
		alert("점수는 0~100만 가능합니다.")
		return false;
		} 
		if($("[name=eng]").val() < 0 || $("[name=eng]").val() > 100 ){
		alert("점수는 0~100만 가능합니다.")
		return false;
		} 
		if($("[name=mat]").val() < 0 || $("[name=mat]").val() > 100 ){
		alert("점수는 0~100만 가능합니다.")
		return false;
		} 
		
		if($("[name=name]").val().length == 0){
		alert("공백을 입력할 수 없습니다.")
		return false;
		}else if($("[name=name]").val().length > 8) {
			alert("이름은 8자까지만 가능합니다.")
			return false;
		}
		
		var replaceName = /^[가-힣a-zA-Z\s]+$/;
		var x = $("[name=name]").val();
		if (x.length > 0) {
			if (!x.match(replaceName)) { // 정규식으로 지정한 한글, 영어와 같지 않다면 false
			   alert("이름은 한글, 영문만 입력 가능합니다.");
				return false;
			} 
		}

		
		if($("[name=kor]").val().length == 0){
		alert("공백을 입력할 수 없습니다.")
		return false;
		}
		if($("[name=eng]").val().length == 0){
		alert("공백을 입력할 수 없습니다.")
		return false;
		}
		if($("[name=mat]").val().length == 0){
		alert("공백을 입력할 수 없습니다.")
		return false;
		}
		
		});
	});
		
</script>


<body>
	</br>
	<div>
		<button class="button-28" role="button"
			onclick="location.href='http://localhost:8888/score'">전체 학생
			조회</button>
		<button class="button-28" role="button"
			onclick="location.href='http://localhost:8888/add'">학생 성적 추가</button>
		<button class="button-28" role="button"
			onclick="location.href='http://localhost:8888/ud'">학생 성적
			수정/삭제</button>
	</div>
	<h1>성적표</h1>

	<c:forEach var="scoreItem" items="${scoreSearch}">

		<table cellspacing=1 width=600 border=1>
			<form method='post'>
				<tr>
					<td width=100>학년</td>
					<td><input type="search" name='class'
						value='${scoreItem.scoreList.getName()}' /></td>
				</tr>
				<tr>
					<td width=100>시험이름</td>
					<td><input type="search" name='testName'
						value='${scoreItem.testName}' /></td>
				</tr>
				<tr>
					<td width=100>이름</td>
					<td><input type="search" name='name' value='${scoreItem.name}' /></td>
				</tr>
				<tr>
					<td width=100>학번</td>
					<td><input type="search" name='studentid'
						value='${scoreItem.studentid}' /></td>
				</tr>
				<tr>
					<td width=100>국어</td>
					<td><input type="number" name='kor' value='${scoreItem.kor}' /></td>
				</tr>
				<tr>
					<td width=100>영어</td>
					<td><input type="number" name="eng" value='${scoreItem.eng}' /></td>
				</tr>
				<tr>
					<td width=100>수학</td>
					<td><input type="number" name="mat" value='${scoreItem.mat}' /></td>
				</tr>
		</table>
		</br>
		<div>
			<input formaction='http://localhost:8888/ud/update' class='oneLine'
				id='submit' type='submit' value='수정' /> <input
				formaction='http://localhost:8888/ud/delete' class='oneLine'
				type='submit' value='삭제' />
		</div>
		</form>
		</br>
		</br>
	</c:forEach>

	</br>


</body>
</html>