import ch.usi.si.codelounge.jsicko.Contract;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;

public class ArrayListTest {
    @Test
    public void getOnEmptyArray() throws Throwable {
        MyArrayList myArray = new MyArrayList<String>(new ArrayList());
        assertThrows(Contract.PreconditionViolation.class, () -> myArray.get(0));
    }
}
