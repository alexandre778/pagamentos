$(document).ready(function() {

    // Alternar seções PIS / IPI
    $("#tipoImposto").change(function() {
        let tipo = $(this).val();
        $("#pisSection, #ipiSection").hide();
        if (tipo === "PIS") $("#pisSection").show();
        else if (tipo === "IPI") $("#ipiSection").show();
    });

    // Função para salvar pagamento
    $("#pagamentoForm").submit(function(e) {
        e.preventDefault();

        let tipo = $("#tipoImposto").val();
        let nome = $("#nomeEmpresa").val();
        let descricao = "";
        let valorCalculado = 0;

        if(tipo === "PIS") {
            let debito = parseFloat($("#pisDebito").val()) || 0;
            let credito = parseFloat($("#pisCredito").val()) || 0;
            descricao = `Débito: ${debito.toFixed(2)}, Crédito: ${credito.toFixed(2)}`;
            valorCalculado = debito - credito;
        } else if(tipo === "IPI") {
            let frete = parseFloat($("#ipiFrete").val()) || 0;
            let seguro = parseFloat($("#ipiSeguro").val()) || 0;
            let outras = parseFloat($("#ipiOutras").val()) || 0;
            let aliquota = parseFloat($("#ipiAliquota").val()) || 0;
            let valorProduto = parseFloat($("#ipiValorProduto").val()) || 0;

            descricao = `Frete: ${frete.toFixed(2)}, Seguro: ${seguro.toFixed(2)}, Outras: ${outras.toFixed(2)}, Aliquota: ${aliquota.toFixed(4)}, Valor Produto: ${valorProduto.toFixed(2)}`;
            valorCalculado = (valorProduto + frete + seguro + outras) * (aliquota/100);
        }

        // Salvar em cookie
        let pagamentos = JSON.parse(getCookie("pagamentos") || "[]");
        pagamentos.push({nome, tipo, descricao, valorCalculado: valorCalculado.toFixed(2)});
        setCookie("pagamentos", JSON.stringify(pagamentos), 1);

        atualizarTabela();
        this.reset();
        $("#pisSection, #ipiSection").hide();
    });

    // Atualizar tabela
    function atualizarTabela() {
        let pagamentos = JSON.parse(getCookie("pagamentos") || "[]");
        let tbody = $("#pagamentosTable tbody");
        tbody.empty();
        pagamentos.forEach(p => {
            tbody.append(`<tr>
                <td>${p.nome}</td>
                <td>${p.tipo}</td>
                <td>${p.descricao}</td>
                <td>${p.valorCalculado}</td>
            </tr>`);
        });
    }

    // Limpar cookie
    $("#limparBtn").click(function() {
        setCookie("pagamentos", "", -1);
        atualizarTabela();
        $("#pagamentoForm")[0].reset();
        $("#pisSection, #ipiSection").hide();
    });

    // Cookies
    function setCookie(name, value, days) {
        let expires = "";
        if (days) {
            let d = new Date();
            d.setTime(d.getTime() + (days*24*60*60*1000));
            expires = "; expires=" + d.toUTCString();
        }
        document.cookie = name + "=" + (value || "") + expires + "; path=/";
    }

    function getCookie(name) {
        let nameEQ = name + "=";
        let ca = document.cookie.split(';');
        for(let i=0;i < ca.length;i++) {
            let c = ca[i];
            while(c.charAt(0)==' ') c = c.substring(1,c.length);
            if(c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
        }
        return null;
    }

    // Inicializar tabela
    atualizarTabela();
});
