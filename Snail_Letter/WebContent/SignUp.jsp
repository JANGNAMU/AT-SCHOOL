<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
	<nav class="navbar navbar-expand-lg navbar-light bg-success">
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
					<a class="nav-link" href="SignUp.jsp">
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

	<section class="container mt-3" style="max-width: 560px;">
		<form method="post" action="SignUpAction.jsp">
			<div class="form-group">
				<h5>아이디</h5>
				<input type="text" name="userID" class="form-control" maxlength="20" placeholder = "아이디"> 
			</div>
			<div class="form-group">
				<h5>비밀번호</h5>
				<input type="password" name="userPW" class="form-control" maxlength="20">
			</div>
			<div class="form-group">
				<h5>이메일</h5>
				<input type="email" name="userEmail" class="form-control" maxlength="30" placeholder = "hongildong@xxxxx.com">
			</div>
			<div class="form-group">
				<h5>성별</h5>
				<input type="text" name="userGender" class="form-control" maxlength="2" placeholder = "남성 or 여성 or 기타로 입력해주세요">
			</div>
			<div class="form-group">
				<h5>생년월일</h5>
				<input type="text" name="userBirth" class="form-control" maxlength="6" placeholder = "-을 뺀 6자리로 입력해주세요">
			</div>
			<div class="form-group">
				<h5>주소</h5>
				<input type="text" name="userLoc" class="form-control" maxlength="50" placeholder = "주소">
			</div>
			<div class="form-group">
				<h5>닉네임</h5>
				<input type="text" name="userName" class="form-control" maxlength="10" placeholder = "닉네임">
			</div>

				<button type="submit" class ="btn btn-primary btn-block">회원가입</button>
			</form>
		</section>

		<footer class="bg-light mt-5 p-4 w-100 text-center" style="color: #050505;">
			<h5 class="text-secondary">Snail Letter</h5> 
			<p> Snail Letter is powered by <span class="text-primary">장남혁</span> / Designed by <span class="text-primary">장남혁</span></p>
		</footer>
</body>
</html>