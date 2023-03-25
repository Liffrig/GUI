import java.util.Arrays;


import Libra.Assistant;

public class lab03 {
    public static void main(String[] args) {

        Assistant assistant = new Assistant();
        assistant.printSeparator("Zadanie 1");

        Pacjent[] pacjenci = {
            new ChoryNaGlowe("Janek"),
            new ChoryNaNoge("Edzio"),
            new ChoryNaDyspepsje("Marian")
            };

            for (Pacjent p : pacjenci) {
                System.out.println(
                    "Pacjent: " + p.nazwisko() + '\n' 
                    + "Chory na: " + p.choroba() + '\n' 
                    + "Zastosowano: " + p.leczenie() +"\n\n"
                );}
        
        assistant.printSeparator("Zadanie 2");

        Integer[] a = {1,5,33,12,98,15};
        printTable("Original    ", a);

        Arrays.sort(a,new MyComp(sortEnum.BY_VAL));
        printTable("ByVal       ", a);

        Arrays.sort(a,new MyComp(sortEnum.BY_VAL_REV));
        printTable("ByValRev    ", a);

        Arrays.sort(a,new MyComp(sortEnum.BY_NUM_OF_DIVS));
        printTable("ByNumOfDivs ", a);

        Arrays.sort(a,new MyComp(sortEnum.BY_SUM_OF_DIGS));
        printTable("BySumOfDigs ", a);

        assistant.printSeparator("Zadanie 3");

        String[] arr = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(arr));
        
        // 1. sposób
        String[] a1 = SFilter.filter(arr, new LenFilter(4));
        System.out.println(Arrays.toString(a1));


        // 2. sposób
        SFilter secondInst = new SFilter() {

            @Override
            public boolean test(String comp) {
                return comp.charAt(0) < 'D' && comp.charAt(0) >= 'A'; 
            }
        };
        String[] a2 = SFilter.filter(arr, secondInst);
        System.out.println(Arrays.toString(a2));

        // 3. sposób
        SFilter lambda = (x) -> {return x.charAt(0) > 'H' && x.charAt(0) <= 'Z';};
        String[] a3 = SFilter.filter(arr, lambda);
        System.out.println(Arrays.toString(a3));

    }


static void printTable(String mess, Integer[] a) {
    System.out.print(mess + "[ ");
    for (int d : a) System.out.print(d + " ");
    System.out.print("]\n");
}

}


abstract class Pacjent {

        String name;

        public Pacjent(String name) {
            this.name = name;
        }

        public abstract String nazwisko();

        public abstract String choroba();

        public abstract String leczenie();
    }

class ChoryNaGlowe extends Pacjent {

        private String panaceum;
        private String objaw;

        public ChoryNaGlowe(String name) {
            super(name);
            this.panaceum = "Aspiryna";
            this.objaw = "głowa";

        }

        public String nazwisko() {
            return super.name;
        };

        public String choroba() {
            return objaw;
        };

        public String leczenie() {
            return panaceum;
        };

    }

class ChoryNaNoge extends Pacjent {

        private String panaceum;
        private String objaw;

        public ChoryNaNoge(String name) {
            super(name);
            this.panaceum = "gips";
            this.objaw = "noga";

        }

        public String nazwisko() {
            return super.name;
        };

        public String choroba() {
            return objaw;
        };

        public String leczenie() {
            return panaceum;
        };

    }

class ChoryNaDyspepsje extends Pacjent{

    private String panaceum;
    private String objaw;


    public ChoryNaDyspepsje(String name) {
        super(name);
        this.panaceum = "węgiel";
        this.objaw = "dyspepsja";

    }

    public String nazwisko(){return super.name;};
    public String choroba(){return objaw;};
    public String leczenie(){return panaceum;};
}


