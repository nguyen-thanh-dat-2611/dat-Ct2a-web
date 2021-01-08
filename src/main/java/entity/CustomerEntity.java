
package entity;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "customer")
public class CustomerEntity {

    
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int ID;
    private String firstname;
    private String name;
    private String email;
    private String sex;
    private String address;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    private String user;
    private String passwork;
    
    

 @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    List<OrderEntity> orderslist;    

    

    public CustomerEntity() {
       
    }

    public CustomerEntity(int ID, String firstname, String name, String email, String sex, String address, String phone, LocalDate birthdate, String user, String passwork, List<OrderEntity> orderslist) {
        this.ID = ID;
        this.firstname = firstname;
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.birthdate = birthdate;
        this.user = user;
        this.passwork = passwork;
        this.orderslist = orderslist;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public List<OrderEntity> getOrderslist() {
        return orderslist;
    }

    public void setOrderslist(List<OrderEntity> orderslist) {
        this.orderslist = orderslist;
    }


   
}
