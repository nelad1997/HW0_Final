public class Product extends Function{
    protected Function[]functions;

    public Product(Function ...functions) {
        this.functions=functions;
    }

    @Override
    public double valueAt(double a) {
        int len =functions.length;
        double product=1;
        for(int i=0;i<len;i++)
            product*=functions[i].valueAt(a);
        return product;

    }

    @Override
    public String toString() {
        int len = functions.length;
        String str="(";
        for (int i = 0; i < len-1; i++)
            str+= functions[i] + "*";
        str+=functions[len-1]+")";
        return str;
    }



    @Override
    public Function derivative() {
        Function firstD=functions[0].derivative();
        Function secondD=functions[1].derivative();
        Product firstP=new Product(firstD,functions[1]);
        Product secondP=new Product(functions[0],secondD);
        return new Sum(firstP,secondP);
    }
}
