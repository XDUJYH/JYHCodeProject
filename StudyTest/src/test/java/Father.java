import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Father {
    private final ArrayList<Integer> fatherAttribute;

    public void addFatherAttribute(Integer a) {
        this.fatherAttribute.add(a);
    }
    public ArrayList<Integer> getFatherAttribute() {
        return this.fatherAttribute;
    }
    public Father() {
        this.fatherAttribute = new ArrayList<>();;
    }

    private void privateSay(){
        System.out.println("我是父类，来自privateSay");
    }
    public void publicSay(){
        System.out.println("我是父类，来自publicSay");
    }
}
