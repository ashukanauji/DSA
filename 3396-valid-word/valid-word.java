class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3)
            return false;
        String vowel = "aeiouAEIOU";
        int vowelFlag = 0, consoFlag = 0, digitFlag = 0;

        int otherFlag = 0;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(vowel.contains(String.valueOf(ch)))
                vowelFlag = 1;
            else if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                consoFlag = 1;
            else if(ch >= '0' && ch <= '9')
                digitFlag = 1;
            else
                return false;
        }
        if(vowelFlag == 1 && consoFlag == 1)
            return true;
        return false;
    }
}