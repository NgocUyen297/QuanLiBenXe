<%-- 
    Document   : sole-ticket
    Created on : Aug 19, 2022, 10:18:49 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Trang bán vé</h1>

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
    
    
    <h5 class="card-title">Ngày đi:${routeBus.ngaydi} </h5>
    <p class="card-title">Giờ đi: ${routeBus.giodi}</p>
    <p class="card-title">Xe số: ${routeBus.getBusesId().getBid()}</p>
    <p class="card-title">Số ghế còn lại: ${routeBus.getBusesId().getLoaixeID().getSoGhe() }</p>
    
    
    
    <c:url value="/route/addTicket/${routeBus.getBusesId().getBid()}/${routeBus.rbid}" var="action" />
    <form:form method="post" action="${action}" class="d-flex" 
               enctype="multipart/form-data"
               modelAttribute="ticket">
        <div class="form-group">
            <label class="form-control" for="username">Tên khách hàng: </label>
            <form:input class="form-control" type="text" id="username" path="username" value="username" />
        </div>
        
        <div class="form-group">
            <label class="form-control" for="soGhe">Nhập số ghế muốn mua: </label>
            <form:input class="form-control" type="number" name="soghe" path="amount"  id="soGhe" placeholder="Nhap so ghe muon mua" />
        </div>
        
        <div class="form-group">
            <label class="form-control" for="pickupStation">Chọn điểm đón: </label>
            <form:select id="pickupStation" class="form-control"  path="pickupStationId" >
                <c:forEach items="${pickupStations}" var="pickupStation">
                    <option value="${pickupStation.id}">${pickupStation.getIdTram().getTenTram()}</option>
                </c:forEach>
            </form:select>
            
            <label class="form-control" for="arriveStation">Chọn điểm trả: </label>
            <form:select id="arriveStation" class="form-control" path="arriveStationId">
                <c:forEach items="${arriveStations}" var="arriveStation">
                    <option value="${arriveStation.id}">${arriveStation.getIdTram().getTenTram()}</option>
                </c:forEach>
            </form:select>
            <input  type="Submit" value="Submit"/>
        </div>
    </form:form>
    
</div>