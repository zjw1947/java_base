package genericity;

public class Bird<T> {

    private String name;

    private Integer age;

    private T other;

    public Bird(){}

    public Bird(String name, Integer age, T other) {
        this.name = name;
        this.age = age;
        this.other = other;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public T getOther() {
        return other;
    }

    public void setOther(T other) {
        this.other = other;
    }
}
