import ch.usi.si.codelounge.jsicko.Contract;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
//        assertThrows(Contract.PostconditionViolation.class, () -> list.remove("1"));
    }

    @Test
    void testToArray(){
        ContractedArrayList<String> list = new ContractedArrayList<>();
        list.add("1");
        list.add("2");
        assertThrows(Contract.PreconditionViolation.class, () -> list.toArray(null));
    }

    @Test
    void testAddAll() {
        ContractedArrayList<String> list = new ContractedArrayList<>();
        ArrayList a = new ArrayList();
        a.add("1");
        a.add("2");
        a.add("3");
        list.addAll(a);
    }
}
