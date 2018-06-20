package www.george.com.dao;

public class UserProgress {
    private String emailAddr;
    private Integer bid;
    private Integer weekdy;
    private Integer wordCount;

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

    public Integer getWeekdy() {
        return weekdy;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWeekdy(Integer weekdy) {
        this.weekdy = weekdy;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }
}
