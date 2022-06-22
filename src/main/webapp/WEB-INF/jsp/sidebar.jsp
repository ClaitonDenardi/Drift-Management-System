<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav id="sidebar">
    <div class="sidebar-header">
        <a href="index.jsp">
            <h3>OPÇÕES</h3>            
        </a>
    </div>
    <ul class="list-unstyled components">
        <li <c:if test="${empty menuAtivo}">class="active"</c:if> id="menu_index">
            <a href="index.jsp">
                <i class="glyphicon glyphicon-plus"></i> Main
            </a>
        </li>
        <li id="menu_eventos">
            <a href="eventoServlet?action=list">
                <i class="glyphicon glyphicon-plus"></i> Eventos
            </a>
        </li>
        <li id="menu_corridas">
            <a href="corridaServlet">
                <i class="glyphicon glyphicon-plus"></i> Corridas
            </a>
        </li>
    </ul>
    <ul class="list-unstyled CTAs" >
        <li>
            <a href="https://pt.wikipedia.org/wiki/Drift" class="article" title="t1" target="_blank">
                <div class="text-center">
                        Mais sobre Drift
                </div>
            </a>
        </li>
        <li>
            <a href="http://wasbrasil.com.br/modalidade/drift" class="article" title="t2" target="_blank">
                <div class="text-center">
                        Solo Drift
                </div>
            </a>
        </li>
        <li>
            <a href="http://www.formulad.com/" class="article" title="t2" target="_blank">
                <div class="text-center">
                        Fórmula Drift
                </div>
            </a>
        </li>
        <li>
            <a href="https://www.devmedia.com.br/introducao-a-servlets-em-java/25285" class="article" title="t2" target="_blank">
                <div class="text-center">
                        Servlets
                </div>
            </a>
        </li>
        <li>
            <a href="https://www.devmedia.com.br/ajax-tutorial/24797" class="article" title="t2" target="_blank">
                <div class="text-center">
                        Ajax
                </div>
            </a>
        </li>
    </ul>
</nav>

<c:if test="${not empty menuAtivo}">
    <script>
        $(function() {
            $("#sidebar").find(".active").removeClass("active");
            $("#sidebar li[id='${menuAtivo}']").addClass("active");
        });
    </script>
    <c:remove var="menuAtivo" />
</c:if> 