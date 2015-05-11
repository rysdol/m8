package ejemplo_listas;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class E04_ListaFicheros {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] files=new File("/home/felix/Descargas").list();
        List<String> lista=new ArrayList<String>(Array.asList(files));
        for(String f:files){
            lista.add(f);
        }
        for(String s:lista){
             System.out.println(s);
        }
        System.out.print("elige una extension: ");
        String ext=sc.next();
        for(int i=lista.size()-1;i>=0i--){
            if(item.get(i).endsWidth("."+ext)){
                lista.remove(i);
            }
        }
         for(String s:lista){
             System.out.println(s);
        }
    }
}
