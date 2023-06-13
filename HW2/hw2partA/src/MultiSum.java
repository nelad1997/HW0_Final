public class MultiSum extends Sum{
    private Function[] functions;
    public MultiSum(Function function1, Function function2,Function... functions) {//TODO: check how to make compilation error if the num of args<2
        super(function1, function2);
        this.functions = functions;
    }
    @Override
    public String toString() {
        int len = functions.length;
        String str = "(" + function1 + " + " + function2;
        for (int i = 0; i < len; i++)
            str += " + " + functions[i] ;
        return str + ")";
    }
    @Override
    public double valueAt(double a) {
        int len =functions.length;
        double multiS=0;
        for(int i=0;i<len;i++)
            multiS+=functions[i].valueAt(a);
        return super.valueAt(a)+multiS;
    }
    @Override
    public Function derivative() {
        int len =functions.length;
        if (len == 0)
            return super.derivative();
        Function []sumFunctions=new Function[len];
        for(int i=0;i<len;i++)
            sumFunctions[i]=functions[i].derivative();
        return new MultiSum(function1.derivative(),function2.derivative(),sumFunctions);
    }

}
