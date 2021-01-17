<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<br>
<div class="content">
    <div class="container-fluid">
        <a style="color:white;" href="/admin/course/new" class="btn btn-primary">Add New Course</a>
    </div>
</div>
<br>
<div class="card">
    <div class="card-header">
        <h3 class="card-title">All Courses</h3>
    </div>
    <!-- /.card-header -->
    <div class="card-body">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th style="width: 10px">#</th>
                <th>Name</th>
                <th>Instructor</th>
                <th>Image</th>
                <th>Date</th>
                <th>Category</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${courses}" var="course">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.userByUserId.name}</td>
                    <c:choose>
                        <c:when test="${course.image!=null}">
                            <td><img src="data:image/jpg;base64,${course.base64Image}" width="130" alt=""></td>
                        </c:when>
                        <c:otherwise>
                            <td>No Cover Photo</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${course.date}</td>
                    <td>${course.categoryByCategoryId.name}</td>
                    <td><a href="/admin/course/${course.id}/review" class="btn btn-info">View Review</a></td>
                    <td><a href="/admin/course/edit/${course.id}" class="btn btn-primary">Edit</a></td>
                    <td><a href="/admin/course/delete/${course.id}" class="btn btn-danger">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- /.card-body -->
    <div class="card-footer clearfix">
        <ul class="pagination pagination-sm m-0 float-right">
            <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
        </ul>
    </div>
</div>
<!-- /.card -->