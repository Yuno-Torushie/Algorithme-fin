package lsp;

public class Square extends Rectangle {
        
		public void setWidth(int width){
                super.setWidth(width);
                super.setHeight(width);
        }
        public void setHeight(int height){
        		super.setWidth(height);
            super.setHeight(height);
        }
        
        public void setSize(int newSize) {
        	rect.setHeight(newSize);
        	rect.setWidth(newSize);
        }
        
        public int getSize() {
        	return rect.getHeight();
        }
        
        public int getArea() {
        	return rect.getArea();
        }
}
