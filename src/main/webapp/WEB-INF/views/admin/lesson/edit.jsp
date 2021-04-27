<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br>

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
                    <li class="breadcrumb-item active">Edit Lesson</li>
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
                    <form role="form" action="/admin/lesson/edit" method="post">
                        <div class="card-body">
                            <div class="form-group">
                                <input type="number" value="${lesson.id}" name="id" hidden>
                                <label for="chapter">Chapter</label>
                                <select name="chapterId" id="chapter">
                                    <option value="${chapter.id}">${chapter.title}</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input type="number" name="serial" value="${lesson.serial}">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Title</label>
                                <input type="text" class="form-control" id="exampleInputEmail1"
                                       placeholder="Enter title" name="title" value="${lesson.title}">
                            </div>
                            <div class="form-group">
                                <label for="">Content</label>
                                <textarea class="form-control" rows="5" placeholder="Enter ..."
                                          name="content">${lesson.content}</textarea>
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