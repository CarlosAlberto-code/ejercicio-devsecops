public class HistoricoDeMovimientos extends Opcion {

    private Saldo saldo;

    protected HistoricoDeMovimientos(Saldo saldo) {
        super("Historial de movimientos");
        this.saldo = saldo;
    }

    @Override
    public void ejecutar() {
        saldo.contultarHistorial();    
    }
    
}
