package entity;

import javax.persistence.*;

@Entity
@Table(name = "group_name")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "number")
    private int number;

    @Column(name = "name_faculty")
    private String nameFaculty;
}
