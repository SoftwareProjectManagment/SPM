package main.java.bupt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Java on 2016/3/11.
 */
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int deploytest;
    private int frontpagetest;
    private int functiontest;
    private int performancetest;
    private int codetestone;
    private int codetestwo;
    private int documentest;
    private String filename;
    private String ipaddress;

    public Team(){

    }

    public Team(int deploytest, int frontpagetest, int functiontest, int performancetest, int codetestone, int codetestwo, int documentest) {
        this.deploytest = deploytest;
        this.frontpagetest = frontpagetest;
        this.functiontest = functiontest;
        this.performancetest = performancetest;
        this.codetestone = codetestone;
        this.codetestwo = codetestwo;
        this.documentest = documentest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeploytest() {
        return deploytest;
    }

    public void setDeploytest(int deploytest) {
        this.deploytest = deploytest;
    }

    public int getFrontpagetest() {
        return frontpagetest;
    }

    public void setFrontpagetest(int frontpagetest) {
        this.frontpagetest = frontpagetest;
    }

    public int getFunctiontest() {
        return functiontest;
    }

    public void setFunctiontest(int functiontest) {
        this.functiontest = functiontest;
    }

    public int getPerformancetest() {
        return performancetest;
    }

    public void setPerformancetest(int performancetest) {
        this.performancetest = performancetest;
    }

    public int getCodetestone() {
        return codetestone;
    }

    public void setCodetestone(int codetestone) {
        this.codetestone = codetestone;
    }

    public int getCodetestwo() {
        return codetestwo;
    }

    public void setCodetestwo(int codetestwo) {
        this.codetestwo = codetestwo;
    }

    public int getDocumentest() {
        return documentest;
    }

    public void setDocumentest(int documentest) {
        this.documentest = documentest;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }
}
