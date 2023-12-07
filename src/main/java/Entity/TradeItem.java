package Entity;

public abstract class TradeItem {
    private String description;
    private String category;
    private String price;
    private String contactName;
    private String email;
    private String phone;

    protected TradeItem(String description, String category, String price, String contactName, String email, String phone) {
        this.description = description;
        this.category = category;
        this.price = price;
        this.contactName = contactName;
        this.email = email;
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
