package poo_sabado_letivo;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
	
    public String palavraEscolhida;
    public int oportunidades;
    public boolean dicaDada = false;

    // Construtor
    public Jogo(String[] palavras) {
        Random aleatorio = new Random();
        this.palavraEscolhida = palavras[aleatorio.nextInt(palavras.length)];
        this.oportunidades = 3; // 3 tentativas
    }

    // Método para dar a dica
    public void darDica() {
        if (!dicaDada) {
            System.out.println("Primeira letra: " + palavraEscolhida.charAt(0));
            System.out.println("Última letra: " + palavraEscolhida.charAt(palavraEscolhida.length() - 1));
            dicaDada = true;
        } else {
            System.out.println("Dica já foi dada.");
        }
    }

    // Método para tentar adivinhar a palavra
    public boolean tentarAdivinhar(String tentativa) {
        if (tentativa.equals(palavraEscolhida)) {
            System.out.println("Parabéns! Você acertou a palavra: " + palavraEscolhida);
            return true;
        }
        return false;
    }

    // Método para jogar
    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        while (oportunidades > 0) {
            System.out.println("TENTATIVAS: " + oportunidades);
            System.out.print("Digite sua tentativa: ");
            String tentativa = scanner.nextLine();

            if (tentativa.equals("dica")) {
                darDica();
                continue;
            }

            if (tentarAdivinhar(tentativa)) {
                break;
            }

            oportunidades--;
            if (oportunidades == 0) {
                System.out.println("Você perdeu! A palavra era: " + palavraEscolhida);
            }
        }
        scanner.close();
    }
}
