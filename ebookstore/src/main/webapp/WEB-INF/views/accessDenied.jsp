<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container">
		<div class="page-header">
            <h1>Access Denied</h1>
        </div>
        
        <div class="container">
        	<c:if test="${pageContext.request.userPrincipal.name != null}">
	        	<h2>Hello ${pageContext.request.userPrincipal.name}.  You are not authorized to access this resource. | <a href="<c:url value="/logout" />">Logout</a></h2>
        	</c:if>

        </div>

</div>

<%@include file="/WEB-INF/views/templates/footer.jsp" %>