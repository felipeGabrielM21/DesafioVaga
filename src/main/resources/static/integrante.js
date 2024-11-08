function carregarJogadores() {
    fetch('http://localhost:8080/time')

        .then(response => response.json())
        .then(data => {
            const selectDisponiveis = document.getElementById("jogadores-disponiveis");
            selectDisponiveis.innerHTML = "";

            data.forEach(jogador => {
                const option = document.createElement("option");
                option.value = jogador.id;
                option.text = `${jogador.nome} - ${jogador.funcao}`;
                option.dataset.funcao = jogador.funcao;
                selectDisponiveis.add(option);
            });
        })
        .catch(error => console.error('Erro ao carregar jogadores:', error));
}

function adicionarAoMeuTime() {
    const selectDisponiveis = document.getElementById("jogadores-disponiveis");
    const selectMeuTime = document.getElementById("meu-time");

    Array.from(selectDisponiveis.selectedOptions).forEach(option => {
        selectMeuTime.add(option);
    });
}

function removerDoMeuTime() {
    const selectMeuTime = document.getElementById("meu-time");

    Array.from(selectMeuTime.selectedOptions).forEach(option => {
        document.getElementById("jogadores-disponiveis").add(option);
    });
}

function salvarTime() {
    const timeSelecionado = Array.from(document.getElementById("meu-time").options).map(option => ({
        id: option.value,
        nome: option.text.split(" - ")[0],
        funcao: option.dataset.funcao
    }));

    fetch('http://localhost:8080/time', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ jogadores: timeSelecionado })
    })
    .then(response => {
        if (response.ok) {
            alert('Time salvo com sucesso!');
            document.getElementById("meu-time").innerHTML = "";
            carregarJogadores();
        } else {
            alert('Erro ao salvar o time.');
        }
    })
    .catch(error => {
        console.error('Erro na requisição:', error);
        alert('Erro ao salvar o time.');
    });
}

window.onload = carregarJogadores;