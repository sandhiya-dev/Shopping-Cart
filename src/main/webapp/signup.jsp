<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>signup page</title>
<%@include file="includes/head.jsp"%>
</head>
<body>


	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center font-weight-bold">SIGN UP</div>
			<div class="card-body">
				<form action="sign-up" method="post">
				<div class="form-group">
						<label>Name</label> <input type="text"
							class="form-control" name="name"
							placeholder="Enter Your Email" required>
					</div>

					<div class="form-group">
						<label>Email Address</label> <input type="email"
							class="form-control" name="email"
							placeholder="Enter Your Email" required>
					</div>


					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password"
							placeholder="Enter Your Password" required>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Sign Up</button>
					</div>
					</div>
					<div class="text-center">
						<p>Already a member ?<a href="login.jsp"> Login</a></p>
					</div>
					

				</form>
			</div>
		</div>
	</div>


	<%@include file="includes/footer.jsp"%>
</body>
</html>