import java.lang.Math;

public class Polynomial extends Function {
    protected double[] coefficients;

    public Polynomial(double ...coefficient) {
        this.coefficients = coefficient;//test it.
    }
    @Override
    public double valueAt(double a) {
        int len=coefficients.length;
        double value=0;
        for(int i=0;i<len;i++){
            value+=coefficients[i]*(Math.pow(a,i));
        }
        return value;
    }

    @Override
    public String toString() {
        String str = "(";
        int len = coefficients.length;
        boolean flag=false;
        if(coefficients[0]!=0) {
            flag = true;
            str += coefficients[0];
        }
        for (int i = 1; i < len; i++) {
            if(coefficients[i]!=0){
                flag=true;
                if(coefficients[i]==1)
                    str+="x^"+i;
                else if(coefficients[i]==-1)
                    str+="-x^"+i;
                else
                    str+= coefficients[i]+"x^"+i;
            }
        }
        if(!flag)
            str+="0";
        return str+")";
    }
    @Override
    public Function derivative() {
        int len=coefficients.length;
        double[] derivative_Coefficients=new double[len-1];
        for(int i=0;i<len-1;i++){
            derivative_Coefficients[i]=(i+1)*coefficients[i+1];
        }
        return new Polynomial(derivative_Coefficients);
    }


}
