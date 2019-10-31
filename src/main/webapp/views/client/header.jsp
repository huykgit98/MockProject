<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <title></title>
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
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/client/plugins/sliderTabs/jquery.sliderTabs.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/plugins/sliderTabs/styles/jquery.sliderTabs.css">
        <!-- add slidebar menu script -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/client/plugins/sidebar/slidebars.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/client/plugins/sidebar/slidebars.css">
        <!-- end add slidebar menu script -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/client/js/theme.js"></script>
        
        
        <!-- style huy -->
      	<style>.dropdown-content {
		  display: none;
		  position: absolute;
		  background-color: #ff6600;
		  min-width: 160px;
		  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		  z-index: 1;
		  
		}
		
		.dropdown-content a {
		  color: black;
		  padding: 12px 16px;
		  text-decoration: none;
		  display: block;
		}
		
		.dropdown-content a:hover {background-color: #b34700}
		
		.dropdown:hover .dropdown-content {
		  display: block;
		}
		
		.dropdown:hover .dropbtn {
		  background-color: #3e8e41;
		}
		</style>
    </head>
<body>
<header>
                <div id="top">
                    <div class="container">
                        <%
						if (session.getAttribute("customername") == null) {
						%> 
                        <div class="support"><i class="fa fa-phone"></i> Tổng đài hỗ trợ: <span>0902 1818 52</span></div>
                       
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/views/client/login.jsp">Đăng nhập</a></li>
                            <li><a href="${pageContext.request.contextPath}/views/client/register.jsp">Đăng ký</a></li>
                            
                        </ul>
                        <%
						} else {
						%>
				       <div class="support"><i class="fa fa-phone"></i> Tổng đài hỗ trợ: <span>0902 1818 52</span></div>
                        <ul>
                            <li class="dropdown">
                            	<a href="#" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                            		<i class="fa fa-user"></i> Chào, <% out.print(session.getAttribute("customername"));%>
                            	</a>
							    <div class="dropdown-content" >
								  <a href="${pageContext.request.contextPath}/views/client/booking_ticket.jsp" ><i class="fa fa-ticket"></i> Đặt vé</a>								  								  
								  <a href="${pageContext.request.contextPath}/views/client/customer_login_info.jsp" ><i class="fa fa-user-secret"></i> Thông tin đăng nhập</a>
								  <a href="${pageContext.request.contextPath}/views/client/customer_info.jsp" ><i class="fa fa-info"></i> Thông tin cá nhân</a>
							      <a href="${pageContext.request.contextPath}/LoginClienController?param=logout"><i class="fa fa-sign-out"></i> Đăng xuất</a>
								  </div>
                            </li>
                            
                        </ul>
                        
						<%
						}
						%>
                    </div>
                </div>
                <div id="header-body">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 col-ms-12">
                                <h1 id="logo">
                                    <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/resources/client/img/logo.png"/></a>
                                </h1>
                                
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 col-ms-12">
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle collapsed sb-toggle-left" data-toggle="collapse" data-target="" aria-expanded="false">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                    <a href="${pageContext.request.contextPath}" class="navbar-brand">Trang chủ</a>
                                </div>
                                  
                                <nav id="main-nav" class="collapse navbar-collapse clearfix">
                                    <ul>
                                        <li><a href="#">Khuyến mãi</a></li>
                                        <li><a href="">Lịch trình</a></li>
                                        <li><a href="">Liên hệ</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </header>
</body>
</html>