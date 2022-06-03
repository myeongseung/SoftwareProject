public class Seat {
    private int low;
    private int column;
    private boolean empty;

    private int price;

    public int getLow() {
        return low;
    }
    public int getColumn() {
        return column;
    }
    public boolean isEmpty() {
        return empty;
    }
    public int getPrice(){
        return price;
    }
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    public void setSeat(int low, int column){
        this.low = low;
        this.column = column;
        this.empty = true;
    }
    public void setPrice(int price){
        this.price = price;
    }
}
