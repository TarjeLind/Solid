import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 45);
        products.put("Масло", 180);
        products.put("Колбаса", 370);
        products.put("Пирожок", 60);

        showGoods(products);

        System.out.println("Введите: название товара и количество. Или end");
        Basket basket = new Basket(products);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if ("end".equalsIgnoreCase(line)) break;
            String[] parts = line.split(" ");
            String product;
            int count;
            try {
                product = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase();
                count = Integer.parseInt(parts[1]);
            } catch (Exception e) {
                throw new IllegalArgumentException("Параметры нужно задавать в формате ТОВАР КОЛИЧЕСТВО!");
            }
            if (isPresent(products, product)) {
                basket.add(product, count);
            } else {
                System.out.println("Данного товара нет в наличии!");
            }
        }
        long sum = basket.sum();
        System.out.println("ИТОГО: " + sum);
        scanner.close();
    }

    private static boolean isPresent(HashMap<String, Integer> products, String product) {
        for (Map.Entry<String, Integer> productValue : products.entrySet()) {
            if (productValue.getKey().equals(product)) {
                return true;
            }
        }
        return false;
    }

    private static void showGoods(HashMap<String, Integer> products) {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }
}
