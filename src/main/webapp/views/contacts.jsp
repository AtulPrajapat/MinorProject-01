<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="y"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	function confirmDelet() {

		return confirm("Are you sure , you want to delete ?");
	}
</script>

</head>
<body>
	<a href="contact">+Add New Contact</a>
	<table border="1">

		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Number</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="contact">
				<tr>
					<th>${contact.contactName}</th>
					<th>${contact.contactEmail}</th>
					<th>${contact.contactNumber}</th>
					<th><a href="edit?cid=${contact.contactId}">Edit</a> <a
						href="delete?cid=${contact.contactId}"
						onclick="return confirmDelet()">Delete</a></th>
				</tr>

			</c:forEach>
		</tbody>
	</table>

</body>
</html>