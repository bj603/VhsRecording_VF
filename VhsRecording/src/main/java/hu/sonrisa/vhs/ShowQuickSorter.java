package hu.sonrisa.vhs;

public class ShowQuickSorter 
{
	private Show[] array;
	private int length;
	
	public void sort(Show[] unsortedArray)
	{
	    this.array = unsortedArray;
	    this.length = unsortedArray.length;
	    quicksort(0, this.length - 1);
	}
	
	private void quicksort(int low, int high) 
	{
	    int i = low;
	    int j = high;
	    int pivot = array[low + (high-low)/2].getStartForSorting();

	    while(i <= j) 
	    {
	    	while(array[i].getStartForSorting() < pivot)
	    	{
	    		i++;
	    	}
	      
	    	while(array[j].getStartForSorting() > pivot) 
	    	{
	    		j--;
	    	}

	    	if(i <= j) 
	    	{
	    		exchange(i, j);
	    		i++;
	    		j--;
	    	}
	    }
	    // Recursion
	    if(low < j)
	    {
	    	quicksort(low, j);
	    }
	    if(i < high)
	    {
	    	quicksort(i, high);	
	    }
	  }

	
	private void exchange(int i, int j) 
	{
		Show temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
