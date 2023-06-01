import java.lang.Math;

public class Polynomial extends Function {
    protected double[] coefficients;

    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public double valueAt(double a) {
        int len = coefficients.length;
        double value = 0;
        for (int i = 0; i < len; i++) {
                value += coefficients[i] * (Math.pow(a, i));
        }
        return value;
    }

    public boolean intOrDouble(double a) {
        return  (int) a == a;
    }

    @Override
    public String toString() {// TODO: check if the number is int or double
        int len = coefficients.length;
        int counter_0 = 0;
        for (double coefficient : coefficients) {
            if (coefficient == 0)
                counter_0++;
        }
        if (counter_0 == len)
            return "(0)";
        StringBuilder str = new StringBuilder("(");
        for (int i = 0; i < len; i++) {
            if (i>= 0 && coefficients[i] != 0) {
                int intcof = (int) coefficients[i];
                if (i == 0 && intOrDouble(coefficients[i]))
                    str.append(intcof).append(" + ");

                else if (i == 0)
                    str.append(coefficients[i]).append(" + ");
                else if (coefficients[i] == 1)
                    str.append("x^").append(i).append(" + ");
                else if (coefficients[i] == -1)
                    str.append("-x^").append(i).append(" + ");
                else if (intOrDouble(coefficients[i])) {
                    str.append(intcof).append("x^").append(i).append(" + ");
                } else
                    str.append(coefficients[i]).append("x^").append(i).append(" + ");
            }
        }
        return str.substring(0, str.length() - 3) + ")";
    }

    @Override
    public Function derivative() {

        int len = coefficients.length ;
        if (len==1)
            return new Polynomial(0);
        else {
            len=len-1;
            double[] derCoefficients = new double[len];

            for (int i = 0; i < len; i++) {
                derCoefficients[i] = coefficients[i + 1] * (i + 1);

            }
            return new Polynomial(derCoefficients);
        }



    }
}
//int len = coefficients.length;
//        int[] clone_Powers = new int[len];
//        for (int i =0; i < len; i++){
//            clone_Powers[i]=powers[i];
//        }
//        double[] derivative_Coefficients = new double[len];
//        for (int i = 0; i < len ; i++) {
//            if (clone_Powers[i] > 0)
//                derivative_Coefficients[i] = clone_Powers[i] * coefficients[i];
//            else
//                derivative_Coefficients[i] = 0;
//            clone_Powers[i] = i - 1;
//        }
//        return new Polynomial(derivative_Coefficients,clone_Powers);//second constructor
//    }