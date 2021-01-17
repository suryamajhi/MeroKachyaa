<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
                <h3 class="card-title">All Users</h3>

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
            <div class="card-body table-responsive p-0" style="height: 300px;">
                <table class="table table-head-fixed text-nowrap">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Address</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <c:choose>
                                <c:when test="${user.image!=null}">
                                   <td> <img src="data:image/jpg;base64,${user.base64Image}" class="img-size-50 img-circle mr-3" alt=""></td>
                                </c:when>
                                <c:otherwise>
                                    <td><img src="${pageContext.request.contextPath}/resources/admin/assets/dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3"></td>
                                </c:otherwise>
                            </c:choose>
                            
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <th>${user.address}</th>
                            
                            <th><a href="/admin/profile/${user.id}" class="btn btn-primary">View Profile</a></th>
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
<!-- /.row -->