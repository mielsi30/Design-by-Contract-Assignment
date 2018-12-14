import ch.usi.si.codelounge.jsicko.Contract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ContractedArrayListTest {

    @Test
    void testAddWithIndex() {
        ContractedArrayList<String> list = new ContractedArrayList<>();
        list.add("ciao");
        list.add("Boiken");
        assertThrows(Contract.PreconditionViolation.class, () -> list.add(3, "1"));
    }
}
