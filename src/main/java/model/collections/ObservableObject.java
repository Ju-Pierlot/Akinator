package model.collections;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;

public class ObservableObject<t> implements ObservableList<t> {
    private List<t> list;

    public ObservableObject(){
        this.list = new ArrayList<>();
    }

    @Override
    public void addListener(ListChangeListener<? super t> listener) {

    }

    @Override
    public void removeListener(ListChangeListener<? super t> listener) {

    }

    @Override
    public boolean addAll(t... elements) {
        if(elements != null){
            Collections.addAll(this.list, elements);
            return true;
        }
        return false;
    }

    @Override
    public boolean setAll(t... elements) {
        return addAll(elements);
    }

    @Override
    public boolean setAll(Collection<? extends t> col) {
        if(col != null){
            this.list.addAll(col);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(t... elements) {
        if(elements != null){
            for(t t : elements){
                this.list.remove(t);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(t... elements) {
        return false;
    }

    @Override
    public void remove(int from, int to) {

    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return this.list.contains(o);
    }

    @Override
    public Iterator<t> iterator() {
        return this.list.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(t t) {
        return this.list.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return this.list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends t> c) {
        return this.list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends t> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.list.clear();
    }

    @Override
    public t get(int index) {
        return this.list.get(index);
    }

    @Override
    public t set(int index, t element) {
        return this.set(index, element);
    }

    @Override
    public void add(int index, t element) {
        this.list.add(index, element);
    }

    @Override
    public t remove(int index) {
        return this.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.list.lastIndexOf(o);
    }

    @Override
    public ListIterator<t> listIterator() {
        return this.list.listIterator();
    }

    @Override
    public ListIterator<t> listIterator(int index) {
        return this.list.listIterator(index);
    }

    @Override
    public List<t> subList(int fromIndex, int toIndex) {
        return this.list.subList(fromIndex, toIndex);
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
