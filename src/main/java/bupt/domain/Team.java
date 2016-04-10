package main.java.bupt.domain;

import javax.persistence.*;

/**
 * Created by Java on 2016/3/11.
 */
@Entity
public class Team {


    //@GeneratedValue(strategy = GenerationType.AUTO)
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
    private int memberOne;
    private int memberTwo;
    private int memberThree;
    private int memberFour;
    private int memberFive;
    private int memberSix;
    private int pcaseOne;
    private int pcaseTwo;
    private int pcaseThree;
    private int pcaseFour;
    private int pcaseFive;
    private int fcaseOne;
    private int fcaseTwo;
    private int fcaseThree;
    private int fcaseFour;
    private int fcaseFive;


    public Team(){

    }

    public Team(int id,int deploytest, int frontpagetest, int functiontest, int performancetest, int codetestone, int codetestwo, int documentest, String filename, String ipaddress, int menberOne, int menberTwo, int menberThree, int menberFour, int menberFive, int menberSix) {
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

    @Id
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="deploytest")
    public int getDeploytest() {
        return deploytest;
    }

    public void setDeploytest(int deploytest) {
        this.deploytest = deploytest;
    }

    @Column(name="frontpagetest")
    public int getFrontpagetest() {
        return frontpagetest;
    }

    public void setFrontpagetest(int frontpagetest) {
        this.frontpagetest = frontpagetest;
    }

    @Column(name="functiontest")
    public int getFunctiontest() {
        return functiontest;
    }

    public void setFunctiontest(int functiontest) {
        this.functiontest = functiontest;
    }

    @Column(name="performancetest")
    public int getPerformancetest() {
        return performancetest;
    }

    public void setPerformancetest(int performancetest) {
        this.performancetest = performancetest;
    }

    @Column(name="codetestone")
    public int getCodetestone() {
        return codetestone;
    }

    public void setCodetestone(int codetestone) {
        this.codetestone = codetestone;
    }

    @Column(name="codetestwo")
    public int getCodetestwo() {
        return codetestwo;
    }

    public void setCodetestwo(int codetestwo) {
        this.codetestwo = codetestwo;
    }

    @Column(name="documentest")
    public int getDocumentest() {
        return documentest;
    }

    public void setDocumentest(int documentest) {
        this.documentest = documentest;
    }

    @Column(name="filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Column(name="ipaddress")
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @Column(name="memberOne")
    public int getMemberOne() {
        return memberOne;
    }

    public void setMemberOne(int memberOne) {
        this.memberOne = memberOne;
    }

    @Column(name="memberTwo")
    public int getMemberTwo() {
        return memberTwo;
    }

    public void setMemberTwo(int memberTwo) {
        this.memberTwo = memberTwo;
    }

    @Column(name="memberThree")
    public int getMemberThree() {
        return memberThree;
    }

    public void setMemberThree(int memberThree) {
        this.memberThree = memberThree;
    }

    @Column(name="memberFour")
    public int getMemberFour() {
        return memberFour;
    }

    public void setMemberFour(int memberFour) {
        this.memberFour = memberFour;
    }

    @Column(name="memberFive")
    public int getMemberFive() {
        return memberFive;
    }

    public void setMemberFive(int memberFive) {
        this.memberFive = memberFive;
    }

    @Column(name="memberSix")
    public int getMemberSix() {
        return memberSix;
    }

    public void setMemberSix(int memberSix) {
        this.memberSix = memberSix;
    }

    @Column(name="pcaseOne")
    public int getPcaseOne() {
        return pcaseOne;
    }

    public void setPcaseOne(int pcaseOne) {
        this.pcaseOne = pcaseOne;
    }

    @Column(name="pcaseTwo")
    public int getPcaseTwo() {
        return pcaseTwo;
    }

    public void setPcaseTwo(int pcaseTwo) {
        this.pcaseTwo = pcaseTwo;
    }

    @Column(name="pcaseThree")
    public int getPcaseThree() {
        return pcaseThree;
    }

    public void setPcaseThree(int pcaseThree) {
        this.pcaseThree = pcaseThree;
    }

    @Column(name="pcaseFour")
    public int getPcaseFour() {
        return pcaseFour;
    }

    public void setPcaseFour(int pcaseFour) {
        this.pcaseFour = pcaseFour;
    }

    @Column(name="pcaseFive")
    public int getPcaseFive() {
        return pcaseFive;
    }

    public void setPcaseFive(int pcaseFive) {
        this.pcaseFive = pcaseFive;
    }

    @Column(name="fcaseOne")
    public int getFcaseOne() {
        return fcaseOne;
    }

    public void setFcaseOne(int fcaseOne) {
        this.fcaseOne = fcaseOne;
    }

    @Column(name="fcaseTwo")
    public int getFcaseTwo() {
        return fcaseTwo;
    }

    public void setFcaseTwo(int fcaseTwo) {
        this.fcaseTwo = fcaseTwo;
    }

    @Column(name="fcaseThree")
    public int getFcaseThree() {
        return fcaseThree;
    }

    public void setFcaseThree(int fcaseThree) {
        this.fcaseThree = fcaseThree;
    }

    @Column(name="fcaseFour")
    public int getFcaseFour() {
        return fcaseFour;
    }

    public void setFcaseFour(int fcaseFour) {
        this.fcaseFour = fcaseFour;
    }

    @Column(name="fcaseFive")
    public int getFcaseFive() {
        return fcaseFive;
    }

    public void setFcaseFive(int fcaseFive) {
        this.fcaseFive = fcaseFive;
    }
}
