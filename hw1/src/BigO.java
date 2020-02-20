public class BigO implements BigOInterface {

    public void cubic(int n) {
        int sum=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    sum = sum+1;
                }
            }
        }
    }


    public void constant(int n) {
        int sum=n;
    }


    public void exp(int n) {
        int sum=0;
        for(int i=0;i<Math.pow(2, n);i++) {
            sum=sum+1;
        }

    }
}
