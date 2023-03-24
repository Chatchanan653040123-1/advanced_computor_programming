/**
 * this TestPolygons program is has three instance attributes which are width, height, and type and two static attributes which are numPolygons and sumPolygonsArea
 * The types of Polygons are defined using enum type PolygonType which has two values as RECTANGLE and TRIANGLE
 * Define one instance method getArea() which returns the area of a polygon  based on width, height, and type of a polygon
 * Define two static methods which are setNumPolygons(int numNewPolygons) which adds numNewPolygons to the current value of numPolygons and setSumPolygonsArea(double newPolygonsArea)  
 * which adds newPolygonsArea to the current value of sumPolygonsArea  
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 19/1/2023
 */
package panyaprasirtkit.chatchanan.lab5;

// enum of type of Polygon
enum PolygonType {
    RECTANGLE,
    TRIANGLE
}

class Polygon {
    double width;
    double height;
    PolygonType type;
    static int numPolygons;
    static double sumPolygonsArea;

    // set Method
    public static void setNumPolygons(int numNewPolygons) {
        numPolygons += numNewPolygons;
    }

    public static void setSumPolygonsArea(double newPolygonsArea) {
        sumPolygonsArea += newPolygonsArea;
    }

    // get method
    public double getArea() {
        if (type == PolygonType.RECTANGLE) {
            return width * height;
        } else {
            return 0.5 * width * height;
        }

    }
}

public class TestPolygons {
    public static void main(String[] args) {
        Polygon polygons1 = new Polygon();
        polygons1.width = 2;
        polygons1.height = 3;
        polygons1.type = PolygonType.RECTANGLE;
        Polygon.setNumPolygons(1);
        Polygon.setSumPolygonsArea(polygons1.getArea());
        Polygon polygons2 = new Polygon();
        polygons2.width = 3;
        polygons2.height = 4;
        polygons2.type = PolygonType.TRIANGLE;
        Polygon.setNumPolygons(1);
        Polygon.setSumPolygonsArea(polygons2.getArea());
        System.out.println("The number of polygons is " + Polygon.numPolygons + " or " + polygons1.numPolygons + " or "
                + polygons2.numPolygons);
        System.out.println(
                "The width of polygon1 is " + polygons1.width + " The width of polygon2 is " + polygons2.width);
        System.out.println("The sum of polygons area is " + Polygon.sumPolygonsArea);
    }

}