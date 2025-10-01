package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;
import model.Status;
import model.TarefaEstudo;

public class TarefaEstudoRepository {

	private final Connection connection;

	public TarefaEstudoRepository(Connection connection) {
		this.connection = connection;
	}

	public void salvar(TarefaEstudo tarefa) throws SQLException {
		String sql = "INSERT INTO tarefas_estudo (titulo, descricao, disciplina_id, status, data_inicio, data_termino) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, tarefa.getTitulo());
			stmt.setString(2, tarefa.getDescricao());
			stmt.setLong(3, tarefa.getDisciplina().getId());
			stmt.setString(4, tarefa.getStatus().name());
			stmt.setDate(5, Date.valueOf(tarefa.getDataInicio()));
			stmt.setDate(6, Date.valueOf(tarefa.getDataTermino()));
			stmt.executeUpdate();

			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					tarefa.setId(rs.getLong(1));
				}
			}
		}
	}

	public List<TarefaEstudo> listar() throws SQLException {
		List<TarefaEstudo> tarefas = new ArrayList<>();
		String sql = "SELECT * FROM tarefas_estudo";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				TarefaEstudo tarefa = new TarefaEstudo();
				tarefa.setId(rs.getLong("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDescricao(rs.getString("descricao"));
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getLong("disciplina_id"));
				tarefa.setDisciplina(disciplina);
				tarefa.setStatus(Status.valueOf(rs.getString("status")));
				tarefa.setDataInicio(rs.getDate("data_inicio").toLocalDate());
				tarefa.setDataTermino(rs.getDate("data_termino").toLocalDate());
				tarefas.add(tarefa);
			}
		}
		return tarefas;
	}

	public void atualizar(TarefaEstudo tarefa) throws SQLException {
		String sql = "UPDATE tarefas_estudo SET titulo=?, descricao=?, disciplina_id=?, status=?, data_inicio=?, data_termino=? WHERE id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, tarefa.getTitulo());
			stmt.setString(2, tarefa.getDescricao());
			stmt.setLong(3, tarefa.getDisciplina().getId());
			stmt.setString(4, tarefa.getStatus().name());
			stmt.setDate(5, Date.valueOf(tarefa.getDataInicio()));
			stmt.setDate(6, Date.valueOf(tarefa.getDataTermino()));
			stmt.setLong(7, tarefa.getId());
			stmt.executeUpdate();
		}
	}

	public void deletar(Long id) throws SQLException {
		String sql = "DELETE FROM tarefas_estudo WHERE id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
		}
	}
}
