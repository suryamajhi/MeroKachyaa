<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- Main content -->
<section class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <div class="container">
                    <form action="/admin/lesson/new" method="post">
                        <select name="course_id" id="" required>
                            <option value="">Choose Course</option>
                            <c:forEach items="${courses}" var="course">
                                <option value="${course.id}">${course.name}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Add New Lesson" class="btn btn-primary">
                    </form>

                </div>
                <br>
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">All Lesson</h3>

                        <div class="card-tools">
                            <div class="input-group input-group-sm" style="width: 150px;">
                                <input type="text" name="table_search" class="form-control float-right"
                                       placeholder="Search">

                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body table-responsive p-0">
                        <table class="table table-hover text-nowrap">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Course</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${lessons}" var="lesson">
                                <tr>
                                    <td>${lesson.id}</td>
                                    <td>${lesson.title}</td>
                                    <td>${lesson.chapterByChapterId.courseByCourseId.name}</td>
                                    <td><a href="/admin/lesson/${lesson.id}">
                                        <button class="btn btn-primary">View lesson</button>
                                    </a></td>
                                    <td><a class="btn btn-primary" href="/admin/lesson/edit/${lesson.id}">Edit</a></td>
                                    <td><a class="btn btn-danger" href="/admin/lesson/delete/${lesson.id}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->
            </div>
        </div>


    </div><!-- /.container-fluid -->
</section>
