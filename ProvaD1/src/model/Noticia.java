package model;

public class Noticia {
	private int id;
	private String titulo;
	private String descricao;
	private String text;
	public Noticia(){
		
	}
	public Noticia(int id, String titulo, String descricao, String text) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
