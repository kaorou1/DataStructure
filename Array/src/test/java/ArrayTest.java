public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.remove(3);
        System.out.println(array);

        array.add(5, 11);
        System.out.println(array);

        Array<Student> array1 = new Array<Student>();
        array1.addLast(new Student("kaorou", 88));
        array1.addLast(new Student("xinye", 77));
        array1.addLast(new Student("wanbo", 66));
        System.out.println(array1);

    }

}
