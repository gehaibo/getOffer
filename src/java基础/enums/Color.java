package java基础.enums;

/**
 * Created by ghb on 2017/1/5.
 */
public enum Color {
    RED("红色",1),GREEN("绿色",2),BLANK("白色",2),YELLOW("黄色",3);

    private String name;
    private int number;

    private Color(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static String getName(int index){
        for (Color  c : Color.values()) {
            if (c.getNumber() == index ){
                return c.getName();
            }
        }
        return null;
    }
}
