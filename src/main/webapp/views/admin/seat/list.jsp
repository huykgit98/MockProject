<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="/common/taglib.jsp" %>
 <c:url var="APIurl" value="/api-admin-seat"/>
 <c:url var ="SeatURL" value="/admin-seat"/>
 
  <!DOCTYPE html>
<html>
<head>
 <script src="<c:url value='/template/lisenme.js' />"></script>
<meta charset="ISO-8859-1">
<title>Seat List</title>
</head>
<body>
	<div class="main-content">
			

		<form action="<c:url value='/admin-seat'/>" id = "formSubmit" method="POST">
	<div class="breadcrumbs ace-save-state" id="breadcrumbs">
	            <ul class="breadcrumb">
	                <li>
	                    <i class="ace-icon fa fa-home home-icon"></i>
	                    <a href="#">Admin Controller</a>
	                </li>
	            </ul><!-- /.breadcrumb -->
	        </div>
	    <div class="main-content-inner">
	        
	        <div class="page-content">
	            <div class="row" >
	                <div class="col-xs-12">
	                			<c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
								</c:if>
	                			<div class="widget-box table-filter" style="margin-bottom: 11px;">
	                			
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Add Ticket' href='<c:url value="/admin-ticket?type=update"/>'>
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
										        <th>Seat</th>
										        <th>Bus NP</th>
										        <th>Date Start</th>
										        <th>Time Start </th>
										        <th>Start Place</th>
										        <th>Finish Place</th>
										        <th>Price</th>
										        <th>Description</th>
										        <th>Status</th>
										        <th>Action</th>
										      </tr>
											</thead>

											<tbody id="myTable">
												<tr>
													<td><input type="checkbox" id="checkBox_${itemticket.seatList}" onClick="toggle(this)" name="idbox" value="${itemticket.seatList }"></td>
													<td>Smith</td>
													<td>50</td>
													<td>Jilasdasl</td>
													<td>Smitsh</td>
													<td>50asc</td>
													<td>JilAl</td>
													<td>SmiSAth</td>
													<td>50S</td>
													<td>50V</td><td>JilAl</td>
												</tr>
												<tr>
													<td><input type="checkbox" id="checkBox_${itemticket.seatList}" onClick="toggle(this)" name="idbox" value="${itemticket.seatList }"></td>
													<td>Jackson</td>
													<td>94</td>
													<td>Jill</td>
													<td>Smith</td>
													<td>50</td>
													<td>Jilasdasl</td>
													<td>Smitsh</td>
													<td>50asc</td>
													<td>JilAl</td>
													<td>JilAl</td>
												</tr>
												<c:forEach var="itemticket" items="${seatModel.listResult}">
											      	<tr>
											      		<td><input type="checkbox" id="checkBox_${itemticket.seatList}" onClick="toggle(this)" name="idbox" value="${itemticket.seatList }"></td>
												     	<td>${itemticket.seatList }</td> 
												     	<td>${itemticket.bus.numberPlate }</td>
												       <td>${itemticket.booking.dateStart }</td>
												       <td>${itemticket.schedule.timeStart }</td>
												       <td>${itemticket.startPlace }</td>
												        <td>${itemticket.finishPlace }</td>
												        <td>${itemticket.schedule.price }</td> 
												        <td>${itemticket.booking.description }</td>
												        
												      <td> ${itemticket.seatStatus }
												       <!--   	<select class="form-control" name="status" onchange="changestatus()">
                                    								<c:if  test="${booking.status != 1 }">
                                    									<option  value="${booking.status == 1 }">BOOKED</option>
                                    									<option  value="${booking.status == 0 }">AVAILABE</option>
                                    									<option  value="${booking.status == 2 }">PAID</option>
                                    								</c:if>
                                    								<c:if  test="${booking.status == 1 }">
                                    									<option  value="${booking.status == 1 }">BOOKED</option>
                                    								</c:if>
                                    						</select> -->
                                    						
												        </td>
												        <td>
																<c:url var="updateURL" value="/admin-updateseat">
																	<c:param name="bus.id" value="${itemticket.bus.id}"/>
																	<c:param name="seatList" value="${itemticket.seatList }"/>
																	
																</c:url>
																<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
																   title="Update Seat Status" href="${updateURL }"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
																					<!-- href='<c:url value="/admin-new?type=edit"/>'  -->
																	</a>
															</td>
															 <td style="display:none;">${itemticket.bus.id }</td>
											      </tr>
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
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
	<script>
	 <!-- totalpage = tong so item trong database/maxPageItem= totelIem/maxpageitem -->
		var totalPages = ${itemticket.totalPage};
		var currentPage = ${itemticket.page};
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
		
			

		    //check & uncheck 
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
	</script>
	
	

</body>
</html>