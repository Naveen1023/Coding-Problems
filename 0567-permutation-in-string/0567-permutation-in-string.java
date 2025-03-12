class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int f1[] = new int[26];
        int temp[] = new int[26];
        int left = 0;
        int right = 0;

        for (int i = 0; i < s1.length(); i++)
            f1[s1.charAt(i) - 'a']++;
        // put the initial window
        while (right < s2.length() && (right - left + 1) < n1 - 1) {
            temp[s2.charAt(right++) - 'a']++;
        }

        // window is fixed now, at each step check is permutation, otherwise left++,
        // right++
        while (right < s2.length()) {
            temp[s2.charAt(right) - 'a']++;

            while (left <= right && right - left + 1 > n1) {
                temp[s2.charAt(left++) - 'a']--;
            }

            // System.out.println("left:"+left+"right:"+right);

            if (right - left + 1 == n1)
                if (isPermutation(f1, temp))
                    return true;

            right++;
        }
        return false;
    }

    public boolean isPermutation(int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

}

/**
 * permutation(all char together) should be present in s2.
 * 
 */