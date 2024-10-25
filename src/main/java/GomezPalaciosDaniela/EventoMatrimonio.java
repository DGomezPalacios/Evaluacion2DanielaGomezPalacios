package GomezPalaciosDaniela;

class EventoMatrimonio extends EventoBase {
    private boolean incluyeCeremonia;

    public EventoMatrimonio(String fecha, String horaInicio, String horaFin,
                            String ubicacion, double precioBase, int cantidadPersonas,
                            boolean incluyeEntretencion, boolean incluyeCeremonia) {
        super(fecha, horaInicio, horaFin, ubicacion, precioBase,
                cantidadPersonas, incluyeEntretencion);
        this.incluyeCeremonia = incluyeCeremonia;
    }

    @Override
    String obtenerTipoEvento() {
        return "Matrimonio";
    }

    @Override
    public double calcularPrecioTotal() {
        double precio = precioBase;
        if (incluyeEntretencion) {
            precio += 150000;
        }
        if (incluyeCeremonia) {
            precio += 300000;
        }
        return precio;
    }


}