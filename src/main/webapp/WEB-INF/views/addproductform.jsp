<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./Base.jsp"%>
<style>
.error {
	color: red;
	font-size: 14px;
}

.mul-select {
	width: 100%;
}
</style>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Fill the product details</h1>

				<form:form action="addProductSubmit" method="post"
					modelAttribute="product">
					<div class="form-group">
						<label for="name">Product Company</label> <input type="text"
							class="form-control" name="productComp"
							placeholder="Enter the product company here">

						<form:errors path="productComp" cssClass="error" />
					</div>

					<div class="form-group">
						<label for="name">Product Category</label> <input type="text"
							class="form-control" name="productCategory"
							placeholder="Enter the product category here">

						<form:errors path="productCategory" cssClass="error" />
					</div>

					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea class="form-control" name="productDesc" rows="5"
							placeholder="Enter the product description"></textarea>
						<form:errors path="productDesc" cssClass="error" />
					</div>

					<div class="form-group">
						<label for="price">Product Price</label> <input type="text"
							placeholder="Enter product price" name="productPrice"
							class="form-control">
						<form:errors path="productPrice" cssClass="error" />
					</div>

					<div class="form-group">
						<label for="date">Start Date</label> <input class="form-control"
							name="startdt" type="date" placeholder="Select Start Date"
							data-flatpickr data-date-format="d-m-Y">
					</div>

					<div class="form-group">
						<label for="date">End Date</label> <input class="form-control"
							name="enddt" type="date" placeholder="Select End Date"
							data-flatpickr data-date-format="d-m-Y">
					</div>

					<div class="input-group mb-3">
					    <label for="price">Select Dealers</label>
						<select class="mul-select" name="dealers" multiple>
						
						<c:forEach var="d" items="${dealerList}">
						<option value="${d.uname}">${d.uname}</option>
						</c:forEach>
							
						</select>
					</div>



					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/manufacturerhome"
							class="btn btn-secondary">Back</a>
						<button type="submit" class="bt btn-primary btn-lg">Add</button>
					</div>
				</form:form>

			</div>

		</div>

	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$(".mul-select").select2({
				placeholder : "select dealers",
				tags : true,
				tokenSeparators : [ '/', ',', ',', " " ]
			});

		})
	</script>
</body>
</html>