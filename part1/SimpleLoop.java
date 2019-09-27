class SimpleLoop
{
   public static int sum(int low, int high)
   {
      /* TO DO:  Return the sum of the integers between
         low and high (inclusive).  Yes, this can be
         done without a loop, but the point is to
         practice the syntax for a loop.
      */
        if (low == high) {
        	return (low * 2);
        }
        int count = low;
        int increase_num = low + 1;
        while (increase_num < high) {
        	count = (count + increase_num);
        	increase_num++;
        }
        count = (count + high);
    	return count;
   }
}
