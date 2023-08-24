public class Cliente {
    private String nombre;
    private int visitas;
    private String categoria;

    public Cliente(String nombre, int visitas) {
        this.nombre = nombre;
        this.visitas = visitas;
    }

    public String getCategoria() {
        if (visitas >= 10) {
            return "VIP";
        } else if (visitas >= 5) {
            return "FRECUENTE";
        } else {
            return "REGULAR";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getVisitas() {
        return visitas;
    }

    public void incrementarVisitas() {
        visitas++;
    }


    public String toString() {
        return nombre + " (" + categoria + ")";
    }
}
