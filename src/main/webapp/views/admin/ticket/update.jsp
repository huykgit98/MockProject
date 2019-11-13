<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-ticket"/>
<c:url var ="TicketURL" value="/admin-ticket"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Tickets</title>
<%=request.getAttribute("availabeSeat") %>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
	            <ul class="breadcrumb">
	                <li>
	                    <i class="ace-icon fa fa-home home-icon"></i>
	                    <a href="#">Admin Controller</a>
	                </li>
	            </ul><!-- /.breadcrumb -->
	        </div>
		</div>
		<div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                	<c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
					</c:if>	
					
					<form id = "formSubmit"  method="POST" action="admin-updateTicket">
					<h2>Customer: </h2>
                      
                       <div class="form-group">
 							 <label class="col-sm-3 control-label no-padding-right">FullName : </label>
                                <div class="col-sm-9">
                           		     <input type="hidden" class="form-control" name="txtBookingID" value="${model.booking.bookingID}"/>
                           		     <input type="hidden" class="form-control" name="txtSeatGET" value="${model.seatList}"/>
                                    <input  type="text" class="form-control" id="txtFullName" name="txtFullName" value="${model.customer.fullName}"/>
                                </div>
                       </div><br/>
                       <br/>
                        <div class="form-group">
 							 <label class="col-sm-3 control-label no-padding-right">Email : </label>
                                <div class="col-sm-9">
                                    <input  type="text" class="form-control" id="txtEmail" name="txtEmail" value="${model.customer.email}"/>
                                </div>
                       </div><br/>
                       <br/>
                       <div class="form-group">
 							 <label class="col-sm-3 control-label no-padding-right">Address : </label>
                                <div class="col-sm-9">
                                    <input  type="text" class="form-control" id="txtAddress" name="txtAddress" value="${model.customer.address}"/>
                                </div>
                       </div><br/>
                       <br/>
                        <div class="form-group">
 							 <label class="col-sm-3 control-label no-padding-right">Phone : </label>
                                <div class="col-sm-9">
                                    <input  type="text" class="form-control" id="txtPhone" name="txtPhone" value="${model.customer.phone}"/>
                                </div>
                       </div><br/>
                       <br/>
                       
                       <h2>Seat: </h2>
                      
                       <div class="form-group">
 							 <label class="col-sm-3 control-label no-padding-right">Bus NP : </label>
                                <div class="col-sm-9">
                                	<c:if test="${empty model.booking.bookingID }">
                                		 <input  type="text" class="form-control" id="txtBusNP" name="txtBusNP" value="${model.bus.numberPlate}"/>
                                	</c:if>
                                	<c:if test="${not empty model.booking.bookingID }">
                                		 <input readonly type="text" class="form-control" id="txtBusNP" name="txtBusNP" value="${model.bus.numberPlate}"/>
                                	</c:if>
                                </div>
                       </div><br/>
                       <br/>
                       
                       <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Seat</label>
                                <div class="col-sm-9">
                                    <select class="form-control" name="txtSeat">
                                    	<c:if test="${empty model.seatList }">                      <!-- ADD -->
                                    		<option value="" >Choose Seat</option>
	                                    	<c:forEach var="itemticket"  items="${availabeSeat}">
                                    			<option value="${itemticket.seatList}" >${itemticket.seatList}</option>
                                    		</c:forEach>
                                    	</c:if>
                                    	<c:if test="${not empty model.seatList }"> 
                                    		<option value="" >Choose New Seat</option>                 <!-- UPDATE -->
	                                    	<c:forEach var="itemticket"  items="${availabeSeat}">
                                    			<c:if test="${itemticket.seatList == 52 }">
                                    				<option  value="${itemticket.seatList}" selected="selected">${itemticket.seatList}</option>
                                    			</c:if>
                                    			<c:if  test="${itemticket.seatList != 52 }">
                                    				<option  value="${itemticket.seatList}">${itemticket.seatList}</option>
                                    			</c:if>
                                    		</c:forEach>
                                    	</c:if>
                                    </select>
                                    <input type="hidden" value="btnAddOrUpdateNew"  />
                                </div>
                       </div>
                         <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                  <c:if test="${ model.booking.bookingID == 0}">
                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Add Ticket" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${ model.booking.bookingID != 0}">
                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Update Ticket" id="btnAddOrUpdateNew"/>
                                    	
                                    </c:if>
                                  
                                </div>
                            </div>
                       
                       </form>
         		</div>
         	</div>
         </div>
	</div>

</body>
</html>