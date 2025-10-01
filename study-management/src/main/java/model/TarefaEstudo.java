package model;

import java.time.LocalDate;

public class TarefaEstudo {
	private Long id;
	private String titulo;
	private String descricao;
	private Disciplina disciplina;
	private Status status;
	private LocalDate dataInicio;
	private LocalDate dataTermino;

	public TarefaEstudo(String titulo, String descricao, Disciplina disciplina, LocalDate dataInicio,
			LocalDate dataTermino) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.disciplina = disciplina;
		this.status = Status.PENDENTE;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	public TarefaEstudo() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina discipina) {
		this.disciplina = discipina;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\nTitulo: " + titulo + "\nDisciplina: " + disciplina.getNome() + "\nStatus: " + status
				+ "\nData Inicio: " + dataInicio + "\nData Termino: " + "\nDescrição: " + descricao;
	}

}
