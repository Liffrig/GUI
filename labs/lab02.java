package labs;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Libra.Assistant;

public class lab02 {

    public static void main(String[] args) {

        Assistant assistant = new Assistant();
        assistant.printSeparator("Zadanie 1");

        List<MyColor> list = Arrays.asList(
            new MyColor(  1,  2,  3),
            new MyColor(255,  0,  0),
            new MyColor( 55, 55,100),
            new MyColor( 10,255, 10)
        );
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(
            list, new MyColorCompar(ColComponent.RED));
        System.out.println(list);
        Collections.sort(
            list, new MyColorCompar(ColComponent.GREEN));
        System.out.println(list);
        Collections.sort(
            list, new MyColorCompar(ColComponent.BLUE));
        System.out.println(list);

        assistant.printSeparator("Zadanie 2");

        
    }
    
}

class MyColor extends java.awt.Color implements Comparable<MyColor>{

    public MyColor(int r, int g, int b) {
        super(r,g,b);
    }
    @Override
    public int compareTo(MyColor c) {
        return this.sumrgb() - c.sumrgb();
    }
    private int sumrgb(){
        return this.getRed() + this.getGreen() + this.getBlue();
    }

    public String toString(){
        return String.format("(%d,%d,%d)", this.getRed(), this.getGreen(), this.getBlue());
    }

}

class MyColorCompar implements Comparator<MyColor>{

    private ColComponent cc;

    public MyColorCompar(ColComponent cc) {
        this.cc = cc;
    }

    @Override
    public int compare(MyColor o1, MyColor o2) {
        switch (this.cc) {
            case RED:
                return o1.getRed() - o2.getRed();
            case GREEN:
                return o1.getGreen() - o2.getGreen();
            case BLUE:
                return o1.getBlue() - o2.getBlue();
            default:
                return 0;
        }
    }
}

enum ColComponent{
    RED,
    GREEN,
    BLUE
}