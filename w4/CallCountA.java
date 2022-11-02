public class CallCountA {
    public static void main(String[] args) {
        int count = 0;

        int n = 15;
        int i = 0;
        while (Math.pow(2, i) < n) {
            int j = i;
            while (j < n) {
                ++count;
                System.out.println(i + " " + j + " " + count);
                ++j;
            }
            ++i;
        }
        System.out.println(count);
    }
}
