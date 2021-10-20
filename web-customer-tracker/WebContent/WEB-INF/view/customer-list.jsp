<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

	<div id = "wrapper">
		<div id = "header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id = "container">
		<div id = "content">
		<table id="searchAddCustomer">
			<tbody>
				<tr id = "ROW">
					<td><input type = "button" value = "Add Customer" onclick = "window.location.href='showFormAdd';return false; "
				class="add-button"/></td>
					
					<td id="td">
						<form:form action="search" method = "GET">
							<input type="text" name="theSearchName"/>
							<input type="submit" value="Search" class = "add-button"/>
						</form:form>
					</td>
				</tr>
			</tbody>
		</table>
		
		
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var = "tempCustomer" items = "${customers}">
					<c:url var = "updateCustomer" value = "/customer/update" >
						<c:param name="customerId" value = "${tempCustomer.customerId}"></c:param>
					</c:url>
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td><a href = "delete?id=${tempCustomer.customerId}" onclick = "if(!(confirm('Are you sure to delete the customer?'))) return false"> delete|</a><a href = "${updateCustomer}"> update</a></td>
						</tr>
						
					</c:forEach>
					
				</table>
		</div>
	
	</div>

</body>
</html>