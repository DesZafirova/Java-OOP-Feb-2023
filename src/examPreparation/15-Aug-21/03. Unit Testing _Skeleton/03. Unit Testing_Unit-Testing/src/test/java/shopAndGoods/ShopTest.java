package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class ShopTest {
    private Shop shop;

    @Before
    public void prepare() {
        this.shop = new Shop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesShouldReturnUnmodifiableCollection() {
        shop.getShelves().clear();
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldFailForNonExistingShelf() throws OperationNotSupportedException {
        shop.addGoods("invalid_test_shelve", null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldFailForExistingProductGood() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);
    }
    @Test
    public void testAddGoodsShouldReturnCorrectMessageOnnAddition() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        String expected = "Goods: test_code is placed successfully!";
        String actual = shop.addGoods("Shelves1", goods);

        Assert.assertEquals(expected, actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldFailForNonExistingShelf() throws OperationNotSupportedException {
        shop.removeGoods("invalid_test_shelve", null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldFailForDifferentGoodOnTheSameShelve() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        Goods goodsOther = new Goods("test_good_Other", "test_code_Other");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1",goodsOther );
    }
    @Test
    public void testRemoveGoodsShouldReturnCorrectMessage() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        String expected = "Goods: test_code is removed successfully!";
        String actual = shop.removeGoods("Shelves1", goods);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testRemoveGoodsShouldSetTheShelveValueToNull() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);
        Goods emptySlot = shop.getShelves().get("Shelves1");
        Assert.assertNull(emptySlot);
    }
}