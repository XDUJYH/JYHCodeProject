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
}
