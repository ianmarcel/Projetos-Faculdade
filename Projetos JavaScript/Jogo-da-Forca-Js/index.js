const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const qtdTentativasMax = 6;
let tentativas = 0;
const palavra_array = ["i", "a", "n"];
let palavra_atual = Array(palavra_array.length).fill("_");
let letras_tentadas = [];

console.log("Dica 1: é um nome próprio");
console.log("Dica 2: tem 3 letras");

function fazerPergunta() {
  if (tentativas < qtdTentativasMax && palavra_atual.includes("_")) {
    rl.question("Digite uma letra: ", (letra) => {
      if (letras_tentadas.includes(letra)) {
        console.log("Você já tentou essa letra. Tente uma letra diferente.");
      } else {
        letras_tentadas.push(letra);
        let checkResp = conferi_letra(letra);

        if (!checkResp) {
          tentativas++;
          console.log("\nTente de novo\n");
          console.log(`Tentativas restantes = ${qtdTentativasMax - tentativas}`);
        } else {
          console.log("\nAcertou!\n");
        }

        mostrar_palavra_atual();

        if (!palavra_atual.includes("_")) {
          console.log("Parabéns! Você adivinhou a palavra!");
          rl.close();
          return;
        }
      }
      fazerPergunta();
    });
  } else {
    if (tentativas === qtdTentativasMax) {
      console.log("Você esgotou todas as tentativas. Fim de jogo.");
    }
    rl.close();
  }
}

function conferi_letra(letra) {
  let acertou = false;
  for (let x = 0; x < palavra_array.length; x++) {
    if (letra === palavra_array[x]) {
      palavra_atual[x] = letra;
      acertou = true;
    }
  }
  return acertou;
}

function mostrar_palavra_atual() {
  console.log("Palavra atual: " + palavra_atual.join(" "));
}

// Iniciar o jogo
fazerPergunta();
