$(document).ready(function () {
    $('#form-integrante').on('submit', function (event) {
        event.preventDefault();

        const data = {
            nome: $('#nome').val(),
            funcao: $('#funcao').val(),
            franquia: $('#franquia').val()
        };

        // URL do backend
        const url = 'http://localhost:8080/integrantes';

        console.log("Dados enviados:", data);

        $.ajax({
            url: url,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function(response) {
                console.log("Integrante cadastrado:", response);
                alert('Integrante cadastrado com sucesso!');
            },
            error: function(xhr, status, error) {
                console.error("Erro ao cadastrar integrante:", error);
                alert(`Ocorreu um erro: ${xhr.status} - ${xhr.statusText}`);
            }
        });
    });
});
