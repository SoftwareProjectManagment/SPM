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

    public int getMemberOne() {
        return memberOne;
    }

    public void setMemberOne(int memberOne) {
        this.memberOne = memberOne;
    }

    public int getMemberTwo() {
        return memberTwo;
    }

    public void setMemberTwo(int memberTwo) {
        this.memberTwo = memberTwo;
    }

    public int getMemberThree() {
        return memberThree;
    }

    public void setMemberThree(int memberThree) {
        this.memberThree = memberThree;
    }

    public int getMemberFour() {
        return memberFour;
    }

    public void setMemberFour(int memberFour) {
        this.memberFour = memberFour;
    }

    public int getMemberFive() {
        return memberFive;
    }

    public void setMemberFive(int memberFive) {
        this.memberFive = memberFive;
    }

    public int getMemberSix() {
        return memberSix;
    }

    public void setMemberSix(int memberSix) {
        this.memberSix = memberSix;
    }

    public int getPcaseOne() {
        return pcaseOne;
    }

    public void setPcaseOne(int pcaseOne) {
        this.pcaseOne = pcaseOne;
    }

    public int getPcaseTwo() {
        return pcaseTwo;
    }

    public void setPcaseTwo(int pcaseTwo) {
        this.pcaseTwo = pcaseTwo;
    }

    public int getPcaseThree() {
        return pcaseThree;
    }

    public void setPcaseThree(int pcaseThree) {
        this.pcaseThree = pcaseThree;
    }

    public int getPcaseFour() {
        return pcaseFour;
    }

    public void setPcaseFour(int pcaseFour) {
        this.pcaseFour = pcaseFour;
    }

    public int getPcaseFive() {
        return pcaseFive;
    }

    public void setPcaseFive(int pcaseFive) {
        this.pcaseFive = pcaseFive;
    }

    public int getFcaseOne() {
        return fcaseOne;
    }

    public void setFcaseOne(int fcaseOne) {
        this.fcaseOne = fcaseOne;
    }

    public int getFcaseTwo() {
        return fcaseTwo;
    }

    public void setFcaseTwo(int fcaseTwo) {
        this.fcaseTwo = fcaseTwo;
    }

    public int getFcaseThree() {
        return fcaseThree;
    }

    public void setFcaseThree(int fcaseThree) {
        this.fcaseThree = fcaseThree;
    }

    public int getFcaseFour() {
        return fcaseFour;
    }

    public void setFcaseFour(int fcaseFour) {
        this.fcaseFour = fcaseFour;
    }

    public int getFcaseFive() {
        return fcaseFive;
    }

    public void setFcaseFive(int fcaseFive) {
        this.fcaseFive = fcaseFive;
    }
}
