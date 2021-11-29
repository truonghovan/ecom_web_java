<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-shipper-donhang"/>
<c:url value="/api-shipper-cart" var="APIurl"> </c:url>
<c:url value="/api-shipper-order" var="APIOrderUrl"> </c:url>
<c:url value="/views/shipper/static" var="url"></c:url>
<c:url value="/shipper-donhang-list" var="SCurl"></c:url>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Shipper Management</title>
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
    <jsp:include page="/views/shipper/view/nav-bar.jsp"></jsp:include>
    <!-- /. NAV TOP  -->
    <jsp:include page="/views/shipper/view/slide-bar.jsp"></jsp:include>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>Danh sách đơn hàng được giao</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <hr />
            <div class="row">
                <div class="col-md-12">
                    <div>
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
                                        <th>Mã đơn hàng </th>
                                        <th>Ngày tạo đơn</th>
                                        <th>Thời gian chấp nhận muộn nhất</th>
                                        <th>Giá(vnđ)</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${lstShipper }" var="shi" >
                                        <tr class="odd gradeX">
                                            <td>${shi.getId() }</td>
<%--                                            <c:url value="/image/${pro.getImage()}" var="imgUrl"></c:url>--%>
<%--                                            <td><img style="width: 50px;height: 50px;object-fit: cover" src="${imgUrl}" /></td>--%>

<%--                                            <td>${pro.getProName() }</td>--%>
<%--                                            <td>${pro.getQuantity()}</td>--%>
<%--                                            <td>${pro.getPrice()}</td>--%>
<%--                                            <td>${pro.getDetailCategoryEntity().getDetailCateName()}</td>--%>

<%--                                                &lt;%&ndash;<td>${pro.detailCateId}</td>&ndash;%&gt;--%>
<%--                                            <td>${pro.describePro } </td>--%>
                                            <td>
                                                <button style="width: 70px;">
                                                    <a href="<c:url value="/shipper-donhang-list?type=edit&id=${shi.id }"/>"
                                                       class="center">Nhận</a>
                                                </button>
                                                |
                                                <button id="btnDelete" type ="button" onclick = "deleteShipper(${shi.id})"
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

    function deleteShipper(data){
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
                window.location.href = "${SCurl}?type=list&message=insert_success";
            },
            error: function (error){
                console.log("Error");
            }
        })
    }
</script>


</body>
</html>