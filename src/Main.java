import exceptions.SaldoInsulficiente;

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

        switch (opcao) {
            case "1" -> {
                System.out.println("Opção escolhida: 1 - Depositar dinheiro ");
                System.out.println("Escreva o valor a ser depositado: ");
                double valor = scanner.nextDouble();
                cliente.depositarDinheiro(valor);

                System.out.println("O saldo na conta é: " + cliente.getSaldo());
            }
            case "2" -> {
                System.out.println("Opção escolhida: 2 - Sacar dinheiro ");
                System.out.println("Escreva o valor a ser sacado: ");
                double valor = scanner.nextDouble();
                try {
                    cliente.sacarDinheiro(valor);
                    System.out.println("O saldo na conta é: " + cliente.getSaldo());
                } catch (SaldoInsulficiente message) {
                    System.out.println("Erro: " + message);
                }

            }
            case "3" -> {
                System.out.println("Opção escolhida: 3 - Pagar um boleto ");
                System.out.println("Escreva o valor do boleto: ");
                double valor = scanner.nextDouble();
                try {
                    cliente.pagarBoleto(valor);
                } catch (SaldoInsulficiente message) {
                    System.out.println("Erro: " + message);
                }
            }
            case null, default -> System.out.println("Escreva um número válido de uma opção.");
        }

        mostrarInfo(cliente);

    }

    static void mostrarInfo(ContaBancaria contaCliente) {
        System.out.println("\n\n================================");
        System.out.println("Nome: " + contaCliente.getNome());
        System.out.println("Saldo: " + contaCliente.getSaldo());
        System.out.println("Usando cheque especial? " + contaCliente.usaChequeEspecial());
        System.out.println("Valor do cheque especial: " + contaCliente.getValorChequeEspecial());
        System.out.println("Valor total (saldo + cheque): " + contaCliente.consultarChequeEspecial());
        System.out.println("================================");
    }
}