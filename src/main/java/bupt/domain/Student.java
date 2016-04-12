package main.java.bupt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Martin on 2015/12/20.
 */
@Entity
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int score;

    private int group;

    private int deployscore;
    private int frontpagescore;
    private int functionscore;
    private int performancescore;
    private int codescore;
    private int documentscore;

    public Student(String name, int score, int group, int deployscore, int frontpagescore, int functionscore, int performancescore, int codescore, int documentscore) {
        this.name = name;
        this.score = score;
        this.group = group;
        this.deployscore = deployscore;
        this.frontpagescore = frontpagescore;
        this.functionscore = functionscore;
        this.performancescore = performancescore;
        this.codescore = codescore;
        this.documentscore = documentscore;
    }

    public Student() {
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getDeployscore() {
        return deployscore;
    }

    public void setDeployscore(int deployscore) {
        this.deployscore = deployscore;
    }

    public int getFrontpagescore() {
        return frontpagescore;
    }

    public void setFrontpagescore(int frontpagescore) {
        this.frontpagescore = frontpagescore;
    }

    public int getFunctionscore() {
        return functionscore;
    }

    public void setFunctionscore(int functionscore) {
        this.functionscore = functionscore;
    }

    public int getPerformancescore() {
        return performancescore;
    }

    public void setPerformancescore(int performancescore) {
        this.performancescore = performancescore;
    }

    public int getCodescore() {
        return codescore;
    }

    public void setCodescore(int codescore) {
        this.codescore = codescore;
    }

    public int getDocumentscore() {
        return documentscore;
    }

    public void setDocumentscore(int documentscore) {
        this.documentscore = documentscore;
    }
}
