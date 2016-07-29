package br.ifrn.meutcc.persistencia;
import java.util.Properties;

public class FabricaMySQL extends FabricaDAO {

	private static FabricaMySQL instancia = null;
	private Properties config;
	
	private FabricaMySQL(Properties config) { 
		this.config = config;
	}
	
	@Override
	public TemaDAO createTemaDAO() {
		String domain = config.getProperty("domain");
		String banco =  config.getProperty("banco");
		String usuario = config.getProperty("usuario");
		String senha = config.getProperty("senha");
		ConexaoMySQL con = new ConexaoMySQL(domain, banco, usuario, senha);
		return TemaDAO.getInstancia(con);
	}

	@Override
	public CandidatoDAO createCandidatoDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static FabricaMySQL getInstancia(Properties config) {
		if (instancia == null) {
			instancia = new FabricaMySQL(config);
		}
		return instancia;
	}

}
