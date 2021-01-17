<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- Hero-area -->
<div class="hero-area section">

    <!-- Backgound Image -->
    <div class="bg-image bg-parallax overlay" style="background-image:url(${pageContext.request.contextPath}/resources/assets/user/assets/img/page-background.jpg)"></div>
    <!-- /Backgound Image -->

    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 text-center">
                <ul class="hero-area-tree">
                    <li><a href="/">Home</a></li>
                    <li>Detail</li>
                </ul>
                <h1 class="white-text">${course.name}</h1>

            </div>
        </div>
    </div>

</div>
<!-- /Hero-area -->
<!-- /.row -->
<div class="card card-primary card-outline">
    <div class="card-header">
        <h3 class="card-title">
            <i class="fas fa-edit"></i>
            Details:
        </h3>
    </div>


        <div class="card-body">
            <div class="row">
                <div class="col-5 col-sm-3">
                    <div class="nav flex-column nav-tabs h-100" id="vert-tabs-tab" role="tablist" aria-orientation="vertical">

                        <c:forEach items="${chapters}" var="chapter">
                            <h4>Chapter ${chapter.serial} : ${chapter.title}</h4>
                            <c:forEach items="${chapter.lessonsById}" var="lesson">
                                <a class="nav-link " id="vert-tabs-${chapter.id}-${lesson.id}-tab" data-toggle="pill" href="#vert-tabs-${chapter.id}-${lesson.id}" role="tab" aria-controls="vert-tabs-${chapter.id}-${lesson.id}" aria-selected="true">${lesson.serial} : ${lesson.title}</a>
                            </c:forEach>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-7 col-sm-9">
                    <div class="tab-content" id="vert-tabs-tabContent">

                        <c:forEach items="${chapters}" var="chapter">
                            <c:forEach items="${chapter.lessonsById}" var="lesson">
                                <div class="tab-pane text-left fade " id="vert-tabs-${chapter.id}-${lesson.id}" role="tabpanel" aria-labelledby="vert-tabs-${chapter.id}-${lesson.id}-tab">
                                        ${lesson.content}

                                            <hr>
                                    <div class="card card-primary">
                                        <div class="card-header">
                                            Discussion
                                        </div>
                                        <div class="card-body">
                                            <!-- blog comments -->
                                            <div class="blog-comments">
                                                <c:forEach items="${lesson.discussions}" var="discussion">
                                                    <!-- single comment -->
                                                    <div class="media">
                                                        <div class="media-left">
                                                            <img src="data:image/jpg;base64,${discussion.userByUserId.base64Image}" alt="">
                                                        </div>
                                                        <div class="media-body">
                                                            <h4 class="media-heading">${discussion.userByUserId.name}</h4>
                                                            <p>${discussion.content}</p>
                                                            <div class="date-reply"><span>${discussion.date}</span><a onclick="reply()" href="#" class="reply">Reply</a></div>
                                                            <!-- comment reply form -->

                                                        </div>
                                                        <div id="replyBlock" style="display: none;" class="blog-reply-form">
                                                            <h4>Leave Reply</h4>
                                                            <form action="/discussion/${discussion.id}/reply" method="post">
                                                                <textarea class="input" name="content" placeholder="Enter your Message" ></textarea>
                                                                <button class="main-button icon-button" type="submit">Submit</button>
                                                            </form>
                                                        </div>

                                                        <c:forEach items="${discussion.discussionReplyById}" var="reply">
                                                            <!-- comment reply -->
                                                            <div class="media">
                                                                <div class="media-left">
                                                                    <img src="data:image/jpg;base64,${reply.userByUserId.base64Image}" alt="">
                                                                </div>
                                                                <div class="media-body">
                                                                    <h4 class="media-heading">${reply.userByUserId.name}</h4>
                                                                    <p>${reply.content}</p>
                                                                    <div class="date-reply"><span>${reply.date}</span><a href="#" class="reply">Reply</a></div>
                                                                </div>
                                                            </div>
                                                            <!-- /comment reply -->
                                                        </c:forEach>

                                                    </div>
                                                    <!-- /single comment -->
                                                </c:forEach>



                                                <!-- blog reply form -->
                                                <div class="blog-reply-form">
                                                    <h3>Leave Question</h3>
                                                    <form action="/lesson/${lesson.id}/discussion" method="post">
                                                        <textarea class="input" name="content" placeholder="Enter your Message" ></textarea>
                                                        <button class="main-button icon-button" type="submit">Submit</button>
                                                    </form>
                                                </div>
                                                <!-- /blog reply form -->

                                            </div>
                                            <!-- /blog comments -->
                                        </div>
                                    </div>


                                </div>
                            </c:forEach>

                        </c:forEach>
                         </div>
                </div>
            </div>
        </div>
        <!-- /.card -->

</div>
<!-- /.card -->