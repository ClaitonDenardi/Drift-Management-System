<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>  

<div id="visualizar_corrida" class="modal fade" tabindex='-1' role="dialog">
    <div class="modal-dialog modal-lg">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Visualiza��o da Corrida</h4>
            </div>
            <div class="row modal-body">
                <form id="visualizacao-form-corrida">
                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Dados do piloto</div>
                        <div class="panel-body">
                            <t:input-text type="text" id="visualizacao_piloto_nome" name="nome" label="Nome" placeholder="Digite o nome do piloto"></t:input-text>
                            <div class="form-group">
                                <label for="visualizacao_piloto_genero">G�nero</label>
                                <select id="visualizacao_piloto_genero" name="genero" class="form-control" required>
                                    <option value="" selected disabled>Selecione</option>
                                    <option value="M">Masculino</option>
                                    <option value="F">Feminino</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="visualizacao_piloto_veiculo">Veiculo</label>
                                <select id="visualizacao_piloto_veiculo" name="veiculo" class="form-control" required>
                                    <option  value="" selected disabled>Selecione</option>
                                    <option value="Nissan350z">Nissan 350z</option>
                                    <option value="Nissan370z">Nissan 370z</option>
                                    <option value="NissanSilvia">Nissan Silvia</option>
                                    <option value="NissanSkyline">Nissan Skyline</option>
                                    <option value="ToyotaAE86">Toyota AE86</option>
                                    <option value="ToyotaAltezza">Toyota Altezza</option>
                                    <option value="MazdaRX-7">Mazda RX-7</option>
                                    <option value="MazdaMiata">Mazda Miata</option>
                                    <option value="SubaruImprenza">Subaru Imprenza</option>
                                    <option value="FordFocus">Ford Focus RS</option>
                                    <option value="FordMustang">Ford Mustang</option>
                                    <option value="ChevroletChevette">Chevrolet Chevette</option>
                                    <option value="BMWS3">BMW S�rie 3</option>
                                </select>                                              
                            </div>
                            <t:input-text type="number" id="anoVeiculo" name="anoVeiculo" label="Ano Ve�culo" placeholder="Ano de montagem do ve�culo"></t:input-text>
                            <t:input-text type="number" id="piloto_HP" name="hp" label="HP" placeholder="Pot�ncia do Carro"></t:input-text>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Dados da corrida</div>
                        <div class="panel-body">
                            <t:input-text type="text" id="visualizacao_corrida_titulo" name="titulo" label="T�tulo" placeholder="T�tulo da corrida"></t:input-text>
                            <t:input-date tipo="date" id="visualizacao_corrida_data" name="data" label="Data" placeholder="Selecione a data"></t:input-date>
                            <div class="form-group">
                                <label for="visualizacao_corrida_inicio">Hor�rio</label>
                                <div class="row">
                                    <div class="col-xs-6">
                                        <div class="input-group date timepickercustom">
                                            <input type='text' id="visualizacao_corrida_inicio" name="inicio" placeholder="In�cio" class="form-control timeinput" required />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-time"></span>
                                            </span>
                                        </div>      
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="input-group date timepickercustom">
                                            <input type='text' id="visualizacao_corrida_fim" name="fim" placeholder="Fim" class="form-control timeinput" required />
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-time"></span>
                                            </span>
                                        </div>            
                                    </div>
                                </div>
                            </div>
                            <t:input-text type="number" id="visualizacao_corrida_pontos" name="pontos" label="Pontos" placeholder="Pontua��o" extra="min='0'"></t:input-text>
                        </div>
                    </div>
                </div>
                </form>
            </div> <!-- ./modal-body -->
            <div class="modal-footer">
                <div class="row">
                    <div class="col-md-12">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div> <!-- ./modal-content -->
    </div> <!-- ./modal-dialog -->
</div> <!-- ./modal -->