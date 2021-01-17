<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <div class="content">
        <form role="form" class="form-control" action="/admin/category/edit/${category.id}" method="post" enctype="multipart/form-data">
                <div class="card card-primary">
                <div class="card-header">Edit Category</div>

                    <div class="card-body">
                        <div class="form-group">
                            <label for="category">Name</label>
                            <input id="category" type="text" name="name" value="${category.name}"><br>
                        </div>
                        <div class="form-group">
                            <label for="image">Image</label>
                            <img src="data:image/jpg;base64,${category.base64Image}" alt="" width="160"> <br>
                            <input id="image" type="file" name="image" value="${category.image}">
                        </div>
                    </div>
                    <div class="card-footer">
                        <input type="submit" value="Update">
                    </div>
            </div>
        </form>
    </div>
</div>