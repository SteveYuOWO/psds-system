<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PSDC 研究生导师双选系统</title>
</head>
<style>
    html {
        min-height: 100%;
        position: relative;
        background-color: rgb(202, 202, 202);
    }
    h1 {
        color: rgb(63, 63, 63);
        text-align: center;
        padding-top: 9em;
    }
</style>
<body>
    <h1 id="msg">500服务器内部错误</h1>
</body>
<script src="./js/jquery-3.5.0.min.js">
</script>
<script>
    setInterval(() => $('#msg').fadeToggle(), 500)
</script>
</html>
