
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Listadiccionario {
    private ArrayList <String> diccionario = new ArrayList<>();
    
    public void leerDiccionario(String a) {
        try {
            Scanner entrada = new Scanner(new File(a));
            while(entrada.hasNext()) {
                String lista = entrada.next();
                diccionario.add(lista);
            }
        } catch(FileNotFoundException e) {
            System.out.println("ERROR");
        }
    }

    public ArrayList<String> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(ArrayList<String> diccionario) {
        this.diccionario = diccionario;
    }
    
    
}
