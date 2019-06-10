package comp1110.lectures.A05;

import comp1110.lectures.A04.Set;

import java.util.ArrayList;
import java.util.List;

// A tree is a node
// A node contains a value and a list of trees.
// No node is duplicated.
/**
 * An implementation of a Set based on a binary search tree.
 *
 * @param <T> the type of elements maintained by this set
 */



public class BSTSet<T extends Object & Comparable<? super T>> implements Set<T> {
    class Node{
        T value;
        Node left;
        Node right;

        Node( T value){
            this.value = value;
        }

        boolean add( T element){
            if(element == null) return false;
            if(value.compareTo(element) < 0){
                if(right!= null){
                   return right.add(element);
                }else{
                    Node newRight = new Node(element);
                    right = newRight;
                    return true;
                }

            }else if(value.compareTo(element) > 0){
                if(left!= null) {
                    return left.add(element);
                }else{
                    Node newLeft = new Node(element);
                    left = newLeft;
                    return true;
                }
            }else{
                return false;
            }

        }

        boolean add(Node targetNode){
            if(targetNode == null) return false;
            if(value.compareTo(targetNode.value) < 0){
                if(right!= null){
                    return right.add(targetNode);
                }else{
                    right = targetNode;
                    return true;
                }

            }else if(value.compareTo(targetNode.value) > 0){
                if(left!= null) {
                    return left.add(targetNode);
                }else{
                    left = targetNode;
                    return true;
                }
            }else{
                return false;
            }

        }

        boolean contains (T element){
            if(element == null) return false;
            if(value.compareTo(element) < 0){
                if(right!= null){
                    return right.contains(element);
                }else{
                    return false;
                }

            }else if(value.compareTo(element) > 0){
                if(left!= null) {
                    return left.contains(element);
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }

        Node find( T element, boolean remove){
            if(element == null) return null;
            if(value.compareTo(element) < 0){
                if(right!= null){
                    Node found = right.find(element,remove);
                    if(found != null && found.value.equals(element) && remove){
                        right = null;
                    }
                    return found;
                }else{
                    return null;
                }

            }else if(value.compareTo(element) > 0){
                if(left!= null) {
                    Node found = left.find(element,remove);
                    if(found != null && found.value.equals(element) && remove){
                        left = null;
                    }
                    return found;
                }else{
                    return null;
                }
            }else{
                return this;
            }

        }

    }









    Node root;
    int numEle = 0;
    @Override
    public boolean add(T element) {
        Node newNode = new Node(element);
        if(root == null){
            root = newNode;
            numEle++;
            return true;
        }else{
            boolean added  =  root.add(element);
            if(added){
                numEle++;
            }
            return added;
        }

    }

    @Override
    public boolean remove(T element) {
        if(root != null){
            if(root.value == element){
                if(root.left!= null){
                    Node rightPart = root.right;
                    root = root.left;
                    root.add(rightPart);
                }
                else if(root.right!= null){
                    root = root.right;

                }
                else{
                    root = null;
                }

                numEle--;
                return true;
            }else{
                Node removeNode = root.find(element, true);
                if(removeNode != null){
                    root.add(removeNode.right);
                    root.add(removeNode.left);
                }
                boolean removed = (removeNode!=null);
                if(removed) numEle--;
                return removed;
            }

        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        if(root!=null){
            return root.contains(element);
        }
        return false;
    }

    @Override
    public int size() {
        return numEle;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Set<T> newInstance() {
        return null;
    }
}