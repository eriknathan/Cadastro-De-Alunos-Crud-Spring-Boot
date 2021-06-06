var tabelas = document.querySelectorAll('#tr');

var alunos = [];

for(let i = 0; i < tabelas.length; i++){

  var aluno = {};

  aluno.matricula = document.getElementById('alunos-matricula' + i).value;
  aluno.nome = document.getElementById('alunos-nome' + i).value;
  aluno.cursoNome = document.getElementById('alunos-curso-nome' + i).value;
  aluno.periodoNome = document.getElementById('alunos-periodo-nome' + i).value;
  aluno.sexo = document.getElementById('alunos-sexo' + i).value;
  aluno.data_nasc = document.getElementById('alunos-nascimento' + i).value;
  aluno.cpf = document.getElementById('alunos-cpf' + i).value;
  aluno.email = document.getElementById('alunos-email' + i).value;
  aluno.cep = document.getElementById('alunos-cep' + i).value;
  aluno.uf = document.getElementById('alunos-uf' + i).value;
  aluno.cidade = document.getElementById('alunos-cidade' + i).value;
  aluno.bairro = document.getElementById('alunos-bairro' + i).value;
  aluno.rua = document.getElementById('alunos-rua' + i).value;
  aluno.numero = document.getElementById('alunos-numero' + i).value;
  aluno.complemento = document.getElementById('alunos-complemento' + i).value;

  alunos.push(aluno);

}

var btn = document.getElementById('btn-relatorio');

function printreport(event){

    event.preventDefault();

    var input = document.getElementById('buscar').value;
    var filter;

    if(input){

        filter = alunos.filter(it => it.nome.toLowerCase().includes(input.toLowerCase()) || it.matricula.toLowerCase().includes(input.toLowerCase()) || it.cursoNome.toLowerCase().includes(input.toLowerCase()));


    }else {

        filter = alunos;

    }

    let printContents = '';
    const WindowObject = window.open('', 'PrintWindow','width=1300,height=960,top=50,left=30,toolbars=no,scrollbars=yes,status=no,resizable=yes');
    printContents += `<table class="table">
                       <tr id="header">
                       <th>Matric.</th>
                       <th>Nome</th>
                       <th>Sexo</th>
                       <th>Nasc.</th>
                       <th>CPF</th>
                       <th>E-mail</th>
                       <th>Curso</th>
                       <th>Periodo</th>
                       <th>CEP</th>
                       <th>UF</th>
                       <th>Cidade</th>
                       <th>Bairro</th>
                       <th>Rua</th>
                       <th>N°</th>
                       <th>Comp.</th>
                     </tr>`;
    filter.map(aluno => {
      printContents += `<tr>
                       <td>${aluno.matricula}</td>
                       <td>${aluno.nome}</td>
                       <td>${aluno.sexo}</td>
                       <td>${aluno.data_nasc}</td>
                       <td>${aluno.cpf}</td>
                       <td>${aluno.email}</td>
                       <td>${aluno.cursoNome}</td>
                       <td>${aluno.periodoNome}</td>
                       <td>${aluno.cep}</td>
                       <td>${aluno.uf}</td>
                       <td>${aluno.cidade}</td>
                       <td>${aluno.bairro}</td>
                       <td>${aluno.rua}</td>
                       <td>${aluno.numero}</td>
                       <td>${aluno.complemento}</td>
                     </tr>`;
    })

  const htmlData = `<html><head><title>Relatorio</title><link rel="stylesheet" type="text/css" href="css/print.css"></head><body><div class="container-relatorio">${printContents}</div><div class="btn-imprimir"><a class="imprimir" id="imprimir" href="#" onclick="javascript: window.print();return false;">Imprimir</a></div></body></html>`;

      WindowObject.document.writeln(htmlData);
      WindowObject.focus();
}

btn.addEventListener('click',printreport);
