package compare;

public class Person implements Comparable<Person> {

    public Person(){}

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;

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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 按年龄大小排序
     * @param person
     * @return
     */
    @Override
    public int compareTo(Person person) {
        System.out.println("进行了比较");
        if(this.age == person.getAge()){
            return this.name.compareTo(person.getName());
        }
        return this.age > person.getAge()? 1: -1;
    }
}
