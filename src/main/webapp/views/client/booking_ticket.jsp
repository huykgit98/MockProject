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
    </head>
    <body>
        <div id="page">
            <!-- header -->
            <%@ include file="header.jsp"%>
            <section id="body-content">
              <div id="" class="user-nav active container">
                  <div onclick="document.href='#'" class="active col-lg-2 col-md-2 col-sm-4 col-xs-6 col-ms-12">
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
              
              <div class="container">
                  <div class="row">
                     <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                         <div class="row">
                             <form action="">
                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                                 
                                     <h3 class="text-uppercase">Thông tin hành khách(HK)</h3>
                                     <%
										if (request.getAttribute("customerinfo") != null) {
											Customer customer = (Customer) request.getAttribute("customerinfo");
									%> 
                                     <div class="form-group">
                                         <label for="">Họ tên</label>
                                         <input type="text" name="fullname" value="<%=customer.getFullName()%>" class="form-control"/>
                                     </div>
                                     <div class="form-group">
                                         <label for="">Số điện thoai</label>
                                         <input type="phone" name="phonenumber" value="<%=customer.getPhone()%>" class="form-control"/>
                                     </div>
                                      <div class="form-group">
                                         <label for="">Email</label>
                                         <input type="email" name="email" value="<%=customer.getEmail()%>" class="form-control"/>
                                     </div>
                                     
                                     <div class="form-group">
                                         <label for="">Địa chỉ</label>
                                         <input type="text" name="address" value="<%=customer.getAddress()%>" class="form-control"/>
                                     </div>
                                    
                                    <%
							}
						%>
                             </div>
                             
                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                                
                                     <h3 class="text-uppercase">Mã vé <span class="text-primary">ABCDE</span> </h3>
                                    
                                     <div class="form-group">
                                         <label for="">Điểm khởi hành</label>
                                         <select name="startplace" class="form-control">
                                       
											<c:forEach items="${placeList}" var="place">
											<option value="${place.id}">${place.placeName}</option>
											</c:forEach>
                                         </select>
                                         
                                     </div>
                                     <div class="form-group">
                                         <label for="">Điểm đến</label>
                                         <select name="finishplace" class="form-control">
                                              <c:forEach items="${placeList}" var="place">
												<option value="<c:out value="${place.id}"></c:out>">
													<c:out value="${place.placeName}"></c:out></option>
											</c:forEach>
                                         </select>
                                     </div>
                                     	<div class="form-group">
                                         <label for="">Ngày đi</label>
                                         <input type="date" name="" class="form-control"/>
                                     </div>
                                      <div class="form-group">
                                         <label for="">Giờ khởi hành</label>
                                         <select name="" class="form-control">
                                             <option>10:00 h</option>
                                             <option>Điểm 1</option>
                                             <option>Điểm 1</option>
                                         </select>
                                     </div>
                                     
                                     <div class="form-group">
                                         <label for="">Số vé</label>
                                         <input type="number" name="" class="form-control" value="0"/>
                                     </div>
                                     
                                    
                                 
                             </div>
                             
                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                                 <button class="btn btn-success btn-block">Mua cho người khác </button>
                             </div>
                             
                              <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                                  <button class="btn btn-primary btn-block">Đặt vé </button>
                             </div>
                             
                             <p class="text-primary">Lưu ý: bạn có thể thay đổi thông tin hành khách nếu mua cho người khác.</p>
                             </form>
                         </div>
                        
                         
                     </div>
                     <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                          <p class="text-primary text-center">Vui lòng chọn tuyến đường, số vé, giờ khởi hành .</p>
                          <form action="">
                               <table class="grid-seat table">
                                                    <thead>
                                                        <tr>
                                                            <th width="20%"></th>
                                                            <th width="20%"></th>
                                                            <th width="20%"></th>
                                                            <th width="20%"></th>
                                                            <th width="20%"></th>
                                                        </tr>
                                                    </thead>
                                                    <tr>
                                                        <td class="">
                                                            <div class="seat choosed">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                        <td></td>
                                                        <td class="">
                                                            <div class="seat choosed">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
        
                                                        <td></td>

                                                        <td class="">
                                                            <div class="seat choosed">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="">
                                                            <div class="seat selected">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                        <td></td>
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
        
                                                        <td></td>

                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                        <td>Lối</td>
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
        
                                                        <td>Lối</td>

                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                    </tr>

                                                    <tr>
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                        <td>đi</td>
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
        
                                                        <td>đi</td>

                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                    </tr>

                                                   <tr>
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                        <td></td>
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
        
                                                        <td></td>

                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    
                                                    <tr>
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
        
                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>

                                                        <td class="">
                                                            <div class="seat">
                                                                <input type="checkbox" name="select_seat">
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>



                              
                          </form>
                         <div class="row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 col-ms-12">
                                <div class="ordered"></div><span>Đang chọn</span>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 col-ms-12">
                                <div class="booked"></div><span>Đã đặt</span>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 col-ms-12">
                                <div class="nothing"></div><span>Còn trống</span>
                            </div>
                        </div>
                        <p class="pull-left">
                            <span class="text-primary">Giá vé:</span> 100.000 đ
                        </p>
                        <p class="pull-right">
                            <span class="text-primary">Tổng tiền:</span> 100.000 đ
                        </p>
                        <div class="clearfix"></div>
                        <p class="text-success">(*) Quý khách vui lòng mang email có chứa mã đặt chỗ để đổi vé lên xe trước giờ xuất bến ít nhất 30ph</p>
                        <p>(*) Thông tin hành kkhách phải chính xác, nếu không sẽ không thể lên xe hoặc hủy/đổi vé</p>
                        <p>(*) QUý khách không được đổi/trả vé vào các ngày lễ tết ( Ngày thường qúy khách được quyền chuyển đổi hoặc hủy vé một lần duy nhất) </p>
                        <p>(*) Nếu quý khách có nhu cầu trung chuyển, vui lòng liên hệ số điện thoại 1900 6067 trước khi đặt vé. Chúng tôi sẽ không đón/ trung chuyển tại những điểm xe trung chuyển không thể tới được.</p>
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