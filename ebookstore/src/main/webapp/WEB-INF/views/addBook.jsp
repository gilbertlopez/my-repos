<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container">
		<div class="page-header">
            <h1>Add Book Page</h1>

            <p class="lead">Book Information</p>
        </div>
        <div class="container">
 			<form:form action="${pageContext.request.contextPath}/admin/saveBook" modelAttribute="book" method="POST" enctype="multipart/form-data">
 				<div class="form-group">
 					<label for="title">Title</label>
 					<form:errors path="title" cssStyle="color: #ff0000;" />
 					<form:input path="title" id="title" class="form-control"/>
 				</div>
 				<div class="form-group">
 					<label for="description">Description</label>
 					<form:errors path="description" cssStyle="color: #ff0000;" />
 					<form:textarea path="description" id="description" class="form-control"/>
 				</div>
  				<div class="form-group">
 					<label for="publisher">Publisher</label>
 					<form:errors path="publisher" cssStyle="color: #ff0000;" />
 					<form:input path="publisher" id="publisher" class="form-control"/>
 				</div>				 				
 				<div class="form-group">
 					<label for="category">Category</label>
 					<form:errors path="category" cssStyle="color: #ff0000;" />
 					<form:input path="category" id="category" class="form-control"/>
 				</div>
  				<div class="form-group">
 					<label for="price">Price</label>
 					<form:errors path="price" cssStyle="color: #ff0000;" />
 					<form:input path="price" id="price" class="form-control"/>
 				</div>
	 			<div class="form-group">
					<label class="control-label" for="bookImage">Upload Image File</label>
					<form:input path="bookImage" id="bookImage" type="file"
						class="form:input-large" />
				</div>
 				
 				<br><br>
				<input type="submit" value="Add" class="btn btn-primary" >
				<a href='<spring:url value="/admin/bookInventory" />' class="btn btn-default">Cancel</a>							 			
 			</form:form>
        </div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>