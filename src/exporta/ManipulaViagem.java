package exporta;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.text.NumberFormatter;

import entidade.Viagem;

public class ManipulaViagem {

	public static String geraArquivoSequencial( List<Viagem> viagens ) {
		
		StringBuilder builder = new StringBuilder();
		
		for ( Viagem viagem : viagens ) {
			
			builder.append(viagem.getId());
			builder.append(";");
			builder.append(viagem.getLocalDe().getDescricao());
			builder.append(";");
			builder.append(viagem.getLocalPara().getDescricao());
			builder.append(";");
			
			NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
			
			int diasViagem = getDiasViagem(viagem.getDataSaida().getTime(), viagem.getDataVolta().getTime());

			double valorTotal = diasViagem * viagem.getLocalPara().getPrecoDia();
			
			builder.append(format.format(valorTotal));
			builder.append(";\n");
		}
		
		return builder.toString();
	}
	
	private static int getDiasViagem(long t1, long t2) {
	    return (int) ((t2 - t1) / (1000 * 60 * 60 * 24));
	} 
	
}
