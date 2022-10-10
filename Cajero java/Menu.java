import java.util.Scanner;

public class Menu {

    private Opcion[] opciones;

    private int cantidad;

    private Salir salir;

    public Menu() {
        opciones = new Opcion[10];
        cantidad = 0;
        salir = new Salir();
    }

    public void agregarOpcion(Opcion opcion) {
        opciones[cantidad] = opcion;
        cantidad++;
    }

    public void cerrar() {
        this.agregarOpcion(salir);
    }

    public void mostrar() {
        for (int i = 0; i < cantidad; i++) {
            opciones[i].mostar(i + 1);
        }
    }

    public boolean terminado() {
        return salir.ejecutada();
    }

    private boolean opcionValida(int opcion) {
        boolean esValido = false;
        esValido = 0 < opcion && opcion <= cantidad;
        return esValido;
    }

    public Opcion getOpcion() {
        int opcion = 0;
        boolean error = true;
        do {
            System.out.print("\nOpcion? [1-" + cantidad + "]: ");
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt()){
                opcion = sc.nextInt();
                error = !opcionValida(opcion);
                if (error){
                    System.out.println("-- Error!!! La opcion debe ser entre 1 y " + cantidad);
                }
            }else{
                System.out.println("-- Eso no es un numero, ingresa una opcion valida");
            }
        } while (error);
        return opciones[opcion-1];
    }
}
