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
                <p id="showstudents" class="gray plem-3 option-text"><i class="fa fa-users prem-1"></i>被选名单</p>
            </div>
            <div class="mtem-1 option-menu rounded-pill">
              <p id="showConfirmedStudents" class="gray plem-3 option-text"><i class="fa fa-user"></i>志愿名单</p>
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
                                      工号
                                  </div>
                              </div>
                              <input type="text" disabled class="form-control" placeholder="student number" value="${user.teaNum}">
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
                              <input id="majors" type="text" name="major" class="form-control" placeholder="major" value="${user.major}">
                          </div>
                          <div class="input-group mb-2">
                              <div class="input-group-prepend">
                                  <div class="input-group-text">
                                      信息
                                  </div>
                              </div>
                              <textarea id="infoas" rows="5" name="info" class="form-control" placeholder="information">${user.info}</textarea>
                          </div>
                          <div class="mr-2">
                              <button type="submit" class="btn-pagenum dark-gray" style="border: 1px solid darkgray">修改</button>
                          </div>
                      </div>
                  </div>
              </form>
          </div>
          <div class="hidden" id="msg">${message}</div>
          <% if(request.getSession().getAttribute("message") != null) request.getSession().removeAttribute("message");%>
      </div>
  </div>
  <footer>
    <div style="height: 10em;"></div>
  </footer>
  <script src="../../js/jquery-3.5.0.min.js"></script>
  <script src="../../js/bootstrap.min.js"></script>
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
  </script>
</body>
</html>