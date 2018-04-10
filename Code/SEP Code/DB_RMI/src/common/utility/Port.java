package common.utility;

public class Port
{
   private static Port instance;
   private int p;
   
   private Port()
   {
      this.p=1099;
   }
   public static Port getInstance()
   {
      if(instance==null)
         instance=new Port();
      return instance;
   }
   
   public int get()
   {
      
      return p;
   }
}
