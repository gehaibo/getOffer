package 刷题归类.剑指offer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class 面试题53正则表达式匹配 {
    //模式匹配.和*

    /**
     *思路：因为*要和前面匹配，都是从二个开始考虑规则。
     * 当模式中的第二个字符不是“*”时：
     1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
     2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

     而当模式中的第二个字符是“*”时：
     如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。（匹配0的情况）
     如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
     1、模式后移2字符，相当于x*被忽略；（匹配0的情况）
     2、字符串后移1字符，模式后移2字符；开始新一轮比较
     3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；继续比较

     *
     */
    public boolean match(char[] str, char[] pattern){
        if(str==null||pattern==null) return false;
        int strIndex=0;
        int patternIndex=0;
        return matchPattern(str,strIndex,pattern,patternIndex);

    }

    private boolean matchPattern(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //都到结尾，匹配成功
        if (strIndex==str.length&&patternIndex==pattern.length) return true;
        //pattern先到尾，匹配失败
        if (strIndex!=str.length&&patternIndex==pattern.length) return false;

        //模式第2个是*
        if (patternIndex + 1 < pattern.length && pattern[patternIndex+1]=='*'){
            //字符串第一个字符跟模式第一个字符匹配
            if ((strIndex!=str.length&&str[strIndex]==pattern[patternIndex])||(strIndex!=str.length&&pattern[patternIndex] == '.')){
                return matchPattern(str,strIndex,pattern,patternIndex+2)||
                        matchPattern(str,strIndex+1,pattern,patternIndex+2)||
                        matchPattern(str,strIndex+1,pattern,patternIndex);
            }else {
                return matchPattern(str,strIndex,pattern,patternIndex+2);
            }
        }

        //模式第2个是不是*
        //字符串第一个字符跟模式第一个字符匹配
        if ((strIndex!=str.length&&str[strIndex]==pattern[patternIndex])||(strIndex!=str.length&&pattern[patternIndex] == '.')){
            return matchPattern(str,strIndex+1,pattern,patternIndex+1);
        }else {
            return false;
        }
    }
}
