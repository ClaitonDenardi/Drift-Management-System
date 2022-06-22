var corridas    = [ ];
var num_corrida = 0;

var Piloto = function(nome, genero, veiculo, anoVeiculo, hp) {
    this.nome = nome;
    this.genero = genero;
    this.veiculo = veiculo;
    this.anoVeiculo = anoVeiculo; 
    this.hp = hp;
};

var Corrida = function(num_corrida, id, titulo, pontos, data, inicio, fim, piloto) {
    this.num_corrida = num_corrida; 
    this.id = id; 
    this.titulo = titulo;
    this.pontos = pontos;
    this.data = data;
    this.inicio = inicio;
    this.fim = fim;
    this.piloto = piloto;
};

var Circuito = function(nome) {
    this.nome = nome;
};

var Evento = function(_id, nome, descricao, autodromo, dataInicio, dataFim, circuito, corridas) {
    this._id = _id;
    this.nome = nome;
    this.descricao = descricao;
    this.autodromo = autodromo;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.circuito = circuito;
    this.corridas = corridas;
};