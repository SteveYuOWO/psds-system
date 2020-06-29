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
                <p id="showstudents" class="gray plem-3 option-text"><i class="fa fa-users prem-1"></i>被选名单</p>
            </div>
            <div class="mtem-1 option-menu option-select rounded-pill">
              <p id="showConfirmedStudents" class="white plem-3 option-text"><i class="fa fa-user"></i>志愿名单</p>
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
        <!-- 表格 -->
        <div class="mtem-2">
          <div class="minbox text-center plem-1 prem-1"><i class="fa fa-file-text-o prem-1"></i>已选学生</div>
          <table class="table text-center">
            <thead>
              <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>邮箱</th>
                <th>报考专业</th>
                <th>个人简介</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach  var="element" items="${ students }">
                <tr>
                  <td class="hidden">${element.id}</td>
                  <td>${element.stuNum}</td>
                  <td>${element.name}</td>
                  <td>${element.sex}</td>
                  <td>${element.email}</td>
                  <td>${element.major}</td>
                  <td>${element.info}</td>
                  <td>
                      <a href="teacherUnconfirm?id=${element.id}" onclick="return confirm('确认不选择该学生？')" class="prem-1"><img width="23px" src="/psds/img/minus.png" /> </a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
            <br />
            <br />
            <br />
            <div class="minbox text-center plem-1 prem-1"><i class="fa fa-file-text-o prem-1"></i>最终志愿</div>
            <table class="table text-center">
                <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>邮箱</th>
                    <th>报考专业</th>
                    <th>个人简介</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach  var="element" items="${ finalStudents }">
                <tr>
                    <td class="hidden">${element.id}</td>
                    <td>${element.stuNum}</td>
                    <td>${element.name}</td>
                    <td>${element.sex}</td>
                    <td>${element.email}</td>
                    <td>${element.major}</td>
                    <td>${element.info}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
          <div class="btn-toolbar float-right mtem-3" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group mr-2" role="group" aria-label="First group">
              <a href="showstudents?pageNum=${0}">
                  <button type="button" class="btn-pagenum">首页</button>
              </a>
            </div>
            <div class="btn-group mr-2" role="group" aria-label="Second group">
              <c:forEach var="i" begin="1" end="${pageCount}">
                <a href="showstudents?pageNum=${i}">
                  <button type="button" class="btn-pagenum">${i}</button>
                </a>
              </c:forEach>
            </div>
            <div class="btn-group mr-2" role="group" aria-label="First group">
              <a href="showstudents?pageNum=${pageCount}">
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
      <form action="insertBatch" enctype="multipart/form-data" method="post">
        <input id="upload-img-inputfile" name="studentFile" type="file" style="display: none;" />
        <button id="upload-img-inputfile-btn" type="submit" class="hidden"></button>
      </form>
      <div class="hidden" id="msg">${message}</div>
      <% if(request.getSession().getAttribute("message") != null) request.getSession().removeAttribute("message");%>
  </div>

  <script src="/psds/js/jquery-3.5.0.min.js"></script>
  <script src="/psds/js/bootstrap.min.js"></script>
 <script>
    $('#showstudents').click(()=>{
        window.location.href="showstudents";
    })

    $('#showConfirmedStudents').click(()=>{
        window.location.href="showConfirmedStudents";
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
      var sex_str = $(this).parent().parent().find('td:eq(3)').text()
      $('#email').val($(this).parent().parent().find('td:eq(4)').text())
      $('#major').val($(this).parent().parent().find('td:eq(5)').text())
      $('#info').text($(this).parent().parent().find('td:eq(6)').text())
      if(sex_str === '男') $('#male').prop('checked', true)
      else $('#female').prop('checked', true)
      // console.log()
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
            window.location.href = "searchStudent?message="+$('#search').val()
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