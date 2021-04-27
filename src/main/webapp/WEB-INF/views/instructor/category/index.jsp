<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="content">
    <div class="container-fluid">
        <div class="row">
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
                                                    <td><img src="data:image/jpg;base64,${category.base64Image}" alt=""
                                                             width="75"></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>No Cover Image</td>
                                                </c:otherwise>
                                            </c:choose>

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
