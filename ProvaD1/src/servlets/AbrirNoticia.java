package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ComentarioService;
import service.NoticiaService;
import model.Comentario;
import model.Noticia;
import service.NoticiaService;
import java.util.Iterator;
@WebServlet("/AbrirNoticia.do")
public class AbrirNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get data from "Notice"
		int id = Integer.parseInt(request.getParameter("id"));
		//Search on "Notice"
		Noticia n = NoticiaService.buscarService(id);
		//Get "Comments"
		Comentario c = new Comentario();
		ArrayList <Comentario> listagem = ComentarioService.listarComentarios(id);
		String listar = "";
		for (Iterator iterator = listagem.iterator(); iterator.hasNext();){
			Comentario cN = (Comentario) iterator.next(); 
			listar += "<h5>" + cN.getNome() + "</h5>";
			listar += "<p>" + cN.getText() + "<p><br>"; 
			listar += "<hr>";
		}
		
		
        request.setAttribute("noticia", n);
        request.setAttribute("comentario", listar);
        HttpSession session = request.getSession();
        session.setAttribute("id", n.getId());
        RequestDispatcher view = 
        request.getRequestDispatcher("exibir.jsp");
        view.forward(request, response);
	}

}
