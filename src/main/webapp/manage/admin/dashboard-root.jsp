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
  <nav class="d-flex flex-column flex-md-row align-items-center p-4 px-md-5 mb-1 bg-white shadow">
    <div class="my-0 mr-md-auto font-weight-normal logo">
      <img src="../../img/logo-design.png" width="400px"/>
    </div>
    <div class="my-2 my-md-1 mr-md-3">
      <a class="p-2 nav-text" href="">导师信息</a>
      <a class="p-2 nav-text" href="">个人信息</a>
      <a class="p-2 nav-text" href="">学院概况</a>
      <a class="p-2 nav-text" href="">信息服务</a>
    </div>
  </nav>
  <div class="container-fluid">
    <div class="row">
      <!-- 侧边栏 -->
      <div class="col-md-2 left-bar">
        <div class="mtem-2 plem-1">
          <p class="gray plem-1 left-bar-title">
            <i class="fa fa-align-justify prem-1"></i>功能列表
          </p>
        </div>
        <div class="mtem-1 option-menu option-select rounded-pill">
          <p class="white plem-3 option-text"><i class="fa fa-users prem-1"></i>学生管理</p>
        </div>
        <div class="mtem-1 option-menu rounded-pill">
          <p class="gray plem-3 option-text"><i class="fa fa-user"></i>教师管理</p>
        </div>
        <div class="mtem-1 option-menu rounded-pill">
          <p class="gray plem-3 option-text"><i class="fa fa-gear"></i>个人信息修改</p>
        </div>
        <br />
        <hr />
      </div>
      <div class="col-md-10">
        <!-- 欢迎界面 -->
        <div class="ptem-2 plem-2 main-content dark-gray">
          <p class="right-title">欢迎管理员 Steve Yu 登陆研究生导师双选平台</p>
        </div>
        <hr />
        <!-- 按钮button -->
        <div class="menu-group">
          <button type="button" class="btn-steve">批量导出</button>
          <button type="button" id="xmlInput" class="btn-steve">批量导入</button>
          <button type="button" class="btn-steve">单条录入</button>
          <input type="text" class="btn-steve-text" placeholder="搜索" />
        </div>
        <!-- 公告 -->
        <!-- <div class="bg-light-gray announce ptem-1 plem-2 dark-gray">
          <h6><i class="fa fa-bullhorn prem-1"></i>公告</h6>
          <hr />
          <h6>为了您的账户安全，首次登陆请修改密码。点击"<a href="dashboard-root.html"></a><font class="emphasize-font change-pass-btn">密码修改</font></a>"进行修改首次密码修改</h6>
        </div> -->
        <!-- 表格 -->
        <div class="mtem-2">
          <div class="minbox text-center plem-1 prem-1"><i class="fa fa-file-text-o prem-1"></i>学生信息</div>
          <table class="table text-center">
            <thead>
              <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>邮箱</th>
                <th>报考专业</th>
                <th>个人简介</th>
                <th>志愿1</th>
                <th>志愿2</th>
                <th>志愿3</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach  var="element" items="${ students }">
                <tr>
                  <td>${element.stuNum}</td>
                  <td>${element.name}</td>
                  <td>${element.email}</td>
                  <td>${element.major}</td>
                  <td>${element.info}</td>
                  <td>${element.chooseTeacher == 0 ? "未选择" : element.chooseTeacher}</td>
                  <td>${element.chooseTeacher == 0 ? "未选择" : element.chooseTeacher}</td>
                  <td>${element.chooseTeacher == 0 ? "未选择" : element.chooseTeacher}</td>
                <td>
                <a href="#" class="prem-1"><img width="23px" src="../../img/pencil.png" /> </a>
                <a href="#"><img width="23px" src="../../img/delete.png" /></a>
              </c:forEach>

              </td>
            </tr>
            </tbody>
          </table>
          <div class="btn-toolbar float-right mtem-3" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group mr-2" role="group" aria-label="First group">
              <button type="button" class="btn-pagenum">首页</button>
            </div>
            <div class="btn-group mr-2" role="group" aria-label="Second group">
              <button type="button" class="btn-pagenum">1</button>
              <button type="button" class="btn-pagenum">2</button>
              <button type="button" class="btn-pagenum">3</button>
              <button type="button" class="btn-pagenum">4</button>
              <button type="button" class="btn-pagenum">7</button>
              <button type="button" class="btn-pagenum">8</button>
              <button type="button" class="btn-pagenum">9</button>
            </div>
            <div class="btn-group mr-2" role="group" aria-label="First group">
              <button type="button" class="btn-pagenum">尾页</button>
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
      <form action="insertBatch" enctype="multipart/form-data" method="post">
        <input id="upload-img-inputfile" name="studentFile" type="file" style="display: none;" />
        <button id="upload-img-inputfile-btn" type="submit" class="hidden"></button>
      </form>
      <div class="hidden" id="msg">${message}</div>
      <% if(request.getSession().getAttribute("message") != null) request.getSession().removeAttribute("message");%>
  </div>
    
  <script src="../../js/jquery-3.5.0.min.js"></script>
  <script src="../../js/bootstrap.min.js"></script>
 <script>
    $('.left-bar-title').click(()=>{
      window.location.href="dashboard-admin.html"; 
    })
    $('.option-text').click(()=>{
      window.location.href="dashboard-admin.html"; 
    })
    $('.change-pass-btn').click(()=>{
      window.location.href="dashboard-admin.html"; 
    })

    $('#xmlInput').click(()=>{
      $('#upload-model-card').css('display', 'block')
    })

    $('#upload-model-card').click(()=>{
      document.getElementById('upload-img-inputfile').click()
    })

    $('#upload-img-inputfile').change(()=>{
      document.getElementById('upload-img-inputfile-btn').click()
    })

    if($('#msg').text() !== '') alert($('#msg').text())
    // if($('#msg').innerHTML !== "") {
    //   alert($('#msg').innerHTML())
    // }
    // 下载hover
    // $('.download-pic').hover((e)=>{
    //   e.target.src = "../../img/download-white.png"
    //   $('.label-download').css('display', 'block')
    // },(e)=>{
    //   e.target.src = "../../img/download.png"
    //   $('.label-download').css('display', 'none')
    // })
    // 下载点击
    
    
    // 上传hover
    // $('.upload-pic').hover((e)=>{
    //   e.target.src = "../../img/upload-white.png"
    //   $('.label-upload').css('display', 'block')
    // },(e)=>{
    //   e.target.src = "../../img/upload.png"
    //   $('.label-upload').css('display', 'none')
    // })
    // // 上传点击
    // $('.upload-pic').click((e)=>{
    //   $('#upload-model-card').fadeIn()
    // })

    // upload 模态框
    // var upload = document.getElementById('upload-img')
    // upload.onclick = ()=>{
    //     document.getElementById('upload-img-inputfile').click()
    //     // 提交
    // }
    // 设置消失
    // $(document).click(function(e) {
    //   var target = $(e.target)
    //   if(target.closest('.upload-pic').length == 0 && target.closest('.model-card').length == 0) {
    //     $('#upload-model-card').fadeOut()
    //   }
    // })
  </script>
</body>
</html>