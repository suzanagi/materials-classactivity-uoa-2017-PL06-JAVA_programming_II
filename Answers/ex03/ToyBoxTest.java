import java.util.ArrayList;

/**
 * ToyBox Example.
 */


class ToyBox<T> {

    private ArrayList<T> v = new ArrayList<T>(); // Complete here to assign ArrayList object         

    public void add(T element) {
        this.v.add(element);    // Complete add method with proper argument and method body
    }

    public T get(int index) {
        return this.v.get(index);    // Complete get method with proper argument and method body
    }

    public int getSize() {
        return this.v.size();    // Complete getSize method with proper argument and method body
    }
}

public class ToyBoxTest {
    public static void showToysinBox(ToyBox<? extends Toy> tBox/* Parameter with bounded wildcard to accept Toy and its subclasses*/) {
        // Complete showAnimalsinToyBox method with proper argument and method body
	for(int i = 0; i < tBox.getSize(); i++) System.out.println(tBox.get(i));
    }

    public static void main(String[] args) {

     // Create a "carBox" with proper sentence
	ToyBox<Car> carBox = new ToyBox<Car>();

       Car t1 = new Car("Yaris", 1500);
       Car t2 = new Car("Corolla", 2500);
      carBox.add(t1);
      carBox.add(t2);
      showToysinBox(carBox);

     // Create a "bearBox" with proper sentence
      ToyBox<Bear> bearBox = new ToyBox<Bear>();
      Bear b1 = new Bear("Bear1", 1000);
      Bear b2 = new Bear("Bear2", 2000);
      bearBox.add(b1);
      bearBox.add(b2);
      showToysinBox(bearBox);


      /* It is OK till now */

      // Next, create Box<Toy>
      
     // Create a "toyBox" with proper sentence
      ToyBox<Toy> toyBox = new ToyBox<Toy>();

      Car t3 = new Car("Tacoma", 3300);
      Bear b3 = new Bear("Bear3", 1200);

      toyBox.add(t3);
      toyBox.add(b3);

      showToysinBox(toyBox);
      /* It is still OK till now */

      // How about the next? Is it subtype?
      ToyBox<? extends Toy> sometoyBox = carBox;
      System.out.println("After assigning the carBox into the \"sometoyBox\"...");
      showToysinBox(sometoyBox);
    }
}

class Toy {
    private String name;
    private int price;

    public Toy(String name, int price){
	this.name = name;
	this.price = price;
    }

    public String toString(){
	return this.name + "/" + this.price;
    }
}

// Car class and Bear class to extend the Toy class
class Car extends Toy{
    public Car(String name, int price){ super(name, price);}
}

class Bear extends Toy{
    public Bear(String name, int price){ super(name, price);}
}

