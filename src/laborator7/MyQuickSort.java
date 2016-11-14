package laborator7;

public class MyQuickSort extends Thread {
     
    private int length;
    private Plansa plansa;
    private VectorElem vectorElem;
    
    MyQuickSort(VectorElem vectorElem, Plansa plansa)
    {
    	super("QuickSort");
    	
    	this.vectorElem=vectorElem;
    	this.length=vectorElem.getVector().length;
    	
    	this.plansa=plansa;
    }
    
    
 
    public void run() {
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = vectorElem.getVector()[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            while (vectorElem.getVector()[i] < pivot) {
                i++;
            }
            while (vectorElem.getVector()[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
                
    			try {
    				Thread.sleep(Plansa.getTimp());
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
                              
                System.out.println(this.getName()+" "+this);
            }
            
            this.plansa.repaint();
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        this.vectorElem.swap(i, j);
    }
    
    public String toString()
    {
    	String str="";
    	
    	for(int i=0; i<this.vectorElem.getVector().length;i++)
    	{
    		str+=this.vectorElem.getVector()[i];
    		str+=" ";
    	}
    	
    	return str;
    }
}
