<div class="container">

	<div class="row">

		<div class="col-md-3">
			<%@include file="./share/sidebar.jsp"%>
		</div>

		<div class="col-md-9">

			<div class="row carousel-holder">

				<div class="col-md-12">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						</ol>
						<div class="carousel-inner">
							
							<div class="item active">
								<img class="slide-image" src="${contextRoot }/static/images/banner1.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${contextRoot }/static/images/banner2.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${contextRoot }/static/images/banner3.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${contextRoot }/static/images/banner4.jpg"
									alt="">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>

			</div>

				<div class="row">
                	<div class="col-xs-12">
                		<h3>Our Most Viewed Products</h3>
                		<hr/>
                	</div>
                </div>

                <div class="row is-table-row">
                	
                    <div class="col-sm-4" >                    	
                        <div class="thumbnail">
                            <img  class="landingImg">
                            <h5>{{product.name}}</h5>
                            <hr/>
                            <div class="caption">
                                <h4 class="pull-right">&#8377; </h4>
                                <p></p>
                                <a  class="btn btn-primary pull-right">View</a>
                            </div>
                        </div>
                        
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <h4>Checkout more products!</h4>
                        <hr/>
                        <a class="btn btn-primary" href="${contextRoot}/show/all/products">More Products</a>
                    </div>

                </div>
				
				<div class="row">
                	<div class="col-xs-12">
                		<h3>Our Most Purchased Products</h3>
                		<hr/>
                	</div>
                </div>
               <div class="row is-table-row">
                	
                    <div class="col-sm-4" >                    	
                        <div class="thumbnail">
                            <img  alt="{{product.name}}" class="landingImg">
                            <h5></h5>
                            <hr/>
                            <div class="caption">
                                <h4 class="pull-right">&#8377; </h4>
                                <p></p>
                                <a  class="btn btn-primary pull-right">View</a>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <h4>Checkout more products!</h4>
                        <hr/>
                        <a class="btn btn-primary" href="${contextRoot}/show/all/products">More Products</a>
                    </div>

                </div>

		</div>

	</div>

</div>
<!-- /.container -->