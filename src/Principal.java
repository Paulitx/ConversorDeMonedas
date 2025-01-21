import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    private ConvertirMoneda convertir = new ConvertirMoneda();

    public void menu() {
        try {
            System.out.println("Cargando datos de monedas...");

            String jsonMoneda;
            Set<String> codigosMonedas = Set.of("CRC", "USD", "CAD", "ARS", "AUD");

            jsonMoneda = ConsultaMoneda.obtenerCodigo();
            TraductorJson consultaMoneda = new TraductorJson(jsonMoneda);
            Map<String, Double> filtroMonedas = consultaMoneda.filtrarMonedas(codigosMonedas);

            int opcion = -1;
            while (opcion != 0) {
                var menu = """
                        --------------------Menu-Conversor--------------------
                        1- CRC - Colón costarricense -> USD - Dólar estadounidense
                        2- CRC - Colón costarricense -> CAD - Dólar canadience
                        3- CRC - Colón costarricense -> ARS - Peso argentino
                        4- CRC - Colón costarricense -> AUD - Dólar australiano
                        5- USD - Dólar estadounidense -> CRC - Colón costarricense
                        6- USD - Dólar estadounidense -> CAD - Dólar canadience
                        7- USD - Dólar estadounidense -> ARS - Peso argentino
                        8- USD - Dólar estadounidense -> AUD - Dólar australiano
                        9- CAD - Dólar canadience -> USD - Dólar estadounidense
                        10- CAD - Dólar canadience -> CRC - Colón costarricense
                        11- CAD - Dólar canadience -> ARS - Peso argentino
                        12- CAD - Dólar canadience -> AUD - Dólar australiano
                        13- ARS - Peso argentino -> CRC - Colón costarricense
                        14- ARS - Peso argentino -> CAD - Dólar canadience
                        15- ARS - Peso argentino -> USD - Dólar estadounidense
                        16- ARS - Peso argentino -> AUD - Dólar australiano
                        17- AUD - Dólar australiano -> CRC - Colón costarricense
                        18- AUD - Dólar australiano -> CAD - Dólar canadience
                        19- AUD - Dólar australiano -> USD - Dólar estadounidense
                        20- AUD - Dólar australiano -> ARS - Peso argentino
                        0- Salir

                        Por favor ingrese una opcion: 
                        """;

                System.out.println(menu);
                opcion = sc.nextInt();
                sc.nextLine();

                Double monedaBase = null;
                Double monedaObjetivo = null;

                switch (opcion) {
                    case 1 -> { monedaBase = filtroMonedas.get("CRC"); monedaObjetivo = filtroMonedas.get("USD"); }
                    case 2 -> { monedaBase = filtroMonedas.get("CRC"); monedaObjetivo = filtroMonedas.get("CAD"); }
                    case 3 -> { monedaBase = filtroMonedas.get("CRC"); monedaObjetivo = filtroMonedas.get("ARS"); }
                    case 4 -> { monedaBase = filtroMonedas.get("CRC"); monedaObjetivo = filtroMonedas.get("AUD"); }
                    case 5 -> { monedaBase = filtroMonedas.get("USD"); monedaObjetivo = filtroMonedas.get("CRC"); }
                    case 6 -> { monedaBase = filtroMonedas.get("USD"); monedaObjetivo = filtroMonedas.get("CAD"); }
                    case 7 -> { monedaBase = filtroMonedas.get("USD"); monedaObjetivo = filtroMonedas.get("ARS"); }
                    case 8 -> { monedaBase = filtroMonedas.get("USD"); monedaObjetivo = filtroMonedas.get("AUD"); }
                    case 9 -> { monedaBase = filtroMonedas.get("CAD"); monedaObjetivo = filtroMonedas.get("USD"); }
                    case 10 -> { monedaBase = filtroMonedas.get("CAD"); monedaObjetivo = filtroMonedas.get("CRC"); }
                    case 11 -> { monedaBase = filtroMonedas.get("CAD"); monedaObjetivo = filtroMonedas.get("ARS"); }
                    case 12 -> { monedaBase = filtroMonedas.get("CAD"); monedaObjetivo = filtroMonedas.get("AUD"); }
                    case 13 -> { monedaBase = filtroMonedas.get("ARS"); monedaObjetivo = filtroMonedas.get("CRC"); }
                    case 14 -> { monedaBase = filtroMonedas.get("ARS"); monedaObjetivo = filtroMonedas.get("CAD"); }
                    case 15 -> { monedaBase = filtroMonedas.get("ARS"); monedaObjetivo = filtroMonedas.get("USD"); }
                    case 16 -> { monedaBase = filtroMonedas.get("ARS"); monedaObjetivo = filtroMonedas.get("AUD"); }
                    case 17 -> { monedaBase = filtroMonedas.get("AUD"); monedaObjetivo = filtroMonedas.get("CRC"); }
                    case 18 -> { monedaBase = filtroMonedas.get("AUD"); monedaObjetivo = filtroMonedas.get("CAD"); }
                    case 19 -> { monedaBase = filtroMonedas.get("AUD"); monedaObjetivo = filtroMonedas.get("USD"); }
                    case 20 -> { monedaBase = filtroMonedas.get("AUD"); monedaObjetivo = filtroMonedas.get("ARS"); }
                    case 0 -> System.out.println("Saliendo de la aplicación...");
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }

                if (monedaBase != null && monedaObjetivo != null) {
                    realizarConversion(monedaBase, monedaObjetivo); // Llama a realizarConversion.
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void realizarConversion(Double monedaBase, Double monedaObjetivo) {
        System.out.println("Ingrese la cantidad en la moneda base:");
        double cantidad = sc.nextDouble(); // Pregunta la cantidad a convertir.
        double total = convertir.convertirMoneda(monedaBase, monedaObjetivo, cantidad); // Realiza la conversión.
        System.out.printf("El total convertido es: %.2f%n", total); // Muestra el resultado.
    }
}
