
public class Gorilla extends Mammal {
	public void throwSomething() {
		energyLevel=energyLevel-5;
		System.out.println(" The gorilla has thrown something, as well as decrease the energy level by 5");
		
	}
	public void eatBananas() {
		energyLevel=energyLevel+10;
		System.out.println("The gorilla's satisfaction and increase its energy by 10");
		System.out.println(energyLevel);


		
		}
	public void climb() {
		energyLevel=energyLevel-10;
		System.out.println("The gorilla has climbed a tree and decrease its by 10");
		System.out.println(energyLevel);
	}

}
