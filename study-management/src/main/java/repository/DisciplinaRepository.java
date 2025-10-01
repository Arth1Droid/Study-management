package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;

public class DisciplinaRepository {

	private Connection connection;

	public DisciplinaRepository(Connection connection) {
		this.connection = connection;
	}

	// Inserir disciplina
	public void salvar(Disciplina disciplina) throws SQLException {
		String sql = "INSERT INTO DISCIPLINA (nome) VALUES (?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, disciplina.getNome());
			stmt.executeUpdate();
		}
	}

	// Buscar todas
	public List<Disciplina> buscarTodas() throws SQLException {
		List<Disciplina> disciplinas = new ArrayList<>();
		String sql = "SELECT * FROM DISCIPLINA";
		try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Disciplina d = new Disciplina(rs.getLong("id"), rs.getString("nome"));
				disciplinas.add(d);
			}
		}
		return disciplinas;
	}

	// Buscar por ID
	public Disciplina buscarPorId(Long id) throws SQLException {
		String sql = "SELECT * FROM DISCIPLINA WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Disciplina(rs.getLong("id"), rs.getString("nome"));
				}
			}
		}
		return null; // não encontrado
	}

	// Deletar
	public void deletar(Long id) throws SQLException {
		String sql = "DELETE FROM DISCIPLINA WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
		}
	}
}
