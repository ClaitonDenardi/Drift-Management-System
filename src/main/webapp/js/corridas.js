/* global corridas, num_corrida */

$(function() {
    /* INSERIR corrida */
    $("#corrida_pontos").prop("required", false);
    var $form_corrida = $("#form-corrida");
    
    $("#salvar_corrida").click(function(event) {
        if (! $form_corrida[0].checkValidity() ) { // dados invalidos
            event.preventDefault(); 
            event.stopPropagation();
            $form_corrida.find(":submit").click();
            return false;
        }
        
        var nome        = $form_corrida.find("input[name='nome']").val();
        var genero      = $form_corrida.find("select[name='genero']").val();
        var veiculo     = $form_corrida.find("select[name='veiculo']").val();
        var anoVeiculo  = $form_corrida.find("input[name='anoVeiculo']").val();
        var hp          = $form_corrida.find("input[name='hp']").val();
        var piloto = new Piloto(nome, genero, veiculo, anoVeiculo, hp);
        
        var titulo      = $form_corrida.find("input[name='titulo']").val();
        var pontos      = $form_corrida.find("input[name='pontos']").val();
        var data        = $form_corrida.find("input[name='data']").val();
        var inicio      = $form_corrida.find("input[name='inicio']").val();
        var fim         = $form_corrida.find("input[name='fim']").val();
        var corrida    = new Corrida(num_corrida, 0, titulo, pontos, data, inicio, fim, piloto);
        corridas.push( corrida );

        // add resumo da corrida no html
        $(".list_corridas").append(
            "<div id='corrida-"+ num_corrida +"' class='resumo_corrida col-md-4 pull left'>\
                <div class='panel panel-primary'>\
                    <div class='panel-heading'>Resumo\
                        <span class='corrida-btns pull-right'>\
                            <button value='"+ num_corrida + "' data-toggle='modal' data-target='#visualizar_corrida' data-keyboard='true' class='visualizar-corrida btn btn-success'><span class='fa fa-search-plus'></span></button>\
                            <button value='"+ num_corrida + "' class='remover-corrida btn btn-danger'><span class='glyphicon glyphicon-trash'></span></button>\
                        </span>\
                    </div>\
                    <div class='panel-body'>\
                        <p><label>Título:</label> "+ titulo +"</p>\
                        <p><label>Data:</label> "+ data +"</p>\
                        <p><label>piloto:</label> "+ nome +"</p>\
                    </div>\
                </div>\
            </div>"
        );
        num_corrida++;       
    });

    /* VISUALIZAR corrida */
    $("#corridas").on("click", ".resumo_corrida .visualizar-corrida", function() {
        var num_corrida_visualizar = parseInt( this.value );
        var $form = $("#visualizacao-form-corrida");
        for(var i = 0; i < corridas.length; i++) {
            if (corridas[i].num_corrida === num_corrida_visualizar) {
                $form.find("input[name='nome']").val(corridas[i].piloto.nome).prop("disabled", true);
                $form.find("select[name='genero']").val(corridas[i].piloto.genero).prop("disabled", true);
                $form.find("select[name='veiculo']").val(corridas[i].piloto.veiculo).prop("disabled", true);
                $form.find("input[name='anoVeiculo']").val(corridas[i].piloto.anoVeiculo).prop("disabled", true);
                $form.find("input[name='hp']").val(corridas[i].piloto.hp).prop("disabled", true);
                $form.find("input[name='titulo']").val(corridas[i].titulo).prop("disabled", true);
                $form.find("input[name='pontos']").val(corridas[i].pontos).prop("disabled", true);
                $form.find("textarea[name='descricao']").val(corridas[i].descricao).prop("disabled", true);
                $form.find("input[name='data']").val(corridas[i].data).prop("disabled", true);
                $form.find("input[name='inicio']").val(corridas[i].inicio).prop("disabled", true);
                $form.find("input[name='fim']").val(corridas[i].fim).prop("disabled", true);
            }
        }    
    });
    
    /* REMOVER corrida */
    $("#corridas").on("click", ".resumo_corrida .remover-corrida", function() {
        var num_corrida_delete = parseInt( this.value );
        for(var i = 0; i < corridas.length; i++) {
            if (corridas[i].num_corrida === num_corrida_delete)
                corridas.splice(i, 1);
        }    
        $('#corrida-' + num_corrida_delete).remove(); // remove resumo da corrida no html
    });    
    
    /* LIMPAR CAMPOS DA MODAL AO FECHAR */
    $("#nova_corrida").on("hidden.bs.modal", function() {
        $form_corrida[0].reset(); 
        $("#piloto_genero, #piloto_veiculo").css("color", "#999");
    });

});