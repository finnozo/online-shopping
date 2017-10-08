<div class="container">

	<div class="row">
		<!-- would be to display sidebar -->
		<!-- Categories -->
		<%@include file="share/sidebar.jsp" %>

		<!-- to display the actual products -->
		<div class="col-md-9">
			<!-- ADDED BREADCRUM COMPONENT -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
						
						<ol class="breadcrumb breadcrumb-arrow">
							<li><a href="/home">Home</a></li>
							<li class="active"><span>All Products</span></li>
						</ol>
						
						
					</c:if>
					
					<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb breadcrumb-arrow">
							<li><a href="/home">Home</a></li>
							<li class="active"><a href="#">Category</a></li>
							<li class="active"><span>${category.name }</span></li>

						</ol>
					</c:if>
				</div>
			</div>
		</div>

	</div>



</div>