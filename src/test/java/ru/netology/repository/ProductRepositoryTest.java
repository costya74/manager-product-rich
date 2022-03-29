package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "One", 100, "AOne");
    Product product2 = new Book(2, "Second", 200, "ASecond");
    Product product3 = new Book(3, "Third", 300, "AOne");
    Product product4 = new Book(4, "Fourth", 400, "AFour");
    Product product5 = new Book(5, "Fifth", 500, "AFive");
    Product product6 = new Smartphone(6, "Sixth", 600, "MSixth");
    Product product7 = new Smartphone(7, "Seventh", 700, "MSeventh");
    Product product8 = new Smartphone(8, "Eighth", 800, "MEigth");
    Product product9 = new Smartphone(9, "Ninth", 900, "MNinth");
    Product product10 = new Smartphone(10, "Tenth", 1000, "MTenth");


    @Test
    void addProduct() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);
        repository.save(product6);
        repository.save(product7);
        repository.save(product8);
        repository.save(product9);
        repository.save(product10);

        Product[] actual = repository.findAll();
        Product[] expected = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        assertArrayEquals(expected, actual);
    }

    @Test
    void addProductOne() {
        repository.save(product1);

        Product[] actual = repository.findAll();
        Product[] expected = {product1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void addProductSeveral() {
        repository.save(product4);
        repository.save(product5);
        repository.save(product6);
        repository.save(product9);
        repository.save(product10);

        Product[] actual = repository.findAll();
        Product[] expected = {product4, product5, product6, product9, product10,};
        assertArrayEquals(expected, actual);
    }

    @Test
    void addProductNull() {

        Product[] actual = repository.findAll();
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);
        repository.save(product6);
        repository.save(product7);
        repository.save(product8);
        repository.save(product9);
        repository.save(product10);

        repository.removeById(7);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{product1, product2, product3, product4, product5, product6, product8, product9, product10};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveNoExistById() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);
        repository.save(product6);
        repository.save(product7);
        repository.save(product8);
        repository.save(product9);
        repository.save(product10);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-1);
        });
    }
}

