public abstract class Opcion {
    protected final String titulo;
    
    protected Opcion(String titulo){
        this.titulo = titulo;
    }
    
    public void mostar(int posicion){
        System.out.println("\n" + posicion+". "+titulo);
    }
    
    public abstract void ejecutar();
}
