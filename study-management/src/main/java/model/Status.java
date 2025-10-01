package model;

import exceptions.StatusInvalidoException;

public enum Status {
	PENDENTE("Pendente"), EM_PROGRESSO("Em Progresso"), CONCLUIDA("Concluída");

	private final String status;

	Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public static Status fromString(String valor) {
		for (Status s : Status.values()) {
			if (s.getStatus().equalsIgnoreCase(valor)) {
				return s;
			}
		}
		throw new StatusInvalidoException("Status inválido: " + valor);
	}

}
