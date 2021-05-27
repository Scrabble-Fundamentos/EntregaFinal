import java.util.ArrayList;
import java.util.Random;

public class Jugador {
    private String nombre;
    private int puntaje;
    private int cantidadDeLetrasEnMano; 
    private ArrayList <Character> letras = new ArrayList();
    private ArrayList <Integer> valor = new ArrayList(); //Una vez mostrado, se vacia

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntaje = 0;
        cantidadDeLetrasEnMano = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getCantidadDeLetrasEnMano() {
        return cantidadDeLetrasEnMano;
    }

    public void setCantidadDeLetrasEnMano(int cantidadDeLetrasEnMano) {
        this.cantidadDeLetrasEnMano = cantidadDeLetrasEnMano;
    }

    public ArrayList<Character> getLetras() {
        return letras;
    }

    public void setLetras(ArrayList<Character> letras) {
        this.letras = letras;
    }
    
    public ArrayList<Character> entregarLetras(){
        int letrasFaltantes;
        int numVocales=0;
        Random r = new Random();
        
        if(cantidadDeLetrasEnMano != 10){
            letrasFaltantes = 10 - cantidadDeLetrasEnMano;
            
            while(cantidadDeLetrasEnMano<10){ //Mientras la cantidad de letras en mano sea menor que 10
                for(int i=0;i<letras.size();i++){ //Contar la cantidad de vocales
                    if(letras.get(i)=='a'|| letras.get(i)=='e'|| letras.get(i)=='i'||letras.get(i)=='o'||letras.get(i)=='u'){
                        numVocales++;
                    }
                }
                
                while(numVocales<2 && cantidadDeLetrasEnMano<10){ //Agregar vocales si hay menos de 3 vocales
                    char c = (char)(r.nextInt(26) + 'a');
                    if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                        letras.add(c);
                        numVocales++;
                        cantidadDeLetrasEnMano++;
                    }
                }
                
                if(cantidadDeLetrasEnMano<10){
                   char c = (char)(r.nextInt(26) + 'a');
                   letras.add(c);
                   cantidadDeLetrasEnMano++;
                }   
            }
        }
        
        entregarValores(letras); //Le coloca valor a todas las letras del arreglo, en otro arreglo
        return letras;
    }
    
    public ArrayList<Integer> entregarValores(ArrayList<Character> s){ // a b c d e f // 1 3 4 1 1 5 --> 15 
        for(int i=0;i<s.size();i++){
            if(null!=s.get(i)) switch (s.get(i)) {
                case 'a':
                case 'e': 
                case 'i':
                case 'l':
                case 'n':
                case 'o':
                case 'r':
                case 's':
                case 't':
                case 'u':
                    valor.add(1);
                    break;
                case 'd':
                case 'g':
                    valor.add(2);
                    break;
                case 'b':
                case 'c':
                case 'm':
                case 'p':
                    valor.add(3);
                    break;
                case 'f':
                case 'h':
                case 'v':
                case 'y':
                case 'k':
                case 'w':
                    valor.add(4);
                    break;
                case 'q':
                    valor.add(5);
                    break;
                case 'j':
                case 'ñ':
                case 'x':
                    valor.add(8);
                    break;
                case 'z':
                    valor.add(10);
                    break;
                default:
                    break;
            }
        }
        return valor;
    }
    
    public void mostrarLetras(){
        System.out.println("\nLas letras de "+nombre+" con sus respectivos valores son: ");
        for(int i=0;i<letras.size();i++){
            System.out.print(letras.get(i)+" ");
        }
        
        System.out.println(" ");
        for(int i=0;i<valor.size();i++){
            System.out.print(valor.get(i)+" ");
        }
        
        valor.clear();
    }
    
    
    public int[] valorPalabras(ArrayList<String> a){
        int[] valorComparadas = new int[a.size()];
        int total=0;
        for(int i=0;i<a.size();i++){
            for(int k=0;k<a.get(i).length();k++){
                if(a.get(i).charAt(k)=='a'||a.get(i).charAt(k)=='e'||a.get(i).charAt(k)=='i'||a.get(i).charAt(k)=='l'||a.get(i).charAt(k)=='o'||a.get(i).charAt(k)=='n'||a.get(i).charAt(k)=='r'||a.get(i).charAt(k)=='s'||a.get(i).charAt(k)=='t'||a.get(i).charAt(k)=='u'){
                    total += 1;
                }
                else if(a.get(i).charAt(k)=='d'||a.get(i).charAt(k)=='g'){
                    total += 2;
                }
                else if(a.get(i).charAt(k)=='b'||a.get(i).charAt(k)=='c'||a.get(i).charAt(k)=='m'||a.get(i).charAt(k)=='p'){
                    total += 3;
                }
                else if(a.get(i).charAt(k)=='f'||a.get(i).charAt(k)=='h'||a.get(i).charAt(k)=='v'||a.get(i).charAt(k)=='y'||a.get(i).charAt(k)=='k'||a.get(i).charAt(k)=='w'){
                    total += 4;
                }
                else if(a.get(i).charAt(k)=='q'){
                    total += 5;
                }
                else if(a.get(i).charAt(k)=='j'||a.get(i).charAt(k)=='ñ'||a.get(i).charAt(k)=='x'){
                    total += 8;
                }
                else if(a.get(i).charAt(k)=='z'){
                    total += 10;
                }
            }
            valorComparadas[i] = total;
            total = 0;
        }
        return valorComparadas;
    }
    
    public int[] ordenarMenoraMayor(int[] valoresPalabras) // los ordena de menor a mayor
    {
        int posMenor, ayuda;
        for(int i = 0; i<valoresPalabras.length-1; i++)
        {
            posMenor = i;
            for(int j = i+1; j<valoresPalabras.length; j++)
            {
                if(valoresPalabras[j]<valoresPalabras[posMenor])
                {
                    posMenor = j;
                }
            }
            ayuda = valoresPalabras[i];
            valoresPalabras[i] = valoresPalabras[posMenor];
            valoresPalabras[posMenor] = ayuda;
        }
        return valoresPalabras;
    }
    
    public int[] mejoresValores(int[] valoresOrdenados) // este método retorna un arreglo con los 10 mejores puntajes
    {
        int[] diezMejores = new int[10];
        int cantidadElementos = valoresOrdenados.length;
        
        for(int i = 0; i<10; i++) // evidentemente siempre vamos a sacar 10 elementos
        {
            diezMejores[i] = valoresOrdenados[cantidadElementos-i];
        }
        return diezMejores;
    }
    
    public void obtenerPalabrasyPuntajes(ArrayList<String> palabras, int[] valoresPalabras, int[] diezMejores)
    {
        for(int i = 0; i<10; i++)
        {
            for(int j = 0; j<valoresPalabras.length; j++)
            {
                if(valoresPalabras[j]==diezMejores[i])
                {
                    System.out.println("La palabra "+palabras.get(j)+" está entre las 10 que más puntaje da, con un puntaje de "+diezMejores[i]);
                    break;
                }
            }
        }
    }
    
    public void ingresarPalabra(String s){
        int tamaño;
        tamaño = s.length();
        //cantidadDeLetrasEnMano = cantidadDeLetrasEnMano-tamaño;
        
        char[] palabraChar = new char[tamaño];
        for(int i=0;i<tamaño;i++){
            palabraChar[i] = s.charAt(i);
        }
        
        int valorJugada=0;
        for(int i=0;i<tamaño;i++){
            if(palabraChar[i]=='a'||palabraChar[i]=='e'||palabraChar[i]=='i'||palabraChar[i]=='l'||palabraChar[i]=='o'||palabraChar[i]=='n'||palabraChar[i]=='r'||palabraChar[i]=='s'||palabraChar[i]=='t'||palabraChar[i]=='u'){
                        valorJugada += 1;
            }
            else if(palabraChar[i]=='d'||palabraChar[i]=='g'){
                    valorJugada += 2;
            }
            else if(palabraChar[i]=='b'||palabraChar[i]=='c'||palabraChar[i]=='m'||palabraChar[i]=='p'){
                    valorJugada += 3;
            }
            else if(palabraChar[i]=='f'||palabraChar[i]=='h'||palabraChar[i]=='v'||palabraChar[i]=='y'||palabraChar[i]=='k'||palabraChar[i]=='w'){
                    valorJugada += 4;
            }
            else if(palabraChar[i]=='q'){
                    valorJugada += 5;
            }
            else if(palabraChar[i]=='j'||palabraChar[i]=='ñ'||palabraChar[i]=='x'){
                    valorJugada += 8;
            }
            else if(palabraChar[i]=='z'){
                    valorJugada += 10;
            }
        }
        
        /*for(int i=0;i<tamaño;i++){
            for(int k=0;k<letras.size();k++){
                if(palabraChar[i]==letras.get(k)){
                    letras.remove(k);
                }
            }
        }
        */
        
        System.out.println("El valor obtenido por la jugada es: "+valorJugada);
        puntaje = puntaje + valorJugada;
        System.out.println("El puntaje acumulado de "+nombre+" es "+puntaje);
    }
    
    public void quitarLetrasDeLaMano(String s){
        int tamaño;
        tamaño = s.length();
        cantidadDeLetrasEnMano = cantidadDeLetrasEnMano-tamaño;
        
        char[] palabraChar = new char[tamaño];
        for(int i=0;i<tamaño;i++){
            palabraChar[i] = s.charAt(i);
        }
        
        for(int i=0;i<tamaño;i++){
            for(int k=0;k<letras.size();k++){
                if(palabraChar[i]==letras.get(k)){
                    letras.remove(k);
                    break;
                }
            }
        }
    }
}
