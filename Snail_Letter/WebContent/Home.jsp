<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Snail Letter</title>
	<!-- 폰트 추가 -->
	<link href="https://fonts.googleapis.com/css2?family=Staatliches&display=swap" rel="stylesheet">
	<!-- 부트스트랩 CSS 추가하기  -->
	<link rel="stylesheet" href="./css/bootstrap.min.css">
	<!-- 커스텀 CSS 추가하기  -->
	<link rel="stylesheet" href="./css/custom.css">
	<!-- 아이콘 추가하기  -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<!-- 제이쿼리 자바스크립트 추가하기 -->
	<script src="./js/jquery.min.js"></script>
	<!-- 파퍼 자바스크립트 추가하기 -->
	<script src="./js/popper.js"></script>
	<!-- 부트스트랩 자바스크립트 추가하기 -->
	<script src="./js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-success sticky-top">
		<a class="navbar-brand" href="index.jsp">Snail Letter</a>
		
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
	       	<span class="navbar-toggler-icon"></span>
	    </button>
		<div class="collapse navbar-collapse" id ="navbar">
			<ul class="navbar-nav ml-auto">
				<li class ="nav-item">
					<a class="nav-link" href="Login.jsp">
						<i class = "fa fa-sign-in"></i>로그인
					</a>
				</li>
				<li class ="nav-item">
					<a class="nav-link" href="Register.jsp">
						<i class = "fa fa-plus"></i>회원가입
					</a>
				</li>
				<li class ="nav-item">
					<a class="nav-link" href="Setting.jsp">
						<i class = "fa fa-gear"></i>설정
					</a>
				</li>
			</ul>
		</div>
	</nav><p>
	<!-- Home 화면 -->
	<div id = "main">
		<div id="contents">
			<h1>Slow, But it isn't Boring</h1>
			<p>대화를 나누며 쉬어갈 여유가 없는 당신을 위한 편지</p>
			<a href = "Login.jsp">Get Started</a>
		</div>
	</div>

</body>
</html>