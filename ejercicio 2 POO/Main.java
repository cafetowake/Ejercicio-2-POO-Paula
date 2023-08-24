import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Hotel hotel = new Hotel(10);

            while (true) {
                System.out.println("Bienvenido al sistema de reservas del hotel.");
                System.out.println("Opciones:");
                System.out.println("1. Reservar habitación");
                System.out.println("2. Asignar cliente a habitación");
                System.out.println("3. Mostrar información de habitaciones y ocupantes");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        scanner.nextLine(); // Consumir la nueva línea pendiente
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombreCliente = scanner.nextLine();
                        Cliente nuevoCliente = new Cliente(nombreCliente, 0);
                        hotel.agregarClienteListaEspera(nuevoCliente);

                        hotel.mostrarHabitaciones();
                        int numeroHabitacion = scanner.nextInt();
                        Habitacion habitacion = hotel.getHabitacionPorNumero(numeroHabitacion);

                        if (habitacion != null && hotel.verificarDisponibilidad(habitacion)) {
                            hotel.reservarHabitacion(nuevoCliente, habitacion);
                        } else {
                            System.out.println("Habitación no válida o no disponible.");
                        }
                        break;
                    case 2:
                        scanner.nextLine(); // Consumir la nueva línea pendiente
                        System.out.print("Ingrese el nombre del cliente: ");
                        String nombreClienteAsignar = scanner.nextLine();
                        Cliente clienteAsignar = hotel.getClientePorNombre(nombreClienteAsignar);

                        if (clienteAsignar != null) {
                            hotel.mostrarHabitaciones();
                            int numeroHabitacionAsignar = scanner.nextInt();
                            Habitacion habitacionAsignar = hotel.getHabitacionPorNumero(numeroHabitacionAsignar);

                            if (habitacionAsignar != null && hotel.verificarDisponibilidad(habitacionAsignar)) {
                                hotel.asignarHabitacion(clienteAsignar, habitacionAsignar);
                            } else {
                                System.out.println("Habitación no válida o no disponible.");
                            }
                        } else {
                            System.out.println("El cliente no existe.");
                        }
                        break;
                    case 3:
                        hotel.mostrarHabitaciones();
                        hotel.mostrarOcupantes();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa.");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            }
        }
    }
}
