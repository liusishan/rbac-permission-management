// 动态设置iframe高度
function alertsize(pixels) {
    // 先清空原有的高度
    document.getElementById('myiframe').style.height = 0 + "px";
    // 再设置新的高度
    pixels += 10;
    document.getElementById('myiframe').style.height = pixels + "px";
}

