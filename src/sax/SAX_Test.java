package sax;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAX_Test extends DefaultHandler{

	public static void main(String[] args) {
		
		SAX_Test test=new SAX_Test();
		test.run();
	}
	private String tag;
	private List<Autor> autores;	
	public void run(){
		try{
			autores=new ArrayList<Autor>();
			//Creamos la factoria de parseadores por defecto
			XMLReader reader=XMLReaderFactory.createXMLReader();
			//Añadimos nuestros manejador al reader
			reader.setContentHandler(this);
			//Procesamos el xml de ejemplo
			reader.parse(new InputSource(new FileInputStream("frases.xml")));
			for(Autor a:autores){
				System.out.println("AUTOR : " + a.getNombre()); //nombre dentro de a
				System.out.println("DESCR : " + a.getDesc()); //dentro de span
				System.out.println("URL   : " + a.getUrl()); //href
				System.out.println();
				for(Frase f:a.getFrases()){
					System.out.println(" - " + f.getTexto()); //<div class="texto_frase">
					System.out.println("   (" + f.getTema() + ")"); //  <a href="/frases-de-esperanza">Esperanza</a>
					
					System.out.println();
				}
			}
		}catch(SAXException e){
			
		}catch(IOException e){
			
		}
	}
	Autor autor;
	Frase frase=new Frase("", "");
//	String url;
	String texto;
//	String nombre;
//	String descripcion;
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
//		tag=localName;
//			if(localName.equals("nombre")){
//				System.out.print("AUTOR :");
//			}
//			if(localName.equals("descripcion")){
//				System.out.print("Descripcion:");
//			}
			switch(localName){
			case "autor":
				autor=new Autor("",attributes.getValue("url"),"");
				break;
			case "frase":
				frase=new Frase("","");
				break;
			}
			if(localName.equals("autor")){
				
				//url=attributes.getValue("url");
			}
			//System.out.println("Start "+localName);
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//System.out.println("End "+localName);
//		tag="";
		switch(localName){
		case "nombre":
			//nombre=texto;
			autor.setNombre(texto);
			break;
		case "descripcion":
			//descripcion=texto;
			autor.setDesc(texto);
			break;
		case "autor":
			autores.add(autor);
			break;
		case "tema":
			frase.setTema(texto);
			break;
		case "texto":
			frase.setTexto(texto);
			break;
		case "frase":
			autor.getFrases().add(frase);
			break;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		texto=new String(ch,start,length);
//		if(tag.equals("nombre")){
//			String texto=new String(ch,start,length);
//			System.out.println(texto);
//		}
//		if(tag.equals("descripcion")){
//			String texto=new String(ch,start,length);
//			System.out.println(texto);
//		}
//		if(tag.equals("url")){
//			String texto=new String(ch,start,length);
//			System.out.println(texto);
//		}
	}
}
