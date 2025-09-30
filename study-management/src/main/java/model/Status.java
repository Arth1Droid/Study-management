package model;

public enum Status {
	PENDENTE("Pendente"), EM_PROGRESSO("Em Progresso"), CONCLUIDA("Concluída");

	private final String status;

	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
