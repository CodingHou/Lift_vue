<!DOCTYPE html>
<html>
<script>
    function checkUserName() {
        //进行查重

        return false;
    }

    $("#userName").blur(checkUserName());
    function checkPwd() {

    }


    function submit() {
       checkUserName();
       checkPwd();
       form.submit();
    }
</script>
<head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
姓名：${user2.name}<br/>
邮箱：${user2.email}
</body>
</html>