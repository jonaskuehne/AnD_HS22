public class CallCountB {
    public static void main(String[] args) {
        int n = 17;
        int i = n;

        int count = 0;

        while (i > 0) {
            ++count;
            int j = 0;
            while (j < n) {
                ++count;
                int k = j;
                while (k < n) {
                    ++count;
                    ++k;
                }
                ++j;
            }
            i /= 2;
        }

        System.out.println(n + ": " + count);
    }
}
