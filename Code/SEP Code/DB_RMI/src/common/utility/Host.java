package common.utility;


//singleton host for the connection in Server/Client
public class Host
{
   private static Host instance;
   private String s; 
   
   private Host()
   {
     this.s="localhost";
   }
   
   public static Host getInstance()
   {
      if(instance==null)
         instance = new Host();
      return instance;
   }
   public String get()
   {
      return s;
   }
   
}
