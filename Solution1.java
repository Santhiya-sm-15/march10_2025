class Solution {
    public long countOfSubstrings(String word, int k) {
        int n=word.length();
        long cnt=0;
        int l=0,r=0;
        int vowels=0,consonants=0;
        int[] next=new int[n];
        Arrays.fill(next,n);
        int ind=n;
        for(int i=n-1;i>=0;i--)
        {
            next[i]=ind;
            char c=word.charAt(i);
            if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u')
                ind=i;
        }
        Map<Character,Integer> m=new HashMap<>();
        while(r<n)
        {
            char c=word.charAt(r);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                m.put(c,m.getOrDefault(c,0)+1);
            else
                consonants++;
            while(consonants>k)
            {
                char x=word.charAt(l);
                if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u')
                {
                    if(m.get(x)!=1)
                        m.put(x,m.get(x)-1);
                    else
                        m.remove(x);
                }
                else
                    consonants--;
                l++;
            }
            while(m.size()==5 && consonants==k)
            {
                cnt+=next[r]-r;
                char x=word.charAt(l);
                if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u')
                {
                    if(m.get(x)!=1)
                        m.put(x,m.get(x)-1);
                    else
                        m.remove(x);
                }
                else
                    consonants--;
                l++;
            }
            r++;
        }
        return cnt;
    }
}