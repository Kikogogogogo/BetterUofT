package food;

import Entity.Food.Food;
import org.junit.Test;

import java.util.UUID;

public class TestFood {

    UUID uuid1 = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    UUID uuid3 = UUID.randomUUID();
    Food a = new Food("KFC", "123 ave", "bad",
            uuid1.toString(), "2", "30", 1, "[bad]");
    Food b = new Food("Subway", "11 st", "good",
            uuid2.toString(), "3", "15", 1, "[good]");
    Food c = new Food("Pizza Hot", "abc plaza", "not bad",
            uuid3.toString(), "4", "10", 1, "[not bad]");

    @Test
    public void testGetName() {
        assert a.getName().equals("KFC");
        assert b.getName().equals("Subway");
        assert c.getName().equals("Pizza Hot");
    }

    @Test
    public void testGetLocation() {
        assert a.getLocation().equals("123 ave");
        assert b.getLocation().equals("11 st");
        assert c.getLocation().equals("abc plaza");
    }

    @Test
    public void testGetDescription() {
        assert a.getDescription().equals("bad");
        assert b.getDescription().equals("good");
        assert c.getDescription().equals("not bad");
    }

    @Test
    public void testGetId() {
        assert a.getId().equals(uuid1.toString());
        assert b.getId().equals(uuid2.toString());
        assert c.getId().equals(uuid3.toString());
    }

    @Test
    public void testGetRating() {
        assert a.getRating() == 2;
        assert b.getRating() == 3;
        assert c.getRating() == 4;
    }

    @Test
    public void testGetPrice() {
        assert a.getPrice() == 30.0;
        assert b.getPrice() == 15.0;
        assert c.getPrice() == 10.0;
    }

    @Test
    public void testGetCount() {
        assert a.getCount() == 1;
        assert b.getCount() == 1;
        assert c.getCount() == 1;
    }

    @Test
    public void testIncreaseCount() {
        a.increaseCount();
        b.increaseCount();
        c.increaseCount();
        assert a.getCount() == 2;
        assert b.getCount() == 2;
        assert c.getCount() == 2;
    }

    @Test
    public void testAddDescription() {
        a.addDescription("good");
        b.addDescription("bad");
        c.addDescription("not bad");
        assert a.getDescriptionList().get(0).equals("bad");
        assert a.getDescriptionList().get(1).equals("good");
        assert b.getDescriptionList().get(0).equals("good");
        assert b.getDescriptionList().get(1).equals("bad");
        assert c.getDescriptionList().get(0).equals("not bad");
        assert c.getDescriptionList().get(0).equals("not bad");
    }

    @Test
    public void testGetDescriptionList() {
        assert a.getDescriptionList().get(0).equals("bad");
        assert b.getDescriptionList().get(0).equals("good");
        assert c.getDescriptionList().get(0).equals("not bad");
    }

    @Test
    public void testGetAverageRating() {
        assert a.getAverageRating().equals("2.0");
        assert b.getAverageRating().equals("3.0");
        assert c.getAverageRating().equals("4.0");
    }

    @Test
    public void testGetRatings() {
        assert a.getRatings().equals("2");
        assert b.getRatings().equals("3");
        assert c.getRatings().equals("4");
    }

    @Test
    public void testGetPrices() {
        assert a.getPrices().equals("30");
        assert b.getPrices().equals("15");
        assert c.getPrices().equals("10");
    }

    @Test
    public void testClone() {
        Food clone = a.clone();
        assert clone.getName().equals("KFC");
        assert clone.getLocation().equals("123 ave");
        assert clone.getDescription().equals("bad");
        assert clone.getId().equals(uuid1.toString());
        assert clone.getRating() == 2;
        assert clone.getPrice() == 30.0;
        assert clone.getCount() == 1;
        clone.increaseCount();
        assert clone.getCount() == 2;
        clone.addDescription("good");
        assert clone.getDescriptionList().get(0).equals("bad");
        assert clone.getDescriptionList().get(1).equals("good");
    }

}
