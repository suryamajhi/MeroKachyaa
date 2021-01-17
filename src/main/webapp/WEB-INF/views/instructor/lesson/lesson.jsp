<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="container-fluid">
        <div class="header-panel"><h2>${lesson.title}</h2></div>
        <div style="padding:2em 1em 2em 0em" class="bg-gray-light">${lesson.content}</div>

<%--        Discussion --%>
        <div class="container">
        <h3>Discussion</h3>
        <c:forEach items="${lesson.discussions}" var="discussion">
            <div class="media mb-4">
                <div class="circular--landscape">
                    <img  class="d-flex mr-3 " src="data:image/jpg;base64,${discussion.userByUserId.base64Image}" alt="">
                </div>
                <div class="media-body">
                    <h5 class="comment--structure mt-0">${discussion.userByUserId.name}</h5>
                    ${discussion.content}

                    <c:forEach items="${discussion.discussionReplyById}" var="reply">
                        <div class="media mt-4">
                            <div class="circular--landscape">
                                <img class="d-flex mr-3" src="data:image/jpg;base64,${reply.userByUserId.base64Image}" alt="">
                            </div>
                            <div class="media-body">
                                <h5 class="comment--structure mt-0">${reply.userByUserId.name}</h5>

                                ${reply.content}
                            </div>
                        </div>
                        <hr>
                    </c:forEach>


                </div>
            </div>
        </c:forEach>

        </div>

    </div>
</div>