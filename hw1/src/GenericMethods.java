public class GenericMethods implements GenericMethodsInterface{
    GenericMethods() {

    }

    public <AnyType extends Comparable<AnyType>> int binarySearch(AnyType[] a, AnyType x) {
        int result = helper(a,x,0,a.length-1);
        return result;

    }


    private <AnyType extends Comparable<AnyType>> int helper(AnyType[] a, AnyType x, int low,int high) {
        if(low>high) {
            return -1;
        }
        int mid = low+ (high-low)/2;
        if(a[mid].compareTo(x)==0) {
            return mid;
        } else if (a[mid].compareTo(x)==-1) {
            return helper(a,x,mid+1,high);
        } else {
            return helper(a,x,low,mid-1);
        }

    }


    public <AnyType extends Comparable<AnyType>> int linearSearch(AnyType[] a, AnyType x) {
        int n = a.length;
        for(int i =0; i<n; i++) {
            if(a[i].compareTo(x)==0) {
                return i;
            }

        }
        return -1;
    }
}
