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
    public Polynomial derivative() {
        int len=coefficients.length;
        double[] derivative_Coefficients=new double[len-1];
        for(int i=0;i<len-1;i++){
            derivative_Coefficients[i]=(i+1)*coefficients[i+1];
        }
        return new Polynomial(derivative_Coefficients);
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        double left=a;
        double right=b;
        while(right-left>epsilon){
            double mid=(left+right)/2;
            if(valueAt(left)*valueAt(right)>0)
                left=mid;
            right=mid;
        }
        return (left+right)/2;
    }

    @Override
    public double bisectionMethod(double a, double b) {
        return bisectionMethod( a,  b, deafult_Epsilon);
    }

    @Override
    public double newtonRaphsonMethod(double a, double epsilon) {
        double xk=a;
        Polynomial der_Function=derivative();
        while((Math.abs(valueAt(xk))<epsilon)){
            double derAtPoint=der_Function.valueAt(xk);
            double funAtPoint=valueAt(xk);
            xk-=derAtPoint/funAtPoint;
        }
        return xk;
    }

    @Override
    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a,deafult_Epsilon);
    }

    @Override
    public Polynomial taylorPolynomial(int n) {
        double[] taylor_Coefficients=new double[n+1];
        Polynomial der_Function=derivative();
        taylor_Coefficients[0]=valueAt(ZERO);
        taylor_Coefficients[1]=der_Function.valueAt(ZERO);
        for(int k=2;k<n+1;k++){
            der_Function=der_Function.derivative();
            double derAtPoint=der_Function.valueAt(ZERO);
            taylor_Coefficients[k]=derAtPoint/factorial(k);
        }
        return new Polynomial(taylor_Coefficients);
    }
    public int factorial(int n){
        int x;
        for(x=1;x<=n;x++)
            x*=x;
        return x;
    }
}
