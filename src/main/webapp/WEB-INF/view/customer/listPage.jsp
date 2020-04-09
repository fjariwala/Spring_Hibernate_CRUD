<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/style.css">

<title>List</title>
</head>
<body>
	<p>Customer Lists</p>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">User Id</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email</th>
				<th scope="col">Delete</th>
				<th scope="col">Update</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="indiCustomer" items="${customers }">

				<!-- This link is used for update the data -->
				<c:url var="updateLink" value="/customer/updateForm">
					<c:param name="customerId" value="${indiCustomer.id }" />
				</c:url>
				
				<!-- Delete link -->
				<c:url var="deleteCustomer" value="/customer/deleteCustomer">
					<c:param name="deleteId" value="${indiCustomer.id }"/>
				</c:url>

				<tr>
					<th scope="row">${indiCustomer.id }</th>
					<td>${indiCustomer.firstName }</td>
					<td>${indiCustomer.lastName }</td>
					<td>${indiCustomer.email }</td>
					<td><a href="${deleteCustomer }">Delete</a></td>
					<td><a href="${updateLink }">Update</a></td>
				</tr>

			</c:forEach>


		</tbody>
	</table>



</body>
</html>