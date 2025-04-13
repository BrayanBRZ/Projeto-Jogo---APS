package poo_sabado_letivo;

import java.util.Random;
import java.util.Scanner;

public class CacaPalavras extends Jogo {
    // O tabuleiro agora é acessível diretamente
    public char[][] tabuleiro;
    public static final int TAMANHO_TABULEIRO = 10;

    // Construtor
    public CacaPalavras(String[] palavras) {
        super(palavras);
        this.tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
    }

    // Método para criar o tabuleiro
    public void criarTabuleiro() {
        Random random = new Random();

        // Preenche o tabuleiro com letras aleatórias
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = (char) ('A' + random.nextInt(26)); // Letras de A-Z
            }
        }

        // Esconde a palavra no tabuleiro
        esconderPalavraNoTabuleiro();
    }

    // Método para esconder a palavra
    public void esconderPalavraNoTabuleiro() {
        Random random = new Random();
        
        
        int x = random.nextInt(TAMANHO_TABULEIRO - palavraEscolhida.length());
        int y = random.nextInt(TAMANHO_TABULEIRO - palavraEscolhida.length());
        boolean horizontal = random.nextBoolean();

        if (horizontal) {
            if (y + palavraEscolhida.length() <= TAMANHO_TABULEIRO) {
                for (int i = 0; i < palavraEscolhida.length(); i++) {
                    tabuleiro[x][y + i] = palavraEscolhida.charAt(i);
                }
            }
        } else {
            if (x + palavraEscolhida.length() <= TAMANHO_TABULEIRO) {
                for (int i = 0; i < palavraEscolhida.length(); i++) {
                    tabuleiro[x + i][y] = palavraEscolhida.charAt(i);
                }
            }
        }
    }

    // Método para exibir o tabuleiro
    public void exibirTabuleiro() {
        System.out.println("Tabuleiro de Caça-Palavras:");
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    // Método jogar específico para o caça-palavras
    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        criarTabuleiro();
        exibirTabuleiro();
        super.jogar(); // Chama o método jogar da classe base
    }
}

