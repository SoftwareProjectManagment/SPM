package main.java.bupt.domain;

import javax.persistence.*;

/**
 * Created by Martin on 2015/12/20.
 */
@Entity
public class Student {



    private int id;

    private String name;

    private int score;

    private int groupnum;

    private int deployscore;
    private int frontpagescore;
    private int functionscore;
    private int performancescore;
    private int codescore;
    private int documentscore;

    public Student(int id, String name, int score, int groupnum, int deployscore, int frontpagescore, int functionscore, int performancescore, int codescore, int documentscore) {
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

    public Student(int id, String name, int groupnum){
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

    public Student() {
    }

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name="score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Column(name="groupnum")
    public int getGroupnum() {
        return groupnum;
    }

    public void setGroupnum(int groupnum) {
        this.groupnum = groupnum;
    }

    @Column(name="deployscore")
    public int getDeployscore() {
        return deployscore;
    }

    public void setDeployscore(int deployscore) {
        this.deployscore = deployscore;
    }

    @Column(name="frontpagescore")
    public int getFrontpagescore() {
        return frontpagescore;
    }

    public void setFrontpagescore(int frontpagescore) {
        this.frontpagescore = frontpagescore;
    }

    @Column(name="functionscore")
    public int getFunctionscore() {
        return functionscore;
    }

    public void setFunctionscore(int functionscore) {
        this.functionscore = functionscore;
    }

    @Column(name="performancescore")
    public int getPerformancescore() {
        return performancescore;
    }

    public void setPerformancescore(int performancescore) {
        this.performancescore = performancescore;
    }

    @Column(name="codescore")
    public int getCodescore() {
        return codescore;
    }

    public void setCodescore(int codescore) {
        this.codescore = codescore;
    }

    @Column(name="documentscore")
    public int getDocumentscore() {
        return documentscore;
    }

    public void setDocumentscore(int documentscore) {
        this.documentscore = documentscore;
    }
}
