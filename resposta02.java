/*Dado a sequência de Fibonacci,onde se inicia por 0 e 1 e o próximo
valor sempre será a soma dos 2 valores anteriores (exemplo: 0, 1, 1, 2,
3, 5,8, 13, 21, 34...), escreva um programa na linguagem que desejar onde,
informado um número, ele calcule a sequência de Fibonacci e retorne uma
mensagem avisando se o número informado pertence ou não a sequência.

IMPORTANTE: Esse número pode ser informado através de qualquer entrada de
sua preferência ou pode ser previamente definido no código;
 */

 import java.util.Scanner;

public class resposta02{
    public static void main(String[] args) {
        //entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitar ao usuário para informar um número
        System.out.print("Digite um número para verificar : ");
        int numero = scanner.nextInt();

        // Verificar se o número pertence à sequência de Fibonacci e imprimir o resultado
        if (pertenceAFibonacci(numero)) {
            System.out.println(" O numero " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(" O numero" + numero + " não pertence à sequência de Fibonacci.");
        }
        scanner.close();
    }
    // Função para verificar o numero
    public static boolean pertenceAFibonacci(int num) {
        if (num < 0) return false;

        int a = 0, b = 1;
        
        while (a < num) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        
        return a == num;
    }
}
