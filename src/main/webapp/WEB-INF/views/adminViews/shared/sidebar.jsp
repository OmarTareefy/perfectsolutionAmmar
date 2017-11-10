
<!-- 
				ASIDE 
				Keep it outside of #wrapper (responsive purpose)
			-->
<aside id="aside">
	<!--
					Always open:
					<li class="active alays-open">

					LABELS:
						<span class="label label-danger pull-right">1</span>
						<span class="label label-default pull-right">1</span>
						<span class="label label-warning pull-right">1</span>
						<span class="label label-success pull-right">1</span>
						<span class="label label-info pull-right">1</span>
				-->
	<nav id="sideNav">
		<!-- MAIN MENU -->
		<ul class="nav nav-list">
			<li id="home">
				<!-- dashboard --> <a class="dashboard" href="${contextRoot}/manage/home">
					<i class="main-icon fa fa-dashboard"></i> <span>Dashboard</span>
			</a>
			</li>
			<li id="about">
				<!-- About us --> <a href="${contextRoot}/manage/about">
					<i class="main-icon fa fa-info-circle"></i> <span>About Us</span>
			</a>
			</li>
			<li id="service">
				<!-- Services --> 
				<a href="#">
					<i class="fa fa-menu-arrow pull-right"></i>
					<i class="main-icon fa fa-cube"></i> <span>Services</span>
				</a>
				<ul><!-- submenus -->
				
					<c:forEach items="${services}" var="service">
						<li><a href="${contextRoot}/manage/service/${service.id}">
							${service.nameEn}
						</a></li>
					</c:forEach>
					
					<li><a href="${contextRoot}/manage/service">Add New</a></li>
				</ul>
			</li>
			
			<li id="product">
				<a href="#">
					<i class="fa fa-menu-arrow pull-right"></i>
					<i class="main-icon fa fa-television"></i> <span>Products</span>
				</a>
				<ul><!-- submenus -->
				
				
					<c:forEach items="${products}" var="product">
						<li><a href="${contextRoot}/manage/product/${product.id}">
							${product.nameEn}
						</a></li>
					</c:forEach>
				
					<li><a href="${contextRoot}/manage/product">Add New</a></li>
				</ul>
				<!-- Prodcut -->
			</li>	
			
		</ul>

	</nav>

	<span id="asidebg">
		<!-- aside fixed background -->
	</span>
</aside>
<!-- /ASIDE -->
