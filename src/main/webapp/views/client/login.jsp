<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <title>Đăng nhập</title>
    
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
                    <div id="body-login" class="row">
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                            <div id="login-form-left" class="border clearfix">
                                 <div  class="col-lg-8 col-md-8 col-sm-12 col-xs-12 col-ms-12 col-lg-offset-2 col-md-offset-2">
                                     <h3 class="text-uppercase text-center">Tôi đã đăng ký tài khoản</h3>
                                     <br>
                                     <%
									if ((String) session.getAttribute("error") != null) {
									%>
									<h4 style="color: red">
										<%
											out.print((String) session.getAttribute("error"));
										 	session.removeAttribute("error");
										%>
									</h4>
									<%
										}
									%>
		                                     <c:url value="/LoginClienController?param=login" var="login"/>       
                               <form id="register-form" class="form-horizontal" method="POST" action="${login}">
                                         <div class="form-group">
                                             <label for="">Địa chỉ email*</label>
                                             <input type="text" name="username" class="form-control" placeholder="abc@gmail.com" required/>
                                         </div>
                                         <div class="form-group">
                                             <label for="">Mật khẩu*</label>
                                             <input type="password" name="password" class="form-control" value="" required/>
                                         </div>
                                         <div class="form-group">
                                             <a href="#">Quên mật khẩu?</a>
                                         </div>
                                         <div class="form-group">
                                             <label for="">
                                                 
                                                 <input type="checkbox">
                                                 Ghi nhớ
                                             </label>
                                             <button class="btn btn-primary pull-right" type="submit">
                                                 Đăng nhập
                                             </button>
                                         </div>
                                     </form>
                                 </div>
                                
                            </div>
                        </div>
                        
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                            <div id="login-form-right" class="border clearfix">
                                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 col-ms-12 col-lg-offset-2 col-md-offset-2">
                                     <h3 class="text-uppercase text-center">Bạn là khách hàng mới?</h3>
                                     <p class="text-center">
                                         <a href="${pageContext.request.contextPath}/views/client/register.jsp" class="btn btn-primary">Đăng ký</a>
                                     </p>
                                     <p class="text-muted text-center">
                                         Chỉ với 1 tài khoản Futabus ID, tham gia được tất cả các chương trình của Futa Bus Lines
                                     </p>
                                     <hr class="sperator">
                                     <p class="text-uppercase text-center">
                                         Đăng nhập bằng tài khoản khác
                                     </p>
                                     <a href="#" class="btn btn-block btn-info btn-flat">
                                         <i class="fa fa-facebook icon-flat bg-btn-info"></i>
                                         Đăng nhập bằng Facebook
                                     </a>
                                     <a href="#" class="btn btn-block btn-primary btn-flat">
                                         <i class="fa fa-google icon-flat bg-btn-actived">
                                             
                                         </i>
                                         Đăng nhập bằng Google
                                     </a>
                                 </div>
                            </div>
                        </div>
                    </div>
                    
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