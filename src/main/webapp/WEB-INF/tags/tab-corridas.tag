<%@tag description="aba corridas" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@attribute name="titulo" required="true"%>

<%-- any content can be specified here e.g.: --%>
<div id="corridas" class="tab-pane fade">
    <h2 class="titulo-destaque">${titulo}</h2>                            
    <div class="row">
        <div class="list_corridas"></div>
        <div class="col-md-4">
            <button type="button" data-toggle="modal" data-target="#nova_corrida" class="btn btn-default btn-lg" style="width: 100%; height: 208px;">
                <span class="glyphicon glyphicon-plus "> </span>
            </button> 
        </div>
    </div><br/>
    <div class="row"> 
        <a href="#local" id="previous_corridas" data-toggle="tab" class="btn btn-lg btn-primary btn-nav pull-left"><span class="glyphicon glyphicon-chevron-left"></span> Anterior</a>
        <button id="finalizar_evento" class="btn btn-lg btn-success btn-nav pull-right">Finalizar <span class="glyphicon glyphicon-ok"></span> </button>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/modalCorrida.jsp" />
<jsp:include page="/WEB-INF/jsp/modalVisualizacao.jsp" />