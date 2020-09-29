class Challenge3 {
    public static int palindromeChainLength(long n) {
        if (n < 10) {
            return 0;
        }
        String str = "" + n;
        if (str.charAt(0) == str.charAt(1)) {
            return 0;
        }
        return recursion(n, 0);
    }

    public static int recursion(long n, int count) {
        long val = n;
        String reversed = "";
        while (val > 9) {
            reversed += val % 10;
            val /= 10;
        }
        reversed += val;
        long longval = Long.parseLong(reversed);
        long result = n + longval;
        String res = "";
        res += result;
        int len = res.length();

        boolean check = true;
        for (int i =0; i < len/2; i++) {
            if (res.charAt(i) != res.charAt(res.length()-(1+i))) {
                check = false;
            }
        }
        if (check == false) {
            if (count == 0){
                count++;
            }
            count++;
            return recursion(result, count);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(palindromeChainLength(52));
        System.out.println(palindromeChainLength(88));
        System.out.println(palindromeChainLength(89));
        System.out.println(palindromeChainLength(87));
        System.out.println(palindromeChainLength(100));
    }
}