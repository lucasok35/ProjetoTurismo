package entidade;
import java.sql.Date;

public class Viagem {

	private int id;

	private Local localDe;
	private Local localPara;

	private Date dataSaida;
	private Date dataVolta;
	
	
	public Viagem(Local localDe, Local localPara, Date dataSaida,
			Date dataVolta) {
		this(0,localDe,localPara,dataSaida,dataVolta);
	}

	public Viagem(int id, Local localDe, Local localPara, Date dataSaida,
			Date dataVolta) {
		this.id = id;
		this.localDe = localDe;
		this.localPara = localPara;
		this.dataSaida = dataSaida;
		this.dataVolta = dataVolta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Local getLocalDe() {
		return localDe;
	}

	public void setLocalDe(Local localDe) {
		this.localDe = localDe;
	}

	public Local getLocalPara() {
		return localPara;
	}

	public void setLocalPara(Local localPara) {
		this.localPara = localPara;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Date getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}

}
