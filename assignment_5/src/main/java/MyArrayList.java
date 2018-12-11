import ch.usi.si.codelounge.jsicko.Contract;

import java.util.*;

public class MyArrayList<E> extends AbstractList<E> implements Contract, List<E>, RandomAccess, Cloneable, java.io.Serializable{
    private final java.util.ArrayList<E> list;

    public MyArrayList(java.util.ArrayList<E> list) {
        this.list = list;
    }

    @Pure
    private boolean size_greater_than_index(int index) {
        return this.size() > index;
    }

    @Requires("size_greater_than_index")
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }


}
