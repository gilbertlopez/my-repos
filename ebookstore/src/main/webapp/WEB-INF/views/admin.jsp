<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container">
		<div class="page-header">
            <h1>Admin Page</h1>

            <p class="lead">Available administrative tasks.</p>
        </div>
        
<a href='<spring:url value="/admin/bookInventory" />' class="btn btn-primary">Book Inventory</a>

</div>

<%@include file="/WEB-INF/views/templates/footer.jsp" %>