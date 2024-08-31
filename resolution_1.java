/*Observe o trecho de código abaixo: int INDICE = 13, SOMA = 0, K = 0;
Enquanto K < INDICE faça { K = K + 1; SOMA = SOMA + K; }
Imprimir(SOMA);
Ao final do processamento, qual será o valor da variável SOMA?*/

public class resolution_1 {

    public static void main(String[] args) {
        //Declaração de variaveis
        int INDICE = 13;
        int SOMA = 0;
        int K = 0;

        //Enquanto K for menor que o INDICE, fazer
        while (K < INDICE) {
            K += 1; //K é incrementado mais 1
            SOMA = SOMA + K;
        }

        //Imprimir resultado
        System.out.println("O valor da variável SOMA é = " + SOMA);
    }
}