import java.util.Comparator;
import java.util.Vector;
import java.util.function.Predicate;

public class ContractedVector<E> implements VectorContract<E> {

    private java.util.Vector<E> vector = new Vector<>();

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return vector.contains(o);
    }

    @Override
    public int indexOf(Object o) {
        return vector.indexOf(o);
    }

    @Override
    public int indexOf(Object o, int index) {
        return vector.indexOf(o, index);
    }

    @Override
    public int lastIndexOf(Object o) {
        return vector.lastIndexOf(o);
    }

    @Override
    public int lastIndexOf(Object o, int index) {
        return vector.lastIndexOf(o, index);
    }

    @Override
    public E elementAt(int index) {
        return vector.elementAt(index);
    }

    @Override
    public E firstElement() {
        return vector.firstElement();
    }

    @Override
    public E lastElement() {
        return vector.lastElement();
    }

    @Override
    public void setElementAt(E obj, int index) {
        vector.setElementAt(obj, index);
    }

    @Override
    public void removeElementAt(int index) {
        vector.removeElementAt(index);
    }

    @Override
    public void removeAllElements() {
        vector.removeAllElements();
    }

    @Override
    public void insertElementAt(E obj, int index) {
        vector.insertElementAt(obj, index);
    }

    @Override
    public void addElement(E obj) {
        vector.addElement(obj);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        vector.sort(c);
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return vector.removeIf(filter);
    }
}
