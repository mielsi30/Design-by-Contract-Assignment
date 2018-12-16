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

//    @Ensures("sizeIncreases")
    boolean add(E e);

    @Ensures("sizeDoesNotIncrease")
    boolean remove(Object o);

    boolean containsAll(Collection<?> c);

    @Ensures("containsAll")
    boolean addAll(Collection<? extends E> c);

    @Requires("indexInRange")
    boolean addAll(int index, Collection<? extends E> c);

    @Requires("collectionNotNull")
    boolean removeAll(Collection<?> c);

    @Requires("collectionNotNull")
    boolean retainAll(Collection<?> c);

    @Ensures("listEmpty")
    void clear();

    @Requires("indexInRange")
    E get(int index);

    @Requires("indexInRange")
    E set(int index, E element);

    @Requires("indexInRange")
    @Ensures("sizeIncreases")
    void add(int index, E element);

    @Requires("indexInRange")
    @Ensures("sizeDecreases")
    E remove(int index);

    @Ensures("equalObjectAtFirstOccurrence")
    int indexOf(Object o);

    @Ensures("equalObjectAtLastPosition")
    int lastIndexOf(Object o);

    @Requires("indexesInRange")
    List<E> subList(int fromIndex, int toIndex);

    @Pure
    default boolean indexInRange(int index) {
        return (size() > index) && (index >= 0);
    }

    @Pure
    default boolean indexesInRange(int fromIndex, int toIndex) {
        return (size() > fromIndex) && (fromIndex >= 0) && (toIndex >=0) && (toIndex < size());
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
    default boolean arrayNotNull(E[] a) {
        return a != null;
    }

    @Pure
    default boolean sizeDoesNotIncrease() {
        return this.size() <= Contract.old(this).size();
    }

    @Pure
    default boolean collectionNotNull(Collection<?> c) {
        return c != null;
    }

    @Pure
    default boolean equalObjectAtFirstOccurrence(Object o) {
        if (contains(o)) {
            int obj = 0;
            while (obj < size() && !(get(obj).equals(o)))
                obj++;

            if (obj < size())
                return get(obj).equals(o);

            return false;
        }
        return true;
    }

    @Pure
    default boolean equalObjectAtLastPosition(Object o) {
        if (contains(o)) {
            int obj = 0;
            int lastPos = 0;
            while (obj < size()) {
                if (get(obj).equals(o))
                    lastPos = obj;
                obj++;
            }

            if (lastPos < size())
                return get(lastPos).equals(o);

            return false;
        }
        return true;
    }




}
