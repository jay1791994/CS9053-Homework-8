package edu.nyu.cs9053.homework8;



public class Job implements Comparable<Job> {
	private int startTime , finishTime ;
	public String name ;
	public int TotalTime  ;
	public float ForCmp ;
	public int cost ;
	
	public String getName() {
		return name;
	}



	public int getTotalTime() {
		return TotalTime;
	}



	public float getForCmp() {
		return ForCmp;
	}



	public Job(int startTime , int finishTime , String Name , int cost){
		this.startTime = startTime ;  
		this.finishTime = finishTime ;
		this.name= Name ;
		this.cost = cost ;
		this.TotalTime = this.finishTime - this.startTime ;
		this.ForCmp = (this.TotalTime) + ((float)(this.startTime/100));
		
	}
	


	public void setCost(int cost) {
		this.cost = cost;
	}



	public int getCost() {
		return cost;
	}



	public int getStartTime() {
		return startTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	
	public int compareTo(Job o) {
		// TODO Auto-generated method stub
		Integer a = Integer.parseInt(this.name);
		Integer b = Integer.parseInt(o.name);
		if(this.cost == o.cost ){
			return 1 ;
		}else{
		return (o.cost - this.cost) ;
		}

}
}