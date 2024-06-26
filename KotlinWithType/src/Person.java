import org.jetbrains.annotations.NotNull;

public class Person {
    private int age;
    private String name;

    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    @NotNull
    public int getAge(){
        return age;
    }
    @NotNull
    public String getName(){
        return name;
    }
}
