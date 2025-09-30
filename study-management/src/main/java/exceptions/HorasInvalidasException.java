package exceptions;

public class HorasInvalidasException extends Exception {

	public HorasInvalidasException() {
		super("Valor digitado inválido!");
	}

	public HorasInvalidasException(String mensagem) {
		super(mensagem);
	}
}
