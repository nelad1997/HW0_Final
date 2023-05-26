public abstract class Function {
    protected final double deafult_Epsilon=1e-5;
    protected final double ZERO=0;
    public  abstract double valueAt(double x);
    @Override
    public abstract String toString();
    public abstract Polynomial derivative();
    public abstract double bisectionMethod(double x, double y,double epsilon);
    public abstract double bisectionMethod(double x, double y);
    public abstract double newtonRaphsonMethod(double x, double epsilon);
    public abstract double newtonRaphsonMethod(double x);
    public abstract Polynomial taylorPolynomial(int n);

}
