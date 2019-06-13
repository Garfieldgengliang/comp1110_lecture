package comp1110.lectures.A02;

import comp1110.lectures.A01.List;

public class LinkedList<T> implements List<T> {

    class LLNode{
        T value;
        LLNode next;

        public LLNode(T value, LLNode next) {
            this.value = value;
            this.next = next;
        }

        T getLLnode(int index){
            if(index == 0){
                return this.value;
            }
            else{
                if(this.next == null){
                    throw  new IndexOutOfBoundsException();
                }
                return  next.getLLnode(index-1);
            }

        }

        T removeLLnode (int index){
            if(this.next == null){
                throw new IndexOutOfBoundsException();
            }

            else if(index<1){
                throw  new IndexOutOfBoundsException();
            }
            else{
                if(index == 1){
                    T value = next.value;
                    next = next.next;
                    return value;
                }
                else{
                    return this.next.removeLLnode(index-1);
                }
            }
        }

        void reverseNode(LLNode newNext){
            if(next != null){
                next.reverseNode(this);
            }

            this.next = newNext;
        }
    }

    LLNode first;
    LLNode last;

    @Override
    public void add(T value) {

        LLNode newNode = new LLNode(value, null);

        if( value == null){
            throw  new IllegalArgumentException();
        }

        if(first == null){
            first = last = newNode;
        }

        else {
            last.next = newNode;
            last = newNode;
        }
    }

    @Override
    public T get(int index) {

        if(first == null){
            throw  new IndexOutOfBoundsException();
        }

        if(index == 0){
            return first.value;
        }

        else{
            return first.getLLnode(index);
        }
    }

    @Override
    public int size() {

        int listNum = 0;
        LLNode firstnode = first;
         if(first == null){
            return 0;
        }
        while(firstnode!= null){
            firstnode = firstnode.next;
            listNum++;
        }
        return listNum;

    }

    @Override
    public T remove(int index) {
         if(first == null){
             throw  new IndexOutOfBoundsException();
         }

         if(index == 0){
             T value = first.value;
             first = first.next;
             return  value;
         }
         return first.removeLLnode(index);

    }

    @Override
    public void reverse() {
        if(first == null){
            return;
        }

        first.reverseNode(null);
        LLNode tempnode = last;
        last = first;
        first = tempnode;

    }
}


