package edu.nyu.cs9053.homework8;

import java.util.Comparator;

public class JobComparator implements Comparator<Job> {
	
	public int compare(Job j1 , Job j2)
	    {
	        if(j1.name == j2.name)
	        {
	            return 0;
	        }
	        else if (j1.ForCmp > j2.ForCmp)
	        {
	            return 1 ;
	        }
	        else if  (j1.ForCmp < j2.ForCmp)
	        {
	            return -1 ;
	        }
	         
	        return 1 ;
	    }


	}



