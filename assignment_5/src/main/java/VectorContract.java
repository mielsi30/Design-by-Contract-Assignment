import ch.usi.si.codelounge.jsicko.Contract;

import java.util.Comparator;
import java.util.function.Predicate;

@SuppressWarnings("UnusedReturnValue")
public interface VectorContract<E> extends Contract {
    @Invariant
    @Pure
    default boolean nonNegativeSize() {
        return size() >= 0;
    }

    @Pure
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    int indexOf(Object o);

    @Requires("nonNegativeIndex")
    @Ensures("sizeStaysTheSame")
    int indexOf(Object o, int index);

    int lastIndexOf(Object o);

    @Requires("indexWithinBounds")
    @Ensures("sizeStaysTheSame")
    int lastIndexOf(Object o, int index);

    @Requires("indexWithinBounds")
    E elementAt(int index);

    @Requires("nonEmptyVector")
    @Ensures("sizeStaysTheSame")
    E firstElement();

    @Requires("nonEmptyVector")
    @Ensures("sizeStaysTheSame")
    E lastElement();

    void setElementAt(E obj, int index);

    @Requires("indexWithinBounds")
    void removeElementAt(int index);

    @Ensures("emptyVector")
    void removeAllElements();

    void insertElementAt(E obj, int index);

    @Ensures("sizeIncreases")
    void addElement(E obj);

    void sort(Comparator<? super E> c);

    @Requires("filterNotNull")
    boolean removeIf(Predicate<? super E> filter);

    @Pure
    default boolean filterNotNull(Predicate<? super E> filter) {
        return filter != null;
    }

    @Pure
    default boolean nonEmptyVector() {
        return this.size() != 0;
    }

    @Pure
    default boolean emptyVector() {
        return this.isEmpty();
    }

    @Pure
    default boolean nonNegativeIndex(int index) {
        return index >= 0;
    }

    @Pure
    default boolean indexWithinBounds(int index) {
        return index < size();
    }

    @Pure
    default boolean sizeStaysTheSame() {
        return this.size() == Contract.old(this).size();
    }

    @Pure
    default boolean sizeIncreases() {
        return this.size() == Contract.old(this).size() + 1;
    }
}
