<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="container">
        <div class="content">
            <div class="row">
                <div class="col-md-4">
                    <img src="data:image/jpg;base64,${course.base64Image}" class="img-fluid " width="300" alt="">

                </div>
                <div class="col-md-8">
                    <div class="card card-primary">
                        <div class="card-header">Course Info</div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" id="name" name="name" placeholder="Course Name"
                                       value="${course.name}" disabled>
                            </div>
                            <div class="form-group">
                                <label for="category">Category :</label>
                                ${course.categoryByCategoryId.name}
                            </div>
                            <div class="form-group">
                                <label for="">Instructor : </label>
                                ${course.userByUserId.name}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="card card-primary">
                <div class="card-header">
                    <h3>Course Review</h3>
                </div>
                <!-- Single Comment -->
                <c:forEach items="${course.reviewsById}" var="review">
                    <div class="media mb-4">
                        <div class="circular--landscape">
                            <img class="d-flex mr-3" src="data:image/jpg;base64,${review.userByUserId.base64Image}"
                                 alt="">
                        </div>
                        <div class="media-body">
                            <h5 class="comment--structure mt-0">${review.userByUserId.name} <span
                                    style="padding-left: 2em" class="">( ${review.star} star)</span></h5><a
                                class="btn btn-danger float-right"
                                href="/admin/course/${course.id}/review/delete/${review.id}">Delete</a>
                            <div>
                                    ${review.content}
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>
</div>