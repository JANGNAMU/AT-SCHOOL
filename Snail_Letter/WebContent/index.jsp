<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<div class= "container-fluid">
			<div class="row">
				<!-- 펜팔 목록 -->
				<div class="col-sm-3" id="PenpalList">
					<h3>펜팔 목록</h3>
					<ul class="list-group">
						<li class="list-group-item list-group-item-action"><a href="펜팔프로필">펜팔1</a>
						<li class="list-group-item list-group-item-action"><a href="펜팔프로필">펜팔2</a>
						<li class="list-group-item list-group-item-action"><a href="펜팔프로필">펜팔3</a>
					</ul>
				</div>
				
				<!-- 편지 작성 -->
				<div class="col-sm-9 col-md-8" id = "Letter">
					<h3>편지 작성</h3>
						<textarea rows="30%" cols="70%" name="Letter" placeholder="손편지를 쓰듯 정성을 담아 보내보세요 :)"></textarea><p>
						<button class="btn btn-primary" type="submit" name="LetterSubmit">전송</button>
						<button class="btn btn-danger" type="reset" name="LetterReset">초기화</button>
			</div>
   		</div>
   	</div>
	
	<footer class="bg-light mt-5 p-4 w-100 text-center" style="color: #050505;">
		<h5 class="text-secondary">Worm Letter</h5> 
		<p> Worm Letter is powered by <span class="text-primary">장남혁</span> / Designed by <span class="text-primary">장남혁</span></p>
	</footer>
</body>
</html>