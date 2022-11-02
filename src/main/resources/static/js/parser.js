$(document).ready(function () {
    $("#typeSelect").change(function () {
        $('.lists').css("display",'none');
        $('.lists').attr("useYn",'false');
        $('#' + $("#typeSelect").val() +'List').css("display",'inline');
        $('#' + $("#typeSelect").val() +'List').attr("useYn",'true');
    });

    $("#selectFile").click(function () {
        $('#currentFile').text( $('.lists[useYn=true]').val());

        window.open('http://localhost:8080/parser/parsed-data?');

    });
});

