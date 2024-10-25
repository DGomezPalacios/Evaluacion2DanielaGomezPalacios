
package GomezPalaciosDaniela;

class EventoFiesta extends EventoBase {
    private String tematica;
    private boolean incluyeBarman;

    public EventoFiesta(String fecha, String horaInicio, String horaFin,
                        String ubicacion, double precioBase, int cantidadPersonas,
                        boolean incluyeEntretencion, String tematica, boolean incluyeBarman) {
        super(fecha, horaInicio, horaFin, ubicacion, precioBase,
                cantidadPersonas, incluyeEntretencion);
        this.tematica = tematica;
        this.incluyeBarman = incluyeBarman;
    }

    @Override
    String obtenerTipoEvento() {
        return "Fiesta";
    }

    @Override
    public double calcularPrecioTotal() {
        double precio = precioBase;
        if (incluyeEntretencion) {
            precio += 120000;
        }
        if (incluyeBarman) {
            precio += 150000;
        }
        return precio;
    }
}