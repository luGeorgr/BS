package www.george.com.dao;


public class Word {
    private Integer wid;
    private String word;
    private String meaning;
    private Integer bid;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getWid() {
        return wid;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getWord() {
        return word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
