<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="../header.jsp"></c:import>
<div class="form-canvas">
    <form:form class="form" method="POST" action="article/create" modelAttribute="article">
        <div class="text-center mb-4">
            <h1 class="h3 mb-3 font-weight-normal">Post New Article</h1>
            <p>Fill in the title and content then press the submit button to create a new article.</p>
        </div>
        <div class="form-label-group">
            <form:input path="title" autofocus="" class="form-control" placeholder="Type the title of your content"/> <form:label path="title">Title</form:label>
            <form:errors path="title" cssClass="error" />
        </div>
        <div class="form-label-group">
            <form:textarea class="form-control" id="content" path="content" placeholder="Type the content of your content"></form:textarea> <form:label path="content">Content</form:label>
            <form:errors path="content" cssClass="error" />
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Publish</button>
        <div class="nav-to-home">
            <a href="#" onclick="window.history.go(-1); return false;">Back to Home</a>
        </div>
    </form:form>
</div>
<c:import url="../footer.jsp"></c:import>