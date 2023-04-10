public void CalculateArea(String shapeType, int side, int width) {
    int area = 0;
    
    if (shapeType == "square") {
        area = side * side;
    } else if (shapeType == "rectangle") {
        area = side * width;
    } else if (shapeType == "circle") {
        area = 3.14 * side * side;
    }

    System.out.println("Area of " + shapeType + " : " + area);
}

class Main {
    public static void main(String[] args) {
        int squareSide = 7;
        int rectangleWidth = 8;
        int rectangleHeight = 3;
        int circleRadius = 10;

        CalculateArea(1, squareSide, 0);
        CalculateArea(2, rectangleWidth, rectangleHeight);
        CalculateArea(3, circleRadius, 0);
    }
}
