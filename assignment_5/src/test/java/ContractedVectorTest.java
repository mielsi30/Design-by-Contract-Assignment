import ch.usi.si.codelounge.jsicko.Contract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ContractedVectorTest {

    @Test
    void testFilter() {
        ContractedVector<Integer> vector = new ContractedVector<>();
        assertThrows(Contract.PreconditionViolation.class, () -> vector.removeIf(null));
    }

    @Test
    void testFirstElement() {
        ContractedVector<Integer> vector = new ContractedVector<>();
        assertThrows(Contract.PreconditionViolation.class, vector::firstElement);
    }

    @Test
    void testLastElement() {
        ContractedVector<Integer> vector = new ContractedVector<>();
        assertThrows(Contract.PreconditionViolation.class, vector::lastElement);
    }

    @Test
    void testIndexOfStartingFromIndex() {
        ContractedVector<Integer> vector = new ContractedVector<>();
        assertThrows(Contract.PreconditionViolation.class, () -> vector.indexOf(null, -1));
    }

    @Test
    void testLastIndexOfBackwardsFromIndex() {
        ContractedVector<Integer> vector = new ContractedVector<>();
        assertThrows(Contract.PreconditionViolation.class, () -> vector.lastIndexOf(null, 2));
    }
}

