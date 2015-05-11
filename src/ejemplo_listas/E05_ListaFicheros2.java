package ejemplo_listas;

import java.util.List;
import java.io.File;
import java.util.ArrayList;

public class E05_ListaFicheros2 {
    public static void main(String[] args){
        new E05_ListaFicheros2().run();
    }
    private void run(){
        File ruta= new File("/home/felix/Descargas");
	List<Fichero> lista=new ArrayList<Fichero>();
        listar(ruta,lista);
        mostrar(lista);
        lista.sort();
        Collections.sort(lista,new Comparator<Fichero>(){
            public int compare(Fichero f1, Fichero f2){
                return Integer.compare(f1.count,f2.count);
            }
        });
    }
    private void mostrar(List<Fichero> lista){
         Collections.sort(lista,new Comparator<Fichero>(){
            public int compare(Fichero f1, Fichero f2){
                return long.compare(f1.length,f2.length);
            }
        });
         System.out.println("Listado ordenado:");
         for(Fichero f:lista){
                System.out.println();
            }
        }
    }
    public static int  cont(File dir){
	File [] lista=dir.listFiles();
        int con=0;
	for(File f:lista){
            if(f.isFile()){
                //archivos[]=new File(f.getAbsolutePath());
                con++;
            }
        }
	for(File f:lista){
            if(f.isDirectory()){
		cont(f);
            }
        }
        return con;
    }
    public static void listar(File dir){
        int con=cont(dir);
        File [] lista=dir.listFiles();
        con2=0;
        for(File f:lista){
            if(f.isFile()){
                archivos[con2]=new Fichero(f.getAbsolutePath());
                con2++;
                
            }
        }
	for(File f:lista){
            if(f.isDirectory()){
		listar(f);
            }
        }
    }
    private class Fichero implements Comparable<Fichero>{
        public String ruta;
        public long length;
        private Fichero(String ruta, long length){
            this.ruta=ruta;
            this.length=length;
        }

        @Override
        public int compareTo(Fichero o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
