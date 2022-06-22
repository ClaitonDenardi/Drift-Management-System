<%@tag description="aba local" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@attribute name="titulo" required="true"%>

<%-- any content can be specified here e.g.: --%>
<div id="local" class="tab-pane fade">
    <h2 class="titulo-destaque">${titulo}</h2>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-primary">
                <div class="panel-heading">Selecione o autodromo e o circuito</div>
                <div class="panel-body">
                    <form id="form-local">
                        <div class="form-group">
                            <label for="autodromoSel">Autódromo</label>
                            <select id="autodromoSel" name="autodromo" class="form-control" required>
                                <option value="" selected disabled>Escolha o autodromo</option>
                                <option value="Circuito1">Autodromo 1</option>
                                <option value="Circuito2">Autodromo 2</option>
                            </select>
                        </div>                                
                        <div class="form-group">
                            <label>Circuito</label>
                            <input type="text" id="circuito" class="form-control" disabled/>
                            <select id="circuitoSel" class="form-control">
                                <option value="" selected disabled>Escolha o circuito</option>
                                <option value="1">Circuito 1</option>
                                <option value="2">Circuito 2</option>
                                <option value="3">Circuito 3</option>
                            </select>
                        </div>
                        <input type="submit" class="hidden" />
                    </form>
                </div> <!-- ./panel-body -->
            </div> <!-- ./panel -->
        </div> <!-- ./col -->
    </div> <!-- ./row -->
    <div class="row"> 
        <a href="#evento" id="previous_local" data-toggle="tab" class="btn btn-lg btn-primary btn-nav pull-left"><span class="glyphicon glyphicon-chevron-left"></span> Anterior</a>
        <a href="#corridas" id="next_local" data-toggle="tab" class="btn btn-lg btn-primary btn-nav pull-right">Próximo <span class="glyphicon glyphicon-chevron-right"></span></a>
    </div>
</div> <!-- ./tab-pane -->

<c:if test="${not empty eventoUpdate}">
    <script>
        $(function() {
            var _enderecoSel = $("#autodromoSel");
            var _circuito      = $("#circuito");
            var _circuitoSel   = $("#circuitoSel");
            _enderecoSel.val("${eventoUpdate.autodromo}");
            if (_enderecoSel.val() === "Circuito 1") {
                _circuitoSel.hide();
                _circuitoSel.prop('selectedIndex', 0);
                _circuitoSel.prop("required", false);
                _circuitoSel.prop("name", null);
                _circuito.show();
                _circuito.prop("name", "circuito");
                _circuito.val("Circuito 2");
            } else {
                _circuito.hide();
                _circuito.prop("name", null);
                _circuitoSel.show();
                _circuitoSel.prop("name", "circuito");
                _circuitoSel.prop("required", true);
                _circuitoSel.val('${eventoUpdate.circuito.nome}');
            }
        });
    </script>
</c:if>