import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snail {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o tamanho da matriz N x N:");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("Matriz:");
        printMatrix(matrix);
        
        List<Integer> result = snail(matrix);
        System.out.println("\nResultado em padrão de caracol:");
        System.out.println(result);
        
        scanner.close();
    }

    public static List<Integer> snail(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Percorre a linha superior da esquerda para a direita
            result.addAll(traverseTop(matrix, top, left, right));
            top++;
            
            // Percorre a coluna da direita de cima para baixo
            result.addAll(traverseRight(matrix, top, bottom, right));
            right--;
            
            // Percorre a linha inferior da direita para a esquerda, se ainda houver linhas
            if (top <= bottom) {
                result.addAll(traverseBottom(matrix, bottom, left, right));
                bottom--;
            }
            
            // Percorre a coluna da esquerda de baixo para cima, se ainda houver colunas
            if (left <= right) {
                result.addAll(traverseLeft(matrix, top, bottom, left));
                left++;
            }
        }
        
        return result;
    }

    private static List<Integer> traverseTop(int[][] matrix, int row, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            list.add(matrix[row][i]);
        }
        return list;
    }

    private static List<Integer> traverseRight(int[][] matrix, int top, int bottom, int col) {
        List<Integer> list = new ArrayList<>();
        for (int i = top; i <= bottom; i++) {
            list.add(matrix[i][col]);
        }
        return list;
    }

    private static List<Integer> traverseBottom(int[][] matrix, int row, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = right; i >= left; i--) {
            list.add(matrix[row][i]);
        }
        return list;
    }

    private static List<Integer> traverseLeft(int[][] matrix, int top, int bottom, int col) {
        List<Integer> list = new ArrayList<>();
        for (int i = bottom; i >= top; i--) {
            list.add(matrix[i][col]);
        }
        return list;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}