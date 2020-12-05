
public class trabb{

	public static void main(String args[]){
	
	Thread threadP, threadC;
	BoundedBuffer buffer;
	int i;
	int numThreadP, numThreadC;
	
	buffer = new BoundedBuffer(5);
	
	
	numThreadP=1;
	for (i=0;  i<numThreadP; i++){
		threadP= new Thread(new Producer(buffer, args, i *(args.length/numThreadP),(args.length/numThreadP)) );
		threadP.start();
	}	
	
	numThreadC=10;
	for (i=0;  i<numThreadC; i++){
		threadC= new Thread(new Consumer(buffer, (args.length/numThreadC)) );
		threadC.start();
	}
}
}
