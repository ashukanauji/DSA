class Solution {
    public int maxDiff(int num) {
        String str = Integer.toString(num);
        char[] a = str.toCharArray();
        char[] b = str.toCharArray();

        char maxNum = ' ';
        for(char ch : a){
            if(ch != '9'){
                maxNum = ch;
                break;
            }   
        }

        for(int i = 0; i < a.length; i++){
            if(a[i] == maxNum)
                a[i] = '9';
        }

        char minNum = b[0];
        int flag = 0;
        for(int i = 0; i < b.length; i++){
            if(b[i] == '0')
                continue;
            if(b[i] != '1'){
                if(i > 0)
                    flag = 1;
                minNum = b[i];
                break;
            }   
        }

        for(int i = 0; i < b.length; i++){
            if(b[i] == minNum && flag == 0)
                b[i] = '1';
            else if(b[i] == minNum)
                b[i] = '0';
        }

        int maxVal = Integer.parseInt(new String(a));
        int minVal = Integer.parseInt(new String(b));

        return maxVal - minVal;


    }
}