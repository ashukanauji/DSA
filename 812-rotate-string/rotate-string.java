class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal))
            return true;
        StringBuilder str = new StringBuilder(s);
        for(int i=0; i<str.length(); i++){
            str.append(str.charAt(0));
            str.deleteCharAt(0);
            if(str.toString().equals(goal))
                return true;
        }
        return false;
    }
}