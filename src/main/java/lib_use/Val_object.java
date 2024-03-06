package lib_use;

public class Val_object {
    // 值与包装对象的转换

    public Val_object() {
        int a = 100;
        Integer integer = a;
        System.out.println(integer);
        int b = integer;
        System.out.println(b);
        int c = integer.intValue();
        System.out.println(c);
        Integer d = Integer.valueOf(a);
        System.out.println(d);
    }
}
