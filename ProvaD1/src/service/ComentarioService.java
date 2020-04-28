package service;

import java.util.ArrayList;

import DAO.ComentarioDao;
import DAO.NoticiaDAO;
import model.Comentario;
import model.Noticia;


public class ComentarioService {


		public static void comentarService(Comentario c){
			ComentarioDao cD = new ComentarioDao();
			cD.criar(c);
		}
		public static Comentario buscarComentarioService(int id){
			ComentarioDao cD = new ComentarioDao();
			Comentario n = cD.consultar(id);
			return n;
		}
		public static ArrayList<Comentario> listarComentarios(int id){
			ComentarioDao cD = new ComentarioDao();
			return cD.listarComentarios(id);
		}
	

}
