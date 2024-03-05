package algorithmCode.designPattern;

/**
 * 描述：抽象工厂模式
 * 
 * 抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。
 * 该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 
 * @author BrokenColor
 * @date 2019年3月14日
 */
public class Abstract_Factory_Pattern {

	public static void main(String[] args) {
		Abstract_Factory_Pattern af = new Abstract_Factory_Pattern();
		
		FactoryProducer fp = af.new FactoryProducer();
		
		//超级工厂创建其他工厂
		AbstractFactory fshape =  fp.getFactory("shape");
		//工厂创建实例
		Shape shape1 = fshape.getTypeShape("rectangle");
		shape1.draw();
		Shape shape2 = fshape.getTypeShape("square");
		shape2.draw();
		Shape shape3 = fshape.getTypeShape("circle");
		shape3.draw();
		
		AbstractFactory fcolor =  fp.getFactory("color");
		Color color1 = fcolor.getTypeColor("red");
		color1.fill();
		Color color2 = fcolor.getTypeColor("green");
		color2.fill();
		Color color3 = fcolor.getTypeColor("yellow");
		color3.fill();
	}
	
	public abstract class AbstractFactory{
		public abstract Shape getTypeShape(String shape);
		public abstract Color getTypeColor(String color);
	}
	
	public class FactoryProducer {
		public AbstractFactory getFactory(String choice) {
			if (choice == null) {
				return null;
			}
			switch(choice.toLowerCase()) {
				case "color": 
					return new FactoryColor();
				case "shape": 
					return new FactoryShape();
				default:
					return null;
			}
		}
	}
	
	//FactoryShape(工厂，根据传入的参数创建不通的参数)
	public class FactoryShape extends AbstractFactory{
		
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
		}

		@Override
		public Color getTypeColor(String color) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	//FactoryColor(工厂，根据传入的参数创建不通的参数)
	public class FactoryColor extends AbstractFactory{
		public Color getTypeColor(String strColor){
			if (strColor == null) {
				return null;
			}
			switch(strColor.toLowerCase()) {
				case "red": 
					return new Red();
				case "green": 
					return new Green();
				case "yellow": 
					return new Yellow();
				default:
					return null;
			}
		}

		@Override
		public Shape getTypeShape(String shape) {
			// TODO Auto-generated method stub
			return null;
		}
		
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
	//接口（颜色）
	public interface Color{
		public void fill();
	}
	//Red（红色）实现接口Color（颜色）
	public class Red implements Color{
		@Override
		public void fill() {
			System.out.println("red fill!");
		}
	}
	//Green（绿色）实现接口Color（颜色）
	public class Green implements Color{
		@Override
		public void fill() {
			System.out.println("green fill!");
		}
	}
	//Yellow（黄色）实现接口Color（颜色）
	public class Yellow implements Color{
		@Override
		public void fill() {
			System.out.println("yellow fill!");
		}
	}

}
