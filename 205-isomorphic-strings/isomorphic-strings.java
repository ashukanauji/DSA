class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (mapST.containsKey(sc)) {
                if (mapST.get(sc) != tc) return false;
            } else {
                mapST.put(sc, tc);
            }

            if (mapTS.containsKey(tc)) {
                if (mapTS.get(tc) != sc) return false;
            } else {
                mapTS.put(tc, sc);
            }
        }

        return true;
    }
}
