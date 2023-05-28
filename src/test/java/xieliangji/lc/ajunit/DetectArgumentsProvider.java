package xieliangji.lc.ajunit;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.stream.Stream;

class DetectArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<DetectWithTestMethodSource> {
    @Override
    public void accept(DetectWithTestMethodSource detectWithTestMethodSource) {

    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {

        return null;
    }
}
