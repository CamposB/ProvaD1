package model;

public class Comentario {
	private int id;
	private String nome;
	private String text;
	private int idNoticia;
	
	public Comentario(){
		
	}

	public Comentario(int id, String nome, String text, int idNoticia) {
		super();
		this.id = id;
		this.nome = nome;
		this.text = text;
		this.idNoticia = idNoticia;
	}
	public Comentario(String nome, String text, int idNoticia) {
		super();
		this.nome = nome;
		this.text = text;
		this.idNoticia = idNoticia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
	
		
}
