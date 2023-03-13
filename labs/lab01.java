package labs;
import Libra.*;

public class lab01 {

   final static double epsilon = 0.00001d;

   public static void main(String[] args) {

      // Zadania 11
      Assistant assistant = new Assistant();
      assistant.printSeparator("Zadanie 1");

      TwoStringsOper[] a = {
            new Concat(), new ConcatRev(),
            new Initials(), new Separ("loves")
      };

      for (TwoStringsOper op : a) {
         System.out.println(op.apply("Mary", "John"));
      }




      assistant.printSeparator("Zadanie 2");

      Func f = new Func() {
         @Override
         public double apply(double x) {

            return x*x;

         }
      };

      Func g = new Func() {
         @Override
         public double apply(double x) {

            return ++x;

         }
      };

      Func cmp1 = Func.compose(f, g);
      Func cmp2 = Func.compose(g, f);
      Func cmp3 = Func.compose(Func.compose(g, cmp1), f);
      Func cmp4 = Func.compose(g, Func.compose(cmp2, f));
      System.out.println("Res1: " + cmp1.apply(3));
      System.out.println("Res2: " + cmp2.apply(3));
      System.out.println("Res3: " + cmp3.apply(3));
      System.out.println("Res4: " + cmp4.apply(3));
      
      assistant.printSeparator("Zadanie 3");

      Parabola parabola = new Parabola(1,-1,1.25);


      System.out.println( "Parabola, 0.5 == " + FunDD.xminim(parabola, 0,1));

      FunDD fdd = new FunDD() {
         @Override
         public double fun(double x) {
            return Math.sqrt( Math.pow((x - 0.75),2) + 1);
         }
      };

      System.out.println( "Klasa anonimowa, 0.75 == " +FunDD.xminim(fdd, 0, 2));

      FunDD lamfun = (x) -> {return Math.pow(x, 2) * (x-2);};
      System.out.println( "Lambda, 1.33 == " + FunDD.xminim(lamfun , 0,2));

   }

}

// <zad 1>
interface TwoStringsOper {
   public String apply(String alpha, String beta);
}

class Concat implements TwoStringsOper {
   @Override
   public String apply(String alpha, String beta) {
      return alpha + " " + beta;

   }
}

class ConcatRev implements TwoStringsOper {
   @Override
   public String apply(String alpha, String beta) {
      return beta + " " + alpha;

   }
}

class Initials implements TwoStringsOper {
   @Override
   public String apply(String alpha, String beta) {
      return alpha.substring(0, 1) + beta.substring(0, 1);

   }
}

class Separ implements TwoStringsOper {

   private String separator;

   public Separ(String separator) {
      this.separator = " " + separator + " ";
   }

   @Override
   public String apply(String alpha, String beta) {

      return alpha + separator + beta;

   }

}
// </zad 1>

// <zad 2>
interface Func {
   public double apply(double x);
   public static Func compose(Func f, Func g){

      Func res = new Func(){

         @Override
         public double apply(double x) {

           return f.apply(g.apply(x));
      }

   };
   return res;
}

}
// </zad 2>

// <zad 3>
@FunctionalInterface 
interface FunDD {
   double fun(double x);

   static double xminim(FunDD f, double a, double b) {
     if (Math.abs(a - b) > lab01.epsilon) {

      double mid = (a+b)/2;
      double fa = f.fun(a);
      double fb = f.fun(b);

      double newParam = fa < fb ? a : b;

      return xminim(f, newParam, mid);
      
     }
     else{
      return a;

     }

   
   }

}

class Parabola implements FunDD{
   private double a;
   private double b;
   private double c;

   public Parabola(double a, double b, double c) {
      this.a = a;
      this.b = b;
      this.c = c;
   }

   @Override
   public double fun(double x) {
    
      return a*(x*x) + b*x + c;
   }


}

