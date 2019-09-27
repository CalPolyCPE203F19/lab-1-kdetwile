import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ExampleMap
{
   public static List<String> highEnrollmentStudents(
      Map<String, List<Course>> courseListsByStudentName, int unitThreshold)
   {
      List<String> overEnrolledStudents = new LinkedList<>();
      Set<String> map_keys = courseListsByStudentName.keySet();
      for (String val : map_keys) {
         List<Course> course_list = courseListsByStudentName.get(val);
         //go through list of courses and count up of the units (course.getUnits())
         int unit_total = 0;
         for (Course course : course_list) {
            int units = course.getNumUnits();
            unit_total = unit_total + units;
         }
         if (unit_total > unitThreshold) {
            overEnrolledStudents.add(val);
         }
      }

      /*
         Build a list of the names of students currently enrolled
         in a number of units strictly greater than the unitThreshold.
      */

      return overEnrolledStudents;      
   }
}
