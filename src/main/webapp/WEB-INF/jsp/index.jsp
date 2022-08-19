<%-- 
    Document   : index
    Created on : Jul 28, 2022, 1:20:49 AM
    Author     : pc
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class = "container">

    <div class="row">
        <h4>Nhập tuyến xe muốn tìm:</h4>
        <c:url value="/" var="action" />
        <form  method="get" action="${action}" class="d-flex">
            <label for="fname">&#128681</label>
            <select name="startingPoint">
                <c:forEach items="${provinces}" var = "c">
                    <option>${c.name}</option>
                </c:forEach>    
            </select>
            <label for="fname"> &#128256</label>
            <select name="destination">
                <c:forEach items="${provinces}" var = "c">
                    <option>${c.name}</option>
                </c:forEach>    
            </select>
            <input type="submit"></li>
        </form>
    </div>
    <h4>Tuyến đường phổ biến:</h4>
    <div class ="row">
        <c:forEach items="${routes}" var = "b">   
            <div class="col-md-3 col-xs-12" style = "padding: 4px;">
                <div class="card">
                    <img class="card-img-top" class = "img-fluid" src="${b.image}" alt="Card image">
                    <div class="card-body">
                        <h5 class="card-title">${b.routename}</h5>
                        <p class="card-title">Điểm xuất phát: ${b.startingpoint.name}</p>
                        <p class="card-title">Điểm đến: ${b.destination.name}</p>
                        
                        <a href="<c:url value="/route/${b.rid}"/>" class="btn btn-primary">Xem thêm</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    
     <ul class="pagination">
            <c:forEach begin="1" end="${Math.ceil(routeCounter/page_size)}" var="i">
            <li><a href="<c:url value="/" />?page=${i}" class="btn">${i}</a></li>
            </c:forEach>
    </ul>

</div>




