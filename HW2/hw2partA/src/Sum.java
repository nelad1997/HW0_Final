public class Sum extends Function{
    protected Function []functions;

    public Sum(Function ...functions) {
        this.functions = functions;
    }

    @Override
    public double valueAt(double a) {
        int len =functions.length;
        int multiS=0;
        for(int i=0;i<len;i++)
            multiS+=functions[i].valueAt(a);
        return multiS;
    }

    @Override
    public String toString() {
        int len = functions.length;
        String str="(";
        for (int i = 0; i < len-1; i++)
            str+= functions[i] + "+";
        str+=functions[len-1]+")";
        return str;
    }

    @Override
    public Function derivative() {
        Function firstD=functions[0].derivative();
        Function secondD=functions[1].derivative();
        return new Sum(firstD,secondD);
    }
}
