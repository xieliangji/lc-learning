package xieliangji.lc.ajunit;

import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataCenter {

    public static Stream<Arguments> forTestHeapSort() {
        return Stream.of(Arguments.of(
                new ArrayList<>(List.of(
                        3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0,
                        1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6
                ))
        ));
    }
}
