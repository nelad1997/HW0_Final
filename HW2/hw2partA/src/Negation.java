public class Negation extends Function{

    Function nFunction;

    public Negation(Function Function) {
        this.nFunction = Function;
    }

    @Override
    public double valueAt(double a) {
        return -(nFunction.valueAt(a));
    }

    @Override
    public String toString() {
        return "("+"-"+nFunction+")";
    }

    @Override
    public Function derivative() {
        return new Negation(nFunction.derivative());
    }
}
