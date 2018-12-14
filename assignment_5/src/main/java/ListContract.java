import ch.usi.si.codelounge.jsicko.Contract;

import java.util.*;

public interface ListContract<E> extends Contract {
    @Invariant
    @Pure
    default boolean nonNegativeSize() {
        return size() >= 0;
    }

    @Pure
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();

    Object[] toArray();

    @Requires("arrayNotNull")
    E[] toArray(E[] a);

/* in theory this method also needs an array of the same type as the list, but the compiler detects the exception
 before our assertion */

    boolean add(E e);

    @Ensures("sizeDoesNotIncrease")
    boolean remove(Object o);

    boolean containsAll(Collection<?> c);

    @Ensures("containsAll")
    boolean addAll(Collection<? extends E> c);

    boolean addAll(int index, Collection<? extends E> c);

    boolean removeAll(Collection<?> c);

    boolean retainAll(Collection<?> c);

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

    @Ensures("sizeDoesNotChange")
    int lastIndexOf(Object o);
    
    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int index);

    @Requires("validRange")
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
    default boolean listEmpty() {
        return this.isEmpty();
    }

    @Pure
    default boolean notEmpty() {
        return !this.isEmpty();
    }

    @Pure
    default <E> boolean arrayNotNull(E[] a) {
        return a != null;
    }

    @Pure
    default boolean sizeDoesNotIncrease(Object o) {
        return this.size() <= Contract.old(this).size();
    }

    @Pure
    default boolean validRange(int fromIndex, int toIndex) {
        return !(fromIndex < 0 || toIndex > size() || fromIndex > toIndex);
    }

    @Pure
    default boolean sizeDoesNotChange() {
        return Contract.old(this).size() == size();
    }

}
