$(function() {
    if ($("#autodromoSel").val() === null)
        $("#circuitoSel").hide();
    
    $("#autodromoSel").change(function() {
        var $circuito      = $("#circuito");
        var $circuitoSel   = $("#circuitoSel");
        if ($( this ).val() === "Circuito 1") {
            $circuitoSel.hide();
            $circuitoSel.prop('selectedIndex', 0);
            $circuitoSel.prop("required", false);
            $circuitoSel.prop("name", null);
            $circuito.show();
            $circuito.prop("name", "circuito");
            $circuito.val("Circuito 1");
        } else {
            $circuito.hide();
            $circuito.prop("name", null);
            $circuitoSel.show();
            $circuitoSel.prop("name", "circuito");
            $circuitoSel.prop("required", true);
        }
    });
    
    // correcao option default selects
    $("#piloto_genero, #piloto_veiculo").css("color", "#999");
    $("#piloto_genero, #piloto_veiculo").on("click change", function() {
        $( this ).css("color", "#555");
    });
    
});