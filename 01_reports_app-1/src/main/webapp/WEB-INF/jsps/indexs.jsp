<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Report app</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
     integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
     crossorigin="anonymous">
</head>
<body>


		<div class="container">
		   <h3 class ="pb-3 pt-3">Report Application</h3>
		   <form:form action="search" modelAttribute ="search" method="POST">
		<table>
		<tr> 
		<td>plan Name:</td>
		<td>
		<form:select path="planName">
		<form:option value="">-select-</form:option>
		<form:options items ="${names}"/></
		
		</form:select>
		
		</td>
		<td>plan Status::</td>
		<td>
		<form:select path="planStatus">
		<form:option value="">-select-</form:option>
		<form:options items ="${status}"/>
		
		</form:select>
		
		</td>
		
		<td>Gender</td>
		<td>
		<form:select path="gender">
		<form:option value="">-select-</form:option>
		<form:option value="male">male</form:option>
		<form:option value="female">female</form:option>
		</form:select></td>
		</tr>
		<tr>
		<td>Start Date</td>
		<td><form:input path="planStartDate" type="date"/></td>
		<td>End Date</td>
		<td><form:input type="date" path="planEndDate"/></td>
		</tr>
		<tr>
		<td><a href ="indexPage" class ="btn btn-secondary">Reset</a></td>
		<td>
		<input type ="submit" value="search" class ="btn btn-primary"/>
		</td>
		</tr>
		</table>
		</form:form>
		   <hr/>
		   <table class="table table-striped table-hover">
		   <thead>
		   <tr>
		   <th>S.NO</th>
		   <th>Holder Name</th>
		   <th>Gender</th>
		   <th>plan Name</th>
		   <th>plan status</th>
		   <th>start Date </th>
		   <th>end Date</th>
		   </tr>
		   </thead>
		   <tbody>
		  <c:forEach items="${plans}" var ="plan" varStatus="index">
		  <tr>
		  <td>${index.count}</td>
		  <td>${plan.citizenName}</td>
		   <td>${plan.gender}</td>
		  <td>${plan.planName}</td>
		  <td>${plan.planStatus}</td>
		  <td>${plan.planStartDate}</td>
		  <td>${plan.palnEndDate}</td>
		  </tr>
		  </c:forEach>
		  <tr>
		   <c:if test="${empty plans}">
		  <td colspan="7" style="text-align:center"> No Records found</td>
		   </c:if>
		   </tr>
		   </tbody>
		   </table>
		   <hr/>
		   Export: <a href="excel">Excel</a> <a href="pdf">Pdf</a>
		</div>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" 
 integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
  crossorigin="anonymous"></script>
  
  
</body>
</html>