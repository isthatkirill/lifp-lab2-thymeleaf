$(document).ready(function () {
    $("#toggleResults").click(function () {
        $("#resultsBlock").slideToggle("slow");
        if ($(this).is(":visible")) {
            $('html, body').animate({
                scrollTop: $(this).offset().top
            }, 800);
        }

        var buttonText = $(this).text();
        if (buttonText === "Показать результаты в виде таблицы") {
            $(this).text("Скрыть таблицу");
        } else {
            $(this).text("Показать результаты в виде таблицы");
        }
    });
});