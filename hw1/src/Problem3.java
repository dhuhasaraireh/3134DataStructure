public class Problem3 {
    public static void main(String[] args) {
        BigO t = new BigO();
        long[] constant= new long[20];
        long[] exp=new long[20];
        long[] cubic=new long[20];
        for(int i=1; i<21; i++) {
            long startTime1 = System.nanoTime();
            t.constant(i);
            long endTime1 = System.nanoTime();
            constant[i-1] =endTime1-startTime1;


            long startTime2 = System.nanoTime();
            t.cubic(i);
            long endTime2 = System.nanoTime();
            cubic[i-1] =endTime2-startTime2;

            long startTime3 = System.nanoTime();
            t.exp(i);
            long endTime3 = System.nanoTime();
            exp[i-1] =endTime3-startTime3;

        }

        System.out.println("-------------------- constant time ------------------------");

        for(int i = 0; i<20;i++) {
            System.out.print(constant[i]);
            System.out.print(" ");
        }
        System.out.println(" ");

        System.out.println("---------------------cubic time-------------------------------");
        for(int i = 0; i<20;i++) {
            System.out.print(cubic[i]);
            System.out.print(" ");
        }

        System.out.println(" ");
        System.out.println("---------------------exp time-------------------------------");
        for(int i = 0; i<20;i++) {
            System.out.print(exp[i]);
            System.out.print(" ");
        }




    }
}
