import ch.usi.si.codelounge.jsicko.Contract;

import java.util.AbstractList;
import java.util.ArrayList;

public class MyArrayList<E> extends AbstractList<E> implements Contract {

    private java.util.ArrayList<E> list;

    public MyArrayList(java.util.ArrayList<E> list) {
        this.list = list;
    }

    public MyArrayList() {
        this.list = new ArrayList<>();
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
        return list.size() > index;
    }


    @Pure
    private boolean listEmpty(){
        return list.isEmpty();
    }

    @Pure
    private boolean sizeIncreases(){
        return this.size() == Contract.old(this).size() + 1;
    }

    @Requires("availableElement")
    @Ensures("sizeIncreases")
    public void add(int index, E elem) {
        list.add(index, elem);
    }

    @Ensures("listEmpty")
    @Override
    public void clear(){
        list.clear();
    }


}
