<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="steve yu">
    <title>PSDS 研究生导师双选系统</title>
    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Favicons -->
    <link rel="apple-touch-icon" href="./img/fav/favicon-128*128.ico" sizes="180x180">
    <link rel="icon" href="./img/fav/favicon-32*32.ico" sizes="32x32" type="image/png">
    <link rel="icon" href="./img/fav/favicon-16*16.ico" sizes="16x16" type="image/png">
    <link rel="icon" href="./img/fav/favicon-48*48.ico">
    <meta name="theme-color" content="#563d7c">
    <!-- Custom styles for this template -->
    <link href="./css/index.css" rel="stylesheet">
    <link href="./css/common.css" rel="stylesheet">
</head>
<body>
  <div class="d-flex flex-column flex-md-row align-items-center p-4 px-md-5 mb-1 bg-white">
    <div class="my-0 mr-md-auto font-weight-normal logo">
      <img src="./img/logo-design.png" width="400px"/>
    </div>
    <nav class="my-2 my-md-1 mr-md-3">
      <a class="p-2 nav-text" href="">导师信息</a>
      <a class="p-2 nav-text" href="">个人信息</a>
      <a class="p-2 nav-text" href="">学院概况</a>
      <a class="p-2 nav-text" href="">信息服务</a>
    </nav>
  </div>
<div class="px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center" id="title-bar">
  <h1 id="title">研究生导师双选系统</h1>
</div>
<div class="container" id="card-container">
  <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">学生</h4>
      </div>
      <div class="card-body">
        <a href="login?type=student">
          <img src="./img/student.png" width="99%" />
        </a>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">教师</h4>
      </div>
      <div class="card-body">
        <a href="login?type=teacher">
          <img src="./img/teacher.png" width="99%" />  
        </a>
      </div>
    </div>
    <div class="card mb-4 shadow-sm login-btn">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">管理员</h4>
      </div>
      <div class="card-body">
        <a href="login?type=admin">
          <img src="./img/admin.png" width="99%" />  
        </a>
      </div>
    </div>
  </div>
  <footer class="pt-4 my-md-3 pt-md-3 border-top">
    <div class="col-12 col-md">
      <small class="d-block text-muted text-center">© 2020 上海电力大学 steveyu</small>
    </div>
  </footer>
</div>
</body>
</html>
<script src="./js/jquery-3.5.0.min.js"></script>
