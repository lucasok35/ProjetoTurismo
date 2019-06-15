package entidade;
public class Local {

	private int id;
	
	private String descricao;
	
	private double precoDia;

	public Local(int id, String descricao, double precoDia) {
		this.descricao = descricao;
		this.precoDia = precoDia;
		this.id = id;
	}
	
	public Local(String descricao, double precoDia) {
		this(0,descricao,precoDia);
	}
	
	

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPrecoDia() {
		return precoDia;
	}

}
