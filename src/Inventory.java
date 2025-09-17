import java.util.ArrayList; 
import java.util.List; 

public class Inventory <T> {
    private List<T> items; 

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public boolean removeItem(T item) {
        return items.remove(item);
    }

    public List<T> getItems() {
        return items; 
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}