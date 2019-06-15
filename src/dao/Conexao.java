package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static Conexao conexao;

	private Conexao() {
	}

	public static Conexao getInstance() {

		if (conexao == null) {
			conexao = new Conexao();
		}

		return conexao;
	}

	public Connection getJdbcConnection() {

		Connection conn = null;
		String serverName = "localhost"; // caminho do servidor do BD
		String mydatabase = "aula"; // nome do seu banco de dados
		String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
		String username = "root"; // nome de um usuário de seu BD
		String password = "123456"; // sua senha de acesso

		String driverName = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url + "?useTimezone=true&serverTimezone=UTC", username, password);
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
