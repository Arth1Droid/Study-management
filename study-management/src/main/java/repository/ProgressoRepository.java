package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Progresso;
import model.TarefaEstudo;

public class ProgressoRepository {

	private final Connection connection;

	public ProgressoRepository(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Progresso progresso) throws SQLException {
		String sql = "INSERT INTO progresso (tarefa_id, percentual, comentario) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setLong(1, progresso.getTarefa().getId());
			stmt.setString(3, progresso.getComentario());
			stmt.executeUpdate();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					progresso.setId(rs.getLong(1));
				}
			}
		}
	}

	public List<Progresso> listar() throws SQLException {
		List<Progresso> progressos = new ArrayList<>();
		String sql = "SELECT * FROM progresso";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Progresso progresso = new Progresso();
				progresso.setId(rs.getLong("id"));
				progresso.setComentario(rs.getString("comentario"));
				// Busca da tarefa associada
				TarefaEstudo tarefa = new TarefaEstudo();
				tarefa.setId(rs.getLong("tarefa_id"));
				progresso.setTarefa(tarefa);
				progressos.add(progresso);
			}
		}
		return progressos;
	}

	public void atualizar(Progresso progresso) throws SQLException {
		String sql = "UPDATE progresso SET tarefa_id=?, percentual=?, comentario=? WHERE id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, progresso.getTarefa().getId());
			stmt.setString(3, progresso.getComentario());
			stmt.setLong(4, progresso.getId());
			stmt.executeUpdate();
		}
	}

	public void deletar(Long id) throws SQLException {
		String sql = "DELETE FROM progresso WHERE id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
		}
	}
}
