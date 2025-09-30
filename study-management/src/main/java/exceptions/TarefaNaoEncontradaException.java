package exceptions;

public class TarefaNaoEncontradaException extends Exception {

	public TarefaNaoEncontradaException() {
		super("Tarefa não encontrada.");
	}

	public TarefaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
}
