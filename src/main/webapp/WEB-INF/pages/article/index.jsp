<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
<c:import url="../header.jsp"></c:import>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Articles</h1>
        <sec:authorize access="isAuthenticated()">
            <p class="lead text-muted">Something short and leading about the article of any contents. Make it short and sweet, but not too short so folks don't simply skip over it entirely.</p>
            <sec:authorize access="hasRole('ROLE_AUTHOR')">
                <p><a class="btn btn-primary my-2" href="article/create">Post a New Article</a></p>
            </sec:authorize>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <p class="lead text-muted">You need to login first to manage the articles</p>
            <p><a class="btn btn-primary my-2" href="login">Login Now</a></p>
        </sec:authorize>
    </div>
</section>
<div class="album py-5 bg-light">
    <div class="container">
        <div class="row">
            <c:forEach var="article" items="${listArticle}">
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div style="background-color: #55595c; height: 255px"></div>
                    <div class="card-body">
                        <p class="card-text card-height"><c:out value="${article.title}" /></p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='article/view/${article.id}'">View</button>
                                <sec:authorize access="isAuthenticated()">
                                    <sec:authorize access="hasRole('ROLE_AUTHOR')">
                                        <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='article/edit/${article.id}'">Edit</button>
                                    </sec:authorize>
                                    <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='article/delete/${article.id}'">Delete</button>
                                </sec:authorize>
                            </div><small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
<c:import url="../footer.jsp"></c:import>