class SimpleLoop
{
   public static int sum(int low, int high)
   {
      /* TO DO:  Return the sum of the integers between
         low and high (inclusive).  Yes, this can be
         done without a loop, but the point is to
         practice the syntax for a loop.
      */

        int count = 0;
        for (int i = low; i < high; i++)
        {
        	count = i + count;
        }
        return (count + high);
   }
}
