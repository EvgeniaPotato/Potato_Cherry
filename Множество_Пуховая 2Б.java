import java.util.ArrayList;
import java.util.List;

class MySet {
    private List<Integer> elements;

    public MySet() {
        this.elements = new ArrayList<>();
    }

    public void add(int element) {
        if (!contains(element)) {
            elements.add(element);
        }
    }

    public void remove(int element) {
        elements.removeIf(e -> e == element);
    }

    public boolean contains(int element) {
        return elements.contains(element);
    }

    public void display() {
        System.out.print("Set: { ");
        for (int element : elements) {
            System.out.print(element + " ");
        }
        System.out.println("}");
    }
}

public class Main {
    public static void main(String[] args) {
        MySet set = new MySet();
        
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); 
        
        set.display(); // Set: { 1 2 3 }
        
        set.remove(2);
        set.display(); // Set: { 1 3 }
        
        System.out.println("Set contains 1: " + set.contains(1)); // true
        System.out.println("Set contains 4: " + set.contains(4)); // false
    }
}