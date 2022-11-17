package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @Test
    @DisplayName("사이즈에 맞는 다리를 만들 수 있다.")
    void createBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(6);

        assertThat(bridge.size()).isEqualTo(6);
        assertThat(bridge).containsOnly("U", "D");
    }

    @Test
    @DisplayName("범위에 맞지 않는 사이즈로 다리를 만들 수 없다.")
    void createBridgeWithNotInRange() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        assertThatThrownBy(() -> bridgeMaker.makeBridge(45))
                .isInstanceOf(IllegalArgumentException.class);
    }
}