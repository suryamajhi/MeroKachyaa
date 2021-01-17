<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- aside blog -->
<div id="aside" class="col-md-3">

    <!-- search widget -->
    <div class="widget search-widget">
        <form>
            <input class="input" type="text" name="search">
            <button><i class="fa fa-search"></i></button>
        </form>
    </div>
    <!-- /search widget -->

    <!-- category widget -->
    <div class="widget category-widget">
        <h3>Categories</h3>
        <c:forEach items="${categories}" var="category">
            <a class="category" href="/category/${category.id}">${category.name} <span>10</span></a>
        </c:forEach>
    </div>
    <!-- /category widget -->

    <!-- posts widget -->
    <div class="widget posts-widget">
        <h3>Recents Posts</h3>

        <c:forEach items="${blogs}" var="blog">
            <!-- single posts -->
            <div class="single-post">
                <a class="single-post-img" href="/blog/${blog.id}">
                    <img src="data:image/jpg;base64,${blog.base64Image}" alt="">
                </a>
                <a href="/blog/${blog.id}">${blog.title}</a>
                <p><small>By : ${blog.userByUserId.name} ${blog.date}</small></p>
            </div>
            <!-- /single posts -->
        </c:forEach>
    </div>
    <!-- /posts widget -->

    <!-- tags widget -->
    <div class="widget tags-widget">
        <h3>Tags</h3>
        <c:forEach items="${tags}" var="tag">
            <a class="tag" href="#">Web</a>
        </c:forEach>

    </div>
    <!-- /tags widget -->

</div>
<!-- /aside blog -->