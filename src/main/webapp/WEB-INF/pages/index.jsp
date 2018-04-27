<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
<c:import url="header.jsp"></c:import>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Article</h1>
        <c:choose>
            <c:when test="${sessionScope.uid != null}">
                <p class="lead text-muted">Something short and leading about the article of any contents. Make it short and sweet, but not too short so folks don't simply skip over it entirely.</p>
                <p><a class="btn btn-primary my-2" href="article/new">Post a New Article</a></p>
            </c:when>
            <c:otherwise>
                <p class="lead text-muted">You need to login first to manage the articles</p>
                <p><a class="btn btn-primary my-2" href="auth/login">Login Now</a></p>
            </c:otherwise>
        </c:choose>
    </div>
</section>
<div class="album py-5 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div style="background-color: #55595c; height: 255px"></div>
                    <div class="card-body">
                        <p class="card-text card-height">How to avoid these 6 mistakes when applying for grants in Singapore</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='article/view?id=1'">View</button>
                            </div><small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div style="background-color: #55595c; height: 255px"></div>
                    <div class="card-body">
                        <p class="card-text card-height">StashAway banks $5.3m funding, but road to profitability for robo-advisors remains unclear</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='article/view?id=2'">View</button>
                            </div><small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div style="background-color: #55595c; height: 255px"></div>
                    <div class="card-body">
                        <p class="card-text card-height">Asia news roundup: Flipkart losses widen to $3.6b, Toutiao and Weibo duke it out, and mores</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='article/view?id=3'">View</button>
                            </div><small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div style="background-color: #55595c; height: 255px"></div>
                    <div class="card-body">
                        <p class="card-text card-height">Alibaba and Twitter backer makes first-ever India bet</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='article/view?id=4'">View</button>
                            </div><small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div style="background-color: #55595c; height: 255px"></div>
                    <div class="card-body">
                        <p class="card-text card-height">Will esports boom in Southeast Asia like it did in China?</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='article/view?id=5'">View</button>
                            </div><small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div style="background-color: #55595c; height: 255px"></div>
                    <div class="card-body">
                        <p class="card-text card-height">4 startup lessons I learned from Alibabaâs founders program</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='article/view?id=6'">View</button>
                            </div><small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <div style="background-color: #55595c; height: 255px"></div>
                    <div class="card-body">
                        <p class="card-text card-height">Behind SingaporeÃ¢ÂÂs meteoric rise as a top blockchain hub</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button class="btn btn-sm btn-outline-secondary" type="button" onclick="location.href='article/view?id=12'">View</button>
                            </div><small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="footer.jsp"></c:import>