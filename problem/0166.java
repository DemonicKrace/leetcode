class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // replace with long type
        long n = (long)numerator;
        long d = (long)denominator;        
        long integerPart = (n / d);
        String result = String.valueOf(integerPart);
        // if divisible in integer
        if (n % d == 0) return result;
        StringBuilder decimalPart = new StringBuilder();
        // divided number => location index
        Map<Long, Integer> record = new HashMap();        
        boolean isDivisible = false;
        int count = 0;
        boolean isPostive = (n < 0 && d < 0) || (n > 0 && d > 0);
        // convert to postive
        result = String.valueOf(Math.abs(integerPart));
        n = Math.abs(n);
        d = Math.abs(d);
        // integer part already computed
        n %= d;
        while (!isDivisible) {
            // check numerator whether processed
            if (record.containsKey(n)) {
                decimalPart.insert(record.get(n), "(");
                decimalPart.append(")");
                break;
            }
            record.put(n, count++);
            n *= 10;
            int digit = (int)(n / d);
            decimalPart.append(digit);
            // update numerator
            if (n >= d) n %= d;
            isDivisible = (n % d == 0);
        }
        result = isPostive ? result : "-" + result;
        result = decimalPart.length() > 0 ? result + "." + decimalPart.toString() : result;        
        return result;
    }
}