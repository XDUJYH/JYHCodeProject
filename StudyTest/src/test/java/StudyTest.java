import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class StudyTest {
    /**
     * 这个测试类是用来测试一些逻辑运算符的
     */
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
    /**
     * 这个测试类是用来测试引用相关的
     */
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
    /**
     * 测试泛型相关
     */
    @Test
    public void test3() throws Exception {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(12);
        //会报错
//        list.add("a");
        Class<? extends List> clazz = list1.getClass();
        //涉及一个知识点：【JAVA反射】getMethod与getDeclaredMethod区别
        //对应解答：https://blog.csdn.net/loulanyue_/article/details/103568496
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //运行期间通过反射添加，可以实现
        add.invoke(list1, "a");
        add.invoke(list2, "a");

        System.out.println(list1);
        System.out.println(list2);
    }

    @Test
    public void test4(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
    }
    @Test
    public void test5(){
        Father father = new Son();
        father.publicSay();
        //调用不了，因为这是子类的独有方法，虽然父类也有，但是父类的访问受限
//        father.privateSay();
    }

    @Test
    public void test6(){
        Son son1 = new Son();
        Son son2 = new Son();
        son1.addFatherAttribute(1);
        son2.addFatherAttribute(2);
        System.out.println(son1.getFatherAttribute());
        System.out.println(son2.getFatherAttribute());
    }
}
