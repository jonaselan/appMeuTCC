package br.ifrn.meutcc.persistencia;
import java.sql.Connection;

public abstract class Conexao {
	public abstract void conectarBD();
	public abstract Connection getConexaoBD();
}
