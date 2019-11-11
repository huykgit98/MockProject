<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<title>Bus Ticket Reservation Widget Flat Responsive Widget Template :: w3layouts</title>
<!-- for-mobile-apps -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="Bus Ticket Reservation Widget Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!-- //for-mobile-apps -->
<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="bus/css/jquery.seat-charts.css">
<link href="bus/css/style_bus.css" rel="stylesheet" type="text/css" media="all" />
<script src="bus/js/jquery-1.11.0.min.js"></script>
<script src="bus/js/jquery.seat-charts.js"></script>


</head>
<body>

<div class="content">
	<h1>Bus Ticket TV BUS</h1>
	<div class="main">
		<h2>Book Your Seat Now?</h2>
			Seats: <b><span id="abc"></span></b>		
		<div class="wrapper">
			<div id="seat-map">
				<div class="front-indicator"><h3>Front</h3></div>
			</div>
			<div class="booking-details">
						<div id="legend"></div>
						<h3> Selected Seats (<span id="counter">0</span>):</h3>
						<ul id="selected-seats" class="scrollbar scrollbar1">
						</ul>
						Total: <b>$<span id="total">0</span></b>						
						<a class="checkout-button" href="${pageContext.request.contextPath}/cart?id=" id="thea" onclick="xyzz()">OK</a>
			</div>
			<div class="clear"></div>
		</div>
		
		<sql:setDataSource var="conn" driver="com.mysql.jdbc.Driver" url = "jdbc:mysql://localhost/mockproject" user="root" password=""/>
			<sql:query var="result" dataSource="${conn}">
				select * from price where id=1001;
			</sql:query>
		<script>
			
			function xyzz(){
				x = document.getElementById("thea");
				y = document.getElementById("abc").innerHTML;
				x.href+=y;
			}
				var firstSeatLabel = 1;
				var mapM = new Map();
				$(document).ready(function() {
					var  economy =0;
					var  first = 0;
					<c:forEach var = "row" items = "${result.rows}">
						first = '${row.firstclass}';
						economy = '${row.economyclass}';				
					</c:forEach>						
					var $cart = $('#selected-seats'),
						$counter = $('#counter'),
						$total = $('#total'),						
						$abc= $('#abc'),
						$xyz= $('#xyz'),
						sc = $('#seat-map').seatCharts({
						map: [
							'ff_ff',
							'ff_ff',
							'ee_ee',
							'ee_ee',
							'ee___',
							'ee_ee',
							'ee_ee',
							'ee_ee',
							'eeeee',
						],
						
						
						seats: {
							f: {																						
								price   : Number(first),
								classes : 'first-class', //your custom CSS class
								category: 'First Class'
							},
							e: {
								price   : Number(economy),
								classes : 'economy-class', //your custom CSS class
								category: 'Economy Class'
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
								[ 'f', 'available',   'First Class' ],
								[ 'e', 'available',   'Economy Class'],
								[ 'f', 'unavailable', 'Already Booked']
							]					
						},
						click: function () {
							var s = '';//id ghe
							if (this.status() == 'available') {
								//let's create a new <li> which we'll add to the cart items
								$('<li>'+this.data().category+' : Seat no '+this.settings.label+': <b>$'+this.data().price+'</b> <a href="#" class="cancel-cart-item">[cancel]</a></li>')
									.attr('id', 'cart-item-'+this.settings.label)
									.data('seatId', this.settings.label)
									.appendTo($cart);
								
								 // * Lets update the counter and total
								 // *
								 // * .find function will not find the current seat, because it will change its stauts only after return
								 // * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
								 
								$counter.text(sc.find('selected').length+1);
								$total.text(recalculateTotal(sc)+this.data().price);
								mapM.set(this.settings.id,this.data().price);
								
								for(var i of mapM.keys()){
									s+=' '+i;					
								}
								$abc.text(s);
								return 'selected';

							} else if (this.status() == 'selected') {
								//update the counter
								$counter.text(sc.find('selected').length-1);
								//and total
								$total.text(recalculateTotal(sc)-this.data().price);
							
								//remove the item from our cart
								$('#cart-item-'+this.settings.label).remove();
								
								mapM.delete(this.settings.id);

								for(var i of mapM.keys()){
									s+=' '+i;					
								}
								$abc.text(s);
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
					var data = new Array();
				        <c:forEach items="${seat}" var="a" >
				            data.push("${a}");
				        </c:forEach>    
					//let's pretend some seats have already been booked
					sc.get(data).status('unavailable');
			});
			function recalculateTotal(sc) {
				var total = 0;			
				//basically find every selected seat and sum its price
				sc.find('selected').each(function () {
					total += this.data().price;
				});				
				return total;
			}			
		</script>
	</div>
</div>

</body>
<script>
</script>
</html>
