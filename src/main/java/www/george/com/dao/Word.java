package www.george.com.dao;


public class Word {
    private Integer wid;
    private String word;
    private String meaning;
    private String index;
    private String bid;

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBid() {
        return bid;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
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
