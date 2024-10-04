package mercadoLibre.pages;

public class Product {
    private String id;
    private int price;

    public Product(String id, int price){
        this.id = id;
        this.price = price;
    }

    public String getId(){
        return id;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "ID: " + id + "\n PRECIO: $" + price;
    }
}
