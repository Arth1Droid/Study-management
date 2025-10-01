package model;

public class Progresso {
	private Long id;
	private TarefaEstudo tarefa;
	private int horasEstudadas;
	private String comentario;

	public Progresso(TarefaEstudo tarefa, int horasEstudadas, String comentario) {
		this.tarefa = tarefa;
		this.horasEstudadas = horasEstudadas;
		this.comentario = comentario;
	}

	public Progresso() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TarefaEstudo getTarefa() {
		return tarefa;
	}

	public void setTarefa(TarefaEstudo tarefa) {
		this.tarefa = tarefa;
	}

	public int getHorasEstudadas() {
		return horasEstudadas;
	}

	public void setHorasEstudadas(int horasEstudadas) {
		this.horasEstudadas = horasEstudadas;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "ID: " + id + "Tarefa: " + tarefa.getTitulo() + "Horas Estudadas: " + horasEstudadas + "Comentário: "
				+ comentario;
	}

}
