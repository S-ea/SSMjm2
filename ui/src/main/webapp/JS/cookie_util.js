//result是服务器返回的json结果
if(result.status==0) {
    var userId = result.data;
    addCookie("uid", userId, 4);//存储2小时
    window.location.href = "edit.html";
}