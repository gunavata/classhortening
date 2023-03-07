import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author Tan Oliver
 */
class ShortServiceTest {

    ShortService service = new ShortService();
    private static final String SAMPLE_PACKAGE = "org.spring.boot.Application";

    // org = 3
    // spring = 6
    // boot = 4
    // Application = 11
    @Test
    @DisplayName("Given org.spring.boot.Application name, " +
            "When length is 11, " +
            "Then return o.s.b.Application")
    void justRight() {
        var result = service.shortenClassName(SAMPLE_PACKAGE, 11);
        assert Objects.equals(result, "o.s.b.Application");
    }

    @Test
    @DisplayName("Given org.spring.boot.Application name, " +
            "When length is 5, " +
            "Then return o.s.b.Application")
    void tooLow() {
        var result = service.shortenClassName(SAMPLE_PACKAGE, 5);
        assert Objects.equals(result, "o.s.b.Application");
    }

    @Test
    @DisplayName("Given org.spring.boot.Application name, " +
            "When length is 15, " +
            "Then return o.s.boot.Application")
    void midPoint() {
        var result = service.shortenClassName(SAMPLE_PACKAGE, 15);
        assert Objects.equals(result, "o.s.boot.Application");
    }

    @Test
    @DisplayName("Given org.spring.boot.Application name, " +
            "When length is 18, " +
            "Then return o.s.boot.Application")
    void partialMidPoint() {
        var result = service.shortenClassName(SAMPLE_PACKAGE, 18);
        assert Objects.equals(result, "o.s.boot.Application");
    }

    @Test
    @DisplayName("Given org.spring.boot.Application name, " +
            "When length is 99," +
            "Then return org.spring.boot.Application")
    void tooHigh() {
        var result = service.shortenClassName(SAMPLE_PACKAGE, 99);
        assert Objects.equals(result, "org.spring.boot.Application");
    }
}
