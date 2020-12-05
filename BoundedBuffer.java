import java.util.concurrent.*;
import java.io.IOException;


public class BoundedBuffer implements buffer{

    private int in;
    private Object[] buffer; 
    
    private condition empty, full;
    public BoundedBuffer (int size){ 
        in = 0;
        buffer = new Object[size];     

    }  
    public  synchronized void insert(Object item){
    	try{
      	  	if (in == buffer.length){
          		wait(full);
       	}
      		buffer[in] = item;
        	in = (in + 1) % buffer.length;
        	System.out.println("item inserido: "+item.toString());

        	if (in!= buffer.length){
           		 notify(empty);
       	 }    
    	
    	}catch (InterruptedException ie){
    		System.out.println("Erro insercao no buffer: "+ie);
    	}
    }

    public Object Leitor(){

    	try{
        	if (in== 0)
           		wait(empty);

        	System.out.println(buffer);

       	if (in!= 0)
            		 notifyAll(full);
               
   	 }catch (InterruptedException ie){
    		System.out.println("Erro na leitura do buffer: "+ie);
    	}
    	
      
    }
}
