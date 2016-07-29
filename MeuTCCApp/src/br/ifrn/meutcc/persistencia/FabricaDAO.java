package br.ifrn.meutcc.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

public abstract class FabricaDAO {
	
	public abstract TemaDAO createTemaDAO();
	public abstract CandidatoDAO createCandidatoDAO();

	public static FabricaDAO getFabrica() throws FileNotFoundException, IOException {
		Properties config = new Properties();
		FileInputStream file = new FileInputStream("C:/Users/Jonas Elan/Desktop/appMeuTCC/MeuTCCApp/properties/banco.properties");
		config.load(file);
		String jdbc = config.getProperty("jdbc");
		switch (jdbc) {
		case "mysql":
			return FabricaMySQL.getInstancia(config);
		default:
			break;
		} 
		return null;
	}
}
