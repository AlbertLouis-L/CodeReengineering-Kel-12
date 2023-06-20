public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		// Check if width and height are valid
		if(width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Width and height must be greater than zero");
		}
		
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int area() {
		return width * height;
	}
	
	public int perimeter() {
		return 2 * (width + height);
	}
	
	public void print(String style) {
		style = style.toLowerCase();
		
		if(style.equals("full")) {
			printFullRectangle();
		} else if(style.equals("border")) {
			printRectangleWithBorder();
		} else {
			System.out.println("Style not recognized");
		}
	}
	
	private void printFullRectangle() {
		// Print a rectangle filled with asterisks (*)
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	private void printRectangleWithBorder() {
		// Print a rectangle with a border using asterisks (*) and empty spaces
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				// Print asterisks (*) for the border and empty spaces for the interior
				System.out.print(
						j == 0 || j == width-1 || 
						i == 0 || i == height-1 ? "*" : " ");
			}
			System.out.println("");
		}
	}
}
