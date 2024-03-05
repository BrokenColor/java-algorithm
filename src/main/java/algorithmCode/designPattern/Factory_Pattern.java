package algorithmCode.designPattern;

/**
 * 描述：工厂模式
 * 
 * @author BrokenColor
 * @date 2019年3月14日
 */
public class Factory_Pattern {

	public static void main(String[] args) {
		Factory_Pattern f1 = new Factory_Pattern();
		
		FactoryShape factory = f1.new FactoryShape();

		Shape shape1 = factory.getTypeShape("Rectangle");
		shape1.draw();
		Shape shape2 = factory.getTypeShape("Square");
		shape2.draw();
		Shape shape3 = factory.getTypeShape("Circle");
		shape3.draw();
	}
	//接口Shape(形状)
	public interface Shape {
		   void draw();
	}
	
	//Rectangle(矩形)实现接口Shape(形状)
	public class Rectangle implements Shape{

		@Override
		public void draw() {
			System.out.println("Rectangle draw!");
		}
		
	}
	//Square(正方形)实现接口Shape(形状)
	public class Square implements Shape{

		@Override
		public void draw() {
			System.out.println("Square draw!");
		}
		
	}
	//Circle(圆形)实现接口Shape(形状)
	public class Circle implements Shape{

		@Override
		public void draw() {
			System.out.println("Circle draw!");
		}
		
	}
	//FactoryShape(工厂，根据传入的参数创建不通的参数)
	public class FactoryShape{
		
		public Shape getTypeShape(String strShape){
			if (strShape == null) {
				return null;
			}
			switch(strShape.toLowerCase()) {
				case "rectangle": 
					return new Rectangle();
				case "square": 
					return new Square();
				case "circle": 
					return new Circle();
				default:
					return null;
			}
			
//			if ("Rectangle".equalsIgnoreCase(strShape)) {
//				return new Rectangle();
//			} else if("Square".equalsIgnoreCase(strShape)){
//				return new Square();
//			} else if ("Circle".equalsIgnoreCase(strShape)) {
//				return new Circle();
//			} 
//			return null;
		}
	}

}
