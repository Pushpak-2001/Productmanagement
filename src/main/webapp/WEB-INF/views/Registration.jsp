<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.*"%>

<!doctype html>
<html lang="en">
<head>
<script type="text/javascript">
function onlyOne(checkbox) {
    var checkboxes = document.getElementsByName('check')
    checkboxes.forEach((item) => {
        if (item !== checkbox) item.checked = false
    })
}

</script>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>REGISTRATION</title>
</head>
<body style="background:grey;">
	<%@ include file="./Navbar.jsp"%>

	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
		<div class="card">
		<div class="card-body px-5">
		<h3 class="text-center my-3">REGISTRATION FORM</h3>
		
			<form action="registrationform">

				<div class="form-group">
					<label for="exampleInputEmail1">Username</label> <input
						type="text" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Enter username"
						name="uname"> <small id="emailHelp"
						class="form-text text-muted"></small>
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Enter email"
						name="email"> <small id="emailHelp"
						class="form-text text-muted">We'll never share your email
						with anyone else.</small>
				</div>

				<div class="form-group">
					<label for="phone">Mobile</label> <input type="number"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Enter Mobile no."
						name="mobile"> <small id="emailHelp"
						class="form-text text-muted"></small>
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Password" name="pwd">
				</div>


				<div class="form-check float-left">
					<input type="checkbox" value="manufacturer" class="form-check-input" name="check" onclick="onlyOne(this)">
					<label class="form-check-label" for="exampleCheck1">MANUFACTURER</label>
				</div>

				<div class="form-check float-right">
					<input type="checkbox" value="dealer" class="form-check-input" name="check" onclick="onlyOne(this)">
					<label class="form-check-label" for="exampleCheck1">DEALER</label>
				</div>

				<br> <br>

				<div class="container text-center">
					<button type="submit" class="btn btn-outline-success">SIGN
						UP</button>

				</div>

<h6 style="color: green; text-align: center;">${frwdmessage}</h6>

			</form>
			</div>
			</div>

		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>