<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container col-12">
    <h3>Course Name: ${courseName}</h3>
</div>

<!-- Content Header (Page header) -->
<section class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6">
                <h1>General Form</h1>
            </div>
            <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item active">Add New Lesson</li>
                </ol>
            </div>
        </div>
    </div><!-- /.container-fluid -->
</section>

<!-- Main content -->
<section class="content">
    <div class="container-fluid">
        <div class="row">
            <!-- left column -->
            <div class="col-md-12">
                <!-- general form elements -->
                <div class="card card-primary">
                    <div class="card-header">
                        <h3 class="card-title">Lesson Detail</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- form start -->
                    <form role="form" action="/admin/lesson/add" method="post">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="chapter">Chapter</label>
                                <c:choose>
                                    <c:when test="${chapter!=null}">
                                        <select name="chapterId" id="chapter" required>
                                            <option value="${chapter.id}">${chapter.title}</option>
                                        </select>
                                    </c:when>
                                    <c:otherwise>
                                        <select name="chapterId" id="chapter" required>
                                            <option value="">Select Chapter</option>
                                            <c:forEach items="${chapters}" var="chapter">
                                                <option value="${chapter.id}">${chapter.title}</option>
                                            </c:forEach>

                                        </select>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                            <div class="form-group">
                                <input type="number" name="serial">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Title</label>
                                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter title" name="title">
                            </div>
                            <div class="form-group">
                                <label for="">Content</label>
                                <textarea class="form-control" rows="5" placeholder="Enter ..." name="content"></textarea>
                            </div>

                        </div>
                        <!-- /.card-body -->

                        <div class="card-footer">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form>
                </div>
                <!-- /.card -->
            </div>
            <!--/.col (left) -->

        </div>
        <!-- /.row -->
    </div><!-- /.container-fluid -->
</section>
<!-- /.content -->