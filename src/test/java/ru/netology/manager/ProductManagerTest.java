package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
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

    @BeforeEach
    void setUp() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);
        manager.addProduct(product7);
        manager.addProduct(product8);
        manager.addProduct(product9);
        manager.addProduct(product10);
    }

    @Test
    void searchByMakerBook() {
        Product[] actual = manager.searchBy("AOne");
        Product[] expected = new Product[] {product1, product3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByMakerSmartphone() {
        Product[] actual = manager.searchBy("MSixth");
        Product[] expected = new Product[] {product6};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneName() {
        Product[] actual = manager.searchBy("Sixth");
        Product[] expected = new Product[] {product6};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookName() {
        Product[] actual = manager.searchBy("Second");
        Product[] expected = new Product[] {product2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByInvalidMaker() {
        Product[] actual = manager.searchBy("MEleventh");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByInvalidAuthor() {
        Product[] actual = manager.searchBy("MSixth");
        Product[] expected = new Product[]{product6};
        assertArrayEquals(expected, actual);
    }

}