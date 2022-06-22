<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>  

<script src="js/tabs-navegation.js"></script>

<div class="container-fluid">
    <div class="row">
        <ul class="nav nav-tabs nav-justified"> 
            <li id="tab_evento" class="active"><a>Evento</a></li>
            <li id="tab_local"><a>Local</a></li>
            <li id="tab_corridas"><a>Corridas</a></li>
        </ul>
        <div class="tab-content">
            <c:choose>
                <c:when test="${not empty eventoUpdate}">
                    <t:tab-evento titulo="Alterar informações do evento"></t:tab-evento>
                    <t:tab-local titulo="Alterar informações do local"></t:tab-local>
                    <t:tab-corridas titulo="Alterar corridas"></t:tab-corridas>
                </c:when>
                <c:otherwise>
                    <t:tab-evento titulo="Informações do evento"></t:tab-evento>
                    <t:tab-local titulo="Informações do local"></t:tab-local>
                    <t:tab-corridas titulo="corridas"></t:tab-corridas>
                </c:otherwise>
            </c:choose>  
        </div>
    </div> <!-- ./row -->
</div> <!-- ./container-fluid -->

<script src="js/input-datas.js"></script>
<script src="js/select-circuito.js"></script>
<script src="js/evento-objetos.js"></script>
<script src="js/corridas.js"></script>
<script src="js/ajax_evento.js"></script>
<c:if test="${not empty eventoUpdate}">
    <script>
        <c:forEach var="p" items="${eventoUpdate.corridas}">
            var p_pal_nome        = "<c:out value="${p.piloto.nome}" escapeXml="true" />";
            var p_pal_genero        = "<c:out value="${p.piloto.genero}" escapeXml="true" />";
            var p_pal_veiculo        = "<c:out value="${p.piloto.veiculo}" escapeXml="true" />";
            var p_pal_anoVeiculo       = "<c:out value="${p.piloto.anoVeiculo}" escapeXml="true" />";
            var p_pal_hp = "<c:out value="${p.piloto.hp}" escapeXml="true" />";
            var p_pal             = new Piloto(p_pal_nome, p_pal_genero, p_pal_veiculo, p_pal_anoVeiculo, p_pal_hp);
            
            var p_id              = 0; 
            <c:if test="${not empty p.id}">
                p_id = ${p.id};
            </c:if>
            var p_titulo          = "<c:out value="${p.titulo}" escapeXml="true" />";
            var p_pontos          = "${p.pontos}";

            <fmt:formatDate pattern="dd/MM/yyyy" value="${p.data}" var="p_data" />
            <fmt:formatDate pattern="HH:mm" value="${p.horaInicio}" var="p_horaInicio" />  
            <fmt:formatDate pattern="HH:mm" value="${p.horaFim}" var="p_horaFim" />
            var p_data            = "${p_data}"; 
            var p_inicio          = "${p_horaInicio}";
            var p_fim             = "${p_horaFim}";            
            
            var corrida          = new Corrida(num_corrida, p_id, p_titulo, p_pontos, p_data, p_inicio, p_fim, p_pal);
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
                            <p><label>Título:</label> "+ p_titulo +"</p>\
                            <p><label>Data:</label> "+ p_data +"</p>\
                            <p><label>Piloto:</label> "+ p_pal_nome +"</p>\
                        </div>\
                    </div>\
                </div>"
            );
            num_corrida++;               
        </c:forEach>
    </script>
</c:if>