class Solution {
    static List<List<String>> res;
    static HashSet<String> palindromes;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        palindromes = new HashSet<>();

        solve(s, new ArrayList<>());
        return res;
    }

    public static void solve(String s, List<String> list) {

        if(s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<s.length();i++) {
            String sub = s.substring(0,i+1);
            if(isPalindrome(sub)) {
                palindromes.add(sub);

                list.add(sub);
                solve(s.substring(i+1, s.length()), list);
                list.remove(list.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        if(palindromes.contains(s)) return true;
        
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}