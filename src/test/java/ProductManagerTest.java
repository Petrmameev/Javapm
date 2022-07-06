import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Product item1 = new Book(21, "Стихи1", 101, "Автор 1");
    Product item2 = new Book(22, "Стихи2", 102, "Автор 2");
    Product item3 = new Book(23, "Стихи3", 103, "Автор 3");
    Product item4 = new Smartphone(24, "Модель 4", 104, "Производитель 1");
    Product item5 = new Smartphone(25, "Модель 5", 105, "Производитель 2");

    @Test
    public void shouldAddNewProductAndRemove() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProducts(item4);
        manager.addNewProducts(item5);
        manager.removeProductById(item3.getId());
        Product[] expected = {item1, item2, item4, item5};
        Product[] actual = manager.getSavedProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchedItem() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProducts(item4);
        manager.addNewProducts(item5);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Стихи 5");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItem() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProducts(item4);
        manager.addNewProducts(item5);

        Product[] expected = {item3};
        Product[] actual = manager.searchBy("Стихи3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchedItem2() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.addNewProducts(item3);
        manager.addNewProducts(item4);
        manager.addNewProducts(item5);

        Product[] expected = {item3, item3};
        Product[] actual = manager.searchBy("Стихи3");

        Assertions.assertArrayEquals(expected, actual);
    }






}
