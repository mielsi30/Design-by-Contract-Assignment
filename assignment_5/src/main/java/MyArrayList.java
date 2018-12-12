import ch.usi.si.codelounge.jsicko.Contract;

import java.util.*;

public class MyArrayList<E> extends AbstractList<E> implements Contract, List<E>, RandomAccess, Cloneable, java.io.Serializable{
    private final java.util.ArrayList<E> list;
    private static int size = 0;

    public MyArrayList(java.util.ArrayList<E> list) {
        this.list = list;
        size = list.size();
    }

    @Requires("availableElement")
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Pure
    private static boolean availableElement(int index) {
        return size > index;
    }
    
}
