package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Noticia;



public class NoticiaDAO {
	public void criar(Noticia noticia) {	
		String sqlInsert = "INSERT INTO noticia "
				+ " (id, descricao, titulo, texto) "
				+ " VALUES (?, ?, ?, ?) ";	
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, noticia.getId());
			stm.setString(2, noticia.getDescricao());
			stm.setString(3, noticia.getTitulo());
			stm.setString(4, noticia.getText());
	
			stm.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular "
					+ "a tabela noticia.");
			ex.printStackTrace();
			
		}
			
	}
	
	public void excluir(int id) {
		
		String sqlInsert = "DELETE FROM noticia "
				+ " WHERE id = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, id);
			
			stm.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela noticia.");
			ex.printStackTrace();
		}
	}
	public Noticia consultar(int id) {
		
		String sqlInsert = "SELECT * FROM noticia "
				+ " WHERE id = ? ";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setInt(1, id);
			ResultSet resultado = stm.executeQuery();
			
			Noticia n = new Noticia();
			if (resultado.next()) {
				n.setTitulo(resultado.getString("titulo"));
				n.setDescricao(resultado.getString("descricao"));
				n.setText(resultado.getString("texto"));
				n.setId(id);
			}
			return n;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
			return null;
		}
	}
	public void alterar(Noticia noticia) {
		
		String sqlInsert = "UPDATE noticia "
				+ "SET titulo = ?, descricao = ?, texto = ? "
				+ " WHERE id = ? "; 
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, noticia.getTitulo());
			stm.setString(2, noticia.getDescricao());
			stm.setString(3, noticia.getText());
			stm.setInt(4, noticia.getId());
			
			stm.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
		}
	}
	public ArrayList<Noticia> listarNoticias() {
		
		String sqlInsert = "SELECT * FROM noticia";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			ResultSet resultado = stm.executeQuery();
			
			ArrayList<Noticia> lista = new ArrayList<>();
			while (resultado.next()) {
				Noticia n = new Noticia();
				n.setId(resultado.getInt("id"));
				n.setTitulo(resultado.getString("titulo"));
				n.setDescricao(resultado.getString("descricao"));
				n.setText(resultado.getString("texto"));
				lista.add(n);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
		}
	}
}
