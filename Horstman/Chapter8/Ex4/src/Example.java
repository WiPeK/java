import com.sun.istack.internal.NotNull;

import java.util.stream.Stream;

/**
 * Created by Acer on 29.03.2017.
 */
public class Example {

    @NotNull
    public static Stream<Long> getInfinityStream(Long a, Long c, Long m, long seed) {
        return Stream.iterate(seed, n -> {
            System.out.println(n);
            return (a*n + c)%m;
        });
    }

    public static void main(String[] args) {

        Stream<Long> strm = getInfinityStream(Long.parseLong("25214903917"), Long.parseLong("11"), (long)Math.pow(2,48), 1);
    }
}
