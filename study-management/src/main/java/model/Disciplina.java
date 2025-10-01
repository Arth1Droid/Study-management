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

	public Disciplina(long long1, String string) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.horasPlanejadas = horasPlanejadas;
	}

	public Disciplina() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getHorasPlanejadas() {
		return horasPlanejadas;
	}

	public void setHorasPlanejadas(int horasPlanejadas) {
		this.horasPlanejadas = horasPlanejadas;
	}

	@Override
	public String toString() {
		return "ID: " + id + "\nNome: " + nome + "\nHoras Planejadas: " + horasPlanejadas + "\nDescrição: " + descricao;
	}
}
