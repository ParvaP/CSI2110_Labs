

// ==========================================================================
// $Id: BubbleSort.java,v 1.1 2006/11/05 03:27:51 jlang Exp $
// CSI2110 Lab code; basic bubble sort 
// ==========================================================================
// (C)opyright:
//
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: unknown (Lab source without reference), adapted by J.Lang
// Email:   jlang@site.uottawa.ca
// ==========================================================================
// $Log: BubbleSort.java,v $
// Revision 1.1  2006/11/05 03:27:51  jlang
// Added lab8 on sorting.
//
//
// ==========================================================================
/**
 * Implements bubble sort.
 */
import java.util.ArrayList;
public class BubbleSort<T extends Comparable> {

  protected void merge(T[] arr, int lS, int rE) {

    int lE = (int)(rE + lS)/2;
    int rS = lE + 1;
    
    ArrayList<T> temp = new ArrayList<>(arr.length);
        int i,j,k;
        for(i=lS,j=rS,k=0; (i<lE) && (j<rE); k++) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp.add(k,arr[i++]);
            } else {
                temp.add(k, arr[j++]);
            }
        }
        while(i < lE) {
            temp.add(k++, arr[i++]);
        }
        while(i < lE) {
            temp.add(k++, arr[j++]);
        }
        for(i = lS, j = 0; j < temp.size(); i++, j++) {
            arr[i] = temp.get(j);
        }
    
    } 
    protected void sort(T[] arr, int l, int r) 
    { 
        if ( l >= r){
            return;
        } 
        int m = (int)(l+r)/2;
        sort(arr, l, m);
        sort(arr, m+1, r);
        merge(arr, l, r);
    }

  public BubbleSort(T[] _seq ) {
    sort(_seq, 0, _seq.length-1);
  }
}
