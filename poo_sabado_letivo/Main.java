package poo_sabado_letivo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] palavras = {"ALGORITMO"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o jogo: ");
        System.out.println("1 - Caça-Palavras");
        System.out.println("2 - Jogo da Descoberta");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consome a linha em branco

        if (opcao == 1) {
            Jogo jogo = new CacaPalavras(palavras);
            jogo.jogar();
        } else if (opcao == 2) {
            Jogo jogo = new JogoDescoberta(palavras);
            jogo.jogar();
        } else {
            System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}