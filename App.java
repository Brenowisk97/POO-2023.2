public class ConfirmaPrimo {
    public static boolean e_primo(int num) {
        if (num <= 1) {
            System.out.println("O resultado não é primo.");
            return false;
        }

        boolean primo = true;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                primo = false;
                System.out.println("O resultado não é primo. Divisível por " + i);
            }
        }

        if (primo) {
            System.out.println("O resultado é primo.");
        }

        return primo;
    }

    public static void main(String[] args) {
        int numero = 47;
        e_primo(numero);
    }
}