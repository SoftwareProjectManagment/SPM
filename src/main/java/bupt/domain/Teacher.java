package main.java.bupt.domain;

import javax.persistence.*;

/**
 * Created by Java on 2016/3/14.
 */
@Entity
public class Teacher {


    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(){

    }

    @Id
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
