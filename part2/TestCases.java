import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class TestCases
{
   public static final double DELTA = 0.00001;

   /*
    * This test is just to get you started.
    */
   @Test
   public void testGetX()
   {
      assertEquals(1.0, new Point(1.0, 2.0).getX(), DELTA);
   }

   /*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
    */

   @Test
   public void testImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getX",
         "getY",
         "getRadius",
         "getAngle",
         "rotate90"
         );

      final List<Class> expectedMethodReturns = Arrays.asList(
         double.class,
         double.class,
         double.class,
         double.class,
         Point.class
         );

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0],
         new Class[0],
         new Class[0],
         new Class[0],
         new Class[0]
         );

      verifyImplSpecifics(Point.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, Point.class.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertTrue("Unexpected number of public methods",
         expectedMethodNames.size()+1 >= publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }

   @Test
   public void testGetX1()
   {
      Point p = new Point(2, 10);
      double x = p.getX();
      assertEquals(2, x, DELTA);
   }

   @Test
   public void testGetX2()
   {
      Point p = new Point(-4, 0);
      double x = p.getX();
      assertEquals(-4, x, DELTA);
   }

   @Test
   public void testGetX3()
   {
      Point p = new Point(-4, 0);
      double x = p.getX();
      assertNotEquals(0, x, DELTA);
   }

   @Test
   public void testGetY1()
   {
      Point p = new Point(2, 10);
      double y = p.getY();
      assertEquals(10, y, DELTA);
   }

   @Test
   public void testGetY2()
   {
      Point p = new Point(-4, 0);
      double y = p.getY();
      assertEquals(0, y, DELTA);
   }

   @Test
   public void testGetY3()
   {
      Point p = new Point(-4, 0);
      double y = p.getY();
      assertNotEquals(-4, y, DELTA);
   }

   @Test
   public void testGetRadius1()
   {
      Point p = new Point(3, 4);
      double radius = p.getRadius();
      assertEquals(5, radius, DELTA);
   }

   @Test
   public void testGetRadius2()
   {
      Point p = new Point(1, 1);
      double radius = p.getRadius();
      assertEquals(1.41421356, radius, DELTA);
   }

   @Test
   public void testGetRadius3()
   {
      Point p = new Point(0, 4);
      double radius = p.getRadius();
      assertNotEquals(5, radius, DELTA);
   }

   @Test
   public void testGetAngle1()
   {
      Point p = new Point(3, 4);
      double rads = p.getAngle();
      assertEquals(0.927295218, rads, DELTA);
   }

   @Test
   public void testGetAngle2()
   {
      Point p = new Point(1, 1);
      double rads = p.getAngle();
      assertEquals(0.78539816, rads, DELTA);
   }

   @Test
   public void testGetAngle3()
   {
      Point p = new Point(0, 4);
      double rads = p.getAngle();
      assertNotEquals(0.927, rads, DELTA);
   }

   @Test
   public void testGetAngle4()
   {
      Point p = new Point(-3, 4);
      double rads = p.getAngle();
      assertEquals(2.214299222, rads, DELTA);
   }

   @Test
   public void testGetAngle5()
   {
      Point p = new Point(-1, -1);
      double rads = p.getAngle();
      assertEquals(3.9269908136, rads, DELTA);
   }

   @Test
   public void testGetAngle6()
   {
      Point p = new Point(2, -4);
      double rads = p.getAngle();
      assertEquals(5.1760365, rads, DELTA);

   }

   @Test
   public void testRotate901()
   {
      double correct_x = -2;
      double correct_y = 2;
      Point p = new Point(2, 2);
      Point new_point = p.rotate90();
      double p_x = new_point.getX();
      double p_y = new_point.getY();
      assertEquals(correct_x, p_x, DELTA);
      assertEquals(correct_y, p_y, DELTA);
   }

   @Test
   public void testRotate902()
   {
      double correct_x = -2;
      double correct_y = -2;
      Point p = new Point(-2, 2);
      Point new_point = p.rotate90();
      double p_x = new_point.getX();
      double p_y = new_point.getY();
      assertEquals(correct_x, p_x, DELTA);
      assertEquals(correct_y, p_y, DELTA);
   }

   @Test
   public void testRotate903()
   {
      double correct_x = 2;
      double correct_y = -2;
      Point p = new Point(-2, -2);
      Point new_point = p.rotate90();
      double p_x = new_point.getX();
      double p_y = new_point.getY();
      assertEquals(correct_x, p_x, DELTA);
      assertEquals(correct_y, p_y, DELTA);
   }

   @Test
   public void testRotate904()
   {
      double correct_x = 2;
      double correct_y = 2;
      Point p = new Point(2, -2);
      Point new_point = p.rotate90();
      double p_x = new_point.getX();
      double p_y = new_point.getY();
      assertEquals(correct_x, p_x, DELTA);
      assertEquals(correct_y, p_y, DELTA);
   }

}
