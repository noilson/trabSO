 public class Consumer extends Thread{
 
  	private BoundedBuffer buffer;
 	private int numElem;
 	
  	public Consumer (BoundedBuffer buffer, int numElem){
 	this.buffer = buffer; 
 	this.numElem =numElem;
 	}
 	public void rum(){
 		for(int i=0; i<numElem; i++)
 			buffer.Leitor();
 			
 	}
	
 }
 	
