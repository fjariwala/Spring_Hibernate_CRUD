<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<style>
.error {
	color: red
}
</style>

<title>Form</title>

</head>

<body>
	<div class="alert alert-primary" role="alert">Registration form</div>

	<form:form action="saveFormData" modelAttribute="customer"
		method="POST">

		<div class="form-group">

			<label for="firstName">First Name</label>
			<form:input path="firstName" cssclass="form-control" />
			<form:errors path="firstName" cssClass="error" />

		</div>

		<div class="form-group">

			<label for="lastName">Last Name</label>
			<form:input path="lastName" cssclass="form-control"  />
			<form:errors path="lastName" cssClass="error" />

		</div>

		<div class="form-group">

			<label for="email">Email</label>
			<form:input path="email" cssclass="form-control" />
			<form:errors path="email" cssClass="error" />

		</div>

		<button type="submit" class="btn btn-primary">Submit</button>

	</form:form>

</body>
</html>