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
    void testConditionsOnAdd() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ciao");
        arrayList.add("mama");
        MyArrayList<String> myArray = new MyArrayList<>(arrayList);
        myArray.add("again");
        assertThrows(Contract.PreconditionViolation.class, () -> myArray.add(2, "1"));
        assertThrows(Contract.PostconditionViolation.class, () -> myArray.add(1, "1"));
    }

    @Test
    void clearList() {
        MyArrayList<String> myArray = new MyArrayList<>(new ArrayList<>());
        assertThrows(Contract.PreconditionViolation.class, () -> myArray.add(0, "1"));
    }
}
