package javaBase.泛型;

/**
 * 限制泛型的可用类型
 */
public class Deme4 {
    public <T extends Number> T getMax(T array[]) {
        T max = null;
        for (T element : array) {
            max = element.doubleValue() > max.doubleValue() ? element : max;
        }
        return max;
    }
}

