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
                    <li>Courses</li>
                </ul>
                <h1 class="white-text">All Courses</h1>

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
                    <c:forEach items="${courses}" var="course">
                        <!-- single blog -->
                        <div class="col-md-4">
                            <div class="single-blog">
                                <div class="blog-img">
                                    <a href="/course/${course.id}">
                                        <img src="data:image/jpg;base64,${course.base64Image}" alt="">
                                    </a>
                                </div>
                                <h4><a href="/course/${course.id}">${course.name}</a></h4>
                                <div class="blog-meta">
                                    <span class="blog-meta-author">By: <a
                                            href="#">${course.userByUserId.name}</a></span>
                                    <div class="pull-right">
                                        <span class="blog-meta-comments"><a href="#"><i class="fa fa-comments"></i> 35 students</a></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /single blog -->

                    </c:forEach>


                </div>
                <!-- /row -->

                <!-- row -->
                <div class="row">

                    <!-- pagination -->
                    <div class="col-md-12">
                        <div class="post-pagination">
                            <a href="#" class="pagination-back pull-left">Back</a>
                            <ul class="pages">
                                <li class="active">1</li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                            </ul>
                            <a href="#" class="pagination-next pull-right">Next</a>
                        </div>
                    </div>
                    <!-- pagination -->

                </div>
                <!-- /row -->
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

