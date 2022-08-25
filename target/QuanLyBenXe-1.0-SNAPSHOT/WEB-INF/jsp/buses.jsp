<%-- 
    Document   : buses
    Created on : Aug 6, 2022, 8:29:06 PM
    Author     : pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<h1 class="text-center text-primary">Thêm chuyến xe</h1>


<c:url value="/admin/buses" var="action" />
<form:form method="post" action="${action}" modelAttribute="buses">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="busesName" class="form-control" id="name" placeholder="name" name="name" />
        <label for="name">Tên chuyến xe</label>
    </div>

    <div class="form-floating">
        <form:select path="driverID" class="form-select" id="driver" name="driver">
            <c:forEach items="${users}" var="c">
                <c:if test="${c.rode == 'Driver'}">
                    <option value="${c.userid}">${c.username}</option>
                </c:if>
            </c:forEach>
        </form:select>
        <label for="driver" class="form-label">Danh sách tài xế</label>
    </div><br>

    <div class="form-floating">
        <form:select path="loaixeID" class="form-select" id="loai" name="loai">
            <c:forEach items="${loaixe}" var="c">
                <option value="${c.lid}">${c.loaiXe}</option>
            </c:forEach>
        </form:select>
        <label for="loai" class="form-label">Loại xe</label>
    </div><br>

    <div>
        <br>
        <input type="submit" value="Thêm chuyến xe" class="btn btn-danger"/>
    </div>
</form:form>

<div class="table-search-buses" style="padding-left: 70%">
    <h6 style="display: inline;">Tìm kiếm: </h6>
    <input type="text" id="myInput" onkeyup="mySearchBuses()" placeholder="Search for names..">
</div>
<div class="spinner-border text-success" id="mySpinner"></div>
<table class="table" id = "myTable">
    <tr>
        <th>Mã</th>
        <th></th>
        <th>Tên chuyến xe</th>
    </tr>
    <tbody id="myBuses">

    </tbody>
</table>

<div>  
    <a href="<c:url value="/admin/routebuses" />"class="btn"  style="padding-left: 75%">
        <h7>Thêm tuyến xe cho chuyến xe &#62&#62</h7>
    </a>
</div>

<script src="<c:url value="/js/buses.js" />"></script>
<script>
    <c:url value="/api/buses" var="u" />

        window.onload = function () {
            getBuses('${u}');
        }

</script>
