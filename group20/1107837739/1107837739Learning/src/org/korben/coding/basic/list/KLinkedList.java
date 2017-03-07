package org.korben.coding.basic.list;

import java.util.Objects;

/**
 * Korben's LinkedList
 *
 * Created by Korben on 18/02/2017.
 */
public class KLinkedList<T> implements KList<T> {

    private int size;

    private Node<T> head;

    private Node<T> last;

    public KLinkedList() {
        this.head = new Node<>(null);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
            if (Objects.equals(node.data, o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        throw new IllegalStateException("方法未实现");
    }

    @Override
    public boolean add(T o) {
        if (this.last == null) {
            this.last = new Node<>(o);
            this.head.next = this.last;
        } else {
            Node<T> oldLast = this.last;
            this.last = new Node<>(o);
            oldLast.next = this.last;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean remove(T o) {
        Node node = this.head;
        Node preNode;
        while (node.next != null) {
            preNode = node;
            node = node.next;
            if (Objects.equals(node.data, o)) {
                preNode.next = node.next;
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.last = null;

        this.size = 0;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T set(int index, T element) {
        Node<T> node = getNode(index);
        node.data = element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = this.head;
        Node<T> preNode = node;
        for (int i = 0; i <= index; i++) {
            preNode = node;
            node = node.next;
        }

        Node<T> newNode = new Node<>(element);
        newNode.next = node;
        preNode.next = newNode;

        this.size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = this.head;
        Node<T> preNode = this.head;

        for (int i = 0; i <= index; i++) {
            preNode = node;
            node = node.next;
        }

        preNode.next = node.next;
        this.size--;
        return node.data;
    }

    @Override
    public int indexOf(T o) {
        Node node = this.head;
        int index = 0;
        while (node.next != null) {
            node = node.next;
            if (Objects.equals(node.data, o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public KIterator<T> iterator() {
        throw new IllegalStateException("方法未实现");
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = this.head;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 把该链表逆置
     * 例如链表为 3->7->10 , 逆置后变为  10->7->3
     */
    public void reverse() {

    }

    /**
     * 删除一个单链表的前半部分
     * 例如：list = 2->5->7->8 , 删除以后的值为 7->8
     * 如果list = 2->5->7->8->10 ,删除以后的值为7,8,10
     */
    public void removeFirstHalf() {

    }

    /**
     * 从第i个元素开始， 删除length 个元素 ， 注意i从0开始
     */
    public void remove(int i, int length) {

    }

    /**
     * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。
     * 从当前链表中中删除在list中出现的元素
     */

    public void subtract(KLinkedList list) {

    }

    /**
     * 已知当前链表中的元素以值递增有序排列，并以单链表作存储结构。
     * 删除表中所有值相同的多余元素（使得操作后的线性表中所有元素的值均不相同）
     */
    public void removeDuplicateValues() {

    }

    /**
     * 已知链表中的元素以值递增有序排列，并以单链表作存储结构。
     * 试写一高效的算法，删除表中所有值大于min且小于max的元素（若表中存在这样的元素）
     */
    public void removeRange(int min, int max) {

    }

    /**
     * 假设当前链表和参数list指定的链表均以元素依值递增有序排列（同一表中的元素值各不相同）
     * 现要求生成新链表C，其元素为当前链表和list中元素的交集，且表C中的元素有依值递增有序排列
     */
    public KLinkedList intersection(KLinkedList list) {
        return null;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}
