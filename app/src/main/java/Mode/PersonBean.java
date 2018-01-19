package Mode;

/**
 * Created by Administrator on 2016/2/27.
 */
public class PersonBean {
    private String name;
    private int age;
    private String email;
    private String address;

    public PersonBean() {
    }

    public PersonBean(String address, int age, String email, String name) {
        this.address = address;
        this.age = age;
        this.email = email;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
