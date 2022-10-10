import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Saldo {

    private double monto;
    private List<String> movimientos;

    public Saldo() {
        this.monto = 1000;
        movimientos = new ArrayList<String>();
    }

    public void consultarSaldoActual() {
        System.out.println("\n--- Tu saldo actual es de: " + this.monto + " \n");
    }

    public void contultarHistorial() {
        System.out.println("\n-- Historial de movimientos");
        for (String movimiento : movimientos) {
            System.out.println(movimiento);
        }
        System.out.println("\n");
    }

    public void mensajeDeExito() {
        System.out.println("\n-- Operacion realizada con exito -- \n");
    }

    private void registrarOperacion(double montoRetidado) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder("--Fecha: ");
        sb.append(myDateObj.format(myFormatObj));
        sb.append(" Monto retirado: ");
        sb.append(montoRetidado);
        sb.append(" Saldo Anterior: ");
        sb.append(this.monto);
        sb.append("\n");
        movimientos.add(sb.toString());
        this.mensajeDeExito();
    }

    private void disminuirSaldo(double montoARetirar) {
        this.monto -= montoARetirar;
    }

    private void solicitarMontoARetirar() {
        boolean error = true;
        do {
            System.out.println("\n-- Denominaciones disponibles: 50, 100, 200 y 500");
            System.out.println("-- Saldo actual: " + this.monto);
            System.out.print("-- Ingresa el monto a retirar: ");
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextDouble()){
                double montoDeRetiro = sc.nextDouble();
                if (montoDeRetiro % 50 == 0) {
                    this.registrarOperacion(montoDeRetiro);
                    this.disminuirSaldo(montoDeRetiro);
                    error = false;
                }else {
                    System.out.println("-- No existen billetes de esa dominacion, no podemos darte esa cantidad");
                }
            }else{
                System.out.println("-- Eso no es un numero, ingresa una opcion valida");
            }
        } while (error);
    }

    public void retirar() {
        if (monto > 0) {
            this.solicitarMontoARetirar();
        } else {
            System.out.println("\n-- Saldo insuficiente");
        }
    }

}
