public class Product extends Function{
    protected Function function1;
    protected Function function2;

    public Product(Function function1, Function function2) {
        this.function1=function1;
        this.function2=function2;
    }

    @Override
    public double valueAt(double a) {
        return function1.valueAt(a) * function2.valueAt(a);

    }

    @Override
    public String toString() {
        return "(" + function1 + " * " + function2 + ")";

    }



    @Override
    public Function derivative() {
        Function firstD=function1.derivative();
        Function secondD=function2.derivative();
        Product firstP=new Product(firstD,function2);
        Product secondP=new Product(secondD,function1);
        return new Sum(firstP,secondP);
    }
}
/*int len =functions.length;
        double product=1;
        for(int i=0;i<len;i++)
            product*=functions[i].valueAt(a);
        return product;*/

/*    public String toString() {
        int len = functions.length;
        String str="(";
        for (int i = 0; i < len-1; i++)
            str+= functions[i] + "*";
        str+=functions[len-1]+")";
        return str;
    }*/