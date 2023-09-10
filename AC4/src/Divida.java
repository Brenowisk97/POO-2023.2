import java.util.Scanner;

public class ParcelamentoDivida {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] parcelas = {1, 3, 6, 9, 12};
        double[] taxasJuros = {0.0, 0.10, 0.15, 0.20, 0.25};

        System.out.print("Escreva o valor da dívida: R$ ");
        double divida = scanner.nextDouble();

        System.out.println("Opções de Parcelamento:");
        System.out.println("----------------------------------------");
        System.out.println("Quantidade de Parcelas  % de Juros  Valor dos Juros  Valor Total  Valor da Parcela");

        for (int i = 0; i < parcelas.length; i++) {
            int vezesParcelas = parcelas[i];
            double taxaJuros = taxasJuros[i];
            double juros = divida * taxaJuros;
            double valorTotal = divida + juros;
            double valorParcela = valorTotal / vezesParcelas;

            System.out.println(vezesParcelas + "\t\t" + (taxaJuros * 100) + "%\t\t" + juros + "\t\t" + valorTotal + "\t\t" + valorParcela);
        }

        scanner.close();
    }
}