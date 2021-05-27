
import java.util.ArrayList;


public class Palabras {
    static String[] convertir = new String[10];
    static ArrayList<String> variantes = new ArrayList(); //Toca vaciar unas vez sea usada
    static ArrayList<String> variantesFinal = new ArrayList();
    
    public ArrayList<String> ConvertirAStringYPermuta(Jugador p, ArrayList<Character> letrasEnTablero){ //AL FINAL EL ARREGLO VARIANTES QUEDA CON TODAS LAS COMBINACIONES POSIBLES DE LAS LETRAS MAS DE 6 MILLONES DE COMBINACIONES EN TOTAL
        
        
        
        for(int i=0;i<p.getLetras().size();i++){
            convertir[i] = Character.toString(p.getLetras().get(i)); //Pasa las letras del jugador a un Arreglo String
        }
        
        int r = convertir.length;
        
        for(int n=0;n<p.getLetras().size();n++){ //Hace 10 permutaciones para que los resultados sean guardados en la variable Variantes
            Perm(convertir, "", n, r); //Se manda al metodo Perm la siguiente información 10 veces, Una por cada cantidad de letras necesaria para formar la palabra
        }
        
        for(int i=0;i<variantes.size();i++){ //Le agrega las letras del tablero a cada variante, para que estas sean tomadas en cuentas para la proxima comparacion
            for(int k=0;k<letrasEnTablero.size();k++){
                variantesFinal.add(variantes.get(i)+Character.toString(letrasEnTablero.get(k)));
            }
        }
        
        return variantesFinal; //Devuelve las variantes unicamente de las que incluye las letras del tablero, excluyendo las opciones que no tienen letras puestas en el tablero
    }
   
    private void Perm(String[] e, String act, int n, int r) { //Metodo que guarda TODAS las combinaciones de las letras en variantes  
        if (n == 0) {
            variantes.add(act);
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(e[i])) { // Controla que no haya repeticiones
                    Perm(e,act+e[i], n - 1, r);
                }
            }
        }
    }
    
    
    public ArrayList<String> compararDiccionarioConPermutaciones(ArrayList<String> d, ArrayList<String> p){
        ArrayList<String> encontrados = new ArrayList();
        for(int i = 0; i<d.size(); i++)
        {
            for(int j = 0; j<p.size(); j++)
            {
                if(d.get(i).equals(p.get(j)))
                {
                    encontrados.add(d.get(i));
                }
            }
        }
        return encontrados;
    }
    
    
}

