import exceptions.SaldoInsulficiente;

public class ContaBancaria {

    private final String nome;
    private double saldo;
    private double valorChequeEspecial;
    private boolean chequeEspecial;

    // construtor da classe
    public ContaBancaria(double saldoInicial, String nome) {
        this.saldo = saldoInicial;
        this.nome = nome.toUpperCase();

        if (saldoInicial <= 500.00) {
            // se for menor ou igual a 500 o cheque especial será apenas R$50,00
            this.valorChequeEspecial = 50.00;
        } else {
            // se for maior que 500 o cheque será 50% do valor inicial;
            this.valorChequeEspecial = saldoInicial/2;
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
    public void pagarBoleto(double valorBoleto) throws SaldoInsulficiente {
        if (valorBoleto <= this.saldo){
            this.saldo = this.saldo - valorBoleto;
        } if (valorBoleto <= this.saldo + this.valorChequeEspecial) {
            // Isso irá acontecer caso o valor do boleto seja maior que o saldo
            valorBoleto = valorBoleto - this.saldo;
            this.saldo = 0;
            this.valorChequeEspecial = this.valorChequeEspecial - valorBoleto - (valorBoleto * 0.20);
            this.chequeEspecial = true;

        }
        else {
            throw new SaldoInsulficiente("Saldo insulficiente para pagar o boleto");
        }
    }

    // metodo consutar cheque especial
    public double consultarChequeEspecial() {
        return this.saldo + this.valorChequeEspecial;
    }

    // verificar se a conta esta usando cheque especial
    public boolean usaChequeEspecial() {
        return this.chequeEspecial;
    }

    // Puxa o nome do cliente

    public String getNome() {
        return nome;
    }

    public double getValorChequeEspecial() {
        return valorChequeEspecial;
    }
}
