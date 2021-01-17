<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="content">
    <div class="container-fluid">
        <div class="row">
        <div class="col-sm-4">
            <div class="card card-primary">
                <div class="card-header">Add Category</div>

                <form action="/admin/category/add" method="post" enctype="multipart/form-data">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input id="name" type="text" name="name">
                        </div>
                        <div class="form-group">
                            <label for="image">Choose Image</label>
                            <input id="image" type="file" name="image">
                        </div>
                    </div>
                    <div class="card-footer">
                        <input type="submit" value="Add Category">
                    </div>

                </form>
            </div>
        </div>
        <div class="col-sm-8">
            <h1 class="header-panel d-block primary">Cateogry List </h1>
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card-body table-responsive p-0">
                            <table class="table sticky-top table-bordered table-hover text-nowrap">
                                <thead>
                                    <tr>
                                        <td>Id</td>
                                        <td>Name</td>
                                        <td>Image</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${categories}" var="category">
                                        <tr>
                                            <td>${category.id}</td>
                                            <td>${category.name}</td>
                                            <c:choose>
                                                <c:when test="${category.base64Image!=null}">
                                                    <td><img src="data:image/jpg;base64,${category.base64Image}" alt="" width="75"></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>No Cover Image</td>
                                                </c:otherwise>
                                            </c:choose>

                                            <td><a class="btn btn-primary" href="/admin/category/edit/${category.id}">Edit</a></td>
                                            <td><a class="btn btn-danger" href="/admin/category/delete/${category.id}">Delete</a></td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        </div>
    </div>
</section>
