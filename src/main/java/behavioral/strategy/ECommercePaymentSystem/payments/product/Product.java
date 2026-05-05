package behavioral.strategy.ECommercePaymentSystem.payments.product;

public class Product {

    private final String productName;
    private final double price;
    private final int quantity;




    public Product (String productName, double price, int quantity){
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName()    { return productName; }
    public double getPrice()   { return price; }
    public int getQuantity()   { return quantity; }
    public double getTotal()   { return price * quantity; }

    @Override
    public String toString() {
        return String.format("   %-25s ₹%8.2f x %d = ₹%.2f",
                productName, price, quantity, getTotal());
    }
}
