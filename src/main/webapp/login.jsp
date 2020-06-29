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
    <link href="./css/index.css" rel="stylesheet" />
    <link href="./css/login.css" rel="stylesheet" />
    <link href="./css/common.css" rel="stylesheet" />
    <link href="http://libs.baidu.com/fontawesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
  <div class="d-flex flex-column flex-md-row align-items-center p-4 px-md-5 mb-1 bg-white shadow">
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
  <form action="loginProcess" method="post">
      <div id="frame-container" class="bg-white shadow row">
          <% if(request.getAttribute("type") != null) {%>
          <div class="col-md-6 bg-shadow full-height text-center">
              <img src="./img/<%=request.getAttribute("type")%>.png" width="40%" class="inline vertical-center ptem-5"/>
              <br /><br />
              <h4 class="gray"><%=request.getAttribute("name")%>登录</h4>
          </div>
          <% } else {%>
          <div class="col-md-6 bg-shadow full-height text-center">
              <img src="./img/student.png" width="40%" class="inline vertical-center ptem-5"/>
              <br /><br />
              <h4 class="gray">学生登录</h4>
          </div>
          <% } %>
          <div class="col-md-6 full-height ptem-5 bg-white shadow">
              <div class="input-group mb-2">
                  <div class="input-group-prepend">
                      <div class="input-group-text">
                          &nbsp;<i class="fa fa-user"></i>&nbsp;
                      </div>
                  </div>
                  <input type="text" name="loginName" class="form-control" placeholder="Username" value="${loginName}">
              </div>
              <label class="wrong-msg">&nbsp;</label>
              <div class="input-group mb-2">
                  <div class="input-group-prepend">
                      <div class="input-group-text">
                          &nbsp;<i class="fa fa-lock"></i>&nbsp;
                      </div>
                  </div>
                  <input type="password" name="password" class="form-control" placeholder="Password" value="${password}">
              </div>
              <div>
                  <label id="wrong-msg" class="wrong-msg">&nbsp;</label>
              </div>
              <div>
                  <input type="checkbox" name="remember" checked /> <div class="inline gray font-sm">记住密码</div>
                  <div class="inline gray font-sm float-right">忘记密码</div><br />
              </div>
              <br />
              <div class="container text-center btn-container">
                  <button type="submit" class="btn btn-default btn-sm border-gray-1 gray hover-dark-gray">&nbsp;&nbsp;&nbsp;登录&nbsp;&nbsp;&nbsp;</button>
              </div>
          </div>
      </div>
  </form>
  <div id="wrongMsg" class="hidden"><%=request.getAttribute("wrongMsg")%></div>
  <script>
      if(document.getElementById("wrongMsg").innerHTML !== 'null') document.getElementById("wrong-msg").innerHTML = document.getElementById("wrongMsg").innerHTML
  </script>
</body>
</html>