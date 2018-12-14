import ch.usi.si.codelounge.jsicko.Contract;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ContractedArrayListTest {

    @Test
    void testAddWithIndex() {
        ContractedArrayList<String> list = new ContractedArrayList<>();
        list.add("1");
        list.add("2");
        assertThrows(Contract.PreconditionViolation.class, () -> list.add(3, "1"));
    }

    @Test
    void testGetWithIndex(){
        ContractedArrayList<String> list = new ContractedArrayList<>();
        assertThrows(Contract.PreconditionViolation.class, () -> list.get(2));
    }

    @Test
    void testRemove(){
        ContractedArrayList<String> list = new ContractedArrayList<>();
        list.add("1");
        list.add("2");
        assertThrows(Contract.PreconditionViolation.class, () -> list.remove(3));
    }

    @Test
    void testClear(){
        ContractedArrayList<String> list = new ContractedArrayList<>();
        assertThrows(Contract.PreconditionViolation.class, () -> list.clear());
    }

    @Test
    void testToArray(){
        ContractedArrayList<String> list = new ContractedArrayList<>();
        list.add("1");
        list.add("2");
        assertThrows(Contract.PreconditionViolation.class, () -> list.toArray(null));
    }


}
