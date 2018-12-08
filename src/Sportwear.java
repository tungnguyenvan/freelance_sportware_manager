public class Sportwear {
    private int id;
    private String name;
    private int total;
    private int price;

    public Sportwear() {
    }

    public Sportwear(int id, String name, int total, int price) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "---------------------------------\n" +
                "ID : " + this.id +"\n" +
                "Tên sản phẩm : " + this.name + "\n" +
                "Tổng số: " + this.total + "\n" +
                "Giá/sản phẩm : " + this.price + " VND";
    }
}
