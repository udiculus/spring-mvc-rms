<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="header.jsp"></c:import>
<div>
	<div class="form-canvas">
        <form action='<spring:url value="/loginAction"/>' method="post">
            <div class="text-center mb-4">
                <h1 class="h3 mb-3 font-weight-normal">Login</h1>
                <p>Put username with 'admin' and password with 'admin123'.</p>
                <c:if test="${not empty sessionScope.message}">
                    <span style="color:green"><c:out value="${sessionScope.message}"/></span>
                    <c:remove var="message" scope="session" />
                </c:if>
            </div>
            <div class="form-label-group">
                <input autofocus="" class="form-control" id="username" name="username" placeholder="Type your username" required="" type="text"> <label for="username">Username</label>
            </div>
            <div class="form-label-group">
                <input class="form-control" id="password"  name="password" placeholder="Type your password" required="" type="password"/><label for="password">Password</label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
            <div class="nav-to-home">
                <a href="#" onclick="window.history.go(-1); return false;">Back to Home</a>
            </div>
        </form>
    </div>
</div>
<c:import url="footer.jsp"></c:import>