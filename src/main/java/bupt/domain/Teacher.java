package main.java.bupt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Java on 2016/3/14.
 */
@Entity
public class Teacher {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
