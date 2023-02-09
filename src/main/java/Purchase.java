public class Purchase {
    protected String title;
    protected int count;

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getTitle() {
        return title;
    }
}
