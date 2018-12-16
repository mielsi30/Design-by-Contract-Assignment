import ch.usi.si.codelounge.jsicko.Contract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ContractedVectorTest {

    @Test
    void testFilter(){
        ContractedVector<Integer> vector = new ContractedVector<>();
        assertThrows(Contract.PreconditionViolation.class, () -> vector.removeIf(null));
    }

    @Test
    void testFirstElement(){
        ContractedVector<Integer> vector = new ContractedVector<>();
        assertThrows(Contract.PreconditionViolation.class, vector::firstElement);
    }

    @Test
    void testLastElement(){
        ContractedVector<Integer> vector = new ContractedVector<>();
        assertThrows(Contract.PreconditionViolation.class, vector::lastElement);
    }
}

