/** Compare Version Numbers **/
/*========================================================================================================================
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
========================================================================================================================*/
// 考虑情况可能是0.0.1，0.0.0.1。
public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2)) return 0;
        int mainV1, mainV2;
        String subV1,subV2;
        if(version1.contains(".")){
            int pos = version1.indexOf(".");
            mainV1 = Integer.parseInt(version1.substring(0,pos));
            subV1 = version1.substring(pos+1);
        }
        else{
            mainV1 = Integer.parseInt(version1);
            subV1 = "0";
        }
        
        if(version2.contains(".")){
            int pos = version2.indexOf(".");
            mainV2 = Integer.parseInt(version2.substring(0,pos));
            subV2 = version2.substring(pos+1);
        }
        else{
            mainV2 = Integer.parseInt(version2);
            subV2 = "0";
        }
        
        if(mainV1>mainV2){
            return 1;
        }
        else if(mainV1<mainV2){
            return -1;
        }
        else{
            return compareVersion(subV1,subV2);
        }
    }
}