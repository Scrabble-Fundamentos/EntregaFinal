
public class Tablero {
    String[][] tablero = new String[15][15];
    
    public void llenarTableroInicial(){
        int numero=0;
        String n;
        for(int i=0;i<15;i++){
            for(int k=0;k<15;k++){
                if(numero<10){
                    n = "00"+Integer.toString(numero);
                    tablero[i][k] = n;
                    numero++;
                }
                else if(numero>=10&&numero<100){
                    n = "0"+Integer.toString(numero);
                    tablero[i][k] = n;
                    numero++;
                }
                else{
                n = Integer.toString(numero);
                tablero[i][k] = n;
                numero++;
                }
            }
        }
    }
    
    
    public void imprimirTablero(){
        for(int i=0;i<15;i++){
            for(int k=0;k<15;k++){
                System.out.print("|"+tablero[i][k]+"| ");
            }
            System.out.println("");
        }
    }
    
    public void agregarLetraATablero(String[][] a ,String casilla, char letra){
        for(int i=0;i<15;i++){
            for(int k=0;k<15;k++){
                if(tablero[i][k].equals(casilla)){; 
                    tablero[i][k] = " "+letra+" ";
                }
            }
        }
        imprimirTablero();
    }
    
    public String[][] getTablero() {
        return tablero;
    }
    
    
}
