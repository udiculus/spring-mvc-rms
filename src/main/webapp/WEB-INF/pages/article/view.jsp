<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="../header.jsp"></c:import>
<section class="article-header">
    <div class="container">
        <div class="article-heading">${article.title}</div>
    </div>
</section>
<div>
    <div class="container">
        <div class="article-content">
            ${article.content}
        </div>
        <div class="article-comments">
            <c:forEach var="comment" items="${comments}">
                <div>${comment.comment}</div>
            </c:forEach>
        </div>
    </div>
</div>
<c:import url="../footer.jsp"></c:import>