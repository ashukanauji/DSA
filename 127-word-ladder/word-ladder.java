class Pair{
    String first;
    int level;

    Pair(String first, int level){
        this.first = first;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        Set<String> st = new HashSet<>();

        int len = wordList.size();

        for(int i = 0; i < len; i++)
            st.add(wordList.get(i));

        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().level;
            q.remove();

            if(word.equals(endWord) == true)
                return step;
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replaceChar = word.toCharArray();
                    replaceChar[i] = ch;
                    String replacedWord = new String(replaceChar);

                    if(st.contains(replacedWord) == true){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, step+1));
                    }
                }
            }
        }

        return 0;
    }
}