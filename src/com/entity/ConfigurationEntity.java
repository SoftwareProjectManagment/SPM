package com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Java on 2016/4/18.
 */
@Entity
@Table(name = "configuration", schema = "test", catalog = "")
public class ConfigurationEntity implements Serializable{
    private int id;
    private String ipOne;
    private String ipTwo;
    private String ipThree;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ipOne")
    public String getIpOne() {
        return ipOne;
    }

    public void setIpOne(String ipOne) {
        this.ipOne = ipOne;
    }

    @Basic
    @Column(name = "ipTwo")
    public String getIpTwo() {
        return ipTwo;
    }

    public void setIpTwo(String ipTwo) {
        this.ipTwo = ipTwo;
    }

    @Basic
    @Column(name = "ipThree")
    public String getIpThree() {
        return ipThree;
    }

    public void setIpThree(String ipThree) {
        this.ipThree = ipThree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigurationEntity that = (ConfigurationEntity) o;

        if (id != that.id) return false;
        if (ipOne != null ? !ipOne.equals(that.ipOne) : that.ipOne != null) return false;
        if (ipTwo != null ? !ipTwo.equals(that.ipTwo) : that.ipTwo != null) return false;
        if (ipThree != null ? !ipThree.equals(that.ipThree) : that.ipThree != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ipOne != null ? ipOne.hashCode() : 0);
        result = 31 * result + (ipTwo != null ? ipTwo.hashCode() : 0);
        result = 31 * result + (ipThree != null ? ipThree.hashCode() : 0);
        return result;
    }
}
