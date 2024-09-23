class Animal {
    public void makeSound() {
        System.out.println("Животное издает звук");
       }
 }
class Dog extends Animal {
    @Override
    public void makeSound() {
         System.out.println("Гав");
     }
 }
class Cat extends Animal { // Наследник 2
     @Override
     public void makeSound() {
        System.out.println("Мяу");
     }
    }

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.makeSound(); 
    }
 }
    

