<%@page language="java" contentType="text/html; ISO-8859-1" isELIgnored="false" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="d-flex flex-column" id="content-wrapper">
    <div id="content">

        <div class="container-fluid">
            <h3 class="text-dark mb-4">Profile</h3>
            <form action="/admin/user/edit/${user.id}" method="post" enctype="multipart/form-data">
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
                                <h4 class="small font-weight-bold">Server migration<span class="float-right">20%</span></h4>
                                <div class="progress progress-sm mb-3">
                                    <div class="progress-bar bg-danger" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%;"><span class="sr-only">20%</span></div>
                                </div>
                                <h4 class="small font-weight-bold">Sales tracking<span class="float-right">40%</span></h4>
                                <div class="progress progress-sm mb-3">
                                    <div class="progress-bar bg-warning" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;"><span class="sr-only">40%</span></div>
                                </div>
                                <h4 class="small font-weight-bold">Customer Database<span class="float-right">60%</span></h4>
                                <div class="progress progress-sm mb-3">
                                    <div class="progress-bar bg-primary" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"><span class="sr-only">60%</span></div>
                                </div>
                                <h4 class="small font-weight-bold">Payout Details<span class="float-right">80%</span></h4>
                                <div class="progress progress-sm mb-3">
                                    <div class="progress-bar bg-info" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;"><span class="sr-only">80%</span></div>
                                </div>
                                <h4 class="small font-weight-bold">Account setup<span class="float-right">Complete!</span></h4>
                                <div class="progress progress-sm mb-3">
                                    <div class="progress-bar bg-success" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"><span class="sr-only">100%</span></div>
                                </div>
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
            <div>
                <a href="/admin/user/delete/${user.id}" class="btn btn-block btn-danger"> Delete This User</a>
            </div>
        </div>
    </div>
</div>
