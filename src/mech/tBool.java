package mech;

public class tBool{
	private boolean valueOf;
	public tBool(boolean value) {
		this.valueOf = value;
	}
	
	public boolean getValue() {return this.valueOf;}
	public void setValue(boolean newValue) {this.valueOf = newValue;}
	
	public void toggle() {
		if(this.valueOf == true) {
			valueOf = false;
		}else {
			valueOf = true;
		}
	}
}
