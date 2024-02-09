<html>
<head>
<%@ include file="./Base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.Product"%>
<%@ page import="java.text.*"%>

<style type="text/css">

/* styling search bar */
.search input[type=text] {
	width: 300px;
	height: 25px;
	border-radius: 25px;
	border: none;
}

.search {
	margin: 7px;
}

.search button {
	background-color: #0074D9;
	color: #f2f2f2;
	padding: 5px 10px;
	margin-right: 16px;
	font-size: 12px;
	border: none;
	cursor: pointer;
}
</style>

</head>


<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	if (session.getAttribute("loginuser") == null) {
		response.sendRedirect("loginPage");
	}
	%>

	<%@ include file="./Navbar.jsp"%>

	<div class="container mt-3">
		<div class="row">

			<div class="col-md-12">

				<h1 class="text-center mb-3">Welcome to Product Management
					Application</h1>

				<table class="table table-hover table-dark">
					<thead class="thead-primary">
						<tr>
							<div class="search" align="center">

								<form action="searchProduct">
									<input type="text" placeholder="Search products" name="search">
									<button>
										<i class="fa fa-search" style="font-size: 18px;"> </i>
									</button>
								</form>
							</div>


							</div>


						</tr>
						<tr>
							<th scope="col">ID</th>
							<th scope="col" style="width: 200px">PRODUCT NAME</th>
							<th scope="col">DESCRIPTION</th>
							<th scope="col">PRICE</th>
							<th scope="col">START DATE</th>
							<th scope="col">END DATE</th>
							<th scope="col">SALES</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${loginuser.product}">
							<tr>
								<th scope="row">PROD ${p.productId}</th>
								<td>${p.productComp}${p.productCategory}</td>
								<td>${p.productDesc}</td>
								<td class="font-weight-bold">&#x20B9;${p.productPrice}</td>
								<td>${p.startdt}</td>
								<td>${p.enddt}</td>
								<td>
									<div class="input-group mb-2">
									<form action="saveSales">
										<input type="number" class="form-control" name="sales" style="width:90px;">
										<input type="hidden" value="${p.productId}" name="pid" />
										<div class="input-group-append">
											<button class="btn btn-primary" type="submit">Save</button>
										</div>
									</form>	
									</div>
								</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>

			</div>

		</div>


	</div>
</body>
</html>
