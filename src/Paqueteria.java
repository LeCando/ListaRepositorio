public class Paqueteria {
    private int tracking;
    private double peso;
    private String ciudadEntrega;
    private String ciduadRecepcion;
    private String cedulaReceptor;
    private String estado;

    public Paqueteria(int tracking, double peso, String ciudadEntrega, String ciduadRecepcion, String cedulaReceptor) {
        this.tracking = tracking;
        this.peso = peso;
        this.ciudadEntrega = ciudadEntrega;
        this.ciduadRecepcion = ciduadRecepcion;
        this.cedulaReceptor = cedulaReceptor;
        this.estado = "Receptado";
    }

    public int getTracking() {

        return tracking;
    }

    public void setTracking(int tracking) {

        this.tracking = tracking;
    }

    public double getPeso() {

        return peso;
    }

    public void setPeso(double peso) {

        this.peso = peso;
    }

    public String getCiudadEntrega() {

        return ciudadEntrega;
    }

    public void setCiudadEntrega(String ciudadEntrega) {

        this.ciudadEntrega = ciudadEntrega;
    }

    public String getCiduadRecepcion() {

        return ciduadRecepcion;
    }

    public void setCiduadRecepcion(String ciduadRecepcion) {
        this.ciduadRecepcion = ciduadRecepcion;
    }

    public String getCedulaReceptor() {
        return cedulaReceptor;
    }

    public void setCedulaReceptor(String cedulaReceptor) {
        this.cedulaReceptor = cedulaReceptor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Numero de tracking= " + tracking +
                "\nPeso= " + peso +
                "\nCiudad de Entrega= " + ciudadEntrega +
                "\nCiduad de Recepcion= " + ciduadRecepcion +
                "\nCedula del Receptor= " + cedulaReceptor +
                "\nEstado= " + estado;
    }
}
