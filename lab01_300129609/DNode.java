public class DNode {
    private Object element;
    private DNode next, previous;

    DNode() { this(null, null,null); }
    DNode(Object e, DNode p, DNode n) {
      element = e;
      next = n;
      previous = p;
    }
    public void setElement(Object newElem) { element = newElem; }
    public void setNext(DNode newNext) { next = newNext; }
    public void setPrevious(DNode newPrevious) {previous = newPrevious;}
    public Object getElement() { return element; }
    public DNode getNext() { return next; }
    public DNode getPrevious() { return previous; }
  }