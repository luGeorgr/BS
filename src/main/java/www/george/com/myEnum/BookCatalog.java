package www.george.com.myEnum;

public enum BookCatalog {
    CET4(0, 3009f),
    CET6(1, 1578f),
    GRE(2, 8396f);

    private int bid;
    private float totalWords;
    BookCatalog(final int bid, final float totalWords){
        this.bid = bid;
        this.totalWords = totalWords;
    }

    public static Integer getValue(final String bookName){
        String temp = bookName.toLowerCase();
        Integer res = 0;
        switch (temp){
            case "cet4": res = CET4.bid; break;
            case "cet6": res = CET6.bid; break;
            case "gre": res = GRE.bid; break;
        }
        return res;
    }

    public static Float getTotalWords(final String bookName){
        String temp = bookName.toLowerCase();
        Float res = 0f;
        switch (temp){
            case "cet4": res = CET4.totalWords; break;
            case "cet6": res = CET6.totalWords; break;
            case "gre": res = GRE.totalWords; break;
        }
        return res;
    }
}
