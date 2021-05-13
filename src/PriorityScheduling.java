public class PriorityScheduling
{	
	static void ps(int p[],int priority[],int bt[])
	{
		int n=p.length;
		int temp;	
		for(int i=0;i<n-1;i++)								//sorting the process based on priority
		{
			for(int j=i+1;j<n;j++)
			{
				if(priority[i]>priority[j])
				{
					temp=priority[i];
					priority[i]=priority[j];
					priority[j]=temp;
					temp=p[i];
					p[i]=p[j];
					p[j]=temp;
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
				}
			}
		}
		int ct[]=new int[n];						//completion time
		int before[]=new int[n+1];					//keeping track of previous completion time
		before[0]=0;								//current time=0
		for(int i=0;i<n;i++)
		{
			ct[i]=bt[i]+before[i];					
			before[i+1]=ct[i];
		}									//arrival time=0 for all the processors
		int tat[]=new int[n];				//turn around time
		int waiting_time[]=new int[n];		//waiting time
		for(int i=0;i<n;i++)
		{
			tat[i]=ct[i];					//turn around time=completion time-arrival time
			waiting_time[i]=tat[i]-bt[i];	//waiting time=turn around time-burst time
		}
		System.out.println("Process  Burst_time  Priority  Turn_around_time  Waiting_time");
		int total_tat=0,total_waiting=0;
		for(int i=0;i<n;i++)
		{	
			total_tat+=tat[i];
			total_waiting+=waiting_time[i];
			System.out.printf("P%d",p[i]);
			System.out.printf("	  %d", bt[i]);
			System.out.printf("		%d",priority[i]);
			System.out.printf("	  %d",tat[i]);
			System.out.printf("		  %d\n", waiting_time[i]);
		}
		System.out.println("Average turn around time = "+(total_tat)/n);			//average turn around time
		System.out.println("Average waiting time = "+(total_waiting)/n);			//average waiting time
	}
	
	public static void main(String[] args)
	{													
		int p[]= {1,2,3,4};								// processors							
		int bt[]= {10,4,5,3};							//burst time					
		int priority[]= {2,1,4,3};						//priority
		ps(p,priority,bt);								//calling the function
	}
}
