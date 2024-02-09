<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
					<thead>
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
						<tr class="bg-success">
							<th scope="col">ID</th>
							<th scope="col" style="width: 200px">PRODUCT</th>
							<th scope="col">DESCRIPTION</th>
							<th scope="col">PRICE</th>
							<th scope="col">START DATE</th>
							<th scope="col">END DATE</th>
							<th scope="col">DEALERS</th>
							<th scope="col">TOTAL SALES</th>
							<th scope="col">ACTIONS</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="p" items="${productList}">
							<tr>
								<th scope="row">PROD ${p.productId}</th>
								<td>${p.productComp} ${p.productCategory}</td>
								<td>${p.productDesc}</td>
								<td class="font-weight-bold">&#x20B9;${p.productPrice}</td>
								<td>${p.startdt}</td>
								<td>${p.enddt}</td>
								<td>
								<c:forEach var="d" items="${p.dealer}">${d.uname}(${d.dealerId})<br></c:forEach>
								</td>
								<td>${p.sales}</td>
								<td>
								<a href="deleteProduct/${p.productId}"><i class="fa-solid fa-trash-can text-danger"
								style="font-size: 20px;"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="updateProduct/${p.productId}"><i class="fa-solid fa-pen-nib text-warning"
								style="font-size: 20px;"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>	
				  <tr>
					<td>
					<a href="goPreviousPage"> <<< Previous </a>&nbsp;
					<a href="goNextPage">Next>>></a>
					</td>
					</tr>	
				
				<div class="conatiner text-center">
					<a href="${pageContext.request.contextPath}/report"
						class="btn btn-primary">Export</a>

				</div>


			</div>

		</div>


	</div>
</body>
</html>
