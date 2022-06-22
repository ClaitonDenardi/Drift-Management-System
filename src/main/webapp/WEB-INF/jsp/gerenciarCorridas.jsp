<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">    
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <h2 class="titulo-destaque">Lista de Corridas</h2>
            <div class="line"></div> 
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
        <div class="table-responsive">
            <table id="data_table" class="table table-bordered table-striped table-hover" class="display">
                <thead>
                    <tr class="cabecalho">
                        <th>Título</th>
                        <th>Piloto</th>
                        <th>Data</th>
                        <th>Evento</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="evento" items="${eventos}">
                        <c:forEach var="corrida" items="${evento.corridas}">
                            <tr>
                                <td>${corrida.titulo}</td>
                                <td>${corrida.piloto.nome}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${corrida.data}" /></td>
                                <td>${evento.nome}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
    </div>
</div> 

<script>
    $(function () {
        $('#data_table').DataTable( {
            "language": {
                "sEmptyTable": "Nenhuma corrida cadastrada até o momento",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ corridas",
                "sInfoEmpty": "Mostrando 0 á 0 de 0 corridas",
                "sInfoFiltered": "(Filtrados de _MAX_ corridas)",
                "sInfoPostFix": "",
                "sInfoThousands": ".",
                "sLengthMenu": "_MENU_ resultados por página",
                "sLoadingRecords": "Carregando...",
                "sProcessing": "Processando...",
                "sZeroRecords": "Nenhuma corrida encontrada na base de dados",
                "sSearch": "Pesquisar",
                "oPaginate": {
                    "sNext": "Próximo",
                    "sPrevious": "Anterior",
                    "sFirst": "Primeiro",
                    "sLast": "Último"
                },
                "oAria": {
                    "sSortAscending": ": Ordenar de forma ascendente",
                    "sSortDescending": ": Ordenar de forma descendente"
                }
            }
        });
    });
</script>

<style>
    .cabecalho {
        background: #337AB7;
        color: #ffffff;
    }
    
    .table-hover tbody tr:hover {
        color: #337AB7;
    }
    
    table > tbody > tr > td:last-child a {
        margin-top: 3px;
        margin-bottom: 3px;
    } 
    
    table > tbody > tr > td {
        vertical-align: middle !important;
    }
</style>
