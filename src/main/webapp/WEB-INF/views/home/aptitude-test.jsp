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
                    <li>Test</li>
                </ul>
                <h1 class="white-text">Aptitude Test</h1>

            </div>
        </div>
    </div>

</div>
<!-- /Hero-area -->
<div class="section">
    <div class="container">
        <div id="main" class="col-md-12">

            <form action="" method="post" class="form-group" style="display: block;">
        <%--    question--%>
                <div class="col-md-8 card">
                    <div class="card-header">
                        Q1 : Choose the out cast
                    </div>
                    <div class="card-body">
                        <label style="display: block;" for="">
                            <input type="radio" name="q1"> Apple
                        </label>
                        <label style="display: block;" for="">
                            <input type="radio" name="q1"> Mango
                        </label>
                        <label style="display: block;" for="">
                            <input type="radio" name="q1"> Orange
                        </label>
                        <label style="display: block;" for="">
                            <input type="radio" name="q1"> Table
                        </label>


                    </div>
                </div>

            <div class="col-md-8 form" style="display: block">
                <input type="submit" value="Submit Answers">
            </div>
            </form>
        </div>
    </div>

</div>