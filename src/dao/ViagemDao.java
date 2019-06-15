package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Local;
import entidade.Viagem;

public class ViagemDao {

	public void salva(Viagem viagem) throws SQLException {

		Connection conexao = Conexao.getInstance().getJdbcConnection();

		PreparedStatement stat = conexao.prepareStatement(
				"INSERT INTO viagem ( idlocal_para, idlocal_de, data_saida, data_volta ) VALUES ( ?, ?, ?, ? )");
		stat.setInt(1, viagem.getLocalPara().getId());
		stat.setInt(2, viagem.getLocalDe().getId());
		stat.setDate(3, viagem.getDataSaida());
		stat.setDate(4, viagem.getDataVolta());

		stat.execute();
	}

	public List<Viagem> getViagens() throws SQLException {

		List<Viagem> viagens = new ArrayList<>();

		Connection conexao = Conexao.getInstance().getJdbcConnection();

		PreparedStatement stat = conexao.prepareStatement("SELECT * FROM viagem");

		ResultSet rs = stat.getResultSet();

		while (rs.next()) {

			LocalDao dao = new LocalDao();

			Local localDe = dao.getById(rs.getInt("idlocal_de"));
			Local localPa = dao.getById(rs.getInt("idlocal_para"));

			Viagem viagem = new Viagem(rs.getInt("id"), localDe, localPa, rs.getDate("data_saida"),
					rs.getDate("data_volta"));

			viagens.add(viagem);
		}

		return viagens;
	}

	public List<Viagem> getViagensById(int id) throws SQLException {

		List<Viagem> viagens = new ArrayList<>();
		Connection conexao = Conexao.getInstance().getJdbcConnection();
		PreparedStatement stat = conexao.prepareStatement("SELECT * FROM viagem where id = " + id);
		ResultSet rs = stat.getResultSet();

		while (rs.next()) {
			LocalDao dao = new LocalDao();
			Local localDe = dao.getById(rs.getInt("idlocal_de"));
			Local localPa = dao.getById(rs.getInt("idlocal_para"));
			Viagem viagem = new Viagem(rs.getInt("id"), localDe, localPa, rs.getDate("data_saida"),
					rs.getDate("data_volta"));
			viagens.add(viagem);
		}
		return viagens;
	}
}
