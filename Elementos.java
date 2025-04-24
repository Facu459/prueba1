public class Elementos { //hola tonotos
    // Atributos privados
    private String id;
    private String nombre;
    private String marca;
    private double precio;
    private int stock;

    // Constructor
    public Elementos(String id, String nombre, String marca, double precio, int stock) {
        setId(id);
        setNombre(nombre);
        setMarca(marca);
        setPrecio(precio);
        setStock(stock);
    }

    // Setters 
    public void setId(String id) {
        this.id=id;    
    }

    public void setNombre(String nombre) {
          this.nombre = nombre;
    }

    public void setMarca(String marca) {
          this.marca = marca;
    }

    public void setPrecio(double precio) {
            this.precio = precio;   
    }

    public void setStock(int stock) {   
            this.stock = stock;
       
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
}
