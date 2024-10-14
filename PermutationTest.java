public class PermutationTest {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean result1 = p.checkInclusion(s1, s2);
        System.out.println("One of s1's permutations is the substring of s2: " + result1);

        String s3 = "ab";
        String s4 = "eidbaoo";
        boolean result2 = p.checkInclusion(s3, s4);
        System.out.println("One of s3's permutations is the substring of s4: " + result2);

        String s5 = "";
        String s6 = "eidbaoo";
        boolean result3 = p.checkInclusion(s5, s6);
        System.out.println("One of s5's permutations is the substring of s6: " + result3);

        String s7 = "ab";
        String s8 = "";
        boolean result4 = p.checkInclusion(s7, s8);
        System.out.println("One of s7's permutations is the substring of s8: " + result4);
    }
}
