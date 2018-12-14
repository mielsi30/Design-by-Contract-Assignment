import ch.usi.si.codelounge.jsicko.Contract;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface ListContract<E> extends Contract {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();

    Object[] toArray();

    @Requires("arrayNotNull")
    <T> T[] toArray(T[] a);
/* in theory this method also needs an array of the same type as the list, but the compiler detects the exception
 before our assertion */

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends E> c);

    boolean addAll(int index, Collection<? extends E> c);

    boolean removeAll(Collection<?> c);

    boolean retainAll(Collection<?> c);

    @Requires("notEmpty")
    @Ensures("listEmpty")
    void clear();

    @Requires("indexInRange")
    E get(int index);

    E set(int index, E element);

    @Requires("indexInRange")
    @Ensures("sizeIncreases")
    void add(int index, E element);

    @Requires("indexInRange")
    @Ensures("sizeDecreases")
    E remove(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

    List<E> subList(int fromIndex, int toIndex);

    @Pure
    default boolean indexInRange(int index) {
        return size() > index;
    }

    @Pure
    default boolean sizeIncreases() {
        return this.size() == Contract.old(this).size() + 1;
    }

    @Pure
    default boolean sizeDecreases() {
        return this.size() == Contract.old(this).size() - 1;
    }

    @Pure
    default boolean notEmpty() {
        return !this.isEmpty();
    }

    @Pure
    default boolean listEmpty() {
        return this.isEmpty();
    }

    @Pure
    default <T> boolean arrayNotNull(T[] a) {
        return a != null;
    }
}
