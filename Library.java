import java.util.Hashtable;
/** 
 *  Class representing a Library
 *  The Library class is built upon the Building class
 */
public class Library extends Building {

  /** What are all of the books in the library? */
  private Hashtable <String, Boolean> collection;
/** Does this building have an elevator? */
  private boolean hasElevator;

    /** 
     *  Create a library with specified name, address, floors, and elevator
     *  @param name The name of the building
     *  @param address Where the building is located
     *  @param nFloors How many floors the building has
     *  @param hasElevator If the building has an elevator or not
     */  
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }

    /* Overloaded constructor with name only */
    public Library(String name){
      super(name);
    }

    /* Overloaded constructor with name and address only */
    public Library(String name, String address){
      super(name, address);
    }

    /** 
     *  Check if the building has an elevator
     *  @return true or false on whether the building has an elevator
     */
    public boolean hasElevator() {
      return this.hasElevator;
    }
    
    /** 
     *  Add a book to the hastable of books
     *  @param title The title of the book
     */  
    public void addTitle (String title){
      if (this.collection.containsKey(title)){
        throw new RuntimeException(title + " is already a part of " + this.name + "'s catalogue.");
      }
      this.collection.put(title,true);
      System.out.println(title + " has been added to " + this.name + "'s catalogue. Give it a read!");
    }

    /** 
     *  Remove a book from the hastable of books
     *  @param title The title of the book
     *  @return The title of the book
     */ 
    public String removeTitle (String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException (title + " is not a part of " + this.name + "'s cataloge.");
      }
      this.collection.remove(title);
      System.out.println(title + " has been removed from " + this.name + "'s catalogue. Hope you got to read it!");
      return title;
    }

    /** 
     *  Change the availability of a book to unavailable
     *  @param title The title of the book
     */ 
    public void checkOut (String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException (title + " is not a part of " + this.name + "'s cataloge.");
      }
      this.collection.replace(title, false);
    }
    /** 
     *  Change the availability of a book to available
     *  @param title The title of the book
     */ 
    public void returnBook (String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException (title + " is not a part of " + this.name + "'s cataloge.");
      }
      this.collection.replace(title, true);
    }

    /** 
     *  Check if the library carries a certain book
     *  @param title The title of the book
     *  @return A boolean on whether or not the library carries the book
     */ 
    public boolean containsTitle (String title){
      if (this.collection.containsKey(title)){
        System.out.println(title + " is a part of " + this.name + "'s cataloge.");
        return true;
      }
      else{
        System.out.println(title + " is not a part of " + this.name + "'s cataloge.");
        return false;
      }
    }

    /** 
     *  Add a book to the list of hastable of books
     *  @param title The title of the book
     *  @return A boolean on whether or not the book is available
     */ 
    public boolean isAvailable (String title){
      if (!this.collection.containsKey(title)){
        throw new RuntimeException (title + " is not a part of " + this.name + "'s cataloge.");
      }
      if (this.collection.get(title) == false){
        System.out.println(title + " is not currently available.");
        return false;
      }
      else{
        System.out.println(title + " is currently available.");
        return true;
      }
    }

    /** 
     *  Print the collection of books at the library
     */ 
    public void printCollection(){
      /////
      this.collection.entrySet().forEach( entry -> {
        System.out.print(entry.getKey() + ": ");
        if (entry.getValue() == true){
          System.out.println("Available");
        }
        if(entry.getValue() == false){
          System.out.println("Unavailable");
        }
      });
    }

    /** 
     *  Converts all of the library information into a readable string
     *  @return the description of the library
     */ 
    public String toString() {
      String description = super.toString();
      return description;
    }

    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + hasElevator()\n + goToFloor(n)\n + addTitle(t) \n + removeTitle(t)\n + checkOut(t)\n + removeTitle(t)\n + returnBook(t)\n + containsTitle(t)\n + isAvailable(t)\n + printCollection()\n + toString()");
    }

    public void goToFloor(int floorNum) {
      if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      if (this.hasElevator == true) {
        System.out.println("You ride the elevator to floor #" + floorNum + ".");
      }
      if (this.hasElevator == false) {
        throw new RuntimeException("Since there is no elevator, you must call goUp() or goDown() in order move between floors.");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }
  }