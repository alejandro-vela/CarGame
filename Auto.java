package gamecar;

public class Auto {

    private String color;
    private String marca;
    private int velocidad;
    private int aceleracion;
  

    public Auto(int velocidad, int aceleracion, String marca, String color, int frenos) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.marca = marca;
        this.color = color;

    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(int aceleracion) {
        this.aceleracion = aceleracion;

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void Aceleracion(int velocidad) {
        this.velocidad = velocidad;
        velocidad += this.aceleracion;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
