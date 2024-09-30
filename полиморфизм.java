public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void study() {
        System.out.println(toString() + "I love math");
    }

    @Override
    public String toString() {
        return "I’m " + name + ", I’m " + age + " years old. " ;
    }
}
public class IT_Love¬_Student extends Student {
    public IT_Love¬_Student (String name, int age) {
        super(name, age);
    }
    @Override
    public void study() {
        System.out.println( toString() + "I love IT!");
    }
}

public class Biology_Love¬_Student extends Student{
    public Biology_Love¬_Student (String name, int age) {
        super(name, age);
    }
    @Override
    public void study(){
        System.out.println(toString() + "I love biology!");
    }
}

public class Main {
    public static void main(String[] args) {
       Student student = new Student("Bob", 18);
        Student IT_Love¬_Student = new IT_love_student("Mark", 21);
        Student Biology_Love¬_Student = new Biology_love¬_student ("Natalia", 22); 

        List<Student> StudentList = Arrays.asList(student, Student IT_Love¬_Student, Biology_Love¬_Student);
        for (Student s : StudentList) {
            s.study();    
        }
    }
}
