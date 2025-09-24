class Solution {
    String b;
    List<List<String>> ans = new ArrayList<>();

    Map<String, Integer> mp = new HashMap<>();

    public void backTrack(String word, List<String> seq){
        if(word.equals(b)){
            List<String> dup = new ArrayList<>(seq);

            Collections.reverse(dup);

            ans.add(dup);
            return;
        }

        int steps = mp.get(word);

        for(int i = 0; i < word.length(); i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                char[] charArray = word.toCharArray();
                charArray[i] = ch;
                String replacedWord = new String(charArray);
                if(mp.containsKey(replacedWord) && mp.get(replacedWord)+1 == steps){
                    seq.add(replacedWord);
                    backTrack(replacedWord, seq);
                    seq.remove(seq.size() -1);
                }
            }
        }
    }
    

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> st = new HashSet<>();

        for(int i = 0; i < wordList.size(); i++){
            st.add(wordList.get(i));
        }

        Queue<String> q = new LinkedList<>();

        b = beginWord;

        q.add(beginWord);
        mp.put(beginWord,1);
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek();
            int steps = mp.get(word);
            
            q.remove();

            if(word.equals(endWord)) break;
            for(int j = 0; j < word.length(); j++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] charArray = word.toCharArray();
                    charArray[j] = ch;
                    String replacedWord = new String(charArray);

                    if(st.contains(replacedWord)){
                        q.add(replacedWord);
                        st.remove(replacedWord);
                        mp.put(replacedWord, steps+1);     
                    }
                }
            }
        }

        ans = new ArrayList<>();

            if(mp.containsKey(endWord)){
                List<String> seq = new ArrayList<>();
                seq.add(endWord);
                backTrack(endWord, seq);
            }

            return ans;

    }
}