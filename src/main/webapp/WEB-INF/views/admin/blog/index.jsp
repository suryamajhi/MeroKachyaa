<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- Main content -->
<section class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <div>
                    <button class="btn btn-primary"><a style="color:white;" href="/admin/blog/new">Add New Blog</a></button>
                </div>
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">All Blogs</h3>

                        <div class="card-tools">
                            <div class="input-group input-group-sm" style="width: 150px;">
                                <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

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
                                <th>Author</th>
                                <th>Image</th>
                                <th>Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${blogs}" var="blog">
                                <tr>
                                    <td>${blog.id}</td>
                                    <td>${blog.title}</td>
                                    <td>${blog.userByUserId.name}</td>
                                    <c:choose>
                                        <c:when test="${blog.base64Image!=null}">
                                            <td><img src="data:image/jpg;base64,${blog.base64Image}" alt="" width="75"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>No Cover Image</td>
                                        </c:otherwise>
                                    </c:choose>

                                    <td>${blog.date}</td>
                                    <td><a href="/blog/${blog.id}"><button class="btn btn-primary btn-sm">View blog</button></a></td>
                                    <td><a class="btn btn-primary btn-sm" href="/admin/blog/edit/${blog.id}">Edit</a></td>
                                    <td><a class="btn btn-danger btn-sm" href="/admin/blog/delete/${blog.id}">Delete</a></td>
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
