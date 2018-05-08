<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
<html>
<head>
    <title>Spring Basic MVC</title>
    <base href="${base}"/>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/css/style.css" rel="stylesheet"/>
    <script src="resources/js/jquery-3.3.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
            <sec:authorize access="isAuthenticated()">
                <a class="navbar-brand d-flex align-items-center" href=""> <strong>Spring MVC - CDC</strong></a> <a class="sign-in-btn" href="logout">Sign Out</a></button>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <a class="navbar-brand d-flex align-items-center" href=""> <strong>Spring MVC - CDC</strong></a> <a class="sign-in-btn" href="login">Sign In</a></button>
            </sec:authorize>
        </div>
    </div>
</header>