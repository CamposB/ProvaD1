package service;

import DAO.NoticiaDAO;
import model.Noticia;
import java.util.ArrayList;
public class NoticiaService {
	public static void cadastrarService(Noticia noticia){
		NoticiaDAO nD = new NoticiaDAO();
		nD.criar(noticia);
	}
	public static void excluirService(int id){
		NoticiaDAO nD = new NoticiaDAO();
		nD.excluir(id);
	}
	
	public static Noticia buscarService(int id){
		NoticiaDAO nD = new NoticiaDAO();
		Noticia n = nD.consultar(id);
		return n;
	}
	public static ArrayList<Noticia> listarNoticias(){
		NoticiaDAO nD = new NoticiaDAO();
		return nD.listarNoticias();
	}
	public static void alterarService(Noticia noticia){
		NoticiaDAO nD = new NoticiaDAO();
		nD.alterar(noticia);
	}

}
