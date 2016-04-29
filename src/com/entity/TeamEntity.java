package com.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Java on 2016/4/18.
 */
@Entity
@javax.persistence.Table(name = "team", schema = "test", catalog = "")
public class TeamEntity implements Serializable{
    private int id;
    @Id
    @javax.persistence.Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int deploytest;

    @Basic
    @javax.persistence.Column(name = "deploytest")
    public int getDeploytest() {
        return deploytest;
    }

    public void setDeploytest(int deploytest) {
        this.deploytest = deploytest;
    }

    private int frontpagetest;

    @Basic
    @javax.persistence.Column(name = "frontpagetest")
    public int getFrontpagetest() {
        return frontpagetest;
    }

    public void setFrontpagetest(int frontpagetest) {
        this.frontpagetest = frontpagetest;
    }

    private int functiontest;

    @Basic
    @javax.persistence.Column(name = "functiontest")
    public int getFunctiontest() {
        return functiontest;
    }

    public void setFunctiontest(int functiontest) {
        this.functiontest = functiontest;
    }

    private int performancetest;

    @Basic
    @javax.persistence.Column(name = "performancetest")
    public int getPerformancetest() {
        return performancetest;
    }

    public void setPerformancetest(int performancetest) {
        this.performancetest = performancetest;
    }

    private int codetestone;

    @Basic
    @javax.persistence.Column(name = "codetestone")
    public int getCodetestone() {
        return codetestone;
    }

    public void setCodetestone(int codetestone) {
        this.codetestone = codetestone;
    }

    private int codetestwo;

    @Basic
    @javax.persistence.Column(name = "codetestwo")
    public int getCodetestwo() {
        return codetestwo;
    }

    public void setCodetestwo(int codetestwo) {
        this.codetestwo = codetestwo;
    }

    private int documentest;

    @Basic
    @javax.persistence.Column(name = "documentest")
    public int getDocumentest() {
        return documentest;
    }

    public void setDocumentest(int documentest) {
        this.documentest = documentest;
    }

    private String filename;

    @Basic
    @javax.persistence.Column(name = "filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private String ipaddress;

    @Basic
    @javax.persistence.Column(name = "ipaddress")
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    private Integer memberOne;

    @Basic
    @javax.persistence.Column(name = "memberOne")
    public Integer getMemberOne() {
        return memberOne;
    }

    public void setMemberOne(Integer memberOne) {
        this.memberOne = memberOne;
    }

    private Integer memberTwo;

    @Basic
    @javax.persistence.Column(name = "memberTwo")
    public Integer getMemberTwo() {
        return memberTwo;
    }

    public void setMemberTwo(Integer memberTwo) {
        this.memberTwo = memberTwo;
    }

    private Integer memberThree;

    @Basic
    @javax.persistence.Column(name = "memberThree")
    public Integer getMemberThree() {
        return memberThree;
    }

    public void setMemberThree(Integer memberThree) {
        this.memberThree = memberThree;
    }

    private Integer memberFive;

    @Basic
    @javax.persistence.Column(name = "memberFive")
    public Integer getMemberFive() {
        return memberFive;
    }

    public void setMemberFive(Integer memberFive) {
        this.memberFive = memberFive;
    }

    private Integer memberSix;

    @Basic
    @javax.persistence.Column(name = "memberSix")
    public Integer getMemberSix() {
        return memberSix;
    }

    public void setMemberSix(Integer memberSix) {
        this.memberSix = memberSix;
    }

    private String pcaseOne;

    @Basic
    @javax.persistence.Column(name = "pcaseOne")
    public String getPcaseOne() {
        return pcaseOne;
    }

    public void setPcaseOne(String pcaseOne) {
        this.pcaseOne = pcaseOne;
    }

    private String pcaseTwo;

    @Basic
    @javax.persistence.Column(name = "pcaseTwo")
    public String getPcaseTwo() {
        return pcaseTwo;
    }

    public void setPcaseTwo(String pcaseTwo) {
        this.pcaseTwo = pcaseTwo;
    }

    private String pcaseThree;

    @Basic
    @javax.persistence.Column(name = "pcaseThree")
    public String getPcaseThree() {
        return pcaseThree;
    }

    public void setPcaseThree(String pcaseThree) {
        this.pcaseThree = pcaseThree;
    }

    private String pcaseFour;

    @Basic
    @javax.persistence.Column(name = "pcaseFour")
    public String getPcaseFour() {
        return pcaseFour;
    }

    public void setPcaseFour(String pcaseFour) {
        this.pcaseFour = pcaseFour;
    }

    private String pcaseFive;

    @Basic
    @javax.persistence.Column(name = "pcaseFive")
    public String getPcaseFive() {
        return pcaseFive;
    }

    public void setPcaseFive(String pcaseFive) {
        this.pcaseFive = pcaseFive;
    }

    private String fcaseOne;

    @Basic
    @javax.persistence.Column(name = "fcaseOne")
    public String getFcaseOne() {
        return fcaseOne;
    }

    public void setFcaseOne(String fcaseOne) {
        this.fcaseOne = fcaseOne;
    }

    private String fcaseTwo;

    @Basic
    @javax.persistence.Column(name = "fcaseTwo")
    public String getFcaseTwo() {
        return fcaseTwo;
    }

    public void setFcaseTwo(String fcaseTwo) {
        this.fcaseTwo = fcaseTwo;
    }

    private String fcaseThree;

    @Basic
    @javax.persistence.Column(name = "fcaseThree")
    public String getFcaseThree() {
        return fcaseThree;
    }

    public void setFcaseThree(String fcaseThree) {
        this.fcaseThree = fcaseThree;
    }

    private String fcaseFour;

    @Basic
    @javax.persistence.Column(name = "fcaseFour")
    public String getFcaseFour() {
        return fcaseFour;
    }

    public void setFcaseFour(String fcaseFour) {
        this.fcaseFour = fcaseFour;
    }

    private String fcaseFive;

    @Basic
    @javax.persistence.Column(name = "fcaseFive")
    public String getFcaseFive() {
        return fcaseFive;
    }

    public void setFcaseFive(String fcaseFive) {
        this.fcaseFive = fcaseFive;
    }

    private int memberFour;

    @Basic
    @javax.persistence.Column(name = "memberFour")
    public int getMemberFour() {
        return memberFour;
    }

    public void setMemberFour(int memberFour) {
        this.memberFour = memberFour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamEntity that = (TeamEntity) o;

        if (id != that.id) return false;
        if (deploytest != that.deploytest) return false;
        if (frontpagetest != that.frontpagetest) return false;
        if (functiontest != that.functiontest) return false;
        if (performancetest != that.performancetest) return false;
        if (codetestone != that.codetestone) return false;
        if (codetestwo != that.codetestwo) return false;
        if (documentest != that.documentest) return false;
        if (memberFour != that.memberFour) return false;
        if (filename != null ? !filename.equals(that.filename) : that.filename != null) return false;
        if (ipaddress != null ? !ipaddress.equals(that.ipaddress) : that.ipaddress != null) return false;
        if (memberOne != null ? !memberOne.equals(that.memberOne) : that.memberOne != null) return false;
        if (memberTwo != null ? !memberTwo.equals(that.memberTwo) : that.memberTwo != null) return false;
        if (memberThree != null ? !memberThree.equals(that.memberThree) : that.memberThree != null) return false;
        if (memberFive != null ? !memberFive.equals(that.memberFive) : that.memberFive != null) return false;
        if (memberSix != null ? !memberSix.equals(that.memberSix) : that.memberSix != null) return false;
        if (pcaseOne != null ? !pcaseOne.equals(that.pcaseOne) : that.pcaseOne != null) return false;
        if (pcaseTwo != null ? !pcaseTwo.equals(that.pcaseTwo) : that.pcaseTwo != null) return false;
        if (pcaseThree != null ? !pcaseThree.equals(that.pcaseThree) : that.pcaseThree != null) return false;
        if (pcaseFour != null ? !pcaseFour.equals(that.pcaseFour) : that.pcaseFour != null) return false;
        if (pcaseFive != null ? !pcaseFive.equals(that.pcaseFive) : that.pcaseFive != null) return false;
        if (fcaseOne != null ? !fcaseOne.equals(that.fcaseOne) : that.fcaseOne != null) return false;
        if (fcaseTwo != null ? !fcaseTwo.equals(that.fcaseTwo) : that.fcaseTwo != null) return false;
        if (fcaseThree != null ? !fcaseThree.equals(that.fcaseThree) : that.fcaseThree != null) return false;
        if (fcaseFour != null ? !fcaseFour.equals(that.fcaseFour) : that.fcaseFour != null) return false;
        if (fcaseFive != null ? !fcaseFive.equals(that.fcaseFive) : that.fcaseFive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + deploytest;
        result = 31 * result + frontpagetest;
        result = 31 * result + functiontest;
        result = 31 * result + performancetest;
        result = 31 * result + codetestone;
        result = 31 * result + codetestwo;
        result = 31 * result + documentest;
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + (ipaddress != null ? ipaddress.hashCode() : 0);
        result = 31 * result + (memberOne != null ? memberOne.hashCode() : 0);
        result = 31 * result + (memberTwo != null ? memberTwo.hashCode() : 0);
        result = 31 * result + (memberThree != null ? memberThree.hashCode() : 0);
        result = 31 * result + (memberFive != null ? memberFive.hashCode() : 0);
        result = 31 * result + (memberSix != null ? memberSix.hashCode() : 0);
        result = 31 * result + (pcaseOne != null ? pcaseOne.hashCode() : 0);
        result = 31 * result + (pcaseTwo != null ? pcaseTwo.hashCode() : 0);
        result = 31 * result + (pcaseThree != null ? pcaseThree.hashCode() : 0);
        result = 31 * result + (pcaseFour != null ? pcaseFour.hashCode() : 0);
        result = 31 * result + (pcaseFive != null ? pcaseFive.hashCode() : 0);
        result = 31 * result + (fcaseOne != null ? fcaseOne.hashCode() : 0);
        result = 31 * result + (fcaseTwo != null ? fcaseTwo.hashCode() : 0);
        result = 31 * result + (fcaseThree != null ? fcaseThree.hashCode() : 0);
        result = 31 * result + (fcaseFour != null ? fcaseFour.hashCode() : 0);
        result = 31 * result + (fcaseFive != null ? fcaseFive.hashCode() : 0);
        result = 31 * result + memberFour;
        return result;
    }

    public TeamEntity(){

    }

    public TeamEntity(int id,int deploytest, int frontpagetest, int functiontest, int performancetest, int codetestone, int codetestwo, int documentest, String filename, String ipaddress, int menberOne, int menberTwo, int menberThree, int menberFour, int menberFive, int menberSix) {
        this.id = id;
        this.deploytest = deploytest;
        this.frontpagetest = frontpagetest;
        this.functiontest = functiontest;
        this.performancetest = performancetest;
        this.codetestone = codetestone;
        this.codetestwo = codetestwo;
        this.documentest = documentest;
        this.filename = filename;
        this.ipaddress = ipaddress;
        this.memberOne = menberOne;
        this.memberTwo = menberTwo;
        this.memberThree = menberThree;
        this.memberFour = menberFour;
        this.memberFive = menberFive;
        this.memberSix = menberSix;
    }
}
