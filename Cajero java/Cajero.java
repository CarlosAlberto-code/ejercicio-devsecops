public class Cajero {

    private Menu menu;
    private Autenticador autenticador;
    
    public Cajero(){
        Saldo saldo = new Saldo();
        menu = new Menu();
        menu.agregarOpcion(new ConsultarSaldo(saldo));
        menu.agregarOpcion(new RetirarSaldo(saldo));
        menu.agregarOpcion(new HistoricoDeMovimientos(saldo));
        menu.cerrar();
        autenticador = new Autenticador();
    }

    private void iniciar(){
        if(autenticador.esValido()){
            do{
                menu.mostrar();
                menu.getOpcion().ejecutar();
            }while(!menu.terminado());
        }else{
            System.out.println("Maximo de intentos alcanzados intente mas tarde");
        }
    }

    public static void main(String[] args){
        new Cajero().iniciar();
    }
}
