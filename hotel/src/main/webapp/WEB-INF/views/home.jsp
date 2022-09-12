<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.connection.DatabaseConnection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>together homepage</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css " />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<nav style="background-color:rgba(0, 0, 0, 0.1);"
		class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header" style="width: 100%;">
			<a class="navbar-brand">투게더</a> <input border="1" width="150px;"
				type="text" placeholder='Search' " style="border-radius: 15px">
			<ul class="nav nav-pills" style="float: right;">
				<li class="active"><a href="home.jsp">메인</a></li>
				<li><a href="account.jsp">Accounts</a></li>
				<li><a href="index.jsp">Reservation</a></li>
				<li><a href="room.jsp">Room</a></li>
				<li><a href="logout.jsp"><span class="label label-danger"><%=(String) session.getAttribute("uname")%></span>&nbsp;로그아웃</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div id="myCarousel" class="carousel slide container-fluid"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
			<li data-target="#myCarousel" data-slide-to="5"></li>
			<li data-target="#myCarousel" data-slide-to="6"></li>
		</ol>
		
		<div style="margin: auto;" class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="images/a.jpg" style="width: 100%; height: 450px;" />
			</div>

			<div class="item">
				<img src="images/b.jpg" style="width: 100%; height: 450px;" />
			</div>

			<div class="item">
				<img src="images/c.jpg" style="width: 100%; height: 450px;" />
			</div>

			<div class="item">
				<img src="images/d.jpg" style="width: 100%; height: 450px;" />
			</div>

			<div class="item">
				<img src="images/e.jpg" style="width: 100%; height: 450px;" />
			</div>

			<div class="item">
				<img src="images/f.jpeg" style="width: 100%; height: 450px;" />
			</div>

			<div class="item">
				<img src="images/g.png" style="width: 100%; height: 450px;" />
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span></a>
		<a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<div id="main1" class="carousel slide container-fluid"
		data-ride="carousel" style=" position: relative;">
		<ol class="carousel-indicators">
			<li data-target="#main1" data-slide-to="0" class="active"></li>
			<li data-target="#main1" data-slide-to="1"></li>
			<li data-target="#main1" data-slide-to="2"></li>
		</ol>
		<div style="margin: auto; position: absolute;"  role="listbox" >
			<div class="item active" >
				<img src="images/1.jpg" style="width: 300px; height: 300px;" />
			</div>
			<div class="item">
				<img src="images/2.jpg" style="width: 300px; height: 300px;" />
			</div>

			<div class="item">
				<img src="images/3.jpg" style="width: 300px; height: 300px;" />
			</div>
		</div>
		<div style="margin: auto; position: absolute;" role="listbox" >
			<div class="item active">
				<img src="images/2.jpg" style="width: 300px; height: 300px;" />
			</div>
			<div class="item">
				<img src="images/3.jpg" style="width: 300px; height: 300px;" />
			</div>

			<div class="item">
				<img src="images/1.jpg" style="width: 300px; height: 300px;" />
			</div>
		</div>
		<div style="margin: auto; position: absolute;" role="listbox" >
			<div class="item active">
				<img src="images/3.jpg" style="width: 300px; height: 300px;" />
			</div>
			<div class="item">
				<img src="images/1.jpg" style="width: 300px; height: 300px;" />
			</div>

			<div class="item">
				<img src="images/2.jpg" style="width: 300px; height: 300px;" />
			</div>
		</div>
		<a class="left carousel-control" href="#main1" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span></a>
		<a class="right carousel-control" href="#main1" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<div class="space" style="width: auto; height:500px;"></div>
	<div style="width: 100%; height: 100px; background-color: #ccc" >
		<div style="width: 50%; float: left;">
			<p>고객센터</p>
			<p>주소 : 대전 둔산동 그린 컴퓨터 학원 100호</p>
			<p>전화 : 042-200-200</p>
		</div>
		<div style="width: 50%; float: right; text-align: right;">
			<p>회사정보</p>
			<p>사업자 등록번호 : 152-45147-1487</p>
			<p>회사 주소 : 대전 둔산동 그린 컴퓨터 학원 1005호</p>
		</div>
	</div>
</body>
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.js"></script>
</html>