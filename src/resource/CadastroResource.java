package resource;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import dao.LocalDao;
import dao.ViagemDao;
import entidade.Local;
import entidade.Viagem;
import exporta.ManipulaViagem;
import service.CadastroService;

@Path("/cadastro")
public class CadastroResource {
	
	//http://localhost:8085/ProjetoTurismo/resource/cadastro/findLocal/2

	@GET
	@Path("/local/{descricao}/{precoDia}")
	public void cadastraLocal(@PathParam("descricao") String descricao, @PathParam("precoDia") double precoDia) {

		Local local = new Local(descricao, precoDia);

		CadastroService.salvaLocal(local);
	}

	@GET
	@Path("/viagem/{localde}/{localpara}/{dataSaida}/{dataVolta}")
	public void cadastraViagem(@PathParam("localde") int idLocalDe, @PathParam("localpara") int idLocalPara,
			@PathParam("dataSaida") Date dataSaida, @PathParam("dataVolta") Date dataVolta) {

		Local localDe = CadastroService.getLocalById(idLocalDe);
		Local localPara = CadastroService.getLocalById(idLocalPara);

		Viagem viagem = new Viagem(localDe, localPara, dataSaida, dataVolta);

		CadastroService.salvaViagem(viagem);
	}

	@GET
	@Path("/geraTexto")
	public String geraTxtViagem() {

		List<Viagem> viagens = CadastroService.getViagens();

		return ManipulaViagem.geraArquivoSequencial(viagens);
	}

	@GET
	@Path("/find/{id}")
	public Response getViagenById(@PathParam("id") int id) {
		try {
			return  Response.status(201).entity(new ViagemDao().getViagensById(id)).build();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Path("/findLocal/{id}")
	public Response getLocalById(@PathParam("id") int id) {
		try {
			return  Response.status(201).entity(new LocalDao().getById(id)).build();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
