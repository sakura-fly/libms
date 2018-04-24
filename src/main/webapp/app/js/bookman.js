$(document).ready(function() {
    // $('#bookmsg').on('hidden.bs.modal', function (e) {
    //    $(".bookinput").val("")
    // })



    $("#addbook").click(function (e) {
        layui.use('layer', function(){
            var layer = layui.layer;

            layer.open({
                type: 1,
                content: $('#bookmsg') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            });
        });

    });





});