package beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Employee_Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Employee_Addr", nullable = false, length = 50)
    private String addr;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Employee_Department",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> department;


}
