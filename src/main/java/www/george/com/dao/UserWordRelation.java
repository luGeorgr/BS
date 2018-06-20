package www.george.com.dao;

public class UserWordRelation {
    private String emailAddr;
    private Integer bid;
    private Integer wid;
    private Integer degree;

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getWid() {
        return wid;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }
}
