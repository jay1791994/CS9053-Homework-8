package edu.nyu.cs9053.homework8;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;



public class Lambdaschedular {
	public static void main(String args[]){
		
		 JobComparator comparator = new JobComparator();
		 TreeSet<Job> jobSet = new TreeSet<Job>(comparator);
		 Scanner scanner =  new Scanner(System.in);
		 
		 System.out.print("ENTER NUMBER OF JOBS: ");
        int n = scanner.nextInt() ;
		 
		 
		 for(int i = 0 ; i <n ; i ++){
			 System.out.println("give a unique name for Job\n" + i);
			 String name = scanner.next() ;
			 System.out.println("give staring time for job\n");
			 int startTime = scanner.nextInt() ;
			 System.out.println("give FinishTime time for job\n");
			 int FinishTime = scanner.nextInt() ;
			 System.out.println("Give cost of jobs");
			 int cost = scanner.nextInt();
			
			 jobSet.add(new Job(startTime , FinishTime , name , cost));
			 
		 }
		 
		 
		/* jobSet.add(new Job(1,20,"1"));
		 jobSet.add(new Job(21,100,"2"));
		 jobSet.add(new Job(30,40,"3"));
		 jobSet.add(new Job(50,60,"4"));
		 jobSet.add(new Job(1,3,"5"));
		 jobSet.add(new Job(5,6,"6"));
		 jobSet.add(new Job(37,38,"7"));
		 jobSet.add(new Job(38,39,"8"));*/
	    
	    
		Iterator<Job> it = jobSet.iterator();
		 
    /*  while (it.hasNext())
      {
      	Job job = it.next();
      	System.out.println("Enter cost of job" + job.name );
      	int cost=  scanner.nextInt() ;
      	job.setCost(cost);
       } */
      TreeSet<Job> subSet = new TreeSet<Job>(comparator);
      TreeSet<Job> list2 = new TreeSet<Job>(comparator);
		Iterator<Job> itr = jobSet.iterator();
		int i = 1 ;
		while(itr.hasNext()){
			 
			Job job = itr.next();
			if(subSet.isEmpty()){
				
				System.out.println(job.name);
				subSet.add(job);
				
			}else{
                int p = 0 ;
				  Iterator<Job>  itr2 = subSet.iterator() ;
				  while(itr2.hasNext()){
					  Job job1 = itr2.next() ;
					  if((job.getStartTime() >=  job1.getFinishTime())){
						  
					  }else{
						  p=1 ;
					  }
					  
				  }
				  if(p==0){
					  list2.add(job);
					  System.out.println(list2.size());
				  }
				  
				
			} 
			subSet.addAll(list2);
			list2.clear();
			
			
		}
		//System.out.println("***"+list2);
		
		//System.out.println("list1" + list1);
		Iterator<Job> itr3  = subSet.iterator();
		TreeSet<Job> subSet1 = new TreeSet<Job>();
		while(itr3.hasNext()){
			Job job3 = itr3.next();
			System.out.println("Subset"+ job3.getStartTime()+":" + job3.getFinishTime());
			subSet1.add(job3);
			
		}
		
		System.out.println("Maximum number of jobs in Container");
		System.out.println("Job Name"+ "       " + "Job StartTime" + "     " +"Job FinishTime");
		Iterator<Job> itr4  = subSet.iterator();
		while(itr4.hasNext()){
			Job job3 = itr4.next();
			System.out.println(job3.name + ":::                 "+ job3.getStartTime()+"              " + job3.getFinishTime());
			
			
		}
		
		
	}


}
