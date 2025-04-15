import java.util.Random;

public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int tabuleiro[][];
    protected int jogador;
    protected int dimensao;

    public JogoDaVelha(int dimensao) {
        this.dimensao = dimensao; 
        this.tabuleiro = new int[dimensao][dimensao];
    }   

    public void limpaTabuleiro() {
        for (int linha = 0; linha < dimensao; linha++) {
            for (int coluna = 0; coluna < dimensao; coluna++) {
                tabuleiro[linha][coluna] = VAZIO;
            }
        }

        jogador = X;
    }

    public int[] gerarPosicao(){
        Random random = new Random();
        int listaPosicoes[] = new int[2];

        listaPosicoes[0] = random.nextInt(0, dimensao);
        listaPosicoes[1] = random.nextInt(0, dimensao);

        return listaPosicoes;

    }

    public void preencherTabuleiro() {
        
        int vencedor = 2;
        jogador = X;

        while (vencedor == 2) {
            int listaPosicoes[] = gerarPosicao();
            vencedor = vencedor();

            if (vencedor == 2) {
                if (tabuleiro[listaPosicoes[0]][listaPosicoes[1]] == VAZIO) {
                    tabuleiro[listaPosicoes[0]][listaPosicoes[1]] = jogador;
                    String tabuleiro = toString();
                    System.out.println(tabuleiro);
                    System.out.println();
                    jogador *= -1; 

                } else {
                    listaPosicoes = gerarPosicao();
                }
            }
        }
    }

    public boolean eVencedor(int jogador) {

        // linha
        for (int linha = 0; linha < dimensao; linha++) {
            int somaLinha = 0;
            for (int coluna = 0; coluna < dimensao; coluna++) {
                somaLinha += tabuleiro[linha][coluna];
            }

            if (somaLinha == jogador * dimensao) {
                return true;
            }
        }

        // coluna
        for (int coluna = 0; coluna < dimensao; coluna++) {
            int somaColuna = 0;
            for (int linha = 0; linha < dimensao; linha++) {
                somaColuna += tabuleiro[linha][coluna];
            }

            if (somaColuna == jogador * dimensao) {
                return true;
            }
        }

        // diagona principal
        int somaDiagonalPrincipal = 0;
        for (int linha = 0; linha < dimensao; linha++) {
            somaDiagonalPrincipal += tabuleiro[linha][linha];
        }

        if (somaDiagonalPrincipal == jogador * dimensao) {
            return true;
        }

        // diagonal secundária
        int somaDiagonalSecundaria = 0;
        for (int linha = 0; linha < dimensao; linha++) {
                somaDiagonalSecundaria += tabuleiro[linha][dimensao - 1 - linha];


            if (somaDiagonalSecundaria == jogador * dimensao) {
                return true;
            }
        }

        return false;
    }

    public int vencedor() {

        if (eVencedor(X)) {
            return X;
        } else if (eVencedor(O)) {
            return O;
        } else {
            for (int linha = 0; linha < dimensao; linha++) {
                for (int coluna = 0; coluna < dimensao; coluna++) {
                    if (tabuleiro[linha][coluna] == VAZIO) {
                        return 2;
                    }
                }
            }
        }

        return 0;
    }

    public String toString() {
        
        String retorno = "";

        for (int linha = 0; linha < dimensao; linha++) {
            for (int coluna = 0; coluna < dimensao; coluna++) {

                if (tabuleiro[linha][coluna] == X) {
                    retorno += (" X ");
                
                } else if (tabuleiro[linha][coluna] == O) {
                    retorno += (" O ");
                
                } else {
                    retorno += ("   ");
                }
                
                if (coluna < dimensao - 1) {
                    retorno += (" | ");
                }
            }

            if (linha < dimensao - 1) {
                retorno += ("\n");
            }

        }
        return retorno;
    }
}