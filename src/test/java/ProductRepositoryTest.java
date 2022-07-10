import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Product item1 = new Book(21, "Стихи1", 101, "Автор 1");
    Product item2 = new Book(22, "Стихи2", 102, "Автор 2");
    Product item3 = new Book(23, "Стихи3", 103, "Автор 3");
    Product item4 = new Smartphone(24, "Модель 4", 104, "Производитель 1");
    Product item5 = new Smartphone(25, "Модель 5", 105, "Производитель 2");

    @Test
    public void shouldRemoveItemByIdIfHave() {
        ProductRepository repository = new ProductRepository();
        repository.addProducts(item1);
        repository.addProducts(item2);
        repository.addProducts(item3);
        repository.addProducts(item4);
        repository.addProducts(item5);
        repository.removeProductsById(23);
        Product[] expected = {item1, item2, item4, item5};
        Product[] actual = repository.getProduct();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfDoNotHave() {
        ProductRepository repository = new ProductRepository();
        repository.addProducts(item1);
        repository.addProducts(item2);
        repository.addProducts(item3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeProductsById(28);
        });
    }


    @Test
    public void shouldAddAndRemoveProduct() {
        ProductRepository repo = new ProductRepository();
        repo.addProducts(item1);
        repo.addProducts(item2);
        repo.addProducts(item3);
        repo.addProducts(item4);
        repo.addProducts(item5);
        repo.removeProductsById(item3.getId());
        Product[] expected = {item1, item2, item4, item5};
        Product[] actual = repo.getProduct();
        Assertions.assertArrayEquals(expected, actual);
    }


}
