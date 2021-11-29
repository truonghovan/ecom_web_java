<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-admin-product"/>
<c:url value="/views/admin/static" var="url"></c:url>
<c:url value="/admin-product-list" var="PCurl"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Product Management</title>
<!-- BOOTSTRAP STYLES-->
<link href="${url}/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="${url}/css/font-awesome.css" rel="stylesheet" />
<!-- MORRIS CHART STYLES-->

<!-- CUSTOM STYLES-->
<link href="${url}/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<!-- TABLE STYLES-->
<link href="${url}/js/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/views/admin/view/nav-bar.jsp"></jsp:include>
		<!-- /. NAV TOP  -->
		<jsp:include page="/views/admin/view/slide-bar.jsp"></jsp:include>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Danh sách sản phẩm</h2>
					</div>
				</div>
				<!-- /. ROW  -->
				<hr />
				<div class="row">
					<div class="col-md-12">
						<div>
							<button class="btn btn-danger square-btn-adjust" style="margin-bottom: 5px"><a href='<c:url value="/admin-product-list?type=add"/>' style="color: white">Thêm sản phẩm</a></button>
						</div>

						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading"></div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>ID </th>
												<th>Ảnh sản phẩm</th>
												<th>Tên sản phẩm</th>
												<th>Số lượng</th>
												<th>Giá(vnđ)</th>
												<th>Chi tiết loại sản phẩm</th>
												<th>Mô tả sản phẩm</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${lstProduct }" var="pro" >
											<tr class="odd gradeX">
												<td>${pro.getId() }</td>
												<c:url value="/image/${pro.getImage()}" var="imgUrl"></c:url>
											<%--	<td><img width="100" height="70" style="object-fit: cover" src="image/${imgUrl}"/></td>--%>
												<td><img style="width: 100px;height: 100px;object-fit: cover" src="${imgUrl}" /></td>

												<td>${pro.getProName() }</td>
												<td>${pro.getQuantity()}</td>
												<td>${pro.getPrice()}</td>
												<td>${pro.getDetailCategoryEntity().getDetailCateName()}</td>

												<%--<td>${pro.detailCateId}</td>--%>
												<td>${pro.describePro } </td>
												<td>
													<button style="width: 70px;">
														<a href="<c:url value="/admin-product-list?type=edit&id=${pro.id }"/>"
														   class="center">Xem/Sửa</a>
													</button>
														|
													<button id="btnDelete" type ="button" onclick = "deleteProduct(${pro.id})"
															class="center">Xóa
													</button>
												</td>
											</tr>
											</c:forEach>
											
											
										</tbody>
									</table>
								</div>

							</div>
						</div>
						<!--End Advanced Tables -->
					</div>
				</div>

			</div>

		</div>
		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="${url}/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="${url}/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="${url}/js/jquery.metisMenu.js"></script>
	<!-- DATA TABLE SCRIPTS -->
	<script src="${url}/js/dataTables/jquery.dataTables.js"></script>
	<script src="${url}/js/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		});
	</script>
	<!-- CUSTOM SCRIPTS -->
	<script src="${url}/js/custom.js"></script>

	<%--	Delete--%>
	<script>

		function deleteProduct(data){
			$.ajax({
				url: '${APIurl}',
				type: 'DELETE',
				enctype: 'multipart/form-data',
				processData:false,
				contentType: 'application/json',
				data:JSON.stringify(data),
				dataType: 'json',
				success: function (result){
					console.log("Success");
					window.location.href = "${PCurl}?type=list&message=insert_success";
				},
				error: function (error){
					console.log("Error");
				}
			})
		}
	</script>


</body>
</html>