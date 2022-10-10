
public class ConsultarSaldo extends Opcion{

    private Saldo saldo;

    protected ConsultarSaldo(Saldo saldo) {
        super("Consulta de saldo");
        this.saldo = saldo;
    }

    @Override
    public void ejecutar() {
        saldo.consultarSaldoActual();
    }
    
}
