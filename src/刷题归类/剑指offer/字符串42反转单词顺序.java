package 刷题归类.剑指offer;

/**
 * “student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”
 * <p>
 * 传统思路：1.反转所有字符，2.反转每个字符
 * <p>
 * 直接用stringBuider，从后往前依次存入
 */
public class 字符串42反转单词顺序 {
    public String ReverseSentence(String str) {
        if (str == null) return null;
        if (str.trim().equals("")) return str;

        String[] strings = str.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (i == 0) {
                sBuilder.append(strings[i]);
            } else {
                sBuilder.append(strings[i]);
                sBuilder.append(" ");
            }
        }
        return sBuilder.toString();
    }
}
