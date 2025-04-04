import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema bancário - Pedro Banks - Atividade DIO");

        System.out.println("Criar cliente");
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Valor inicial: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria cliente = new ContaBancaria(saldoInicial, nomeCliente);
        System.out.println("Cliente criado nome: " + cliente.getNome() + " Saldo: " + cliente.getSaldo() + " cheque especial: " + cliente.getValorChequeEspecial());

        System.out.println("Escolha uma dessas opções a baixo: \n1 - Depositar dinheiro\n2 - Sacar dinheiro\n3 - Pagar um boleto\n");
        scanner.nextLine();
        String opcao = scanner.nextLine();
        if (Objects.equals(opcao, "1")){
           System.out.print("escolheu 1");

        } else if (Objects.equals(opcao, "2")) {
            System.out.print("escolheu 2");

        } else if (Objects.equals(opcao, "3")) {
            System.out.print("escolheu 3");

        } else {
            System.out.println("Escreva um número válido.");
        }

    }
}