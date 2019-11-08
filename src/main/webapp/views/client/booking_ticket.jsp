<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page import="edu.sgu.bookingsystem.model.Customer"%>

<!DOCTYPE html>
<html>
    <head>
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

        
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
       
        <!-- link jquery và css cho booking seat -->
        <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/client/book-seat-plugins/jquery.seat-charts.css">
        <style>
        a {
			color: #b71a4c;
		}
		.front-indicator {
			width: 145px;
			margin: 5px 32px 15px 32px;
			background-color: #f6f6f6;	
			color: #adadad;
			text-align: center;
			padding: 3px;
			border-radius: 5px;
		}
        .booking-details {
			float: left;
			text-align: left;
			margin-left: 35px;
			font-size: 12px;
			position: relative;
			height: 401px;
		}
		.booking-details h2 {
			margin: 25px 0 20px 0;
			font-size: 17px;
		}
		.booking-details h3 {
			margin: 5px 5px 0 0;
			font-size: 14px;
		}
		div.seatCharts-cell {
			color: #182C4E;
			height: 50px;
			width: 50px;
			line-height: 50px;
			
		}
		div.seatCharts-seat {
			color: #FFFFFF;
			cursor: pointer;	
		}
		div.seatCharts-row {
			height: 35px;
		}
		div.seatCharts-seat.available {
			background-color:  #cccccc;
		
		}
		div.seatCharts-seat.available.first-class {
		/* 	background: url(vip.png); */
			background-color: #3a78c3;
		}
		div.seatCharts-seat.focused {
			background-color:  #ff9999;
		}
		div.seatCharts-seat.selected {
			background-color: red;
		}
		div.seatCharts-seat.unavailable {
			background-color: #472B34 ;
		}
		
		div.seatCharts-legend {
			padding-left: 0px;
			position: absolute;
			bottom: 16px;
		}
		ul.seatCharts-legendList {
			padding-left: 0px;
		}
		span.seatCharts-legendDescription {
			margin-left: 5px;
			line-height: 30px;
		}
		.checkout-button {
			display: block;
			margin: 10px 0;
			font-size: 14px;
		}
		#selected-seats {
			max-height: 90px;
			overflow-y: scroll;
			overflow-x: none;
			width: 170px;
		}
        </style>
        <!--END link jquery và css cho booking seat -->
        
        
        
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
                                 
                                     <h3 class="text-uppercase">Thông tin hành khách</h3>
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
                                
                                     <h3 class="text-uppercase">Thông tin vé </h3>
                                    
                 
                                     <div class="form-group">
                                         <label for="">Điểm khởi hành</label>
                                         <select name="startplace" class="form-control" id="startplace" onchange="chg()">
											<option value="#"></option>
											<c:forEach items="${placeList}" var="place">
											<option value="${place.id}">${place.placeName}</option>
											</c:forEach>
                                         </select>
                                         
                                     </div>
                                     
                                     <div class="form-group">
                                         <label for="">Điểm đến</label>
                                         <!-- bé này sẽ load khi chọn điểm khởi hành -->
                                         <select name="finishplace" class="form-control" id="finishplace">
                                              
                                         </select>
                                     </div>
                                   
                                     	<div class="form-group">
                                         <label for="">Ngày đi</label>
                                         <input type="date" name="" class="form-control"/>
                                     </div>
                                      <div class="form-group">
                                         <label for="">Giờ khởi hành</label>
                                         <select name="timestart" id="timestart" class="form-control">
                                         </select>
                                     </div>
                                     
                                 
                             </div>
                            <!--  --> 
                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-ms-12">
                                 <button class="btn btn-success btn-block">Load xe </button>
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
                          <div class="row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 col-ms-12"><div style="  width: 10px; height: 10px; background: red; border: 1px solid #ddd;"></div><span>Đã chọn</span></div>
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 col-ms-12"><div style="  width: 10px; height: 10px; background: #472B34 ; border: 1px solid #ddd;"></div><span>Đã có người đặt</span> </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 col-ms-12"><div style="  width: 10px; height: 10px; background: #cccccc; border: 1px solid #ddd;"></div><span>Còn trống</span></div>
                        </div>
                       <hr>
                         <div class="booking-details">
					      <h2> Số ghế đã chọn (<span id="counter">0</span>):</h2>
					      <ul id="selected-seats">
					      </ul>
					     <h3> Tổng tiền: <b><span id="total">0</span> VNĐ</b></h3>
					      
					    </div>
						<div id="seat-map">
					    </div>
    
                     <!-- Script cho booking seat -->
                     		<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script> 
							<script src="${pageContext.request.contextPath}/resources/client/book-seat-plugins/jquery.seat-charts.js"></script> 
							<script>
										var firstSeatLabel = 1;
									
										$(document).ready(function() {
											var $cart = $('#selected-seats'),
												$counter = $('#counter'),
												$total = $('#total'),
												sc = $('#seat-map').seatCharts({
												map: [
													'ee_ee',
													'ee_ee',
													'ee_ee',
													'ee_ee',
													'eeeee',
												],
												seats: {
													f: {
														price   : 100,
														classes : 'first-class', //your custom CSS class
														category: 'First Class'
													},
													e: {
														price   : 180000,
														classes : 'economy-class', //your custom CSS class
														category: ''
													}					
												
												},
												naming : {
													top : false,
													getLabel : function (character, row, column) {
														return firstSeatLabel++;
													},
												},
												legend : {
													node : $('#legend'),
												    items : [
														[ 'e', 'available',   'Chỗ trống'],
														[ 'f', 'unavailable', 'Đã có người đặt']
												    ]					
												},
												click: function () {
													if (this.status() == 'available') {
														//let's create a new <li> which we'll add to the cart items
														$('<li style=" list-style-type: none;">'+this.data().category+' Ghế số '+this.settings.label+' <a href="#" class="cancel-cart-item">[X]</a></li>')
															.attr('id', 'cart-item-'+this.settings.id)
															.data('seatId', this.settings.id)
															.appendTo($cart);
														
														/*
														 * Lets update the counter and total
														 *
														 * .find function will not find the current seat, because it will change its stauts only after return
														 * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
														 */
														$counter.text(sc.find('selected').length+1);
														$total.text(recalculateTotal(sc)+this.data().price);
														
														return 'selected';
													} else if (this.status() == 'selected') {
														//update the counter
														$counter.text(sc.find('selected').length-1);
														//and total
														$total.text(recalculateTotal(sc)-this.data().price);
													
														//remove the item from our cart
														$('#cart-item-'+this.settings.id).remove();
													
														//seat has been vacated
														return 'available';
													} else if (this.status() == 'unavailable') {
														//seat has been already booked
														return 'unavailable';
													} else {
														return this.style();
													}
												}
											});
							
											//this will handle "[cancel]" link clicks
											$('#selected-seats').on('click', '.cancel-cart-item', function () {
												//let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
												sc.get($(this).parents('li:first').data('seatId')).click();
											});
							
											//let's pretend some seats have already been booked
											sc.get(['1_1', '4_1', '3_1']).status('unavailable');
									
									});
							
									function recalculateTotal(sc) {
										var total = 0;
									
										//basically find every selected seat and sum its price
										sc.find('selected').each(function () {
											total += this.data().price;
										});
										
										return total;
									}
									
									</script><script type="text/javascript">
							
							  var _gaq = _gaq || [];
							  _gaq.push(['_setAccount', 'UA-36251023-1']);
							  _gaq.push(['_setDomainName', 'jqueryscript.net']);
							  _gaq.push(['_trackPageview']);
							
							  (function() {
							    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
							    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
							    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
							  })();
							
							</script>
                     <!-- end script booking seat -->
                     
     
                        <div class="clearfix"></div>
                     </div>
                     
                     <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 col-ms-12">
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
                            <p>Copyright &copy; 2019 Công ty TNHH ABC</p>
                        </div>
                    </div>
                </div>
                
            </footer>
        </div>    
        <!-- load các thông tin khi chọn điểm bắt đầu -->
		<script type="text/javascript">
			function chg(){
				var val  = document.getElementById('startplace').value;
				var xhttp = new XMLHttpRequest();
			 	xhttp.onreadystatechange = function() {
				    if (xhttp.readyState == 4 && this.status == 200) {
				    	var responseArray = xhttp.responseText.split("||");
				    	document.getElementById('finishplace').innerHTML=responseArray[0];
				        document.getElementById('timestart').innerHTML=responseArray[1];

				    }
				};
				xhttp.open("POST", "BookingTicketController?loadinfoticket="+val, true);
				xhttp.send();
			}
		</script>
        <!--END load các thông tin khi chọn điểm bắt đầu -->
        
        <!-- load các thông tin khi chọn điểm bắt đầu -->
		<script type="text/javascript">
			function chg2(){
				var val  = document.getElementById('startplace').value;
				var val2 = document.getElementById('finishplace').value;
				
				var xhttp = new XMLHttpRequest();
			 	xhttp.onreadystatechange = function() {
				    if (xhttp.readyState == 4 && this.status == 200) {
				    	var responseArray = xhttp.responseText.split("||");
				        document.getElementById('timestart').innerHTML=responseArray[1];

				    }
				};
				xhttp.open("POST", "BookingTicketController?loadinfoticket="+val, true);
				xhttp.send();
			}
		</script>
        <!--END load các thông tin khi chọn điểm bắt đầu -->
        
        <!-- load các thông tin khi chọn điểm bắt đầu -->
		<script type="text/javascript">
			function chg3(){
				var val  = document.getElementById('startplace').value;
				var val2  = document.getElementById('finishplace').value;
				var val3  = document.getElementById('startplace').value;
				var val4  = document.getElementById('startplace').value;

				var xhttp = new XMLHttpRequest();
			 	xhttp.onreadystatechange = function() {
				    if (xhttp.readyState == 4 && this.status == 200) {
				    	var responseArray = xhttp.responseText.split("||");
				    	document.getElementById('finishplace').innerHTML=responseArray[0];
				        document.getElementById('timestart').innerHTML=responseArray[1];

				    }
				};
				xhttp.open("POST", "BookingTicketController?loadinfoticket="+val, true);
				xhttp.send();
			}
		</script>
        <!--END load các thông tin khi chọn điểm bắt đầu -->
        
    </body>
</html>