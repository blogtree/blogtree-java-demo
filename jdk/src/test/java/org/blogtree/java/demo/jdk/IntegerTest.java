package org.blogtree.java.demo.jdk;

import org.junit.Test;

public class IntegerTest {

    /**
     * 精度小于int的数值运算的时候，都回被自动转换为int后进行计算
     * 但 +=、-=、*=、/= 等操作，会对右边的表达式结果强转匹配左边的数据类型
     */
    @Test
    public void add() {
        byte a = 127;
        byte b = 127;
//        b = a + b; // java: 不兼容的类型: 从int转换到byte可能会有损失
        b += a;

        short s1 = 1;
//        s1 = s1 + 1; // java: 不兼容的类型: 从int转换到short可能会有损失

        short s21 = 1;
        short s22 = 1;
//        s22 = s21 + s22; // java: 不兼容的类型: 从int转换到short可能会有损失
//        short s23 = (s21 + s22); // java: 不兼容的类型: 从int转换到short可能会有损失
        short s24 = (short) (s21 + s22);
        s22 += s21;
        s22 -= s21;
        s22 *= s21;
        s22 /= s21;
        s22 %= s21;
    }
}
