<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Hero-area -->
<div class="hero-area section">

    <!-- Backgound Image -->
    <div class="bg-image bg-parallax overlay"
         style="background-image:url(.${pageContext.request.contextPath}/resources/assets/user/assets/img/page-background.jpg)"></div>
    <!-- /Backgound Image -->

    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 text-center">
                <ul class="hero-area-tree">
                    <li><a href="/">Home</a></li>
                    <li>Aptitude Test</li>
                </ul>
                <h1 class="white-text">WordNet Quiz</h1>

            </div>
        </div>
    </div>

</div>
<!-- /Hero-area -->
<div class="section">
    <div class="container">
        <div id="main" class="col-md-12">

            <c:choose>
                <c:when test="${response}">
                    Your score is <c:out value="${score}"/> <br>
                    <c:forEach items="${answers.entrySet()}" var="map">
                        ${map.getKey()} ${map.getValue()} <br>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <form action="" method="post" class="form-group" style="display: block;">
                            <%--    question--%>
                        <c:forEach var="question" items="${lists}" >
                            <div class="col-md-8 card">
                                <div class="card-header">
                                    Q1 : Choose the out cast
                                </div>
                                <div class="card-body">
                                    <c:forEach var="q" items="${question.options}">
                                        <label style="display: block;" for="">
                                            <input type="radio" name="${question.index}" value="${q}"> ${q}
                                        </label>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:forEach>

                        <div class="col-md-8 form" style="display: block">
                            <input type="submit" value="Submit Answers">
                        </div>
                    </form>
                </c:otherwise>
            </c:choose>


        </div>
    </div>

</div>