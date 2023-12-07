package use_case.food;

import Entity.Food.Food;

public class AddFoodOutputData {
    public String name;
    public String price;
    public String description;
    public String rating;
    public String location;
    public String id;

    public AddFoodOutputData(Food food){
        this.name = food.getName();
        this.price = food.getAveragePrice();
        this.description = food.getDescription();
        this.rating = food.getAverageRating();
        this.location = food.getLocation();
        this.id = food.getId();
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }

    public String getDescription(){
        return description;
    }

    public String getRating(){
        return rating;
    }

    public String getLocation(){
        return location;
    }

}
