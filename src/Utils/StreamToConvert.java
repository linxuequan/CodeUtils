package Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamToConvert {
    @Test
    public void testConvert() {
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        integers.add(4);
    //lambda表达式------------------------------------------------------------------------//
        List<String> strings = Convert(integers, integer -> String.valueOf(integer));
    //------------------------------------------------------------------------//
        for (String i : strings) {
            System.out.println(i.getClass() + ":" + i);
        }
    }
    private List<String> Convert(List<Integer> integers, Function<Integer, String> convertor) {
        return integers.stream().map(convertor).collect(Collectors.toList());
    }
    //    private List<String> Convert(List<Integer> integers) {
//        List<String> strings = new ArrayList<>();
//        for (int i:integers) {
//            strings.add(String.valueOf(i));
//        }
//        return strings;
//    }


}