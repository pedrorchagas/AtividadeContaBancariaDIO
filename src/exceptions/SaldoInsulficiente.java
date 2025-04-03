package exceptions;

public class SaldoInsulficiente extends RuntimeException {
    public SaldoInsulficiente (String message) {
        super(message);
    }
}
