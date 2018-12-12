import ch.usi.si.codelounge.jsicko.Contract;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;

class ArrayListTest {

    @Test
    void getOnEmptyArray() {
        MyArrayList<String> myArray = new MyArrayList<>(new ArrayList<>());
        assertThrows(Contract.PreconditionViolation.class, () -> myArray.get(0));
    }

    @Test
    void addWrongElement() {
        MyArrayList<String> myArray = new MyArrayList<>(new ArrayList<>());
        assertThrows(Contract.PreconditionViolation.class, () -> myArray.add(1, "1"));
    }

    @Test
    void clearList() {
        MyArrayList<String> myArray = new MyArrayList<>(new ArrayList<>());
        assertThrows(Contract.PreconditionViolation.class, () -> myArray.add(0, "1"));
    }
}
