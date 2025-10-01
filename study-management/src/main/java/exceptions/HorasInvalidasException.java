package exceptions;

public class HorasInvalidasException extends RuntimeException {

	public HorasInvalidasException() {
		super("Valor digitado inválido!");
	}

	public HorasInvalidasException(String mensagem) {
		super(mensagem);
	}
}
