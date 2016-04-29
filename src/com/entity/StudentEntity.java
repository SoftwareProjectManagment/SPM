package com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Java on 2016/4/18.
 */
@Entity
@Table(name = "student", schema = "test", catalog = "")
public class StudentEntity implements Serializable{
    private int id;
    private String name;
    private int score;
    private Integer groupnum;
    private Integer deployscore;
    private Integer frontpagescore;
    private Integer functionscore;
    private Integer performancescore;
    private Integer codescore;
    private Integer documentscore;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Basic
    @Column(name = "groupnum")
    public Integer getGroupnum() {
        return groupnum;
    }

    public void setGroupnum(Integer groupnum) {
        this.groupnum = groupnum;
    }

    @Basic
    @Column(name = "deployscore")
    public Integer getDeployscore() {
        return deployscore;
    }

    public void setDeployscore(Integer deployscore) {
        this.deployscore = deployscore;
    }

    @Basic
    @Column(name = "frontpagescore")
    public Integer getFrontpagescore() {
        return frontpagescore;
    }

    public void setFrontpagescore(Integer frontpagescore) {
        this.frontpagescore = frontpagescore;
    }

    @Basic
    @Column(name = "functionscore")
    public Integer getFunctionscore() {
        return functionscore;
    }

    public void setFunctionscore(Integer functionscore) {
        this.functionscore = functionscore;
    }

    @Basic
    @Column(name = "performancescore")
    public Integer getPerformancescore() {
        return performancescore;
    }

    public void setPerformancescore(Integer performancescore) {
        this.performancescore = performancescore;
    }

    @Basic
    @Column(name = "codescore")
    public Integer getCodescore() {
        return codescore;
    }

    public void setCodescore(Integer codescore) {
        this.codescore = codescore;
    }

    @Basic
    @Column(name = "documentscore")
    public Integer getDocumentscore() {
        return documentscore;
    }

    public void setDocumentscore(Integer documentscore) {
        this.documentscore = documentscore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (score != that.score) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (groupnum != null ? !groupnum.equals(that.groupnum) : that.groupnum != null) return false;
        if (deployscore != null ? !deployscore.equals(that.deployscore) : that.deployscore != null) return false;
        if (frontpagescore != null ? !frontpagescore.equals(that.frontpagescore) : that.frontpagescore != null)
            return false;
        if (functionscore != null ? !functionscore.equals(that.functionscore) : that.functionscore != null)
            return false;
        if (performancescore != null ? !performancescore.equals(that.performancescore) : that.performancescore != null)
            return false;
        if (codescore != null ? !codescore.equals(that.codescore) : that.codescore != null) return false;
        if (documentscore != null ? !documentscore.equals(that.documentscore) : that.documentscore != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + score;
        result = 31 * result + (groupnum != null ? groupnum.hashCode() : 0);
        result = 31 * result + (deployscore != null ? deployscore.hashCode() : 0);
        result = 31 * result + (frontpagescore != null ? frontpagescore.hashCode() : 0);
        result = 31 * result + (functionscore != null ? functionscore.hashCode() : 0);
        result = 31 * result + (performancescore != null ? performancescore.hashCode() : 0);
        result = 31 * result + (codescore != null ? codescore.hashCode() : 0);
        result = 31 * result + (documentscore != null ? documentscore.hashCode() : 0);
        return result;
    }

    public StudentEntity(int id, String name, int score, int groupnum, int deployscore, int frontpagescore, int functionscore, int performancescore, int codescore, int documentscore) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.groupnum = groupnum;
        this.deployscore = deployscore;
        this.frontpagescore = frontpagescore;
        this.functionscore = functionscore;
        this.performancescore = performancescore;
        this.codescore = codescore;
        this.documentscore = documentscore;
    }

    public StudentEntity(int id, String name, int groupnum){
        this.id = id;
        this.name = name;
        this.score = -1;
        this.groupnum = groupnum;
        this.deployscore = -1;
        this.frontpagescore = -1;
        this.functionscore = -1;
        this.performancescore = -1;
        this.codescore = -1;
        this.documentscore = -1;
    }

    public StudentEntity() {
    }
}
