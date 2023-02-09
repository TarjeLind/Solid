import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Basket {
    private final List<Purchase> purchases;
    private final HashMap<String, Integer> products;

    public Basket(HashMap<String, Integer> products) {
        this.purchases = new ArrayList<>();
        this.products = products;
    }

    public void add(String product, int count) {
        for (Purchase purchase : purchases) {
            if (purchase.getTitle().equals(product)) {
                purchase.setCount(purchase.getCount() + count);
                return;
            }
        }
        purchases.add(new Purchase(product, count));
    }

    public long sum() {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            System.out.println("\t" + purchase.getTitle() + " " + purchase.getCount() + " шт. в сумме "
                    + (purchase.getCount() * products.get(purchase.getTitle())) + " руб.");
            sum += (long) purchase.getCount() * products.get(purchase.getTitle());
        }
        return sum;
    }

}
