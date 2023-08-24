public class Hotel {
    private Habitacion[] habitaciones;
    private Cliente[] listaEspera;

    public Hotel(int numHabitaciones) {
            habitaciones = new Habitacion[numHabitaciones];
            listaEspera = new Cliente[10];

            // Inicializar las habitaciones con datos ficticios para este ejemplo
            for (int i = 0; i < numHabitaciones; i++) {
                int numeroHabitacion = i + 1;
                int capacidad = 2 + i % 2; // Capacidad de 2 o 3 alternadamente
                double precio = 100 + i * 20; // Precio aumenta con cada habitación
                habitaciones[i] = new Habitacion(numeroHabitacion, capacidad, precio);
            }
        }



        public Habitacion[] getHabitaciones() {
            return habitaciones;
        }

        public Cliente[] getListaEspera() {
            return listaEspera;
        }
    

    public void asignarHabitacion(Cliente cliente, Habitacion habitacion) {
        if (!habitacion.isOcupada()) {
            habitacion.setOcupada(true);
            habitacion.setOcupante(cliente); // Establecer al cliente como ocupante
            System.out.println("Habitación asignada a " + cliente.getCategoria() + ": " + habitacion);
        } else {
            System.out.println("La habitación ya está ocupada.");
        }
    }


    public void reservarHabitacion(Cliente cliente, Habitacion habitacion) {
        if (!habitacion.isOcupada()) {
            habitacion.setOcupada(true);
            habitacion.setOcupante(cliente); // Establecer al cliente como ocupante
            cliente.incrementarVisitas(); // Incrementar visitas del cliente
            System.out.println(cliente.getCategoria() + " ha reservado la habitación: " + habitacion);
        } else {
            System.out.println("La habitación ya está ocupada.");
        }
    }


    public boolean verificarDisponibilidad(Habitacion habitacion) {
        return !habitacion.isOcupada();
    }

    public void mostrarHabitaciones() {
        System.out.println("Información de habitaciones:");
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion);
        }
    }

    public void mostrarOcupantes() {
        System.out.println("Información de ocupantes:");
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isOcupada()) {
                Cliente ocupante = habitacion.getOcupante();
                if (ocupante != null) {
                    System.out.println("Habitación #" + habitacion.getNumero() + " - Ocupante: " + ocupante.getNombre());
                }
            }
        }
    }


    public Habitacion getHabitacionPorNumero(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

        public Cliente getClientePorNombre(String nombre) {
        for (Cliente cliente : listaEspera) {
            if (cliente != null && cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null;
    }



        public void agregarClienteListaEspera(Cliente nuevoCliente) {
        }
}
