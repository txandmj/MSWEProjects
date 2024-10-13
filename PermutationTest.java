public class PermutationTest {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        String s1 = "ab";
        String s2 = "dbaoo";
        boolean result = p.checkInclusion(s1, s2);
        System.out.println("One of s1's permutations is the substring of s2: " + result);
    }
}
