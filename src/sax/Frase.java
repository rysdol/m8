package sax;

public class Frase {

	private String texto;
	private String tema;

	public Frase(String texto, String tema) {
		super();
		this.texto = texto;
		this.tema = tema;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
