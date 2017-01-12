<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container">
		<div class="page-header">
            <h1>All Books</h1>

            <p class="lead">List of Available Books</p>
        </div>
<table class="table table-bordered table-hover">
	<thead>
		<tr>
			<th>Title</th>
			<th>Category</th>
			<th>Publisher</th>
			<th>Description</th>
			<th>Price</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${books}" var="book">
		<tr>
			<td>${book.title}</td>
			<td>${book.category}</td>
			<td>${book.publisher }</td>
			<td>${book.description}</td>
			<td>$ ${book.price}</td>
			<th><a href='<spring:url value="/books/${book.id}" />'><span class="glyphicon glyphicon-info-sign"></span></a></th>
		</tr>
	</c:forEach>
</table>
<br><br>
<a href='<spring:url value="/admin/addBook" />' class="btn btn-primary">Add Book</a>
</div>



<%@include file="/WEB-INF/views/templates/footer.jsp" %>