
import java.util.Scanner;

public class distribuiProblemas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a quantidade de alunos: ");
        int qtdAlunos = scanner.nextInt();

        System.out.print("Informe a quantidade de problemas: ");
        int qtdProblemas = scanner.nextInt();

        int qtdColunas = calculaColuna(qtdProblemas, qtdAlunos);

        //declaração de arrays
        String[] vetorNomeAlunos = new String[qtdAlunos];
        int[][] matriz = new int[qtdAlunos][qtdColunas];

        vetorNomeAlunos = alimentaNomes(vetorNomeAlunos, qtdAlunos);

        matriz = atribuiProblema(matriz, qtdProblemas);

        mostraTudo(vetorNomeAlunos, matriz);

    }//fim main

    //funções:
    public static int calculaColuna(int qtdProblemas, int qtdAlunos) {
        if (qtdProblemas % qtdAlunos == 0) {
            return qtdProblemas / qtdAlunos;
        } else {
            return (int) qtdProblemas / qtdAlunos + 1;
        }
    }//fim calculaColuna

    public static String[] alimentaNomes(String[] vetorNomeAlunos, int qtdAlunos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("NÃO USAR ESPAÇOS");
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.printf("Informe o nome do %d° aluno: ", i + 1);
            vetorNomeAlunos[i] = scanner.next();
        }
        return vetorNomeAlunos;
    }

    public static int[][] atribuiProblema(int[][] matriz, int qtdProblemas) {
        int comprimentoLinha = matriz.length;
        int comprimentoColunas = matriz[0].length;

        int problemaIteracao = 1;
        for (int j = 0; j < comprimentoColunas; j++) {
            for (int i = 0; i < comprimentoLinha; i++) {
                matriz[i][j] = problemaIteracao;
                problemaIteracao++;
                if (problemaIteracao > qtdProblemas)
                    break;
            }
        }
        return matriz;
    }

    public static void mostraTudo(String[] vetorNomeAlunos, int[][] matriz) {
        int comprimentoLinha = matriz.length;
        int comprimentoColunas = matriz[0].length;

        for (int i = 0; i < comprimentoLinha; i++) {
            System.out.print(vetorNomeAlunos[i] + ": ");
            for (int j = 0; j < comprimentoColunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }
}
