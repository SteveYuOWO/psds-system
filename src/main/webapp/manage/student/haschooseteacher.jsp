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
    <link href="../../css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Favicons -->
    <link rel="apple-touch-icon" href="../../img/fav/favicon-128*128.ico" sizes="180x180">
    <link rel="icon" href="../../img/fav/favicon-32*32.ico" sizes="32x32" type="image/png">
    <link rel="icon" href="../../img/fav/favicon-16*16.ico" sizes="16x16" type="image/png">
    <link rel="icon" href="../../img/fav/favicon-48*48.ico">
    <meta name="theme-color" content="#563d7c">
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../fontawesome/css/all.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="../../css/index.css" rel="stylesheet" />
    <link href="../../css/common.css" rel="stylesheet" />
    <link rel="stylesheet" href="../../css/dashboard.css" />
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
          <div class="mtem-1 option-menu rounded-pill option-select">
              <p id="hasChooseTeachers" class="white plem-3 option-text"><i class="fa fa-check-square-o prem-1"></i>志愿查看</p>
          </div>
          <div class="mtem-1 option-menu rounded-pill">
              <p id="modifyInfo" class="gray plem-3 option-text"><i class="fa fa-book prem-1"></i>个人信息修改</p>
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
          <!-- 已选导师 -->
          <div class="mtem-2">
              <div class="minbox text-center plem-1 prem-1"><i class="fa fa-file-text-o prem-1"></i>已选导师</div>
              <table class="table text-center">
                  <thead>
                  <tr>
                      <th>教工号</th>
                      <th>姓名</th>
                      <th>性别</th>
                      <th>邮箱</th>
                      <th>专业</th>
                      <th>个人简介</th>
                      <th>移除导师</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach  var="element" items="${ notChooseTeachers }">
                  <tr>
                      <td class="hidden">${element.id}</td>
                      <td>${element.teaNum}</td>
                      <td>${element.name}</td>
                      <td>${element.sex}</td>
                      <td>${element.email}</td>
                      <td>${element.major}</td>
                      <td>${element.info}</td>
                      <td>
                          <a href="deleteChooseTeacher?id=${element.id}"  onclick="return confirm('确定删除该志愿?')"><img width="23px" src="../../img/minus.png" /></a>
                          </c:forEach>
                  </tbody>
              </table>
          </div>

          <!-- 已被选择 -->
          <br/>
          <br/>
          <div class="mtem-2">
              <div class="minbox text-center plem-1 prem-1"><i class="fa fa-file-text-o prem-1"></i>已被选择</div>
              <table class="table text-center">
                  <thead>
                  <tr>
                      <th>教工号</th>
                      <th>姓名</th>
                      <th>性别</th>
                      <th>邮箱</th>
                      <th>专业</th>
                      <th>个人简介</th>
                      <th>&nbsp;</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach  var="element" items="${ hasConfirmedTeachers }">
                  <tr>
                      <td class="hidden">${element.id}</td>
                      <td>${element.teaNum}</td>
                      <td>${element.name}</td>
                      <td>${element.sex}</td>
                      <td>${element.email}</td>
                      <td>${element.major}</td>
                      <td>${element.info}</td>
                      <td>&nbsp;</td>
                  </c:forEach>
                  </tbody>
              </table>
          </div>


          <!-- 最终志愿 -->
          <br/>
          <br/>
          <div class="mtem-2">
              <div class="minbox text-center plem-1 prem-1"><i class="fa fa-file-text-o prem-1"></i>最终志愿</div>
              <table class="table text-center">
                  <thead>
                  <tr>
                      <th>教工号</th>
                      <th>姓名</th>
                      <th>性别</th>
                      <th>邮箱</th>
                      <th>专业</th>
                      <th>个人简介</th>
                      <th>&nbsp;</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach  var="element" items="${ finalConfirmed }">
                  <tr>
                      <td class="hidden">${element.id}</td>
                      <td>${element.teaNum}</td>
                      <td>${element.name}</td>
                      <td>${element.sex}</td>
                      <td>${element.email}</td>
                      <td>${element.major}</td>
                      <td>${element.info}</td>
                      <td>&nbsp;</td>
                      </c:forEach>
                  </tbody>
              </table>
          </div>

          <!-- 确立专业 -->
          <div class="mtem-2 hidden">
              <div class="minbox text-center plem-1 prem-1"><i class="fa fa-file-text-o prem-1"></i>最终导师</div>
              <table class="table text-center">
                  <thead>
                  <tr>
                      <th>教工号</th>
                      <th>姓名</th>
                      <th>性别</th>
                      <th>邮箱</th>
                      <th>专业</th>
                      <th>个人简介</th>
                      <th>&nbsp;</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach  var="element" items="${ teachers }">
                  <tr>
                      <td class="hidden">${element.id}</td>
                      <td>${element.teaNum}</td>
                      <td>${element.name}</td>
                      <td>${element.sex}</td>
                      <td>${element.email}</td>
                      <td>${element.major}</td>
                      <td>${element.info}</td>
                      <td>&nbsp;</td>
                      </c:forEach>
                  </tbody>
              </table>
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
              <img id="upload-img" class="upload-img" src="../../img/upload-pic.png" width="40%" />
          </div>
      </div>
      <form action="insertBatchTeachers" enctype="multipart/form-data" method="post">
        <input id="upload-img-inputfile" name="studentFile" type="file" style="display: none;" />
        <button id="upload-img-inputfile-btn" type="submit" class="hidden"></button>
      </form>
      <div class="hidden" id="msg">${message}</div>
      <% if(request.getSession().getAttribute("message") != null) request.getSession().removeAttribute("message");%>
  </div>

  <!-- 修改信息模态框 -->
  <form action="modifyTeacher" method="post">
    <div class="model-card-modify shadow" id="upload-model-card-modify">
      <div class="model-card-container">
          <input type="hidden" id="stuid" name="id" />
          <div>
              修改信息
          </div>
          <hr />
          <div class="input-group mb-2">
              <div class="input-group-prepend">
                  <div class="input-group-text">
                      工号
                  </div>
              </div>
              <input id="stuNum" type="text" name="teaNum" class="form-control" placeholder="teacher number">
          </div>
          <div class="input-group mb-2">
              <div class="input-group-prepend">
                  <div class="input-group-text">
                      姓名
                  </div>
              </div>
              <input id="name" type="text" name="name" class="form-control" placeholder="name" value="">
          </div>
          <div class="mtem-1 mbem-1 row">
              <div class="col-md-6"><input id="male" type="radio" name="sex" value="1"/> 男</div>
              <div class="col-md-6"><input id="female" type="radio" name="sex" value="0" /> 女</div>
          </div>
          <div class="input-group mb-2">
              <div class="input-group-prepend">
                  <div class="input-group-text">
                      邮箱
                  </div>
              </div>
              <input id="email" type="text" name="email" class="form-control" placeholder="email" value="">
          </div>
          <div class="input-group mb-2">
              <div class="input-group-prepend">
                  <div class="input-group-text">
                      专业
                  </div>
              </div>
              <input id="major" type="text" name="major" class="form-control" placeholder="major" value="">
          </div>
          <div class="input-group mb-2">
              <div class="input-group-prepend">
                  <div class="input-group-text">
                      信息
                  </div>
              </div>
              <textarea id="info" name="info" class="form-control" placeholder="information"></textarea>
          </div>
          <div class="row ptem-1">
            <div class="col-md-6"><button type="submit">修改</button></div>
            <div class="col-md-6" id="hide-mofify-card"><button type="button">取消</button></div>
          </div>
      </div>
    </div>
  </form>
  <script src="../../js/jquery-3.5.0.min.js"></script>
  <script src="../../js/bootstrap.min.js"></script>
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

  </script>
</body>
</html>