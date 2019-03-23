package data;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAll", query="select l from Lecturers l"),
        @NamedQuery(name = "findWithParam", query="select l from Lecturers l where l.lecturer = :lecturer")
})
@Cacheable(true)
public class Lecturers {
    @Id
    private Long ID;
    private String lecturer;
    private Integer age;
    @OneToOne
    @JoinColumn(name = "address_fk")
    private Address address;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
}
