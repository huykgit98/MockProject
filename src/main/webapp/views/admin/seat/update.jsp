<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-ticket"/>
<c:url var ="seatURL" value="/admin-seat"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Tickets</title>
<%=request.getAttribute("availabeSeat") %>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
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
					
		<form action="admin-updateseat" method="POST" >
						<h2>Customer: </h2>
 	   <!--                    <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Email: </label>
                                <div class="col-sm-9">
                                    <input  type="text" class="form-control" id="txtEmail" name="txtEmail" value=""/>
                                </div>
                       </div>
                        <br/>
                       <br/>
                       <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">FullName:</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="txtFullName" name="txtFullName" value=""/>
                                </div>
                       </div>
                       <br/>
                       <br/>
                         <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Address</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="txtAddress" name="txtAddress" value=""/>
                                </div>
                       </div>
                       <br/>
                       <br/>
                        <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Phone: </label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="txtPhone" name="txtPhone" value=""/>
                                </div>
                       </div>
                       <br/>
                       <br/>  -->
                       <div class="form-group">
 							 <label class="col-sm-3 control-label no-padding-right">Choose Customer: </label>
                                <div class="col-sm-9">
                                    <!-- <input  type="text" class="form-control" id="txtCustomer" name="txtCustomer" value=""/> -->
                                     <select class="form-control" name="txtCustomerId">
                                     		<option>Choose </option>
	                                    	<c:forEach var="itemseat"  items="${allCustomer}">
                                    				<option  value="${itemseat.customer.id}">ID: ${itemseat.customer.id} - Mail: ${itemseat.customer.email } - Phone: ${itemseat.customer.phone }</option>
                                    		</c:forEach>
                                    </select>
                                </div>                                 
                       </div><br/>
                       <br/>
                       
                       <h2>Seat</h2>
                       <input type="hidden" name="txtSeat" value="${seatModel.seatList }" />
 						 <div class="form-group">
 							 <label class="col-sm-3 control-label no-padding-right">Seat Number: </label>
                                <div class="col-sm-9">
                                    <input readonly type="text" class="form-control" id="txtseat" name="txtseat" value="${seatModel.seatList}"/>
                                </div>
                       </div><br/>
                       <br/>
                        <div class="form-group">
 							 <label class="col-sm-3 control-label no-padding-right">Bus NP: </label>
                                <div class="col-sm-9">
                                    <input readonly type="text" class="form-control" id="txtBusNP" name="txtBusNP" value="${seatModel.bus.numberPlate}"/>
                                </div>
                       </div>
                       <br/>
                       <br/>
                        <div class="form-group">
 							 <label class="col-sm-3 control-label no-padding-right">Bus Type: </label>
                                <div class="col-sm-9">
                                    <input readonly type="text" class="form-control" id="txtBusType" name="txtBusType" value="${seatModel.busType.typeName}"/>
                                </div>
                       </div>
                       <br/>
                       <br/>
                           <h2>Booking: </h2>
 						<!-- <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Booking Date: </label>
                                <div class="col-sm-9">
                                    <input type="datetime-local" class="form-control" id="txtBookingDate" name="txtBookingDate" value=""/>
                                </div>
                       </div>
                       <br/>
                       <br/>  --> 
                       <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Starting Date: </label>
                                <div class="col-sm-9">
                                    <input type="datetime-local" class="form-control" id="txtStartingDate" name="txtStartingDate" value=""/>
                                </div>
                       </div>
                       <br/>
                       <br/>
                          <h2>Schedule: </h2>
                          <input type="hidden" class="form-control" name="txtScheduleId" value="${seatModel.scheduleID }">
 						 <div class="form-group">
 						 		 <label class="col-sm-3 control-label no-padding-right"> Start Place: </label>
                                <div class="col-sm-9">
                                    <input readonly type="text" class="form-control" id="txtTimeStart" name="txtTimeStart" value="${seatModel.startPlace}"/>
                                </div>
                       </div><br/>
                       <br/>
                       <div class="form-group">
 						 		 <label class="col-sm-3 control-label no-padding-right">Finish Place: </label>
                                <div class="col-sm-9">
                                    <input readonly type="text" class="form-control" id="" name="" value="${seatModel.finishPlace}"/>
                                </div>
                       </div><br/>
                       <br/>
                         <div class="form-group">
 						 		 <label class="col-sm-3 control-label no-padding-right">Time Start: </label>
                                <div class="col-sm-9">
                                    <input readonly type="text" class="form-control" id="" name="" value="${ seatModel.schedule.timeStart}"/>
                                </div>
                       </div>

                         <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
   
                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Update Ticket" id="btnAddOrUpdateNew"/>
                                 
                                  
                                </div>
                            </div>
                       
                       </form>
         		</div>
         	</div>
         </div>
	</div>

</body>
</html>