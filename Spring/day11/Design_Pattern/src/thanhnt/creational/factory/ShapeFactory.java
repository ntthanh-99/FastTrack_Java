package thanhnt.creational.factory;

public class ShapeFactory {
    public enum SHAPE_TYPE {CIRCLE, SQUARE, RECTANGLE}

    Shape createShape(SHAPE_TYPE type){
        if (type == null){
            return null;
        }
        if(type.equals(SHAPE_TYPE.CIRCLE)){
            return new Circle();
        }else if(type.equals(SHAPE_TYPE.SQUARE)){
            return new Square();
        }else if(type.equals(SHAPE_TYPE.RECTANGLE)){
            return new Rectangle();
        }else{
            return null;
        }
    }
}
