class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age must be > 0");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ben", 25);
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        person.setAge(30);
        System.out.println("New age: " + person.getAge());
        person.setAge(-5); 
    }
}

