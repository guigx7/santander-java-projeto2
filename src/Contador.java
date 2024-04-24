import exceptions.ParametrosInvalidosException;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        System.out.print("\nDigite o primeiro parâmetro:\n--> ");
        int parametroUm = terminal.nextInt();

        System.out.print("\nDigite o segundo parâmetro\n--> ");
        int parametroDois = terminal.nextInt();

        try {
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    static void contar(int n1, int n2) throws ParametrosInvalidosException {
        if (isNAN(n1) || isNAN(n2)) {
            throw new ParametrosInvalidosException("Ambos os parâmetros devem ser números inteiros.");
        }

        if (n1 < n2){
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }

        int contagem = n1 - n2;

        System.out.print("\n");

        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }

    static boolean isNAN(int num) {
        try {
            Integer.parseInt(String.valueOf(num));
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
