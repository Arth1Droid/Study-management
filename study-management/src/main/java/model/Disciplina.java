package model;

public class Disciplina {

	private Long id;
	private String nome;
	private String descricao;
	private int horasPlanejadas;

	public Disciplina(String nome, String descricao, int horasPlanejadas) {
		this.nome = nome;
		this.descricao = descricao;
		this.horasPlanejadas = horasPlanejadas;

	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getHorasPlanejadas() {
		return horasPlanejadas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String desccricao) {
		this.descricao = desccricao;
	}

	public void setHorasPlanejadas(int horasPlanejadas) {
		this.horasPlanejadas = horasPlanejadas;
	}

}
