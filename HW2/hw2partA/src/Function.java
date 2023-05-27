public abstract class Function {
    protected final double EPSILON_DEFAULT =1e-5;
    protected final double ZERO=0;
    public  abstract double valueAt(double a);
    @Override
    public abstract String toString();
    public abstract Function derivative();
    public  double bisectionMethod(double a, double b,double epsilon){
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
    public  double bisectionMethod(double a, double b){
        return bisectionMethod( a,  b, EPSILON_DEFAULT);
    }
    public  double newtonRaphsonMethod(double a, double epsilon){
        double xk=a;
        Function der_Function=derivative();
        while((Math.abs(valueAt(xk))<epsilon)){
            double derAtPoint=der_Function.valueAt(xk);
            double funAtPoint=valueAt(xk);
            xk-=derAtPoint/funAtPoint;
        }
        return xk;
    }
    public  double newtonRaphsonMethod(double a){
        return newtonRaphsonMethod(a, EPSILON_DEFAULT);
    }
    public  Polynomial taylorPolynomial(int n){
        double[] taylor_Coefficients=new double[n+1];
        Function der_Function=derivative();
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


