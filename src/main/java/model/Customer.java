package model;

public class Customer {
    private String name;
    private Integer password;
    private Integer phone;
    private String email;
    private String address;

    public Customer(){
    }
    public Customer(String name, int password, int phone, String email, String address){
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setCustomer(Customer customer){
        this.setName(customer.getName());
        this.setPassword(customer.getPassword());
        this.setPhone(customer.getPhone());
        this.setEmail(customer.getEmail());
        this.setAddress(customer.getAddress());
    }
}
