
package GomezPalaciosDaniela;

class EventoCena extends EventoBase {
    private String tipoMenu;
    private boolean incluyeVinos;

    public EventoCena(String fecha, String horaInicio, String horaFin,
                      String ubicacion, double precioBase, int cantidadPersonas,
                      boolean incluyeEntretencion, String tipoMenu, boolean incluyeVinos) {
        super(fecha, horaInicio, horaFin, ubicacion, precioBase,
                cantidadPersonas, incluyeEntretencion);
        this.tipoMenu = tipoMenu;
        this.incluyeVinos = incluyeVinos;
    }

    @Override
    String obtenerTipoEvento() {
        return "Cena";
    }

    @Override
    public double calcularPrecioTotal() {
        double precio = precioBase;
        if (incluyeEntretencion) {
            precio += 80000;
        }
        if (incluyeVinos) {
            precio += cantidadPersonas * 15000; // Costo adicional por vinos
        }
        return precio;
    }
}
