<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page import="edu.sgu.bookingsystem.model.Customer"%>
	
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <title>Thông tin cá nhân</title>
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
                  
                  <div onclick="document.href='#'" class="active col-lg-2 col-md-2 col-sm-4 col-xs-6 col-ms-12">
                      <div class="u-nav-left pull-left">
                          <span class="sprite icon-login-info"></span>
                      </div>
                      <div class="u-nav-right pull-left">
                          <h3 class="text-uppercase">Thông tin cá nhân</h3>
                          <small class="text-muted">Cập nhật thông tin</small>
                      </div>
                  </div>
                  <div onclick="document.href='#'" class="bg-gray col-lg-2 col-md-2 col-sm-4 col-xs-6 col-ms-12">
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
              
              <div id="user-infomations" class="container">
                  <div class="row">
                      
                         <div class=" col-lg-12 col-md-12 col-sm-12 col-sm-12 col-xs-12">
                                <h3 class="text-uppercase bg-success">Thông tin cá nhân</h3>
                               <%
							if (request.getAttribute("customerinfo") != null) {
								Customer customer = (Customer) request.getAttribute("customerinfo");
						%> 
                               <table class="table">
                                   <tr>
                                       <td>Họ tên</td>
                                       <td><%=customer.getFullName()%></td>
                                   </tr>
                                   <tr>
                                       <td>Địa chỉ email</td>
                                       <td><%=customer.getEmail()%></td>
                                   </tr>
                                   <tr>
                                       <td>Điện thoại</td>
                                       <td><%=customer.getPhone()%></td>
                                   </tr>
                                   <tr>
                                       <td>Địa chỉ</td>
                                       <td><%=customer.getAddress()%></td>
                                   </tr>
                               </table>
                                   <%
							}
						%>
                             
                         </div>
                         
                         
                     
                  </div>
              </div>
             
				<div id="user-infomations" class="container">
                  <div class="row"> 
                         <div class=" col-lg-12 col-md-12 col-sm-12 col-sm-12 col-xs-12">
           
             				<button class="btn btn-primary " onclick="hideShowForm()">Chỉnh sửa thông tin cá nhân</button>
						</div>
					</div>
				</div>
			<br>
             <hr>
             
              <div id="user-infomations" class="container">
                  <div class="row" id="myDIV" style="display:none;">
                      <%
							if ((String) session.getAttribute("errorUpd") != null) {
						%>
						<h4 style="color: red">
							<%
								out.print(session.getAttribute("errorUpd"));
					 			session.removeAttribute("errorUpd");
							%>
						</h4>
						<%
							}
						%>

						<%
							if (request.getAttribute("customerinfo") != null) {
								Customer customer = (Customer) request.getAttribute("customerinfo");
						%>
                         <div class=" col-lg-12 col-md-12 col-sm-12 col-sm-12 col-xs-12">
                                <h3 class="text-uppercase bg-success">Cập nhật thông tin cá nhân</h3>
                              <form method="POST" action="CustomerInfoController?param=changeInfoCustomer" id="forgot-pass">  
                               <table class="table">
                                 
                                   <tr>
                                       <td>Họ tên</td>
                                       <td> <input type="text" name="fullname" value="<%=customer.getFullName()%>" class="form-control" /></td>
                                   </tr>
                                    <tr>
                                       <td>Địa chỉ email</td>
                                       <td> <input type="text" name="email" value="<%=customer.getEmail()%>" class="form-control"/></td>
                                   </tr>
                                   <tr>
                                       <td>Điện thoại</td>
                                       <td> <input type="text" name="phonenumber" value="<%=customer.getPhone()%>" class="form-control" /></td>
                                   </tr>
                                   <tr>
                                       <td>Địa chỉ</td>
                                       <td> <input type="text" name="address" value="<%=customer.getAddress()%>" class="form-control" /></td>
                                   </tr>
                                   <%
							}
						%>
                                   <tr>
                                       <td><button type="submit" class="btn pull-left" style="background-color:#1a53ff; color:white;">
                                  			<i class="fa fa-check"></i> Xác nhận</button>
                                  		</td>
                                       <td></td>
                                   </tr>
                                   
                                   
                               </table>
                               </form>
                         </div>
                         
                         
                     
                  </div>
              </div>
            </section>
            <!-- hide/show form update customer -->
            <script>
			function hideShowForm() {
			  var x = document.getElementById("myDIV");
			  if (x.style.display === "none") {
			    x.style.display = "block";
			  } else {
			    x.style.display = "none";
			  }
			}
			</script>
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