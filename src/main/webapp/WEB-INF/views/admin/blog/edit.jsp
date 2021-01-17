
<!-- Content Header (Page header) -->
<br>
<div class="container content">
    <button class="btn btn-primary"><a style="color:white;" href="/admin/blog/new">Add New Blog</a></button>
</div>
<br><br>

<section class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-6">
                <h1>General Form</h1>
            </div>
            <div class="col-sm-6">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item active">Edit Blog</li>
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
                        <h3 class="card-title"> Blog Details:</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- form start -->
                    <form role="form" action="/admin/blog/edit/${blog.id}" method="post" enctype="multipart/form-data">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="exampleInputEmail1">Title</label>
                                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter title" name="title" value="${blog.title}">
                            </div>
                            <div class="form-group">
                                <label for="image">Image</label> <br>
                                <img src="data:image/jpg;base64,${blog.base64Image}" alt="">
                                <input type="file" id="image" name="image">
                            </div>
                            <div class="form-group">
                                <label for="">Content</label>
                                <textarea class="form-control" rows="3" placeholder="Enter ..." name="content" >${blog.content}</textarea>
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