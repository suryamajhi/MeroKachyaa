<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="container-fluid">
        <form action="" method="post" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-4">
                    <label class="btn btn-primary" for="image">Choose Cover Photo</label>
                    <input style="visibility: hidden;" id="image" type="file" name="image">
                </div>
                <div class="col-md-8">
                    <div class="card card-primary">
                        <div class="card-header">Course Info</div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input type="text" id="name" name="name" placeholder="Course Name">
                            </div>
                            <div class="form-group">
                                <label for="category">Category</label>
                                <select name="categoryId" id="category">
                                    <c:forEach items="${categories}" var="category">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <input type="submit" value="Save Course">
        </form>
    </div>
</div>