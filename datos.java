public class datos {
    private double litrosAgua;
    private double kilosPet;
    private double kwhLuz;
    private double puntaje;

    public datos(double litrosAgua, double kilosPet, double kwhLuz) {
        this.litrosAgua = litrosAgua;
        this.kilosPet = kilosPet;
        this.kwhLuz = kwhLuz;
        this.puntaje = calcularPuntaje();
    }

    private double calcularPuntaje() {
        return (litrosAgua / 10.0) + (kilosPet * 2) + (kwhLuz * 1.5);
    }

    public double getLitrosAgua() { return litrosAgua; }
    public double getKilosPet() { return kilosPet; }
    public double getKwhLuz() { return kwhLuz; }
    public double getPuntaje() { return puntaje; }
}
