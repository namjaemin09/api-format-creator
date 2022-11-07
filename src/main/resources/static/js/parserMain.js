$(document).ready(function () {
    $(".file_select_button").click(function () {
        let fileType = $(this).val();
        let fileName = $('#' + $(this).val() +'List option:selected' ).val() ;

        window.open('http://localhost:8080/parser/result?' +
            'type=' + fileType +'&file=' +fileName);
    });
});

