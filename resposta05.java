/*Escreva um programa que inverta os caracteres de um string.
IMPORTANTE:
a) Essa string pode ser informada através de qualquer entrada de sua
preferência ou pode ser previamente definida no código;
b) Evite usar funções prontas, como, por exemplo, reverse;*/
import java.util.Scanner;

public class resposta05 {
    public static void main(String[] args) {
        String inputString = obterString(); // Obter a string a ser invertida
        String stringInvertida = inverterString(inputString); // Inverter a string
        System.out.println("Palavra original: " + inputString);
        System.out.println("Palavra invertida: " + stringInvertida);
    }
    // Função para obter a string
    private static String obterString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        return scanner.nextLine();
    }

    // Função para inverter a string
    private static String inverterString(String str) {
        char[] caracteres = str.toCharArray();
        int inicio = 0;
        int fim = caracteres.length - 1;
        // Trocar os caracteres na posição 'inicio' com os caracteres na posição 'fim'
        while (inicio < fim) {
            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;
            inicio++;
            fim--;
        }
        // Converter o array de caracteres de volta para uma string
        return new String(caracteres);
    }
}
