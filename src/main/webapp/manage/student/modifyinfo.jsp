<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="steve yu">
    <title>PSDS 研究生导师双选系统</title>
    <!-- Bootstrap core CSS -->
    <link href="/psds/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Favicons -->
    <link rel="apple-touch-icon" href="/psds/img/fav/favicon-128*128.ico" sizes="180x180">
    <link rel="icon" href="/psds/img/fav/favicon-32*32.ico" sizes="32x32" type="image/png">
    <link rel="icon" href="/psds/img/fav/favicon-16*16.ico" sizes="16x16" type="image/png">
    <link rel="icon" href="/psds/img/fav/favicon-48*48.ico">
    <meta name="theme-color" content="#563d7c">
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/psds/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/psds/fontawesome/css/all.min.css" />
    <link href="http://libs.baidu.com/fontawesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="/psds/css/common.css" rel="stylesheet" />
    <link rel="stylesheet" href="/psds/css/dashboard.css" />
  </head>
<body>
    <%@include file="../../navbar.jsp"%>
  <div class="container-fluid">
    <div class="row">
      <!-- 侧边栏 -->
      <div class="col-md-2 left-bar">
        <div class="mtem-2 plem-1">
          <p class="gray plem-1 left-bar-title">
            <i class="fa fa-align-justify prem-1"></i>功能列表
          </p>
        </div>
          <div class="mtem-1 option-menu rounded-pill">
              <p id="showTeachers" class="gray plem-3 option-text"><i class="fa fa-user"></i>导师选择</p>
          </div>
          <div class="mtem-1 option-menu rounded-pill">
              <p id="hasChooseTeachers" class="gray plem-3 option-text"><i class="fa fa-check-square-o prem-1"></i>志愿查看</p>
          </div>
          <div class="mtem-1 option-menu option-select rounded-pill">
              <p id="modifyInfo" class="white plem-3 option-text"><i class="fa fa-book prem-1"></i>个人信息修改</p>
          </div>
          <div class="mtem-1 option-menu rounded-pill">
              <p id="modifyPassword" class="gray plem-3 option-text"><i class="fa fa fa-asterisk prem-1"></i>密码修改</p>
          </div>
        <br />
        <hr />
      </div>
      <div class="col-md-10">
        <!-- 欢迎界面 -->
        <div class="ptem-2 plem-2 main-content dark-gray">
            <p class="right-title">欢迎 ${type} ${username} 登陆研究生导师双选平台</p>
        </div>
        <hr />
          <!-- 个人信息修改 -->
            <div class="text-center" style="padding-left: 5%; padding-right: 5%;">
              <form action="modifyInfoProcess" method="post" class="shadow-sm">
                  <div class=" " id="">
                      <div class="model-card-container">
                          <div>
                              <h2 class="dark-gray">个人信息修改</h2>
                          </div>
                          <hr />
                          <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                  <div class="input-group-text">
                                      学号
                                  </div>
                              </div>
                              <input type="text" disabled class="form-control" placeholder="student number" value="${user.stuNum}">
                          </div>
                          <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                  <div class="input-group-text">
                                      姓名
                                  </div>
                              </div>
                              <input type="text" disabled class="form-control" placeholder="name" value="${user.name}">
                          </div>
                          <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                  <div class="input-group-text">
                                      性别
                                  </div>
                              </div>
                              <input type="text" disabled class="form-control" placeholder="sex" value="${user.sex}">
                          </div>
                          <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                  <div class="input-group-text">
                                      邮箱
                                  </div>
                              </div>
                              <input id="email" type="text" name="email" class="form-control" placeholder="email" value="${user.email}">
                          </div>
                          <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                  <div class="input-group-text">
                                      专业
                                  </div>
                              </div>
                              <input id="major" readonly type="text" name="major" class="form-control" placeholder="major" value="${user.major}">
                          </div>
                          <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                  <div class="input-group-text">
                                      信息
                                  </div>
                              </div>
                              <textarea id="info" rows="5" name="info" class="form-control" placeholder="information">${user.info}</textarea>
                          </div>
                          <div class="mr-2">
                              <button type="submit" class="btn-pagenum dark-gray" style="border: 1px solid darkgray">修改</button>
                          </div>
                      </div>
                  </div>
              </form>
            </div>
      </div>
    </div>
  </div>
  <footer>
    <div style="height: 10em;"></div>
  </footer>
    <!-- 弹模态框 -->
    <!-- 批量导入模态框 -->
    <div class="model-card shadow" id="upload-model-card">
      <div class="model-card-container">
          <div>
              批量导入
          </div>
          <hr />
          <div>
              <img id="upload-img" class="upload-img" src="/psds/img/upload-pic.png" width="40%" />
          </div>
      </div>
      <form action="insertBatchTeachers" enctype="multipart/form-data" method="post">
        <input id="upload-img-inputfile" name="studentFile" type="file" style="display: none;" />
        <button id="upload-img-inputfile-btn" type="submit" class="hidden"></button>
      </form>
      <div class="hidden" id="msg">${message}</div>
      <% if(request.getSession().getAttribute("message") != null) request.getSession().removeAttribute("message");%>
  </div>

  <script src="/psds/js/jquery-3.5.0.min.js"></script>
  <script src="/psds/js/bootstrap.min.js"></script>
 <script>
    $('#showTeachers').click(()=>{
        window.location.href="showteachers";
    })

    $('#hasChooseTeachers').click(()=>{
        window.location.href="hasChooseTeachers";
    })

    $('#modifyInfo').click(()=>{
        window.location.href="modifyInfo";
    })


    $('#modifyPassword').click(()=>{
        window.location.href="modifyPassword";
    })

    $('.left-bar-title').click(()=>{
        window.location.href="#";
    })

    $('.change-pass-btn').click(()=>{
      window.location.href="#";
    })


    // 提示语的 alert
    if($('#msg').text() !== '') alert($('#msg').text())

    // 点旁边小时
    $(document).click(function(e) {
      var target = $(e.target)
      if(target.closest('#upload-model-card').length == 0 && target.closest('#xmlInput').length == 0) {
        $('#upload-model-card').fadeOut()
      }
    })

    // 点取消隐藏
    $('#hide-mofify-card').click((e)=> {
      $('#upload-model-card-modify').fadeOut()
    })

    $('#search').on('keypress', function (e) {
        if(e.keyCode == 13) {
            window.location.href = "searchTeacher?message="+$('#search').val()
        }
    })

    var menuCnt = 0
    $('.left-bar-title').click(function () {
        if($(window).width() < 800) {
            if(menuCnt % 2 == 0) $('.option-menu').slideToggle()
            else $('.option-menu').slideToggle()
            menuCnt++
        }
    })
  </script>
</body>
</html>