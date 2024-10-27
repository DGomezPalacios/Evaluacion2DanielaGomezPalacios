package GomezPalaciosDaniela;

abstract class EventoBase implements Cotizable {
    protected int codigo; // se asignará automáticamente
    protected String fecha;
    protected String horaInicio;
    protected String horaFin;
    protected String ubicacion;
    protected double precioBase;
    protected int cantidadPersonas;
    protected boolean incluyeEntretencion;

    // constructor sin parámetros
    public EventoBase(String fecha, String horaInicio, String horaFin,
                      String ubicacion, double precioBase, int cantidadPersonas,
                      boolean incluyeEntretencion) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.ubicacion = ubicacion;
        this.precioBase = precioBase;
        this.cantidadPersonas = cantidadPersonas;
        this.incluyeEntretencion = incluyeEntretencion;
    }

    abstract String obtenerTipoEvento();


    // Getters y Setters

    public String getFecha() {
        return fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public abstract double calcularPrecioTotal();
}
