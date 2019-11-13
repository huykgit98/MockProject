<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <title>FUTA</title>
        <link rel="profile" href="http://gmpg.org/xfn/11">
        <link rel="pingback" href="http://vinpearlsafari.com/xmlrpc.php">
        <!--[if lt IE 9]>
        <script src="http://vinpearlsafari.com/wp-content/themes/vinsafari/js/html5.js"></script>
        <![endif]-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link rel='stylesheet' id='theme-style-css'  href='${pageContext.request.contextPath}/resources/client/css/style.css' type='text/css' media='all' />
        <link rel='stylesheet' id=''  href='${pageContext.request.contextPath}/resources/client/plugins/flexslider/flexslider.css' type='text/css' media='all' />
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/client/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/client/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/client/plugins/flexslider/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/client/js/theme.js"></script>
   <link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	$(document).ready(function() {
		$('#datatable').dataTable();

		$("[data-toggle=tooltip]").tooltip();

	});
</script>
<!------ Include the above in your HEAD tag ---------->

<script language="JavaScript"
	src="https://code.jquery.com/jquery-1.11.1.min.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
    </head>
    <body>
        <div id="page">
            <!-- header -->
                        <%@ include file="header.jsp"%>
             	
            <section id="body-content">
              <div id="" class="user-nav active container">
                  <div onclick="document.href='#'" class="bg-gray col-lg-2 col-md-2 col-sm-4 col-xs-6 col-ms-12">
                      <div class="u-nav-left pull-left">
                          <span class="sprite icon-laptop"></span>
                      </div>
                      <div class="u-nav-right pull-left">
                          <h3 class="text-uppercase">Đặt vé</h3>
                          <small class="text-muted">Đặt vé dễ dàng</small>
                      </div>
                  </div>
                  <div onclick="document.href='#'" class="bg-gray col-lg-2 col-md-2 col-sm-4 col-xs-6 col-ms-12">
                      <div class="u-nav-left pull-left">
                          <span class="sprite icon-login-info"></span>
                      </div>
                      <div class="u-nav-right pull-left ">
                          <h3 class="text-uppercase">Thông tin đăng nhập</h3>
                          <small class="text-muted"> Quản lý thông tin</small>
                      </div>
                  </div>
                  
                  <div onclick="document.href='#'" class="bg-gray col-lg-2 col-md-2 col-sm-4 col-xs-6 col-ms-12">
                      <div class="u-nav-left pull-left">
                          <span class="sprite icon-user"></span>
                      </div>
                      <div class="u-nav-right pull-left">
                          <h3 class="text-uppercase">Thông tin cá nhân</h3>
                          <small class="text-muted">Cập nhật thông tin</small>
                      </div>
                  </div>
                  <div onclick="document.href='#'" class="active col-lg-2 col-md-2 col-sm-4 col-xs-6 col-ms-12">
                      <div class="u-nav-left pull-left">
                          <span class="sprite icon-history-ticket"></span>
                      </div>
                      <div class="u-nav-right pull-left">
                          <h3 class="text-uppercase">Lịch sử mua vé</h3>
                          <small class="text-muted">Xem các chuyến đi</small>
                      </div>
                  </div>
                  
                  <div onclick="document.href='#'" class="bg-gray col-lg-2 col-md-2 col-sm-4 col-xs-6 col-ms-12">
                      <div class="u-nav-left pull-left">
                          <span class="sprite icon-ccoin"></span>
                      </div>
                      <div class="u-nav-right pull-left">
                          <h3 class="text-uppercase">Điểm thưởng</h3>
                          <small class="text-muted">Xem điểm mua vé</small>
                      </div>
                  </div>
                  
                  <div onclick="document.href='#'" class="bg-gray col-lg-2 col-md-2 col-sm-4 col-xs-6 col-ms-12">
                      <div class="u-nav-left pull-left">
                          <span class="sprite icon-money-history"></span>
                      </div>
                      <div class="u-nav-right pull-left">
                          <h3 class="text-uppercase">Lịch sử nạp tiền</h3>
                          <small class="text-muted">Xem lần nạp gần nhất</small>
                      </div>
                  </div>
                  
                  
              </div>
              
            	   <link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	$(document).ready(function() {
		$('#datatable').dataTable();

		$("[data-toggle=tooltip]").tooltip();

	});
</script>
<!------ Include the above in your HEAD tag ---------->

<script language="JavaScript"
	src="https://code.jquery.com/jquery-1.11.1.min.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script language="JavaScript"
	src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
              
              <div class="container">
                  <table id="datatable" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th class="col-3 col-sm-2">Chỗ ngồi</th>
							<th class="col-3 col-sm-2">Giá</th>
							<th class="col-3 col-sm-2">Biển số xe</th>
							<th class="col-3 col-sm-2">Tình trạng</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listDetailBooking}" var="list">
							<tr>
								<td><c:out value="${list.seat }"></c:out></td>
								<td><c:out value="${list.price }"></c:out></td>
								<td><c:out value="${list.numberPlate }"></c:out></td>
								<td>
									<c:if test="${list.status == 1}">Đã đặt
		
								     </c:if>
								     <c:if test="${list.status == 0}">Đã hủy
		
								     </c:if>
								</td>
							</tr>
						</c:forEach>
						<%-- <c:forEach var="listDetail" items="${listDetailBooking}" >
							<tr>
								<td>${listDetail.seatList }</td>
								<td>${listDetail.price }</td>
								<td>${listDetail.NumberPlate }</td>
							</tr>
						</c:forEach> --%>
					</tbody>
				</table>
              </div>
              
            </section>
            
            
            <!-- footer -->
            <footer>
               
                <div id="footer-img">
                     <img src="${pageContext.request.contextPath}/resources/client/img/bg-top-footer.png" class="center-block">
                </div>
                <div id="footer-body">
                    <div class="f-body-wrap container">
                       
                        <nav id="nav-f">
                            <ul>
                                <li><a href="#">Lịch trình</a></li>
                                <li><a href="#">Về chúng tôi</a></li>
                                <li><a href="#">Hỗ trợ khách hàng</a></li>
                                <li><a href="#">Thanh toán oan toàn</a></li>
                                <li><a href="#">Tuyển dung</a></li>
                            </ul>
                        </nav>
                        
                        <div id="f-info" class="row">
                           <div id="social" class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                                <ul>
                                    <li>Kết nối chúng tôi</li>
                                    <li>
                                        <a href="">
                                           <i class="fa fa-facebook-square"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="">
                                           <i class="fa fa-google-plus-square"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="">
                                           <i class="fa fa-twitter-square"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            
                             <div id="info" class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                                 <div id="info-c">
                                     <p>Công Ty CP Xe khách phương trang EAF</p>
                                     <p>Địa chỉ: 80 Trần Hưng Đạo, Q1, TP Hồ Chí Minh.</p>
                                     <p>Điện thoại: 0902 181852 - Fax: 0902 181852</p>
                                     <p>Website: <a href="#">viralwave.vn</a> - Email: info@viralwave.vn </p>
                                 </div>
                             </div>
                        </div>
                        
                        <div class="f-copy">
                            <p>Copyright &copy; 2015 Công ty TNHH ABC</p>
                            <p>Design by <a href="">viralwave.vn</a> </p>
                        </div>
                    </div>
                </div>
                
            </footer>
        </div>    
        
    </body>
</html>