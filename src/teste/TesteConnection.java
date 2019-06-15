package teste;

import dao.Conexao;

public class TesteConnection {

	
	public static void main(String[] args) {
		
		System.out.println("Begin");
		
		Conexao.getInstance().getJdbcConnection();
		
		System.out.println("The End!");
		
	}
}
