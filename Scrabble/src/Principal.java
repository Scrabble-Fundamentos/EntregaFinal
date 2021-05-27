
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
PROYECTO SCRABBLE FUNDAMENTOS DE PROGAMACIÓN
POR: 
Pablo Arango Castaño
Jhon Alexander Acevedo Serna
Miguel Angel Calvache Giraldo
*/

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    static Scanner entradaj2 = new Scanner(System.in);
    static Jugador j1;
    static Jugador j2;
    static Palabras palabras;
    static ArrayList<String> letrasPermutadas = new ArrayList(); //Si se vacia //Todas las posibles opciones
    static ArrayList<String> dicciona = new ArrayList();//No se vacia //Diccio
    static ArrayList<String> comparadas = new ArrayList(); //Si se vacia //Es las comparadas que estan bien, encuentran que son iguales en diccionario y permutadas
    static ArrayList<Character> letrasEnTablero = new ArrayList();
    static Listadiccionario diccionario;
    static int[] valorPosiblesPalabras;
    static int[] mejoresDiez = new int[10];
    static Tablero tablero  = new Tablero();;
    static String palabra, casilla;
    
    public static void main(String[] args) {
        //diccionario.leerDiccionario("listado.txt"); //AQUI VA EL 
        //dicciona = diccionario.getDiccionario();
        
        tablero.llenarTableroInicial();
        
        
        System.out.println(".:BIENVENIDO AL JUEGO SCRABBLE:.");
        System.out.print("Para comenzar ingrese el nombre del jugador 1: ");
        j1 = new Jugador(entrada.nextLine());
        
        System.out.print("Ingrese el nombre del jugador 2: ");
        j2 = new Jugador(entradaj2.nextLine());
        
        palabras = new Palabras();
        for(int i=0;i<3;i++){
            turnoJ1();
            turnoJ2();
        }
        
        System.out.println("::::::::::RESULTADOS::::::::::");
        System.out.println("\nEl puntaje de "+j1.getNombre()+" es: "+j1.getPuntaje());
        System.out.println("\nEl puntaje de "+j2.getNombre()+" es: "+j2.getPuntaje());
        
    }
    
    public static void turnoJ1(){
        tablero.imprimirTablero();
        j1.entregarLetras(); //Entrega las letras del jugador 1
        j1.mostrarLetras(); //Muestra las letras del jugador 1
        
        //CODIGO QUE MUESTRA LAS 10 MEJORES POSIBILIDADES
        /*
        letrasPermutadas = palabras.ConvertirAStringYPermuta(j1,letrasEnTablero); //Encuentra todas las posibles combinaciones de las letras y una letra del tablero si hay
        System.out.println();
        comparadas = palabras.compararDiccionarioConPermutaciones(letrasPermutadas,dicciona); //Compara las posibles combinaciones con el diccionario y se obtiene un array dinamico con las opciones
        valorPosiblesPalabras = new int[comparadas.size()];
        valorPosiblesPalabras = j1.valorPalabras(comparadas);
        valorPosiblesPalabras = j1.ordenarMenoraMayor(valorPosiblesPalabras);
        mejoresDiez = j1.mejoresValores(valorPosiblesPalabras); 
        j1.obtenerPalabrasyPuntajes(comparadas, valorPosiblesPalabras, mejoresDiez); //Muestras las 10 palabras con mayor puntaje
        */
        
        //CODIGO PARA AGREGAR LA PALABRA Y LLENAR TABLERO
        System.out.print("\nIngrese la palabra: ");
        palabra = entrada.nextLine();
        j1.ingresarPalabra(palabra);
        llenarLetrasEnTablero();
        j1.quitarLetrasDeLaMano(palabra);
        for(int i=0;i<palabra.length();i++){
            letrasEnTablero.add(palabra.charAt(i));
        }
        
        //ARREGLOS QUE SON NECESARIOS VACIAR CADA TURNO
        comparadas.clear();
        letrasPermutadas.clear();
        Palabras.variantes.clear();
        Palabras.variantesFinal.clear();
    }
    
    public static void turnoJ2(){
        tablero.imprimirTablero();
        j2.entregarLetras();
        j2.mostrarLetras();
        
        //CODIGO QUE MUESTRA LAS 10 MEJORES POSIBILIDADES
        /*
        letrasPermutadas = palabras.ConvertirAStringYPermuta(j2,letrasEnTablero); //Encuentra todas las posibles combinaciones de las letras
        System.out.println();
        comparadas = palabras.compararDiccionarioConPermutaciones(letrasPermutadas,dicciona); //Compara las posibles combinaciones con el diccionario y se obtiene un array dinamico con las opciones
        valorPosiblesPalabras = new int[comparadas.size()];
        valorPosiblesPalabras = j2.valorPalabras(comparadas);
        valorPosiblesPalabras = j2.ordenarMenoraMayor(valorPosiblesPalabras);
        mejoresDiez = j2.mejoresValores(valorPosiblesPalabras);
        j2.obtenerPalabrasyPuntajes(comparadas, valorPosiblesPalabras, mejoresDiez); //Muestras las 10 palabras con mayor puntaje
        */
        
        //CODIGO PARA AGREGAR LA PALABRA Y LLENAR TABLERO
        System.out.print("\nIngrese la palabra: ");
        palabra = entrada.nextLine();
        j2.ingresarPalabra(palabra);
        llenarLetrasEnTablero();
        j2.quitarLetrasDeLaMano(palabra);
        for(int i=0;i<palabra.length();i++){
            letrasEnTablero.add(palabra.charAt(i));
        }
        
        //ARREGLOS QUE SON NECESARIOS VACIAR CADA TURNO
        comparadas.clear();
        letrasPermutadas.clear();
        Palabras.variantes.clear();
        Palabras.variantesFinal.clear();
    }
    
    public static void llenarLetrasEnTablero(){
        
        tablero.imprimirTablero();
        System.out.println("Ingrese las letras que va a utilizar (INGRESAR LAS LETRAS SIN ESPACIOS ej: iobfs)");
        palabra = entrada.nextLine();
        
        for(int i=0;i<palabra.length();i++){
            System.out.println("");
            System.out.println("¿En que casilla desea ingresar la letra "+palabra.charAt(i)+"?");
            casilla = entrada.nextLine();
            tablero.agregarLetraATablero(tablero.getTablero(), casilla, palabra.charAt(i));
        }
    }
}
