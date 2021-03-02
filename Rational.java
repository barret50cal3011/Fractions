public class Rational {

    private int numerator, denominator;

    public Rational(double d) {
         String s = String.valueOf(d);
         int digitsDec = s.length() - 1 - s.indexOf('.');        

         int denom = 1;
         for(int i = 0; i < digitsDec; i++){
            d *= 10;
            denom *= 10;
         }
         int num = (int) Math.round(d);

         this.numerator = num; this.denominator = denom;
         Rational r = reduce();
         this.numerator = r.numerator;
         this.denominator = r.denominator;
    }

    private int gcd(int denom1, int denom2)
    {
       int factor = denom2;
       while (denom2 != 0) {
          factor = denom2;
          denom2 = denom1 % denom2;
          denom1 = factor;
       }
       return denom1;
    }

    private Rational reduce()
    {
          Rational result = new Rational();
       int common = 0;
       // get absolute values for numerator and denominator
       int num = Math.abs(numerator);
       int den = Math.abs(denominator);
       // figure out which is less, numerator or denominator
       if (num > den)
          common = gcd(num, den);
       else if (num < den)
          common = gcd(den, num);
       else  // if both are the same, don't need to call gcd
          common = num;
 
       // set result based on common factor derived from gcd
       result.numerator = num / common;
       result.denominator = denominator / common;
       return result;
    }

    public Rational(int num, int denom) {
         this.numerator = num; this.denominator = denom;
    }

    public Rational() {
    }

    public String toString() {
         return String.valueOf(numerator) + "/" + String.valueOf(denominator);
    }

    public static void main(String[] args) {
         System.out.println(new Rational(0.75));
    }
}