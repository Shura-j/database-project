<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<div class="container mt-5">
		<h1 class="display-4 text-center text-danger">Error Happened</h1>
		
		<div class="card">
			<div class="card-body">
				<h5 class="card-title text-danger">${message}</h5>
				<p>error description</p>
				<a href="/" class="btn bnt-lg btn-light text-danger">Back To Home</a>
			</div>
		</div>
	</div>
</body>
</html>