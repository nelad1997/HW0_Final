import java.lang.Math;
public class Power extends Function{
    private Function function;
    private int n;

    public Power(Function function, int n) {
        this.function = function;
        this.n = n;
    }

    @Override
    public double valueAt(double a) {
        return Math.pow(function.valueAt(a),n);
    }

    @Override
    public String toString() {
        return "("+function+"^"+n+")";
    }

    @Override
    public Function derivative() {
        if(n==1)
            return function.derivative();
        Constant power=new Constant(n);
        Function derivative=function.derivative();
        Function nMinusone=new Power(function,n-1);
        return new MultiProduct(power,nMinusone,derivative);
    }
}
