public class LenFilter implements SFilter {
    private int minLen;

    public LenFilter(int minLen) {
        this.minLen = minLen;
    }
    @Override
    public boolean test(String comp) {return comp.length() >= this.minLen;}

}
