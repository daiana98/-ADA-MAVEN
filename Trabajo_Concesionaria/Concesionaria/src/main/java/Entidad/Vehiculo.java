package Entidad;

public class Vehiculo {
    private Integer id;
    private String marca;
    private String modelo;
    private String color;
    private Integer stock;

    public Vehiculo() {
    }

    public Vehiculo(Integer id, String marca, String modelo, String color, Integer stock) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("VEHICULO (id: %s, marca: %s, modelo: %s, color: %s, stock: %s)",
                id, marca, modelo, color, stock);
    }
}
