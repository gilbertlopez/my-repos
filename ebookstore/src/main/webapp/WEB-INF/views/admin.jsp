<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container">
		<div class="page-header">
            <h1>Administration Page</h1>
        </div>
        
        <div class="container">
        	<c:if test="${pageContext.request.userPrincipal.name != null}">
	        	<h2>Hello ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout" />">Logout</a></h2>
        	</c:if>

        </div>
        
        <div class="container">
        	<p class="lead">Available administrative tasks.</p>
			<a href='<spring:url value="/admin/bookInventory" />' class="btn btn-primary">Book Inventory</a>
		</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp" %>