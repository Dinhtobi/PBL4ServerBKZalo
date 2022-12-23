<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	  <%@ include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>

</head>
<body>
	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img
							src="https://cdn.freebiesupply.com/logos/large/2x/pinterest-circle-logo-png-transparent.png"
							class="brand_logo" alt="Logo">
					</div>
				</div>
				<c:if test= "${not empty message}">
						<div class="alert alert-${alert}">
					<strong>${message}</strong> 
						</div>
					</c:if>	
				<div class="d-flex justify-content-center form_container">
					<form action="http://localhost:8080/Test-web/dang-nhap"
						id="formlogin" method="POST">
					
				
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input id="username" type="text" name="username"
								class="form-control input_user" value="" placeholder="username">
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input id="matkhau" type="password" name="matkhau"
								class="form-control input_pass" value="" placeholder="password">
						</div>
						<div class="d-flex justify-content-center mt-3 login_container">
							<input type="hidden" value="login" name="action" />
							<button type="submit" name="button" class="btn login_btn">Login</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>