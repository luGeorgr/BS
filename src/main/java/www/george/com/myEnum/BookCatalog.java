package www.george.com.myEnum;

public enum BookCatalog {
    CET4(0),
    CET6(1),
    GRE(2);

    private int bid;
    BookCatalog(final int bid){
        this.bid = bid;
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
}
