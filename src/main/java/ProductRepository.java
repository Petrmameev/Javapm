public class ProductRepository {
    private Product[] items = new Product[0];

//    public void findAll(Product product) {
//        Product[] tmp = new Product[items.length];
//        for (int i = 0; i < items.length; i++){
//            tmp[i] = items[i];
//        }
//        tmp[tmp.length] = product;
//    }

    public void addProducts(Product product) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = product;

        items = tmp;

    }

    public void removeProductsById(int id) {
        Product tmp1 = findById(id);
        if (tmp1 == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }
    public Product[] getSavedProducts () {
        return items;
    }
    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[] getProduct() {
        return items;
    }




}
