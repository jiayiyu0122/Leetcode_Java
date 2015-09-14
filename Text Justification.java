/** Text Justification **/
/*============================================================================================
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
============================================================================================*/
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words==null || words.length==0){
            return res;
        }
        // 用来算上一次的单词长度的长度；
        int count = 0;
        // 标记每一行的第一个字符串,从而来算空格数
        int last = 0;
        
        for(int i=0; i<words.length; i++){
            if(count+words[i].length()+(i-last)>maxWidth){
                // 当空格大于一的情况（至少有两个单词）
                if(i-last-1>0){
                    int spaceNum = (maxWidth-count)/(i-last-1);
                    int extraNum = (maxWidth-count)%(i-last-1);
                    
                    // 组建string
                    StringBuilder str = new StringBuilder();
                    for(int j=last; j<i; j++){
                        str.append(words[j]);
                        // 不是最后一个单词，后面要加space
                        if(j<i-1){
                            // 加空格
                            for(int k=0; k<spaceNum; k++){
                                str.append(" ");
                            }
                            if(extraNum>0){
                                str.append(" ");
                                extraNum--;
                            }
                        }
                        
                    }
                    
                    res.add(str.toString());
                }
               else if(i-last-1==0){
                   int spaceNum = maxWidth-count;
                   StringBuilder str = new StringBuilder();
                   str.append(words[last]);
                   for(int k=0; k<spaceNum; k++){
                       str.append(" ");
                   }
                   res.add(str.toString());
               }
               
            //   set 
            // i--;
            count = 0;
            last = i;
                
            }
            count += words[i].length();
        }
        
        // 处理最后一行
        StringBuilder str = new StringBuilder();
        for(int k=last; k<words.length; k++){
            str.append(words[k]);
            if(str.length()<maxWidth){
                str.append(" ");
            }
        }
        for(int k=str.length(); k<maxWidth; k++){
            str.append(" ");
        }
        res.add(str.toString());
        
        return res;
        
    }
}