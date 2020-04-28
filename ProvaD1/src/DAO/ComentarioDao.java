package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;
import model.Noticia;

public class ComentarioDao {
	public static void criar(Comentario comentario) {	
		String sqlInsert = "INSERT INTO comentario "
				+ " (nome, texto, fk_noticia_id) "
				+ " VALUES (?, ?, ?)";	
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			

			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getText());
			stm.setInt(3, comentario.getIdNoticia());
	
			stm.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular "
					+ "a tabela Pagamento.");
			ex.printStackTrace();
			
		}
			
	}
	public Comentario consultar(int id) {
		
		String sqlInsert = "SELECT * FROM comentario "
				+ " WHERE id = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, id);
			ResultSet resultado = stm.executeQuery();
			
			Comentario c  = new Comentario();
			if (resultado.next()) {
				c.setNome(resultado.getString("nome"));
				c.setText(resultado.getString("texto"));
				c.setIdNoticia(resultado.getInt("fk_noticia_id"));
				c.setId(id);
			}
			return c;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
			return null;
		}
	}
	public ArrayList<Comentario> listarComentarios(int idNoticia) {
		
		String sqlInsert = "SELECT * FROM comentario "
				+ " WHERE fk_noticia_id = ? ORDER BY id DESC";
		
		
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, idNoticia);
			ResultSet resultado = stm.executeQuery();
			
			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario c = new Comentario();
				c.setNome(resultado.getString("nome"));
				c.setText(resultado.getString("texto"));
				lista.add(c);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
