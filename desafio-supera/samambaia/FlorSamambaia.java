import java.util.Scanner;

public class FlorSamambaia {
    public static String tentativaDesenhar(int r1, int x1, int y1, int r2, int x2, int y2) {
        // Calcula a distância entre os centros dos dois círculos
        double distanciaCentros = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        
        // Verifica se o círculo da flor está completamente dentro do círculo do caçador
        if (distanciaCentros + r2 <= r1) {
            return "RICO";
        } else {
            return "MORTO";
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Coleta os dados do usuário
        System.out.println("Digite o raio do círculo do caçador (R1):");
        int r1 = scanner.nextInt();
        
        System.out.println("Digite as coordenadas do centro do círculo do caçador (X1 Y1):");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        
        System.out.println("Digite o raio do círculo da flor (R2):");
        int r2 = scanner.nextInt();
        
        System.out.println("Digite as coordenadas do centro do círculo da flor (X2 Y2):");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        
        // Calcula e exibe o resultado
        String resultado = tentativaDesenhar(r1, x1, y1, r2, x2, y2);
        System.out.println("Resultado: " + resultado);
        
        scanner.close();
    }
}