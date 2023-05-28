package xieliangji.lc.ajunit;

import org.apiguardian.api.API;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

import static org.apiguardian.api.API.Status.STABLE;

/**
 * A primitive type
 * <p>
 * String
 * <p>
 * Class or an invocation of Class
 * <p>
 * An enum class type
 * <p>
 * An annotation interface type
 * <p>
 * An array type whose component type is one of the preceding types
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@API(status = STABLE, since = "5.7")
@ArgumentsSource(DetectArgumentsProvider.class)
public @interface DetectWithTestMethodSource {

    Class<?> dataCenter();

    String testMethod();
}
