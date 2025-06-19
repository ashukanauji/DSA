class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left <= right){
            char a = s.charAt(left);
            char b = s.charAt(right);

            if(a >= 'A' && a <= 'Z')
                a += 'a' - 'A'; // adding 32 i.e converting into a lowercase character
            else if((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9'))
                a += 0;
            else{
                left++;
                continue;
            }
                


            if(b >= 'A' && b <= 'Z')
                b += 'a' - 'A'; // adding 32 i.e converting into a lowercase character
            else if((b >= 'a' && b <= 'z') || (b >= '0' && b <= '9'))
                b += 0;
            else{
                right--;
                continue;
            }

            if(a != b)
                return false;
            left++;
            right--; 
        }
        return true;
    }
}