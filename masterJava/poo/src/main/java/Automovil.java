public class Automovil {
    private String fabricante;
    private String modelo;
    private String color;
    private double cilindrada;
    private int capacidadEstanque = 40;

    public Automovil() {
    }

    public Automovil(String fabricante, String modelo, String color, double cilindrada, int capacidadEstanque) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.color = color;
        this.cilindrada = cilindrada;
        this.capacidadEstanque = capacidadEstanque;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getCapacidadEstanque() {
        return capacidadEstanque;
    }

    public void setCapacidadEstanque(int capacidadEstanque) {
        this.capacidadEstanque = capacidadEstanque;
    }

    public String verDetalle(){
        return "Fabricante: " + this.fabricante +
                "\nModelo: " + this.modelo +
                "\nColor:" + this.color +
                "\nCilindrada: " + this.cilindrada;
    }

    public String acelerar(int rpm){
        return "Auto: " + this.fabricante + " acelerando a " + rpm + "rpm";
    }

    public String frenar(){
        return "Auto: " + this.fabricante + " frenando!";
    }

    public float calcularConsumo(int km, float porcentajeBenzina){
        return km/(this.capacidadEstanque * porcentajeBenzina);
    }

    public float calcularConsumo(int km, int porcentajeBenzina){
        return km/(this.capacidadEstanque * (porcentajeBenzina/100F));
    }
}
