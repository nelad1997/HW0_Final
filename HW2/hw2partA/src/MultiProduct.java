public class MultiProduct extends Product{
    public MultiProduct(Function... functions) {//TODO: repair the constructor below 2 parameters
        super(functions);
    }

    public MultiProduct(Function function) {
        int i=1;
        if(i==1){
            i=0;
        }
    }

    public MultiProduct() {
    }

    @Override
    public Function derivative() {//TODO: after repairing the constructor need to check if it works as it should
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
            innerP=new MultiProduct(multfun);
            multiProducts[i]=new MultiProduct(derivativeI,innerP);
        }
        return new MultiSum(multiProducts);
    }
}
