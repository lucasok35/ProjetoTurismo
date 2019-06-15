package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.LocalDao;
import dao.ViagemDao;
import entidade.Local;
import entidade.Viagem;

public class CadastroService {
	
	
	public static void salvaLocal( Local local ) {
		
		try {
			new LocalDao().salva(local);
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
	
	
	public static void salvaViagem( Viagem viagem ) {
		
		try {
			new ViagemDao().salva(viagem);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static Local getLocalById( int idLocal ) {
		
		Local local = null;
		
		try {
			local = new LocalDao().getById(idLocal);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		if ( local == null ) {
			throw new RuntimeException( "Local não encontrado para o código " + idLocal );
		}
		
		return local;
	}
	
	
	public static List<Viagem> getViagens() {
		
		try {
			return new ViagemDao().getViagens();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
