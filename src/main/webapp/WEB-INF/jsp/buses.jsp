<%-- 
    Document   : buses
    Created on : Aug 6, 2022, 8:29:06 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary">Thông tin các chuyến xe</h1>


<c:url value="/admin/buses" var="action" />
<form:form method="post" action="${action}" modelAttribute="buses">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="name" class="form-control" id="name" placeholder="name" name="name" />
        <label for="name">Tên chuyến xe</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="seats" class="form-control" id="seats" placeholder="seats" name="seats" />
        <label for="name">Số lượng ghế</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <select>
            <option>Xe giường nằm</option>   
            <option>Xe ghế ngồi</option>  
        </select>
        <label for="name">Loại xe</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="date" path="ngaydi" class="form-control" id="ngaydi" placeholder="ngaydi" name="ngaydi" />
        <label for="name">Ngày đi</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="time" path="giodi" class="form-control" id="giodi" placeholder="giodi" name="giodi" />
        <label for="name">Giờ đi</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" path="price" class="form-control" id="price" placeholder="price" name="price" />
        <label for="name">Giá chuyến xe</label>
    </div>
    <div class="form-floating">
        <form:select path="routeId" class="form-select" id="route" name="route">
            <c:forEach items="${routes}" var="c">
                <option value="${c.rid}">${c.routename}</option>
            </c:forEach>
        </form:select>
        <label for="route" class="form-label">Danh mục tuyến xe xe</label>
    </div>
    <div>
        <br>
        <input type="submit" value="Thêm chuyến xe" class="btn btn-danger" />
    </div>
</form:form>

<table class="table">
    <tr>
        <th></th>
        <th>Tên chuyến</th>
        <th></th>
    </tr>
    <tbody id="myBuses">

    </tbody>
</table>

<script src="<c:url value="/js/buses.js" />"></script>
<script>
    <c:url value="/api/buses" var="endpoint" />
    window.onload = function () {
        loadBuses('${endpoint}');
    }
</script>