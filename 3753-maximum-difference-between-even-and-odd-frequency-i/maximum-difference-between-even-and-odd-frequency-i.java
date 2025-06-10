class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch , hm.getOrDefault(ch,0)+1);
        }

        int minEven = Integer.MAX_VALUE, maxOdd = 0;

        for(Map.Entry<Character, Integer> element : hm.entrySet()){
            Character ch = element.getKey();

            int freq = element.getValue();

            if(freq%2 == 0)
                minEven = Math.min(freq, minEven);
            else
                maxOdd = Math.max(freq, maxOdd);
        }
        return maxOdd - minEven;
    }
}