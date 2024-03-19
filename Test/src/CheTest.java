import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheTest {
    Che che = new Che("che");

    @Test
    void isCookIncreaseExperience() {
        che.cook("e");
        assertEquals(2,che.experience);
    }
}