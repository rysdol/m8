package sax;

import java.util.ArrayList;
import java.util.List;

public class Autor {

	private String nombre;
	private String url;
	private String desc;
	
	private List<Frase> frases = new ArrayList<Frase>();

	public Autor(String nombre, String url, String desc) {
		this.nombre = nombre;
		this.url = url;
		this.desc = desc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Frase> getFrases() {
		return frases;
	}

}
