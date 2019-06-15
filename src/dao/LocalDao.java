package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidade.Local;

public class LocalDao {

	public void salva(Local local) throws SQLException {

		Connection conexao = Conexao.getInstance().getJdbcConnection();

		PreparedStatement stat = conexao.prepareStatement("INSERT INTO local ( descricao, valor ) VALUES ( ?, ? )");
		stat.setString(1, local.getDescricao());
		stat.setDouble(2, local.getPrecoDia());

		stat.execute();
	}

	public Local getById(int idLocal) throws SQLException {

		Connection conexao = Conexao.getInstance().getJdbcConnection();
		PreparedStatement stat = conexao.prepareStatement("SELECT * FROM local WHERE id = ?");
		stat.setInt(1, idLocal);

		ResultSet rs = stat.executeQuery();
		Local local = null;
		if (rs.next()) {
			local = new Local(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("valor"));
		}
		return local;
	}
}
