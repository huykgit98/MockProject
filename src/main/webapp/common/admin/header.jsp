<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/common/taglib.jsp" %>
    
<!DOCTYPE html>


<div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Admin HomePage
                </small>
            </a>
        </div>
        <div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                	<c:if test="${not empty loginedUser}">
                		<li><a href="#" >Welcome, ${loginedUser.userName}</a></li>
                	</c:if>
                    <c:if test="${ empty loginedUser}">
                    	<a data-toggle="dropdown" href="${pageContext.request.contextPath}/login" class="dropdown-toggle">
                       Login 
                    	</a>
                	</c:if>
                    <li class="light-blue dropdown-modal">
                        <a href="${pageContext.request.contextPath}/logout">
                            <i class="ace-icon fa fa-power-off"></i>
                            Logout
                        </a>
                    </li>
            </ul>
        </div>
    </div>
</div>