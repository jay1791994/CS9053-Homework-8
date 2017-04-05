package edu.nyu.cs9053.homework8;

import java.util.*;




public class LambdaWeightedScheduler {
public static void main(String args[]){
		
		JobComparator comparator = new JobComparator();
		TreeSet<Job> jobSet= new TreeSet<Job>(comparator);
		Scanner scanner = new Scanner(System.in) ;

		 
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
		 
	    
		 Iterator<Job> it = jobSet.iterator();
		 
		 TreeSet<Job> jobSet1= new TreeSet<Job>();
		 System.out.println("job list as per interval time");
	       
	       while (it.hasNext())
	       {
	       	Job job = it.next() ;
	       	System.out.println(job.name + "   " + job.cost);
	       }
	       
	       
	       
	       jobSet1.addAll(jobSet);
	    //   System.out.println(jobSet1);
	       
	       System.out.println("jobset as per cost");
	      //   System.out.println("container giving maximum cost"); 
			 Iterator<Job> it1 = jobSet1.iterator();
			 
		       while (it1.hasNext())
		       {
		       	Job job = it1.next();
		     	System.out.println(job.name   +     "   " + job.cost);
		        
		       }
		       
		       
		       TreeSet<Job> subSet = new TreeSet<Job>();
		       ArrayList<Job>  toberemoved = new ArrayList<Job>();
		        TreeSet<Job> list2 = new TreeSet<Job>();
				Iterator<Job> itr = jobSet1.iterator();
			
				while(itr.hasNext()){
					 
					Job job = itr.next();
					if(subSet.isEmpty()){
						
						subSet.add(job);
						
					}else{
		                  int p = 0 ;
						  Iterator<Job>  itr2 = subSet.iterator() ;
						  while(itr2.hasNext()){
							  Job job1 = itr2.next() ;
							  if((job.getStartTime() >= job1.getFinishTime()) ||(job.getFinishTime() <= job1.getStartTime() )  ){
								  
							  }else{
								  p=1 ;
							  }
							  
						  }
						  if(p==0){
							  list2.add(job);
							  
						  }
					 } 
					subSet.addAll(list2);
					list2.clear();
					}
				
			
			      // ---------------------------------------------------------------------------------------------------------//
				
			       
				
				
				Iterator<Job> itr6 = subSet.iterator() ;
				TreeSet<Job> newSet= new TreeSet<Job>();
				ArrayList lastJobSet = new ArrayList<Job>()  ;
				
			
				
				TreeSet<Job> subSet1 = new TreeSet<Job>(comparator);
			    TreeSet<Job> list3 = new TreeSet<Job>(comparator);
			   
			while(itr6.hasNext()){
				Job job1 = itr6.next() ;	
				Iterator<Job> it11 = jobSet.iterator() ;
				while(it11.hasNext()){
					Job job =  it11.next();
                
					if( job.getStartTime() >= job1.getStartTime() && job.getFinishTime() <= job1.getFinishTime()){
						if( job.getStartTime() == job1.getStartTime() && job.getFinishTime() == job1.getFinishTime())
						{
							
						}else{

						           newSet.add(job); 
						}   
							    						
					       }
					 

                    Iterator<Job> itrn =newSet.iterator();
					while(itrn.hasNext()){
						 
						Job jobn = itrn.next();
						if(subSet1.isEmpty()){
							
							//System.out.println(jobn.name);
							subSet1.add(jobn);
							
						}else{
			                 int p = 0 ;
							  Iterator<Job>  itr2n = subSet1.iterator() ;
							  while(itr2n.hasNext()){
								  Job job1n = itr2n.next() ;
								  if((jobn.getStartTime() >=  job1n.getFinishTime())|| (jobn.getFinishTime() <= job1n.getStartTime() )){
									  
								  }else{
									  p=1 ;
								  }
								  
							  }
							  if(p==0){
								  list3.add(jobn);
							//	  System.out.println(list3.size());
							  }
							  
							
						} 
						subSet1.addAll(list3);
					
						list3.clear();
					}
					
					
					}
				     int totalValue = 0  ;
				
			         Iterator<Job> itrs = subSet1.iterator();
			         while(itrs.hasNext()){
			        	 Job jobsubset1 = itrs.next() ;
			        	 totalValue = jobsubset1.cost + totalValue;
			           }
			         if(totalValue > job1.cost){
			        	 lastJobSet.addAll(subSet1);
			        	 System.out.println("Job Name"+ job1.name+ "Lastset Size" + lastJobSet.size());
			         }
			         
			          
			         
			         
			         if(subSet1.size() > 0 ){
			        	toberemoved.add(job1) ;
			        	System.out.println("removed size " + toberemoved.size());
			        	
			        	 }
				
				     System.out.println(job1.name +"total element in ineterval"+  ":" + newSet.size());
				     System.out.println(job1.name + "total compitable element" + ":" + subSet1.size());
				     
			             newSet.clear();
			             subSet1.clear();
			             
				      }
				    System.out.println(lastJobSet.size());
				    System.out.println(subSet.size());
				    lastJobSet.addAll(subSet) ;
				    System.out.println(lastJobSet.removeAll(toberemoved) );
				 
				   
					System.out.println("maximum cost container ");
					System.out.println("------------------------------------------------");
					 Iterator<Job> it3 = lastJobSet.iterator();
					 
				       while (it3.hasNext())
				       {
				       	Job job = it3.next();
				      	System.out.println(job.name +  "    " + job.cost);
				        
				       }
				
				}

}
