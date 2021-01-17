<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Hero-area -->
<div class="hero-area section">

    <!-- Backgound Image -->
    <div class="bg-image bg-parallax overlay" style="background-image:url(.${pageContext.request.contextPath}/resources/assets/user/assets/img/page-background.jpg)"></div>
    <!-- /Backgound Image -->

    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 text-center">
                <ul class="hero-area-tree">
                    <li><a href="/">Home</a></li>
                    <li>Profile</li>
                </ul>
                <h1 class="white-text">${user.name}</h1>

            </div>
        </div>
    </div>

</div>
<!-- /Hero-area -->


<div class="d-flex flex-column" id="content-wrapper">
    <div id="content">
        <br>
        <div class="container-fluid">
            <form action="/profile/edit" method="post" enctype="multipart/form-data">
                <div class="row mb-3">
                    <div class="col-lg-4">
                        <div class="card mb-3">
                            <div class="card-body text-center shadow">
                                <c:choose>
                                    <c:when test="${user.image!=null}">
                                        <img class="rounded-circle mb-3 mt-4" src="data:image/jpg;base64,${user.base64Image}" width="160" height="160">
                                    </c:when>
                                    <c:otherwise>
                                        <img class="rounded-circle mb-3 mt-4" src="${pageContext.request.contextPath}/resources/admin/assets/dist/img/user3-128x128.jpg" width="160" height="160">
                                    </c:otherwise>
                                </c:choose>

                                <div class="mb-3">
                                    <label class="btn btn-primary" for="image">Change Photo</label>
                                    <input hidden id="image" class="form-control-file btn btn-primary btn-sm" type="file" name="image">
                                </div>
                            </div>
                        </div>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="text-primary font-weight-bold m-0">Course Enrolled</h6>
                            </div>
                            <div class="card-body">

                                <c:forEach items="${user.courses}" var="course">
                                    <h4 class="small font-weight-bold">${course.name}<span class="float-right">40%</span></h4>
                                    <div class="progress progress-sm mb-3">
                                        <div class="progress-bar bg-danger" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%;"><span class="sr-only">20%</span></div>
                                    </div>

                                </c:forEach>


                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="row mb-3 d-none">
                            <div class="col">
                                <div class="card text-white bg-primary shadow">
                                    <div class="card-body">
                                        <div class="row mb-2">
                                            <div class="col">
                                                <p class="m-0">Peformance</p>
                                                <p class="m-0"><strong>65.2%</strong></p>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
                                        </div>
                                        <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card text-white bg-success shadow">
                                    <div class="card-body">
                                        <div class="row mb-2">
                                            <div class="col">
                                                <p class="m-0">Peformance</p>
                                                <p class="m-0"><strong>65.2%</strong></p>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
                                        </div>
                                        <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div class="card shadow mb-3">
                                    <div class="card-header py-3">
                                        <p class="text-primary m-0 font-weight-bold">User Settings</p>
                                    </div>
                                    <div class="card-body">

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group"><label for="name"><strong>Name</strong></label>
                                                    <input id="name" class="form-control" type="text" value="${user.name}" name="name"></div>
                                            </div>
                                        </div>
                                        <div class="form-row">

                                            <div class="col">
                                                <div class="form-group"><label for="email"><strong>Email Address</strong></label><input id="email" class="form-control" type="email" value="${user.email}" name="email"></div>
                                            </div>

                                        </div>
                                        <div class="form-group"><label for="address"><strong>Address</strong></label><input id="address" class="form-control" type="text" value="${user.address}" name="address"></div>
                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group"><label for="school"><strong>School</strong></label><input id="school" class="form-control" type="text" value="${user.school}" name="school"></div>
                                            </div>
                                        </div>
                                        <div class="form-group"><input class="btn btn-primary" type="submit" value="Save Setting"></div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="card shadow mb-5">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Forum Settings</p>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6">
                                <form>
                                    <div class="form-group"><label for="signature"><strong>Signature</strong><br></label><textarea id="signature" class="form-control" rows="4" name="signature">${user.signature}</textarea></div>
                                    <div class="form-group"><input class="btn btn-primary" type="submit" value="Save Setting"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
