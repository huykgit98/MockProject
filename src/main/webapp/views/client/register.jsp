<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <title>Đăng ký</title>
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
               <div class="container" id="login-page">
                    
                    <div id="top-login" class="clearfix hidden-sm">
                        
                        <div id="login-top-bar-left" class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                            <div class="row">
                                <div class="text-center col-lg-4 col-md-4 col-sm-4 col-xs-12 col-ms-12">
                                    <div class="text-uppercase"><span class="relative"><span class="sprite safe"></span>An toàn</span></div>
                                    
                                </div>
                                <div class="text-center col-lg-4 col-md-4 col-sm-4 col-xs-12 col-ms-12">
                                    <div class="text-uppercase"><span class="relative"><span class="sprite bus"></span>Luôn có tuyến</span></div>
                            
                                </div>
                                <div class="text-center col-lg-4 col-md-4 col-sm-4 col-xs-12 col-ms-12">
                                    <div class="text-uppercase"><span class="relative"><span class="sprite faq"></span>Hỏi đáp</span></div>
                            
                                </div>
                            </div>
                            
                        </div>
                        
                         <div id="login-top-bar-right" class="text-center col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                            <p class="text-uppercase">Hãy tải app để chúng tôi phục vụ bạn tốt hơn <span class="sprite ico-app hidden-xs"></span> </p>
                            
                        </div>
                    </div>
                    <div id="body-register" class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                            <img src="${pageContext.request.contextPath}/resources/client/res/banner-dangky.jpg">
                        </div>
                        
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                            <div id="register-form-wrapper" class="border padding10 clearfix">
                       		    <c:url value="/RegisterClientController?param=register" var="register"/>       
                               <form id="register-form" class="" method="POST"
					action="${register}">
                                   <h1 class="text-uppercase" >Đăng ký thành viên</h1>
                                   <p class="text-muted">
                                       <%
											if ((String) session.getAttribute("errorReg") != null) {
										%>
										<h4 style="color: red">
											<%
												out.print(session.getAttribute("errorReg"));
												session.removeAttribute("errorReg");
											%>
										</h4>
										<%
											}
										%>
                                       
                                   </p>
                                   <br>
                                   <div class="form-group">
                                       <label for="">Địa chỉ email *</label>
                                       <input type="email" name="email" class="form-control" placeholder="abc@gmail.com" required/>
                                   </div>
                                   <div class="form-group">
                                       
                                       <div class="row">
                                           <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 col-ms-12">
                                               <label for="">Mật khẩu *</label>
                                                <input type="password" value="" name="password" class="form-control" required/>
                                            </div>
                                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 col-ms-12">
                                                <label for="">Xác nhận lại mật khẩu *</label>
                                                <input type="password" value="" name="repassword" class="form-control" required/>
                                            </div>
                                       </div>
                                      
                                   </div>
                                   
                                   <h3 class="text-uppercase">Thông tin khác</h3>
                                 
                                   <div class="form-group">
                                       <div class="row">
                                           <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                                               <label for="">Họ Tên *</label>
                                                <input type="text" name="fullname" class="form-control" required/>
                                            </div>
                                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                                                <label for="">Địa Chỉ </label>
                                                <input type="text" value="" name="address" class="form-control"/>
                                            </div>
                                       </div>
                                       <br>
                                      <div class="row">
                                           <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                                               <label for="">Số di động *</label>
                                                <input type="text" name="phonenumber" class="form-control" required/>
                                            </div>

                                       </div>
                                   </div>
                                    <div class="form-group clearfix">
                                        <button class="btn btn-primary pull-right">HOÀN TẤT</button>
                                       
                                    </div>
                                     <p class="clearfix"> <small class="pull-right" style="color:red;">* Mục bắt buộc </small> </p>
                                     <p class="text-center" >Nếu bạn đã có FUTA ID. CLick <a href="${pageContext.request.contextPath}/views/client/register.jsp">đây</a> để đăng nhập</p>
                               </form>
                            </div>
                        </div>
                    </div>
                   
                </div>
                <br>
                <br>
            </section>
            
            
            <!-- footer -->
            <footer>
                <div id="footer-header" >
            <div class="container">
                <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-ms-12 ">
                    <h4>Các tuyến xe miền nam</h4>
                    <ul class="f-link">
                        <li><a href="#">TPHCM</a></li>
                        <li><a href="#">Vũng tàu</a></li>
                        <li><a href="#">Cần thơ</a></li>
                        <li><a href="#">Đà Lạt</a></li>
                        <li><a href="#">Bla bla</a></li>
                    </ul>
                </div>
                
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-ms-12">
                    <h4>Các tuyến xe miền nam</h4>
                    <ul class="f-link">
                        <li><a href="#">TPHCM</a></li>
                        <li><a href="#">Vũng tàu</a></li>
                        <li><a href="#">Cần thơ</a></li>
                        <li><a href="#">Đà Lạt</a></li>
                        <li><a href="#">Bla bla</a></li>
                    </ul>
                </div>
                
                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-ms-12">
                    <h4>Các tuyến xe miền nam</h4>
                    <ul class="f-link">
                        <li><a href="#">TPHCM</a></li>
                        <li><a href="#">Vũng tàu</a></li>
                        <li><a href="#">Cần thơ</a></li>
                        <li><a href="#">Đà Lạt</a></li>
                        <li><a href="#">Bla bla</a></li>
                    </ul>
                </div>
                
                 <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-ms-12">
                    <h4>Các tuyến xe miền nam</h4>
                    <ul class="f-link">
                        <li><a href="#">TPHCM</a></li>
                        <li><a href="#">Vũng tàu</a></li>
                        <li><a href="#">Cần thơ</a></li>
                        <li><a href="#">Đà Lạt</a></li>
                        <li><a href="#">Bla bla</a></li>
                    </ul>
                </div>
                
                
            </div>
            </div>
        </div>
        
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