class Challenge {
    public static long triangular( Integer n ) {
        System.out.println(n);
        long sum = 0;
        while (n > 0) {
            sum += n;
            n--;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(triangular(3));
    }
}
