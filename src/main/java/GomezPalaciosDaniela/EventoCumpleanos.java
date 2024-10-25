package GomezPalaciosDaniela;
class EventoCumpleanos extends EventoBase {
    private int edadCumpleanero;

    public EventoCumpleanos(int codigo, String fecha, String horaInicio, String horaFin,
                            String ubicacion, double precioBase, int cantidadPersonas,
                            boolean incluyeEntretencion, int edadCumpleanero) {
        super(codigo, fecha, horaInicio, horaFin, ubicacion, precioBase,
                cantidadPersonas, incluyeEntretencion);
        this.edadCumpleanero = edadCumpleanero;
    }

    @Override
    String obtenerTipoEvento() {
        return "Cumpleaños";
    }

    @Override
    public double calcularPrecioTotal() {
        double precio = precioBase;
        if (incluyeEntretencion) {
            precio += 100000;
        }
        if (edadCumpleanero < 10) {
            precio += 50000; // Costo adicional por animación infantil
        }
        return precio;
    }
}


