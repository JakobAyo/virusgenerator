package Folien;

public class test {
    public static int average(int... numbers){
        int total = 0;

        for (int i : numbers){
            total += i;
        }
        return total / numbers.length;
    }

    public static void main(String[] args) {
        int i1 = 10;
        int i2 = 12;
        int i3 = 14;
        int i4 = 16;
        int i5 = 18;

        System.out.printf("i1 = %d%ni2= %d%ni3 = %d%ni4 = %d%ni5 = %d%n", i1,i2,i3,i4,i5);

        System.out.printf("Average of i1 and i2 is %d%n", average(i1,i2));
        System.out.printf("Average of i1, i2 and i3 is %d%n", average(i1,i2,i3));
        System.out.printf("Average of i1, i2, i3 and i4 is %d%n", average(i1,i2,i3,i4));
        System.out.printf("Average of all number is %d%n", average(i1,i2,i3,i4,i5));
    }

}