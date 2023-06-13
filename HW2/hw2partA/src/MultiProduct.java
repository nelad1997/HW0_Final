public class MultiProduct extends Product{

    private Function[] functions;


    public MultiProduct(Function function1, Function function2,Function... functions) {//TODO: repair the constructor below 2 parameters
        super(function1, function2);
        this.functions = functions;
    }

    @Override
    public String toString() {
        int len = functions.length;
        String str = "(" + function1 + " * " + function2;
        for (int i = 0; i < len; i++)
            str += " * " + functions[i] ;
        return str + ")";
    }
    @Override
    public double valueAt(double a) {
        int len =functions.length;
        double product=1;
        for(int i=0;i<len;i++)
            product*=functions[i].valueAt(a);

        return super.valueAt(a)*product;
    }

    @Override
    public Function derivative() {//TODO: after repairing the constructor need to check if it works as it should
        int len =functions.length;
        if (len == 0){
            return super.derivative();
        }
        MultiProduct [] multiProducts=new  MultiProduct [len];//temporary array of all products
        MultiProduct mult0 = new MultiProduct(function1.derivative(),function2,functions);
        MultiProduct mult1 = new MultiProduct(function2.derivative(),function1,functions);
        Function derivativeI;
        if(functions.length==2)
          return super.derivative();//the regular derivative method of Product Class, because there are only 2 Functions
        for(int i=0;i<len;i++){
            derivativeI=functions[i].derivative();
            Function []multfun=new Function[len];//Parameter to the first inner Product
            multfun[0]=function2;//we enterd the second function in the first place of a temporary array that includes all thr functions with i!=j
            for(int j=0,k=1; j<len;j++){
                if(j!=i) {
                    multfun[k] = functions[j];//all functions so that i!=j
                    k++;
                    }
                }
            multiProducts[i]=new MultiProduct(derivativeI,function1,multfun);
        }
        return new MultiSum(mult0,mult1,multiProducts);//TODO muly0 the first element of multisum, the firs gzira, mult1 is the second gzira, than all the gzirot
    }
}
/*    public Function derivative() {//TODO: after repairing the constructor need to check if it works as it should
        int len =functions.length;
        Product innerP;//inner multiProduct i!=j
        MultiProduct [] multiProducts=new  MultiProduct [len];//temporary array of all products
        Function derivativeI;
        if(functions.length==2)
          return super.derivative();//the regular derivative method of Product Class, because there are only 2 Functions
        for(int i=0;i<len;i++){
            derivativeI=functions[i].derivative();
            Function []multfun=new Function[len-1];//Parameter to the first inner Product
            for(int j=0,k=0; j<len;j++){
                if(j!=i) {
                    multfun[k] = functions[j];//all functions so that i!=j
                    k++;
                    }
                }
            multiProducts[i]=new MultiProduct();
        }
        return new MultiSum(multiProducts);
    }*/