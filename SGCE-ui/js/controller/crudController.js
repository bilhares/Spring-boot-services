let tk = JSON.parse(getToken());

function listar(page, tipo) {
  console.log("TIPO PROC" + tipo);
  let url_pag = `?size=${TOTAL_REGISTROS}&page=0`;

  if (page != null) {
    url_pag = `?size=${TOTAL_REGISTROS}&page=${page}`;
  }
  new Promise((resolve, reject) => {
    var req = new XMLHttpRequest();
    req.withCredentials = true;
    req.open("GET", `${URL_BASE}api/processos/${tipo}${url_pag}`, true);
    req.setRequestHeader("Authorization", `Bearer ${tk.access_token}`);

    req.onreadystatechange = () => {
      if (req.readyState == 3) {
        $("#overlay").show();
      }
      if (req.readyState == 4) {
        $("#overlay").hide();
        if (req.status == 200) {
          let dados = JSON.parse(req.responseText);

          $("#tabela_processos").empty();
          $("#tipo").empty();

          $("#tipo").append(getTituloEtapa(tipo));
          paginar(dados.totalPages, tipo);
          resolve(
            dados.content.map(n =>
              $("#tabela_processos").append(`
                <tr onclick='buscaDetalhes(${n.id})'>
                   <td>${n.condutor}</td>
                   <td>${n.placa}</td>
                   <td>${n.codProcesso}</td>
                   <td>${n.numeroProcesso}</td>
                   <td style='display:none'>${n.id}</td>
                </tr>
                `)
            )
          );
        } else {
          reject(console.log(JSON.parse(req.responseText)));
        }
      }
    };
    req.send();
  });
}

function paginar(total, tipo) {
  window.pagObj = $("#pagination")
    .twbsPagination({
      startPage: 1,
      totalPages: total,
      visiblePages: 10,
      onPageClick: function(event, page) {
        listar(page - 1, tipo);
      }
    })
    .on("page", function(event, page) {});
}

function cadastrarPessoa() {
  var obj = JSON.stringify({
    nome: form_cadastro_pessoa.nome.value,
    endereco: {
      logradouro: form_cadastro_pessoa.logradouro.value,
      numero: form_cadastro_pessoa.numero.value,
      complemento: form_cadastro_pessoa.complemento.value,
      bairro: form_cadastro_pessoa.bairro.value,
      cep: form_cadastro_pessoa.cep.value,
      cidade: form_cadastro_pessoa.cidade.value,
      estado: form_cadastro_pessoa.estado.value
    },
    ativo: true
  });
  console.log(obj);
  new Promise((resolve, reject) => {
    var req = new XMLHttpRequest();
    req.withCredentials = true;
    req.open("POST", URL_BASE + "pessoas", false);
    req.setRequestHeader("content-type", "application/json");
    req.setRequestHeader("Authorization", `Bearer ${tk.access_token}`);

    req.onreadystatechange = () => {
      if (req.readyState == 4) {
        if (req.status == 200) {
          resolve(console.log(JSON.parse(req.responseText)));
        } else {
          reject(console.log(JSON.parse(req.responseText)));
        }
      }
    };
    req.send(obj);
  });
}

function buscaDetalhes(idProcesso) {
  new Promise((resolve, reject) => {
    var req = new XMLHttpRequest();
    req.withCredentials = true;
    req.open("GET", `${URL_BASE}api/processos/id/${idProcesso}`, true);
    req.setRequestHeader("Authorization", `Bearer ${tk.access_token}`);

    req.onreadystatechange = () => {
      if (req.readyState == 3) {
        $("#overlay").show();
      }
      if (req.readyState == 4) {
        $("#overlay").hide();
        if (req.status == 200) {
          $("#modal-detalhes").modal("open");
          let dados = JSON.parse(req.responseText);
          $("#ul-detalhes").empty();
          resolve(
            $("#ul-detalhes").append(
              "<li><b>Condutor:</b>   " +
                dados.condutor +
                "</li>" +
                "<li><b>Cnh:</b>   " +
                dados.cnh +
                "</li>" +
                "<li><b>Tipo de Processo:</b>  " +
                dados.tipoProcesso +
                "</li>" +
                "<li><b>nº Auto:</b>   " +
                dados.nAuto +
                "</li>" +
                "<li><b>Placa:</b>  " +
                dados.placa +
                "</li>" +
                "<li><b>data/hora/local:</b>   " +
                replacer(dados.dataHoraLocal) +
                "</li>" +
                "<li><b>Tipifição:</b>   " +
                dados.tipificacao +
                "</li>" +
                "<li><b>Numero do Processo:</b>   " +
                dados.numeroProcesso +
                "</li>" +
                "<li><b>Registro Pgu:</b>   " +
                dados.registroPgu +
                "</li>" +
                "<li><b>Orgão Atuador:</b>   " +
                replacer(dados.orgaoAtuador) +
                "</li>" +
                "<li><b>nº Pontos:</b>  " +
                replacer(dados.nPontos) +
                "</li>"
            )
          );
        } else {
          reject(console.log(JSON.parse(req.responseText)));
        }
      }
    };
    req.send();
  });
}

function replacer(value) {
  if (value === null || value == undefined) {
    return "";
  }
  return value;
}

function getTituloEtapa(tipo){
  let tituloEtapa ='';
  switch (tipo) {
    case '5': tituloEtapa = '15 Dias';
        break;
    case '16': tituloEtapa = 'Provido';
        break;
    case '27': tituloEtapa = '30 Dias';
        break;
    case '43': tituloEtapa = '48 Horas';
        break;
    case '57': tituloEtapa = 'Portaria';
        break;
}
return tituloEtapa;

}