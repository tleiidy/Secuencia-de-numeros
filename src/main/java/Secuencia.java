
import java.util.Scanner;


/**
 *Esta clase maneja la secuencia de numeros.
 * @author Duvan Poveda - Leidy Torres
 */
public class Secuencia {
    /**
 *Variable para el manejo de la entrada del teclado
 */
    private Scanner scanner = new Scanner(System.in);
    
    /**
    *Este metodo se encarga de recibir los numeros que el usuario ingresa
    * 
    */
    public void recibirNumeros(){
        int[] numero = new int[100];
        int contador = 0;
        String respuesta;
        do{
        
            System.out.print("Ingrese un numero:");
            numero[contador] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Desea ingresar otro numero? (si/no):");
            respuesta = scanner.nextLine();
            if(respuesta.equals("si")){
               contador =  (contador + 1);
            }
        }while(respuesta.equals("si"));
        ordenBurbuja(numero,contador);
    }
    
       /**
    *Este metodo se encarga de ordenar por el metodo de burbuja el vector recibido
    * @param numero
    * @param contador
    */
    public void ordenBurbuja(int[] numero,int contador){
        for (int x = 0; x <=contador; x++) {
            for (int i = 0; i <= contador-x-1; i++) {
                if(numero[i] < numero[i+1]){
                    int tmp = numero[i+1];
                    numero[i+1] = numero[i];
                    numero[i] = tmp;
                }
            }
        }
    int mayor = numero[0];
    int menor = numero[contador];
    System.out.println("El numero mayor es: "+mayor);
    System.out.println("El numero menor es : "+menor);
    mostrarFaltantes(numero,contador,mayor,menor);
    }
    /**
    *Este metodo se encarga de calcular los numeros faltantes e imprimirlos en pantalla
    * @param numero
    * @param contador
    * @param mayor
    * @param menor
    */
    public void mostrarFaltantes(int[] numero,int contador,int mayor,int menor){
         int[] numerosRequeridos = new int[100];
    int tamaño = mayor - menor;
    for(int i=0;i<=tamaño; i++){
        numerosRequeridos[i]=menor;
        menor = menor+1;
    }
    int[] numerosFaltan = new int[10];
    int error = 1;
    int contadorFaltantes = 0;
    for(int i=0;i<=tamaño; i++){
        error = 1;
        for(int j=0; j<=contador;j++){
            if(numerosRequeridos[i]==numero[j]){
                error = 0;
                j=contador;
            }
        }
        if(error == 1){
            for(int k=0;k<=tamaño;k++){
                if(numerosFaltan[k]==0){
                    numerosFaltan[k]=numerosRequeridos[i];
                    contadorFaltantes = contadorFaltantes + 1;
                    k= tamaño;
                   
                }
            }
        }
    }
    System.out.println("Los numeros Faltantes son:");
    for(int i=0; i<=contadorFaltantes-1;i++){
        
        System.out.println(numerosFaltan[i]);
    }
    }
}
