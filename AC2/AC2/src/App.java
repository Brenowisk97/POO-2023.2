import java.util.Scanner;

public class Calculadora {
     public static void main(String[] args) {
        Scanner calc = new Scanner(System.in);
        boolean novo = true;
    while (novo) {
            System.out.print("Digite o primeiro número: ");
            double num1 = calc.nextDouble();

            System.out.print("Escolha uma das operações (+, -, *, /): ");
            char operacao = calc.next().charAt(0);

            System.out.print("Digite um segundo número: ");
            double num2 = calc.nextDouble();

            double resultado = 0;

            switch (operacao) {
                case '+':
                    resultado = soma(num1, num2);
                    break;
                case '-':
                    resultado = subtracao(num1, num2);
                    break;
                case '*':
                    resultado = multiplicacao(num1, num2);
                    break;
                case '/':
                    resultado = divisao(num1, num2);
                    break;
                default:
                    System.out.println("Operação nula.");
            }

            System.out.println("Resultado: " + resultado);

            System.out.print("Deseja continuar? (S/N): ");
            char novoChar = calc.next().charAt(0);
            novo = (novoChar == 'S' || novoChar == 's');
        }
    System.out.println("Calculadora encerrada.");
    }
    public static double soma(double a, double b) {
        return a + b;
    }
     public static double subtracao(double a, double b) {
        return a - b;
    }
    public static double multiplicacao(double a, double b) {
        return a * b;
    }
    public static double divisao(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Nenhum número pode ser dividido por zero.");
            return Double.NaN;

            //NaN-Not a number , achei no mozilla
        }
    }
}