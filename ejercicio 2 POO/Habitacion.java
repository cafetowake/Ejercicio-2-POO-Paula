public class Habitacion {
    private int numero;
    private int capacidad;
    private double precio;
    private boolean ocupada;

    public Habitacion(int numero, int capacidad, double precio) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.precio = precio;
        this.ocupada = false;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public String toString() {
        return "Habitación #" + numero + " (Capacidad: " + capacidad + ")";
    }

    public void setOcupante(Cliente cliente) {
    }

    public Cliente getOcupante() {
        return null;
    }
}
