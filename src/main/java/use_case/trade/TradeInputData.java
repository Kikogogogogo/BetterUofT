package use_case.trade;

public class TradeInputData {
    private String description;
    private String category;
    private String price;
    private String contactName;
    private String email;
    private String phone;


    public TradeInputData(String description, String category, String price, String contactName, String email, String phone) {
        this.description = description;
        this.category = category;
        this.price = price;
        this.contactName = contactName;
        this.email = email;
        this.phone = phone;
    }

}


