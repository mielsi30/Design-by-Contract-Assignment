import ch.usi.si.codelounge.jsicko.Contract;

import java.util.Comparator;
import java.util.function.Predicate;

public interface VectorContract<E> extends Contract {

    int size();
    boolean isEmpty();
    boolean contains(Object o);
    int indexOf(Object o);

    @Requires("nonNegativeIndex")
    int indexOf(Object o, int index);

    int lastIndexOf(Object o);
    int lastIndexOf(Object o, int index);
    E elementAt(int index);

    @Requires("nonEmptyVector")
    E firstElement();

    @Requires("nonEmptyVector")
    E lastElement();

    void setElementAt(E obj, int index);
    void removeElementAt(int index);
    void removeAllElements();
    void insertElementAt(E obj, int index);
    void addElement(E obj);
    void sort(Comparator<? super E> c);

    @Requires("filterNotNull")
    boolean removeIf(Predicate<? super E> filter);

    @Pure
    default boolean filterNotNull(Predicate<? super E> filter){
        return filter != null;
    }

    @Pure
    default boolean nonEmptyVector(){
        return this.size() != 0;
    }

    @Pure
    default boolean nonNegativeIndex(int index){
        return index >= 0;
    }
}
