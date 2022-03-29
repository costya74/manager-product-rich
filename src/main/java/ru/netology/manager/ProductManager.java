package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    //    просим предоставить репозиторий с которым работать
    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    //    создаем продукт в корзину
    public void addProduct(Product product) {
        repository.save(product);
    }

    //    создаем метод возвращающий массив найденных товаров
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
// вычисляем номер ячеки, в которую укладываем
                tmp[tmp.length - 1] = product;
                // сохраняем
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
//        сравниваем product из ячейки с смартфоном, если = то дальше
        if (product instanceof Smartphone) {
            // положем его в переменную типа смартфон чтобы пользоваться методами класса смартфон
            Smartphone smartphone = (Smartphone) product;
            // проверим есть ли поисковое слово в данных об авторе
//            if (smartphone.getName().equalsIgnoreCase(search)) {
            if (smartphone.getName().contains(search)) { //тоже , что и скрытое, только для точного совпадения
                return true;
            }
//            if (smartphone.getMarker().equalsIgnoreCase(search)) { для игнорирования разного регистра
            if (smartphone.getMarker().contains(search)) {  // тоже , что и скрытое, только по вхождению
                return true;
            }
        }
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().contains(search)) {
                return true;
            }
            if (book.getAuthor().contains(search)) {
                return true;
            }
        }
        return false;
    }
}
