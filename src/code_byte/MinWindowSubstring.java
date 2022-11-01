package code_byte;

class MinWindowSubstring {

    public static String MinWindowSubstringTest(String[] strArr) {
        String N = strArr[0];
        String K = strArr[1];
        int min = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < N.length(); i++) {
            StringBuilder match = new StringBuilder(K);
            for (int j=i; j < N.length(); j++) {
                if (match.toString().contains(String.valueOf(N.charAt(j)))) {
                    int index = match.indexOf(String.valueOf(N.charAt(j)));
                    match.replace(index, index + 1, "");
                }

                if (match.length() == 0) {
                    if (j - i < min) {
                        min = j - i;
                        result = N.substring(i, j+1);
                    }
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.print(MinWindowSubstringTest(new String[]{"abcaaaabbbbbbccccbbbbbaaaaa", "bca"}));
    }

}

//Input: new String[] {"ahffaksfajeeubsne", "jefaa"}
//Output: aksfaje
//Input: new String[] {"aaffhkksemckelloe", "fhea"}
//Output: affhkkse