package www.george.com.dao;

public class MyBookWord {
    private String emailAddr;
    private Integer bid;
    private Integer wid;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getEmailAddr() {
        return emailAddr;
    }
}
