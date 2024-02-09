<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./Base.jsp"%>
<title>Upload file</title>
</head>
<body>
	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
			<form action="uploadAction" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="exampleFormControlFile1">Upload Excel File</label> <input
						type="file" name="xlfile" class="form-control-file"
						id="exampleFormControlFile1">
				</div>

				<button class="btn btn-outline-success">Upload</button>

				<h6 style="color: green; text-align: center;">${message}</h6>
			</form>
		</div>
	</div>
	<br>
	<br>
	<h5 class="text-center mb-3">FORMAT</h5>
	<table class="table table-bordered">
		<thead>
			<tr class="table-danger">
				<th scope="col">Column Description</th>
				<th scope="col">Database Column Width</th>
				<th scope="col">Data Type</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>PRODUCT COMP</td>
				<td>20</td>
				<td>VARCHAR</td>
			</tr>

			<tr>
				<td>PRODUCT CATEGORY</td>
				<td>20</td>
				<td>VARCHAR</td>
			</tr>

			<tr>
				<td>DESCRIPTION</td>
				<td>255</td>
				<td>VARCHAR</td>
			</tr>

			<tr>
				<td>PRICE</td>
				<td></td>
				<td>DOUBLE</td>
			</tr>

			<tr>
				<td>START DATE</td>
				<td>6</td>
				<td>DATETIME</td>
			</tr>

			<tr>
				<td>END DATE</td>
				<td>6</td>
				<td>DATETIME</td>
			</tr>

		</tbody>
	</table>

	</div>

</body>
</html>