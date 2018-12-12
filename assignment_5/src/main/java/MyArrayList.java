import ch.usi.si.codelounge.jsicko.Contract;

import java.util.*;

public class MyArrayList<E> extends AbstractList<E> implements Contract, List<E>, RandomAccess, Cloneable, java.io.Serializable{
    private final java.util.ArrayList<E> list;

    public MyArrayList(java.util.ArrayList<E> list) {
        this.list = list;
    }

    @Requires("availableElement")
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Pure
    private boolean availableElement(int index) {
        return this.list.size() > index;
    }

}
