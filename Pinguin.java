
package animals;

import MainClasses.Beings.Animal;
import Interfaces.Swimmable;

public class Pinguin extends Animal implements Swimmable{
    
    public void Swim()
    {
        System.out.println("Пингвин плывет");
    }
}
