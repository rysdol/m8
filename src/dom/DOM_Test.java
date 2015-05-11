package dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sax.Autor;
import sax.Frase;

public class DOM_Test {
	private List<Autor> autores=new ArrayList<Autor>();
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		new DOM_Test().run();
	}
	public void run() throws SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.parse(new File("frases.xml"));
		Element root=doc.getDocumentElement();
		System.out.println(root.getTagName());
		NodeList nodes=root.getChildNodes();
		for(int i=0;i<nodes.getLength();i++){
			Node node=nodes.item(i);
			if(node.getNodeType()==Node.ELEMENT_NODE){
				procesarAutor((Element)node);
			}
		}
		mostrar(autores);
	}

	private void mostrar(List<Autor> autores2) {
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
	}
	private void procesarAutor(Element elautor) {
		Autor autor=new Autor("", "", "");
		autor.setUrl(elautor.getAttribute("url"));
//		NodeList elements=elautor.getElementsByTagName("nombre");
//		autor.setNombre(elements.item(0).getTextContent());
//		elements=elautor.getElementsByTagName("descripcion");
//		autor.setDesc(elements.item(0).getTextContent());
		NodeList nodes=elautor.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node=nodes.item(i);
			if(node instanceof Element){
				switch (node.getNodeName()) {
				case "nombre":
					autor.setNombre(node.getTextContent());
					break;
				case "descripcion":
					autor.setDesc(node.getTextContent());
					break;
				case "frases":
					procesarFrases(autor,node);
					break;
				}
			}
		}
		autores.add(autor);
	}
	private void procesarFrases(Autor autor, Node node) {
		
		
	}

}
