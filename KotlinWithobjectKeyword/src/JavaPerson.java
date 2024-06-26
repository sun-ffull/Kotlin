public class JavaPerson {
    private static final int MIN_AGE = 1;

    public static JavaPerson newBaby(String name){
        return new JavaPerson(name, MIN_AGE);
    }

    private String name;

    private int age;

    private JavaPerson(String name, int age){
        this.name= name;
        this.age = age;
    }

    /*JvmStatic 어노테이션을 활용하여 자바처럼 사용*/
    Person person = Person.newBaby("Asdf");

    /*컴패니언 객체에 이름이 있으면 st, 없으면 Companion 사용*/
    //Person p1 = Person.Companion.newBaby("Adfs");
    Person p1 = Person.st.newBaby("ADF");
}

