class Solution {
    public List<String> letterCombinations(String digits) {
     
        String arr[] = {"abc", "def", "ghi","jkl","mno","pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        String str = "";
        if(digits.length() == 0)
            return list;
        
        findLetterCombination(0, 0, digits, arr, list,str);
        return list;
    }
    
    void findLetterCombination(int indexDigit, int indexString, String digits, String arr[], List<String> list, String str){
        
        if(indexDigit == digits.length())
        {
            list.add(str);
            return;
        }        
        int digit = Character.getNumericValue(digits.charAt(indexDigit));
        digit-=2;
        for(int i = 0;i<arr[digit].length();i++){
            findLetterCombination(indexDigit + 1, indexString, digits, arr, list, str + arr[digit].charAt(i));
            
        }
        
        
    }
    
    
}