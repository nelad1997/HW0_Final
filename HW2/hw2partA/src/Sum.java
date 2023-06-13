public class Sum extends Function{
    protected Function function1;
    protected Function function2;

    public Sum(Function function1, Function function2) {
        this.function1=function1;
        this.function2=function2;
    }

    @Override
    public double valueAt(double a) {
        return function1.valueAt(a) + function2.valueAt(a);

    }


    @Override
    public String toString() {
        return "(" + function1 + " + " + function2 + ")";

    }

    @Override
    public Function derivative() {
        Function firstD= function1.derivative();
        Function secondD= function2.derivative();
        return new Sum(firstD,secondD);
    }
}
/*    public double valueAt(double a) {
        int len =functions.length;
        int multiS=0;
        for(int i=0;i<len;i++)
            multiS+=functions[i].valueAt(a);
        return multiS;
    }//
       public String toString() {
        int len = functions.length;
        String str="(";
        for (int i = 0; i < len-1; i++)
            str+= functions[i] + "+";
        str+=functions[len-1]+")";
        return str;
    }
 */