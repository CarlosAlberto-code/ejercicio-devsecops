public class RetirarSaldo extends Opcion{

    private Saldo saldo;

    protected RetirarSaldo(Saldo saldo) {
        super("Retirar saldo");
        this.saldo = saldo;
    }

    @Override
    public void ejecutar() {
        saldo.retirar();
    }
    
}
