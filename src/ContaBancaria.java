import exceptions.SaldoInsulficiente;

public class ContaBancaria {

    private double saldo;
    private double chequeEspecial;

    // construtor da classe
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;

        if (saldoInicial <= 500.00) {
            // se for menor ou igual a 500 o cheque especial será apenas R$50,00
            this.chequeEspecial = 50.00;
        } else {
            // se for maior que 500 o cheque será 50% do valor inicial;
            this.chequeEspecial = saldoInicial/2;
        }
    }
    // consultar saldo
    public double getSaldo(){
        return this.saldo;
    }

    // depositar dinheiro
    public void depositarDinheiro(double valor){
        this.saldo = this.saldo + valor;
    }

    // sacar dinheiro
    public void sacarDinheiro(double valorParaSacar) throws SaldoInsulficiente {
        if (valorParaSacar <= this.saldo) {
            this.saldo = this.saldo - valorParaSacar;
        } else {
            throw new SaldoInsulficiente("O valor para sacar é maior que o saldo existente.");
        }
    }
    // pagar um boleto

    // metodo consutar cheque especial
    // verificar se a conta esta usando cheque especial
}
