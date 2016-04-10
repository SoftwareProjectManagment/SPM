package main.java.bupt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Java on 2016/4/3.
 */
@Entity
public class Admin {
    private int id;

    private String name;

    public Admin(String name) {
        this.name = name;
    }

    public Admin(){

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
