<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="container-fluid">
        <form action="/instructor/course/edit/${course.id}" method="post" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-4">
                    <img src="data:image/jpg;base64,${course.base64Image}" class="img-fluid " width="300" alt="">
                    <label class="btn btn-primary" for="image">Change Cover Photo</label>
                    <input style="visibility: hidden;" id="image" type="file" name="image">
                </div>
                <div class="col-md-8">
                    <div class="card card-primary">
                        <div class="card-header">Course Info</div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" id="name" name="name" placeholder="Course Name" value="${course.name}">
                            </div>
                            <div class="form-group">
                                <label for="category">Category</label>
                                <select name="categoryId" id="category">
                                    <c:forEach items="${categories}" var="category">
                                        <option value="${category.id}" ${(course.categoryId==category.id)?'selected':''}>${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <input type="submit" value="Update Course Info"class="btn btn-primary">
        </form>
    </div>
    <hr>
    <div class="container-fluid">
        <div class="card card-primary">
            <div class="card-header">
                <h3>Course Details</h3>
            </div>
            <div class="card-body">
                <div class="content">
                    <ol class="list-group">
                        <c:forEach items="${chapters}" var="chapter">

                            <li class="list-group-item list-group-item-info">${chapter.title}<a href="/instructor/chapter/delete/${chapter.id}" class="btn btn-danger float-right">Delete</a> <a href="" class="btn btn-primary float-right">Edit</a></li>
                            <ol class="list-group">
                                <c:forEach items="${chapter.lessonsById}" var="lesson">
                                    <li style="padding-left:5em;" class="list-group-item list-group-item-light">${lesson.title}<a href="/instructor/lesson/delete/${lesson.id}" class="btn btn-danger float-right">Delete</a><a href="/instructor/lesson/edit/${lesson.id}" class="btn btn-info float-right">Edit</a><a href="/instructor/lesson/${lesson.id}" class="btn btn-primary float-right">View Lesson</a></li>
                                </c:forEach>
                                <li class="list-group-item list-group-item-light"><a class="btn btn-primary float-right" href="/instructor/lesson/chapter/${chapter.id}">Add Lessson</a></li>
                            </ol>

                        </c:forEach>

                    </ol>

                </div>
            </div>
            <div class="card-footer">
                <form action="/instructor/chapter/add" method="post">
                    <input type="number" name="serial" required width="100" min="0">
                    <input type="text" name="title" placeholder="Enter Chapter Name">
                    <input type="number" value="${course.id}" name="courseId" hidden>
                    <input type="submit" class="btn btn-primary" value="Add Chapter">
                </form>
            </div>
        </div>
    </div>
    <div class="container">
        <a class="btn btn-danger btn-block" href="/instructor/course/delete/${course.id}">Delete This Course</a>
    </div>
</div>