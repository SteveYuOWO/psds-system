<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="d-flex flex-column flex-md-row align-items-center p-4 px-md-5 mb-1 bg-white shadow">
    <div class="my-0 mr-md-auto font-weight-normal logo">
        <img src="../../img/logo-design.png" width="400px"/>
    </div>
    <div class="my-2 my-md-1 mr-md-3">
        <a class="p-2 nav-text" href="">导师信息</a>
        <a class="p-2 nav-text" href="">个人信息</a>
        <a class="p-2 nav-text" href="">学院概况</a>
        <a class="p-2 nav-text" href="">信息服务</a>
        <a class="p-2 nav-text" href="<%=request.getContextPath()%>/logout" style="color: #ff723e; font-weight: bold; font-size: larger; margin-left: 1em">注销</a>
    </div>
</nav>