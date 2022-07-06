public class ProductManager {

    private final ProductRepository repository;

    public ProductManager (ProductRepository repository) {
        this.repository = repository;
    }
    public void addNewProducts (Product product) {
        repository.addProducts(product);
    }

    public void removeProductById (int id) {
        repository.removeProductsById(id);
    }
    public Product [] getSavedProducts () {
        return repository.getSavedProducts();
    }

    // добавьте необходимые поля, конструкторы и методы

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.getSavedProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}
