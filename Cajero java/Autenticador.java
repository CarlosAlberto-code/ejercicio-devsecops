import java.util.Scanner;

public class Autenticador {

    private static final String PIN = "123";
    private int intentos = 3;

    public boolean esValido(){
        boolean autenticado = false;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.print("-- Ingresa tu PIN para acceder al sistema: ");
            String entrada = scanner.nextLine();
            if(entrada.equals(PIN)){
                autenticado = true;
            }else{
                intentos--;
            }
        }while(intentos > 0 && !autenticado);
        return autenticado;
    }

}
