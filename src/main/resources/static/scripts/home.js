function getColorId() {
    var colorIds = document.getElementsByName("colorId");
    for (var i = 0; i < colorIds.length; i++) {
        if (colorIds[i].checked) {
            alert("選択中：" + colorIds[i].value);
        }
    }
}
