<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container">
		<div class="page-header">
            <h1>${book.title}</h1>

            <p class="lead">Book Information</p>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src='<c:url value="/resources/images/${book.id}.png" />' alt="image" 
						style="width:100%" />
                </div>

                <div class="col-md-5">
                    <h3>${book.title}</h3>
                    <p>${book.description}</p>
                    <p>
                       <strong>Publisher</strong> : ${book.publisher}
                    </p>
                    <p>
                        <strong>Category</strong> : ${book.category}
                    </p>
                    <h4>${book.price} USD</h4>
                </div>
            </div>
        </div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>