import org.junit.Test;

public class StudyTest {
    @Test
    public void test(){
        int a = -4;
        int b = 4;
        System.out.println("b:" + Integer.toBinaryString(b));
        System.out.println("a:" + Integer.toBinaryString(a));
        //左移
        System.out.println(a<<1);
        //带符号右移
        System.out.println(a>>1);
        //无符号右移
        System.out.println(a>>>1);
        System.out.println("无符号右移a：" + Integer.toBinaryString(a>>>1));
        int c = 2147483646;
        System.out.println("c:" + Integer.toBinaryString(c));
        System.out.println(Integer.MAX_VALUE);
        /**
         *         注意它显示的时候没有显示前面的0
         *         11111111111111111111111111111100
         *         01111111111111111111111111111110
         *         01111111111111111111111111111110
         */
    }
    @Test
    public void test2(){
        System.out.println(42.0 == 42.0);
        int a  = 42;
        double b = 42.0;
        double c = 42.0;
        System.out.println(a == 42.0);
        System.out.println( a == b);
        System.out.println( b == c);
        Double d = 42.0;
        Double e = 42.0;
        //此处输出为false因为这里对比的事引用类型！！之前的都是true，因为他们都是基本类型，基本类型==比较的是值
        System.out.println(d == e);

    }
}
