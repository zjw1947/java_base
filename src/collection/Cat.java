package collection;

public class Cat implements Comparable<Cat> {

    private String name;

    private int age;

    public Cat(){}

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Cat o) {
        int c = o.name.compareTo(this.name);
        if(c == 0){
            c = o.age - this.age;
        }
        return c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
