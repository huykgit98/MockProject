<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="/common/taglib.jsp" %>
 <c:url var="APIurl" value="/api-admin-ticket"/>
 <c:url var ="TicketURL" value="/admin-ticket"/>
 
 <!DOCTYPE html>
<html>
<head>
 <script src="<c:url value='/template/lisenme.js' />"></script>
<meta charset="ISO-8859-1">
<title>Ticket List</title>
</head>

<body>
	<div class="main-content">
	
  	  <form action="<c:url value='/admin-updateTicket'/>" id = "formSubmit" method="POST">
	
	    <div class="main-content-inner">
	        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
	            <ul class="breadcrumb">
	                <li>
	                    <i class="ace-icon fa fa-home home-icon"></i>
	                    <a href="#">Admin Controller</a>
	                </li>
	            </ul><!-- /.breadcrumb -->
	        </div>
	        <div class="page-content">
	            <div class="row" >
	                <div class="col-xs-12">
	                			<c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
								</c:if>
	                			<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Add Ticket' href='<c:url value="/admin-updateTicket"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
												<button id="btnDelete" type="button"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Delete Ticket'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button>
											</div>
										</div>
										<div align="left"> <input id="myInput" type="text" placeholder="Enter your keyword">  </div>
									</div>
								</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responive">
									 <table class="table table-bordered" id="table-seat-list">
   										 <thead>
    										<tr>
										      	<th><input type="checkbox" id="checkAll"></th>
										        <th>Booking ID</th>
										        <th>Bus NP</th>
										        <th>Seat</th>
										        <th>Full Name</th>
										        <th>Booking Date</th>
										        <th>Date Start</th>
										        <th>Time Start</th>
										        <th>Start Place</th>
										        <th>Finish Place</th>
										        <th>Price</th>
										        <th>Action</th>
										      </tr>
     									</thead>
     
										     <tbody id="myTable">
	<tr>
											     <td><input type="checkbox" id="checkBox_${itemticket.booking.bookingID}" onClick="toggle(this)" name="idbox" value="${itemticket.booking.bookingID }"></td>
											      <td>Smith</td>
											      <td>50</td>
											      <td>50</td>
											      <td>50</td>
											      <td>50</td>
											      <td>50</td>
											      <td>50</td>
											      <td>50</td>
											      <td>50</td>
											      <td>50</td>
											      <td>50</td>
											    </tr>
											    <tr>
											      		<td><input type="checkbox" id="checkBox_${itemticket.booking.bookingID}" onClick="toggle(this)" name="idbox" value="${itemticket.booking.bookingID }"></td>
											      <td>Jackson</td>
											      <td>94</td>
											      <td>20</td>
											      <td>5sdas0</td>
											      <td>5sda0</td>
											      <td>5v0</td>
											      <td>5dv0</td>
											      <td>50b</td>
											      <td>50a</td>
											      <td>50v</td>
											      <td>50a</td>
											    </tr>
											    <c:forEach var="itemticket" items="${model.listResult}">
											      	<tr>
											      		<td><input type="checkbox" id="checkBox_${itemticket.booking.bookingID}" onClick="toggle(this)" name="idbox" value="${itemticket.booking.bookingID }"></td>
												       <td>${itemticket.booking.bookingID }</td>
												       
												     	 <td>${itemticket.bus.numberPlate }</td>
												        <td>${itemticket.seatList }</td> 
												         <td>${itemticket.customer.fullName }</td>
												        <td>${itemticket.booking.bookingDate }</td>
												        <td>${itemticket.booking.dateStart }</td>
												        <td>${itemticket.schedule.timeStart }</td>
												        <td>${itemticket.startPlace }</td>
												        <td>${itemticket.finishPlace }</td>
												        <td>${itemticket.schedule.price }</td> <td style="display:none;">${itemticket.schedule.id }</td>
												        <td>
																<c:url var="updateURL" value="/admin-updateTicket">
																	<c:param name="booking.bookingID" value="${itemticket.booking.bookingID}"/>
																	<c:param name="seatList" value="${itemticket.seatList }"/>
																</c:url>
																<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																   title="Update Ticket" href='${updateURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																					<!-- href='<c:url value="/admin-new?type=edit"/>'  -->
																	</a>
																<a class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip"
																   title="Cancel Ticket" href='<c:url value="/admin-cancelTicketController?booking.bookingID=${itemticket.booking.bookingID}&seatList=${itemticket.seatList }"/>'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																	</a>
															</td>
											      </tr>
											      <input type="hidden" value="${itemticket.schedule.id }" id="type" name="type"/> 
											      <input type="hidden" value="${itemticket.booking.bookingID }" id="txtBookingId" name="txtBookingId"/> 
											      <input type="hidden" value="${itemticket.seatList }" id="txtSeat" name="txtSeat"/> 
										      </c:forEach>
										    </tbody>
									  </table>
			
			<script type="text/javascript" src="<c:url value='/template/lisenme.js' />"></script>  
	<script>
		jQuery('#table-seat-list').ddTableFilter();
	</script>
	<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase().trim();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
																
										<ul class="pagination"  id="pagination"></ul> 
										<input type="hidden" value="" id="page" name="page"/>
										<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
										<input type="hidden" value="" id="sortName" name="sortName"/>
										<input type="hidden" value="" id="sortBy" name="sortBy"/>
										<input type="hidden" value="" id="type" name="type"/> 
								</div>							
							</div>
						</div>
	                </div>
	            </div>
	        </div>
	    </div>
    </form>
   </div>
	<!-- /.main-content  -->
	<script>
	 <!-- totalpage = tong so item trong database/maxPageItem= totelIem/maxpageitem -->
			var totalPages = ${model.totalPage};
			var currentPage = ${model.page};
			var limit = 2;
			$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: 2,
				startPage: currentPage,
				onPageClick: function (event, page) {
					if (currentPage != page){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('Seat');
						$('#sortBy').val('ASC');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}		
			});
		});
			
		
	 
		    
		    $('#checkAll').click(function(event) {   
		        if(this.checked) {
		            // Iterate each checkbox
		            $(':checkbox').each(function() {
		                this.checked = true;                        
		            });
		        } else {
		            $(':checkbox').each(function() {
		                this.checked = false;                       
		            });
		        }
		    });
		    
		    
			$("#btnDelete").click(function(){
				var data={};
				var ids = $('tbody input[type=checkbox]:checked').map(function () {
		            return $(this).val();
		        }).get();
				data['ids'] = ids;
				deleteTicket(data);
			});
			
		    function deleteTicket(data) {
		        $.ajax({
		            url: '${APIurl}',
		            type: 'DELETE',
		            contentType: 'application/json',
		            data: JSON.stringify(data),
		            success: function (result) {
		            	window.location.href ="${TicketURL}?type=list&page=1&maxPageItem=10&sortName=booking.bookingID&sortBy=ASC";
		            },
		            error: function (error) {
		            }
		        });
		    }
	</script> 

</body>
</html>