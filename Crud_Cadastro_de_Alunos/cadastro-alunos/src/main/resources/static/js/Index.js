
var filtro = document.getElementById('buscar');
var tabela = document.getElementById('tabela');

filtro.onkeyup = function() {

    var nomeFiltro = filtro.value;
    var regra = /^[0-9]+$/;

    if (nomeFiltro.match(regra)) {

      for (var i = 1; i < tabela.rows.length; i++) {
        var conteudoCelula = tabela.rows[i].cells[0].innerText;
        var corresponde = conteudoCelula.toLowerCase().indexOf(nomeFiltro) >= 0;
        tabela.rows[i].style.display = corresponde ? '' : 'none';
        }

    }else{
        for (var i = 1; i < tabela.rows.length; i++) {

            var conteudoCelula = tabela.rows[i].cells[1].innerText;
            var corresponde = conteudoCelula.toLowerCase().indexOf(nomeFiltro.toLowerCase()) >= 0;

            if(conteudoCelula.toLowerCase().match(nomeFiltro.toLowerCase())){

                tabela.rows[i].style.display = corresponde ? '' : 'none';

            }else{

                var conteudoCelula = tabela.rows[i].cells[2].innerText;
                var corresponde = conteudoCelula.toLowerCase().indexOf(nomeFiltro.toLowerCase()) >= 0;
                tabela.rows[i].style.display = corresponde ? '' : 'none';

            }

        }
    }
};
