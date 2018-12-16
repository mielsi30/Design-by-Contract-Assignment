import ch.usi.si.codelounge.jsicko.Contract;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        assertThrows(Contract.PreconditionViolation.class, () -> list.addAll(5, a));
    }

    @Test
    void testRemoveAll() {
        ContractedArrayList<String> list = new ContractedArrayList<>();
        ArrayList a = new ArrayList();
        a.add("1");
        a.add("2");
        list.addAll(a);
        assertThrows(Contract.PreconditionViolation.class, () -> list.removeAll(null));
    }

    @Test
    void testRetainAll() {
        ContractedArrayList<String> list = new ContractedArrayList<>();
        ArrayList a = new ArrayList();
        a.add("1");
        a.add("2");
        list.addAll(a);
        list.add("3");
        list.retainAll(a);
        assert(!list.contains("3"));
        assertThrows(Contract.PreconditionViolation.class, () -> list.retainAll(null));
    }

    @Test
    void testSet() {
        ContractedArrayList<String> list = new ContractedArrayList<>();
        assertThrows(Contract.PreconditionViolation.class, () -> list.set(0, "fail"));
    }

    @Test
    void testIndex() {
        ContractedArrayList<String> list = new ContractedArrayList<>();
        ArrayList a = new ArrayList();
        a.add("1");
        a.add("2");
        list.addAll(a);
        list.add("3");
        list.add("3");
        list.indexOf("3");
        list.lastIndexOf("3");
    }

    @Test
    void testSubList(){
        ContractedArrayList<String> list = new ContractedArrayList<>();
        list.add("1");
        list.add("2");
        assertThrows(Contract.PreconditionViolation.class, () -> list.subList(3,1));
    }
}
