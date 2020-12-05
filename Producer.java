 public class Producer extends Thread{
 
  	private BoundedBuffer buffer;
 	private String[] stringArray;
 	private int start;
 	private int numElem;
 	
 	public Producer(BoundedBuffer buffer, String[] elem, int start, int numElem){
 	this.buffer = buffer; 
 	stringArray = elem;
 	this.start = start;
 	this.numElem =numElem;
 	
 	}
  	public void rum(){
 		for(int i=0;i<numElem;i++)
 			buffer.insert(stringArray[i+start]);
 	
 	}
}


