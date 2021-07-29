<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./basic.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Update product details</h1>
				<form action="${pageContext.request.contextPath}/handle-product" method="post">
					<div class="form-group">
						<label for="name">Product ID</label> <input type="text"
							class="form-control" id="id" aria-describedby="emailHelp"
							name="id" placeholder="Enter the product ID"
							value="${product.id}" />
					</div>
					<div class="form-group">
						<label for="name">Product Name</label> <input type="text"
							class="form-control" id="name" aria-describedby="emailHelp"
							name="name" placeholder="Enter the product name"
							value="${product.name}" />
					</div>
					<div class="form-group">
						<label for="desc">Product Description</label>
						<textarea class="form-control" id="desc"
							aria-describedby="emailHelp" name="desc" rows="5"
							placeholder="Enter the product description">${product.desc}</textarea>
					</div>
					<div class="form-group">
						<label for="price">Product Price</label> <input type="text"
							class="form-control" id="price" aria-describedby="emailHelp"
							name="price" placeholder="Enter the product price"
							value="${product.price}">
					</div>
					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/home"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-warning">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>