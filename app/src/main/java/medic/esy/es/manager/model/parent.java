package medic.esy.es.manager.model;

public class parent {

    private String name;
    private String gender;
    private String address;
    private String age,email;
    private String password;
    private String phone;


    public parent(){

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public parent(  String name, String gender, String address, String age, String email,String password,String phone) {
        this.name = name;
        this.gender = gender;
        this.password=password;
        this.address = address;
        this.age = age;
        this.email = email;
        this.phone=phone;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
