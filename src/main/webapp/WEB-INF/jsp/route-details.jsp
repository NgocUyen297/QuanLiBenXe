<%-- 
    Document   : route-details
    Created on : Aug 15, 2022, 12:46:24 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
        <h1 class="route-detail-header text-center">${route.routename}</h1>   
    <div>
        <c:choose>
            <c:when test="${route.image != null}">
                <img  src="${route.image}" alt="anh chuyen xe" class="img-fluid card-img-top"/>
            </c:when>
            <c:when test="${route.image == null}">
                <img  src="<c:url value="/image/defaultXeKhach.jpg"/>" alt="anh chuyen xe" class="img-fluid card-img-top"/>
            </c:when>
        </c:choose>
    </div>
    
    <div class ="row">
        <c:forEach items="${routeBuses}" var = "routeBus">   
            <div class="col-md-3 col-xs-12" style = "padding: 4px;">
                <div class="card">
                    <img class="card-img-top" class = "img-fluid" src="${route.image}" alt="Card image">
                    <div class="card-body">
                       <h5 class="card-title">Ngày đi:${routeBus.ngaydi} </h5>
                        <p class="card-title">Giờ đi:${routeBus.giodi} </p>               
                        <p class="card-title">Xe số: ${routeBus.getBusesId().getBid()}</p>
                        <p class="card-title">Số ghế còn lại: ${routeBus.getBusesId().getLoaixeID().getSoGhe()}</p>
                        <a href="<c:url value="/route/${route.rid}/${routeBus.rbid}"/>" class="btn btn-primary">Đặt vé</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
