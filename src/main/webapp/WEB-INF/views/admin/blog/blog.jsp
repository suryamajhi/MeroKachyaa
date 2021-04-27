<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="container">
        <div class="header-panel"><h2>${blog.title}</h2></div>
        <hr>
        ${blog.date}
        <hr>
        <div style="padding:2em 1em 2em 0em">
            <img class="img-fluid" src="data:image/jpg;base64,${blog.base64Image}" alt="">
            <div class="bg-gray-light">${blog.content}</div>
        </div>
        <%--        Comments      --%>
        <div class="container">
            <h3>Comments</h3>
            <c:forEach items="${blog.commentsById}" var="comment">
                <div class="media mb-4">
                    <div class="circular--landscape">
                        <img src="data:image/jpg;base64,${comment.userByUserId.base64Image}" alt="">
                    </div>
                    <div class="media-body">
                        <h4 style="vertical-align: middle;padding-top:10px;"
                            class="comment--structure mt-0">${comment.userByUserId.name}</h4><span
                            class="float-right"><a class="btn btn-danger"
                                                   href="/admin/blog/${blog.id}/comment/delete/${comment.id}">Delete</a></span>
                        <div>${comment.content}</div>
                        <c:forEach items="${comment.commentReplyById}" var="commentReply">
                            <div class="media mt-4">
                                <div class="circular--landscape">
                                    <img src="data:image/jpg;base64,${commentReply.userByUserId.base64Image}" alt="">
                                </div>
                                <div class="media-body">
                                    <h4 style="vertical-align: middle;padding-top:10px;"
                                        class=" comment--structure mt-0">
                                        <div>${commentReply.userByUserId.name}</div>
                                    </h4>
                                    <span class="float-right"><a class="btn btn-danger"
                                                                 href="/admin/blog/${blog.id}/commentReply/delete/${commentReply.id}">Delete</a></span>
                                    <div>${commentReply.content}</div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </c:forEach>


        </div>


    </div>
</div>