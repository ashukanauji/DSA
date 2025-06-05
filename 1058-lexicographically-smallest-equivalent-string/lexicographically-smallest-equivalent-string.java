class Solution {
    int[] par = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < 26; i++) {
            par[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            char ch = baseStr.charAt(i);
            int root = find(ch - 'a');
            sb.append((char)(root + 'a'));
        }

        return sb.toString();
    }

    public int find(int x) {
        if (par[x] != x) {
            par[x] = find(par[x]);
        }
        return par[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        // Always attach the larger to the smaller to maintain lex smallest
        if (px < py) {
            par[py] = px;
        } else {
            par[px] = py;
        }
    }
}