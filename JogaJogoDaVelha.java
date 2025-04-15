import java.util.Scanner;

public class JogaJogoDaVelha {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao teste do Jogo da Velha!");
        System.out.println("1 - Jogar");
        System.out.println("0 - Sair");
        int opcao = scanner.nextInt();

        while (opcao != 1 && opcao != 0) {
            System.out.println("Opção Inválida. Digite novamente.");
            System.out.println("1 - Jogar");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
        }
        
        
        while (opcao != 0) {
            System.out.println("Digite um número inteiro para a dimensão do tabuleiro: ");
            int dimensao = scanner.nextInt();
            
            if (dimensao < 3) {
                System.out.println("Dimensão muito pequena. Digite outra novamente.");
                continue;
            }

            JogoDaVelha jogo = new JogoDaVelha(dimensao);
            
            jogo.preencherTabuleiro();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            String tabuleiro = jogo.toString();
            System.out.println("Jogo final: \n");
            System.out.println(tabuleiro + "\n");
            jogo.vencedor();
            
            if (jogo.vencedor() == 1) {
                System.out.println("Jogador X (1) venceu!");
            } else if (jogo.vencedor() == -1) {
                System.out.println("Jogador O (-1) venceu!");
            } else {
                System.out.println("Empate (0)!");
            } 

            
            System.out.println("Deseja jogar novamente?");
            System.out.println("1 - Sim");
            System.out.println("0 - Não");
            opcao = scanner.nextInt();

            while (opcao != 1 && opcao != 0) {
                System.out.println("Resposta inválida. Digite novamente.");
                System.out.println("1 - Sim");
                System.out.println("0 - Não");
                opcao = scanner.nextInt();
            }

            if (opcao == 1) {
                jogo.limpaTabuleiro();
            }
        }
    }
}
