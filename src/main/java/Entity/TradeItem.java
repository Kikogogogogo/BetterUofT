package Entity;

public class TradeItem{
    private String description;
    private boolean traded;
    private String category;
    private double price;
    private String id;

    public TradeItem(String description, boolean status, String category, double price) {
        this.description = description;
        this.traded = status;
        this.category = category;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public boolean getStatus() { return traded; }

    public void setStatus(boolean status) { this.traded = status; }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String toCsvString() {
        return category + "," + traded + "," + description + "," + price;
    }
    public static TradeItem fromCsvString(String csvString) {
        String[] data = csvString.split(",");
        String category = data[0].trim();
        boolean traded = Boolean.parseBoolean(data[1]);
        String description = data[2].trim();
        double price = Double.parseDouble(data[3].trim());

        return new TradeItem(description, traded, category, price);
    }
}
