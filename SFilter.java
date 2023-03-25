import java.util.Arrays;

public interface SFilter {
    boolean test(String comp);

    public static String[] filter(String[] arr, SFilter filt) {

        
        int tabLen = 0;
        String[] resArr = new String[tabLen];
        for (int i = 0; i < arr.length; i++) {
            if (filt.test(arr[i])) {
                tabLen++;
                resArr = Arrays.copyOf(resArr, tabLen);
                resArr[tabLen-1] = arr[i];
            };
        };
        return resArr;
        
}



}
