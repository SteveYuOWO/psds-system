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
    <link href="../../css/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/psds/css/common.css" rel="stylesheet" />
    <link href="/psds/css/dashboard.css" rel="stylesheet" />
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
              <p id="showStudents" class="gray plem-3 option-text"><i class="fa fa-users prem-1"></i>学生管理</p>
          </div>
          <div class="mtem-1 option-menu rounded-pill">
              <p id="showTeachers" class="gray plem-3 option-text"><i class="fa fa-user"></i>教师管理</p>
          </div>
          <% if(request.getSession().getAttribute("type").equals("超级管理员")) { %>
          <div class="mtem-1 option-menu rounded-pill">
              <p id="showAdmins" class="gray plem-3 option-text"><i class="fa fa-expeditedssl prem-1"></i>学院管理员管理</p>
          </div>
          <% } %>
          <div class="mtem-1 option-menu option-select rounded-pill">
              <p id="showMajors" class="white plem-3 option-text"><i class="fa fa-book prem-1"></i>专业管理</p>
          </div>
          <div class="mtem-1 option-menu rounded-pill">
              <p id="chooseManage" class="gray plem-3 option-text"><i class="fa fa-building-o prem-1"></i>志愿管理</p>
          </div>
          <div class="mtem-1 option-menu rounded-pill">
              <p id="showLogs" class="gray plem-3 option-text"><i class="fa fa-files-o prem-1"></i>登录日志</p>
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
        <!-- 表格 -->
        <div class="mtem-2">
          <div class="minbox text-center plem-1 prem-1"><i class="fa fa-file-text-o prem-1"></i>专业信息</div>
          <table class="table text-center">
            <thead>
              <tr>
                <th>专业名</th>
                <th>最大上限</th>
                <th>专业简介</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach  var="element" items="${ majors }">
                <tr>
                  <td class="hidden">${element.id}</td>
                  <td>${element.name}</td>
                  <td>${element.max}</td>
                  <td>${element.info}</td>
                <td>
                <a class="prem-1 modify-label"><img width="23px" src="/psds/img/pencil.png" /> </a>
              </c:forEach>
            </tbody>
          </table>
          <div class="btn-toolbar float-right mtem-3" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group mr-2" role="group" aria-label="First group">
              <a href="showMajors?pageNum=${0}">
                  <button type="button" class="btn-pagenum">首页</button>
              </a>
            </div>
            <div class="btn-group mr-2" role="group" aria-label="Second group">
              <c:forEach var="i" begin="1" end="${pageCount}">
                <a href="showMajors?pageNum=${i}">
                  <button type="button" class="btn-pagenum">${i}</button>
                </a>
              </c:forEach>
            </div>
            <div class="btn-group mr-2" role="group" aria-label="First group">
              <a href="showMajors?pageNum=${pageCount}">
                  <button type="button" class="btn-pagenum">尾页</button>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <footer>
    <div style="height: 10em;"></div>
  </footer>

  <!-- 修改信息模态框 -->
  <form action="modifyMajor" method="post">
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
                      专业
                  </div>
              </div>
              <input id="stuNum" type="text" name="name" class="form-control" readonly placeholder="major name">
          </div>
          <div class="input-group mb-2">
              <div class="input-group-prepend">
                  <div class="input-group-text">
                      上限
                  </div>
              </div>
              <input id="name" type="text" name="maxCapacity" class="form-control" placeholder="name" value="max capacity">
          </div>
          <div class="input-group mb-2">
              <div class="input-group-prepend">
                  <div class="input-group-text">
                      简介
                  </div>
              </div>
              <textarea id="info" name="info" class="form-control" placeholder="information"></textarea>
          </div>
          <div class="row ptem-1">
            <div class="col-md-6"><button class="steve-sm-btn" type="submit">修改</button></div>
            <div class="col-md-6" id="hide-mofify-card"><button class="steve-sm-btn" type="button">取消</button></div>
          </div>
      </div>
    </div>
  </form>
  <div class="hidden" id="msg">${message}</div>
  <% if(request.getSession().getAttribute("message") != null) request.getSession().removeAttribute("message");%>
  <script src="/psds/js/jquery-3.5.0.min.js"></script>
  <script src="/psds/js/bootstrap.min.js"></script>
 <script>

     $('#showAdmins').click(()=>{
         window.location.href="showAdmin"
     })

     $('#showLogs').click(()=>{
         window.location.href="showLogs";
     })

     $('#chooseManage').click(()=>{
         window.location.href="showChooseManage";
     })

     $('#showStudents').click(()=>{
         window.location.href="showstudents";
     })

     $('#showTeachers').click(()=>{
         window.location.href="showteachers";
     })

     $('#showMajors').click(()=>{
         window.location.href="showMajors";
     })

    $('.left-bar-title').click(()=>{
        window.location.href="#";
    })

    $('.change-pass-btn').click(()=>{
      window.location.href="#";
    })

    $('#xmlInput').click(()=>{
      $('#upload-model-card').fadeIn(0.2)
    })

    $('#upload-model-card').click(()=>{
      document.getElementById('upload-img-inputfile').click()
    })

    $('#upload-img-inputfile').change(()=>{
      document.getElementById('upload-img-inputfile-btn').click()
    })

    $('.modify-label').click(function(){
      $('#upload-model-card-modify').css('display', 'block')
      $('#stuid').val($(this).parent().parent().find('td:eq(0)').text())
      $('#stuNum').val($(this).parent().parent().find('td:eq(1)').text())
      $('#name').val($(this).parent().parent().find('td:eq(2)').text())
      $('#info').text($(this).parent().parent().find('td:eq(3)').text())
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

    // 增加页面弹出
    $('#add-model-card-btn').click((e)=>{
      $('#add-model-card').css('display', 'block')
    })

    // 增加页面隐藏
    $('#add-model-card-hidden').click((e)=>{
      $('#add-model-card').fadeOut()
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