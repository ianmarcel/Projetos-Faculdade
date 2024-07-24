const container        = document.querySelector(".container");
const listaAtividades = document.querySelector(".lista_atividades");
const input            = document.querySelector(".input");
const erro             = document.querySelector(".erro");
const botaoCadastra    = document.querySelector(".botao_adc");
const paleta1          = document.querySelector("#paleta1");
const paleta2          = document.querySelector("#paleta2");
const paleta3          = document.querySelector("#paleta3");

function criaAtividade(){
    const atividade         = document.createElement("div");
    atividade.classList.add("atividade");
    const nomeAtividade     = document.createElement("p");
    nomeAtividade.textContent = input.value;
    const botaoLimpar       = document.createElement("button");
    botaoLimpar.textContent = "Limpar";
    botaoLimpar.classList.add("botao_del");
    
    botaoLimpar.addEventListener("click", () => {
        atividade.remove();
    });

    atividade.appendChild(nomeAtividade);
    atividade.appendChild(botaoLimpar);
    listaAtividades.appendChild(atividade);
}

function cadastraAtividade(){
    if(input.value.length > 3){
        erro.style.display = "none";
        criaAtividade();
    }else{
        erro.style.display = "grid";
        erro.innerHTML = `${input.value} não é uma atividade válida!`;
    }
    limpaInput();
}

function limpaInput(){
    input.value = "";
}

botaoCadastra.addEventListener("click", cadastraAtividade);

window.addEventListener("keypress", (e) => {
    if(e.key === "Enter"){
        cadastraAtividade();
    }
});
