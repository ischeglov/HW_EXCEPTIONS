import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    ShopRepository shopRepository = new ShopRepository();

    Product iPhone12 = new Product(1, "Apple iPhone 12 128GB", 59_999);
    Product iPhone13 = new Product(2, "Apple iPhone 13 128GB", 69_999);
    Product iPhone14 = new Product(3, "Apple iPhone 14 128GB", 73_999);
    Product iPhone15 = new Product(4, "Apple iPhone 15 128GB", 88_999);
    Product iPhone15ProMax = new Product(5, "Apple iPhone 15 Pro Max 1TB", 206_390);

    @BeforeEach
    void setUp() {
        shopRepository.add(iPhone12);
        shopRepository.add(iPhone13);
        shopRepository.add(iPhone14);
        shopRepository.add(iPhone15);
        shopRepository.add(iPhone15ProMax);
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Тесты завершены");
    }

    @Test
    public void shouldRemoveByIdExistingElement() {
        shopRepository.removeById(2);

        Product[] expected = {iPhone12, iPhone14, iPhone15, iPhone15ProMax};
        Product[] actual = shopRepository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNonExistentElement() {
        assertThrows(NotFoundException.class, () -> {
            shopRepository.removeById(6);
        });
    }
}