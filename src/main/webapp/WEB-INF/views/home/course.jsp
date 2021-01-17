<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- Hero-area -->
<div class="hero-area section">

    <!-- Backgound Image -->
    <div class="bg-image bg-parallax overlay" style="background-image:url(.${pageContext.request.contextPath}/resources/assets/user/assets/img/page-background.jpg)"></div>
    <!-- /Backgound Image -->

    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 text-center">
                <ul class="hero-area-tree">
                    <li><a href="/">Home</a></li>
                    <li>Course</li>
                </ul>
                <h1 class="white-text">${course.name}</h1>

            </div>
        </div>
    </div>

</div>
<!-- /Hero-area -->

<!-- Blog -->
<div id="blog" class="section">

    <!-- container -->
    <div class="container">

        <!-- row -->
        <div class="row">

            <!-- main blog -->
            <div id="main" class="col-md-9">

                <!-- row -->
                <div class="row">
                    <div class="col-md-4">
                        <div class="single-blog">
                            <div class="blog-img">
                                <img src="data:image/jpg;base64,${course.base64Image}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="form-group">
                            <label for="">Instructor: </label> ${course.userByUserId.name}
                        </div>
                        <div class="form-group">
                            <label>Category: </label>${course.categoryByCategoryId.name}
                        </div>
                        <div class="form-group">
                            <label for="">Reviews:</label> ${reviewAverage}
                        </div>
                        <div class="form-group">
                            <a class="btn btn-primary" href="/course/${course.id}/detail">Enroll</a>
                        </div>
                    </div>

                </div>
                <div class="card card-primary">
                    <div class="card-header">Course Objective</div>
                    <div class="card-body">
                        To do this this this. I don't know.
                    </div>
                </div>
                <!-- /row -->
                <hr>
                <div class="blog-comments">
                    <h3>Reviews</h3>
                    <c:forEach items="${course.reviewsById}" var="review">
                        <div class="media">
                            <div class="media-left">
                                <img src="data:image/jpg;base64,${review.userByUserId.base64Image}" alt="">
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">${review.userByUserId.name} <span class="info float-right">${review.star} star</span></h4>
                                <p>${review.content}</p>
                                <div class="date-reply"><span>${review.date}</span></div>
                            </div>
                        </div>

                    </c:forEach>

                    <div class="blog-reply-form">
                        <h3>Leave Review</h3>
                        <form action="/course/${course.id}/review" method="post">
                            <label for="rate">Rate:</label>
                            <input id="rate" type="number" min="1" max="5" name="star">
                            <textarea class="input" name="content" placeholder="Enter your Message" ></textarea>
                            <button class="main-button icon-button" type="submit">Submit</button>
                        </form>
                    </div>

                </div>

            </div>
            <!-- /main blog -->


            <jsp:include page="../sections/aside.jsp">
                <jsp:param name="categories" value="${categories}"/>
                <jsp:param name="blogs" value="${blogs}"/>
                <jsp:param name="tags" value="${tags}"/>
            </jsp:include>

        </div>
        <!-- row -->

    </div>
    <!-- container -->

</div>
<!-- /Blog -->

