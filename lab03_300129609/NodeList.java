// ==========================================================================
// $Id: addTemplate.cpp,v 1.1 2005/11/02 23:13:32 jlang Exp $
// CSI2110 Lab code Node List skeleton class
// ==========================================================================
// (C)opyright:
//
//   Jochen Lang
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: jlang (Jochen Lang)
// Email:   jlang@site.uottawa.ca
// ==========================================================================
// $Log: addTemplate.cpp,v $
//
// ==========================================================================
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class NodeList<E> {
  // The linked list which is to be adapted
  protected LinkedList<E> linkedList = new LinkedList<E>();

//My Method
public int getIndex(E element) {
  for (int i = 0; i < size() ; i++) {
    if (element == linkedList.get(i)) {
      return i;
    }
  }
  return -1;
}

  // Directly available
  public int size() {
    return linkedList.size();
  }

  // Directly available
  public boolean isEmpty() {
     return linkedList.isEmpty();
  }

  // fix me!
  public boolean isFirst(E element) {
    return element == first();
  }

  // fix me!
  public boolean isLast(E element) {
    return element == last();
  }

  // Directly available
  public E first() 
    throws NoSuchElementException {
    return linkedList.element();
  }


  // Directly available
  public E last() 
    throws NoSuchElementException {
    return linkedList.getLast();
  }

  // fix me!
  E prev(E element)
    throws NoSuchElementException {
      return linkedList.get(getIndex(element)-1);
  }


  // fix me!
  E next(E element)
    throws NoSuchElementException {
        return linkedList.get(getIndex(element) + 1);
  }

  // fix me!
  public void swapElements(E element1, E element2)
    throws NoSuchElementException {
      int i1 = getIndex(element1);
      int i2 = getIndex(element2);
      
      linkedList.add(i1,element2);
      linkedList.remove(i1+1);
      
      linkedList.add(i2,element1);
      linkedList.remove(i2+1);
  }
  

  // fix me!
  public void set(E currElement, E repElement)
    throws NoSuchElementException {
      linkedList.add(getIndex(currElement),repElement);
      linkedList.remove(getIndex(currElement));
  }


  // Directly available
  public void addFirst(E element) {
    linkedList.addFirst(element);
  }

  // Directly available
  public void addLast(E element) {
    linkedList.addLast(element);
  }

  // fix me!
  public void addBefore(E currElement,E addElement)
    throws NoSuchElementException {
      linkedList.add(getIndex(currElement),addElement);
  }

  // fix me!
  public void addAfter(E currElement,E addElement) 
    throws NoSuchElementException {
      linkedList.add(getIndex(currElement)+1,addElement);
  }
  
  // fix me!
  public E remove(E element) 
    throws NoSuchElementException {
      linkedList.remove(getIndex(element));
      return element;
  }
}
