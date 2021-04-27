<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- Hero-area -->
<div class="hero-area section">

    <!-- Backgound Image -->
    <div class="bg-image bg-parallax overlay"
         style="background-image:url(.${pageContext.request.contextPath}/resources/assets/user/assets/img/blog-post-background.jpg)"></div>
    <!-- /Backgound Image -->

    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 text-center">
                <ul class="hero-area-tree">
                    <li><a href="/">Home</a></li>
                    <li><a href="/blogs">Blog</a></li>
                    <li>${blog.title}</li>
                </ul>
                <h1 class="white-text">${blog.title}</h1>
                <ul class="blog-post-meta">
                    <li class="blog-meta-author">By : <a href="#">${blog.userByUserId.name}</a></li>
                    <li>${blog.date}</li>
                    <li class="blog-meta-comments"><a href="#"><i class="fa fa-comments"></i> 35</a></li>
                </ul>
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
                <img class="blog-img img-fluid" src="data:image/jpg;base64,${blog.base64Image}" alt="">
                <!-- blog post -->
                <hr>
                <div class="blog-post">
                    ${blog.content}
                </div>
                <!-- /blog post -->

                <!-- blog share -->
                <div class="blog-share">
                    <h4>Share This Post:</h4>
                    <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
                    <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
                    <a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a>
                </div>
                <!-- /blog share -->

                <!-- blog comments -->
                <div class="blog-comments">
                    <h3>Comments</h3>
                    <c:forEach items="${blog.commentsById}" var="comment">
                        <!-- single comment -->
                        <div class="media">
                            <div class="media-left">
                                <img src="data:image/jpg;base64,${comment.userByUserId.base64Image}" alt="">
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">${comment.userByUserId.name}</h4>
                                <p>${comment.content}</p>
                                <div class="date-reply"><span>${comment.date}</span><a onclick="reply()" href="#"
                                                                                       class="reply">Reply</a></div>
                                <!-- comment reply form -->

                            </div>
                            <div id="replyBlock" style="display:none;" class="blog-reply-form">
                                <h4>Leave Reply</h4>
                                <form action="/comment/${comment.id}/reply" method="post">
                                    <textarea class="input" name="content" placeholder="Enter your Message"></textarea>
                                    <button class="main-button icon-button" type="submit">Submit</button>
                                </form>
                            </div>

                            <c:forEach items="${comment.commentReplyById}" var="reply">
                                <!-- comment reply -->
                                <div class="media">
                                    <div class="media-left">
                                        <img src="data:image/jpg;base64,${reply.userByUserId.base64Image}" alt="">
                                    </div>
                                    <div class="media-body">
                                        <h4 class="media-heading">${reply.userByUserId.name}</h4>
                                        <p>${reply.content}</p>
                                        <div class="date-reply"><span>${reply.date}</span><a href="#" class="reply">Reply</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /comment reply -->
                            </c:forEach>

                        </div>
                        <!-- /single comment -->
                    </c:forEach>


                    <!-- blog reply form -->
                    <div class="blog-reply-form">
                        <h3>Leave Comment</h3>
                        <form action="/blog/${blog.id}/comment" method="post">
                            <textarea class="input" name="content" placeholder="Enter your Message"></textarea>
                            <button class="main-button icon-button" type="submit">Submit</button>
                        </form>
                    </div>
                    <!-- /blog reply form -->

                </div>
                <!-- /blog comments -->
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
