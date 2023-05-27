public class Difference extends Function{

    protected Function []functions=new Function[2];

    public Difference(Function func1,Function func2) {
        this.functions[0] = func1;
        this.functions[1] = func2;
    }

    @Override
    public double valueAt(double a) {
        return (functions[0].valueAt(a))-(functions[1].valueAt(a));
    }

    @Override
    public String toString() {
        return "("+functions[0]+"-"+functions[1]+")";
    }

    @Override
    public Function derivative() {
        Function firstD=functions[0].derivative();
        Function secondD=functions[1].derivative();
        return new Difference(firstD,secondD);

    }
}
