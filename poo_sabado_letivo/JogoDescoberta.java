package poo_sabado_letivo;

import java.util.Random;
import java.util.Scanner;

public class JogoDescoberta extends Jogo {
    // Construtor
    public JogoDescoberta(String[] palavras) {
        super(palavras);
    }

    // Método para embaralhar a palavra
    public String embaralharPalavra(String palavra) {
        char[] letras = palavra.toCharArray();
        Random aleatorio = new Random();
        for (int i = letras.length - 1; i > 0; i--) {
            int j = aleatorio.nextInt(i + 1);
            char temp = letras[i];
            letras[i] = letras[j];
            letras[j] = temp;
        }
        return new String(letras);
    }

    @Override
    // Método jogar específico para o jogo de descoberta
    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        String palavraEmbaralhada = embaralharPalavra(palavraEscolhida);

        System.out.println("Qual é a palavra embaralhada?");
        System.out.println("Palavra embaralhada: " + palavraEmbaralhada);

        super.jogar(); // Chama o método jogar da classe base
    }
}
