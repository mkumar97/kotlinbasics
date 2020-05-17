package com.example.helloworld

data class User(val id : Long, var name : String)

// Class that inherits features of another class is called Sub class or Derived Class,
// and class whose features are inherited is called Super class or Parent class or Base class

interface Drivable{
    var maxSpeed: Double
    fun drive(): String
    fun brake(){
        println("Car will Stop")
    }
}

// open is used to make class inheritable otherwise default not inheritable
// Super class , Parent class, Base class
open class Car(val name : String, val brand : String): Drivable{
    // properties
    // methods
    open var range : Double = 150.0

    override var maxSpeed: Double = 432.0
    // Have to Declare methods and variables in interface using override to use interface properties
    override fun drive(): String {
        return "Interface is implemented"
    }

    open fun extendRange(amount: Double){
        if (amount > 0) range+= amount
    }

    open fun drive(distance: Double){
        println("$name drove for : $distance KM on petrol")
    }
}

// Derived Class, Sub class
// Should have at least all the parameters of Parent class
open class ElectricCar(name: String, brand: String, batteryLife : Double) : Car(name, brand){

    var batteryLife = 91.0
    var chargerType = "Type3"
    override var range = batteryLife * 8.0
    var balance = batteryLife * 8.0

    override fun extendRange(charged: Double){
        range += charged * 8.0
    }

    override fun drive(distance: Double){
        balance = range - distance
        println("$name drove for : $distance KM on electricity")
        println("$name can drive for $balance more KM before zero battery charge")
    }

    override fun drive() : String{
        return ("Can Drive for ($range) KM")
    }

    override fun brake() {
        super.brake() // inherited from interface i.e. super class of super class but not in direct super class
    }
}

// abstract class cannot be instantiated
// cannot create objects of class
// Can inherit sub classes from an abstract class
// members ( properties and methods) of abstract class are non - abstract
// unless explicitly mentioned
abstract  class Mammal(private  val name: String, private  val origin:String, private  val weight: Double){
    // arguments are concrete (non abstract) properties

    // Abstract properties ( Must be overridden by Sub classes)
    abstract var maxSpeed:Double

    // Abstract Methods (Must be implemented by Sub classes)
    abstract fun run()
    abstract fun breath()

    fun displayDetails(){
        println("Name : $name, Origin : $origin, Weight : $weight with Max Speed : $maxSpeed")
    }
}

class Human(val name: String, val origin: String, val weight: Double, override var maxSpeed:Double): Mammal(name, origin, weight){

    override fun breath() {
        println("$name breathes Oxygen")
    }

    override fun run() {
        println("$name runs at $maxSpeed kmph")
    }
}

class Elephant(val name: String, val origin: String, val weight: Double, override var maxSpeed: Double): Mammal(name, origin, weight){

    override fun breath() {
        println("$name breathes throught trunk")
    }

    override fun run() {
        println("$name runs at $maxSpeed kmph")
    }
}

fun main() {

    var human = Human("Manoj", "India", 62.0, 32.0)
    var elephant = Elephant("Denis", "US", 1200.0, 25.0)
    human.run()
    elephant.run()
    // var mammal = Mammal("Manoj") - cannot create an instance of abstract class throws error

    var audi = Car("A3", "AUDI")
    var tesla = ElectricCar("Tesla", "S", 63.0)

    tesla.chargerType = "Type4"
    audi.drive(300.0)
    tesla.extendRange(30.0)
    tesla.drive(450.0)
    tesla.maxSpeed = 560.0
    println("Max Speed of ${tesla.name} is  ${tesla.maxSpeed} kmph")
    tesla.brake()

    var myName = "Manoj - The Thop " // var is variable, val is immutable
    // TODO: Add new functionality later which helps in finding easily
    /* multi line comment */
    println("Hello " + myName)

    var user1 = User(15117046, "Manoj Kumar")
    println(user1.name)
    println("$user1")

    var user2= user1.copy(id=15117049, name = "OmP")
    println("$user2")

    val (enrolid, student) = user1
    println(enrolid)
    println(student)

    /*
    var manoj = Person("Manoj", "Kumar", 23)
    manoj.age = 22
    print("${manoj.age} ")
    manoj.hobby = "Watch Anime"
    manoj.stateHobby()
    var thop = Person()
    thop.stateHobby()
    */

    /*
    // var mobile = MobilePhone()
    var lambo = Car("Manoj", "Lambo")
    lambo.owner = "Thope"
    lambo.maxSpeed = 350

    var austin = Car("Kumar", "BMW M5")
    println(austin.myModel)
    // lambo.myModel = "Surprise" // cannot set value outside class as it is private
    */
}

/*
class Car(buyer : String){

    lateinit var owner : String

    val myBrand : String = "Lamborghini"
    get(){
        return field.toUpperCase() // normal get is return field which is default no need to mention
    }

    var maxSpeed : Int = 400
    get() = field // which is default, field means just as alias
    set(value){
        field = if(value > 250) value else throw IllegalArgumentException("Lamborghini is not slow..!!!")
    }

    var myModel : String = "Aventador"
    private set

    init {
        this.owner = buyer
    }

    constructor(buyer : String , model : String) : this(buyer){
        this.myModel = model
    }
}
*/
/*
class Person (firstName : String = "Nene", lastName : String = "Thop"){
    // cannot use firstName (argument) directly in methods
    // Member Variable - Properties
    var age : Int? = null
    var hobby : String = "Watch Netflix"
    var name : String? = null

    // Runs whenever Object type Person is Created
    init {
        name = firstName + " " + lastName
        println("New Person Object Created with FirstName : " + firstName + " and lastname : " + lastName)
    }

    // Member secondary constructor
    constructor(firstName: String, lastName: String, age : Int) : this(firstName, lastName){
        // above this is to take from main class firstName and lastName
        // below this is to assign age to class member variable or property
        this.age = age
        println("Initialised new Person Object with firstname = $firstName and lastname = $lastName and age = $age")
    }
    // Member Functions - Methods
    fun stateHobby(){
        println("$name's Hobby is $hobby")
    }
}
*/

/*
class MobilePhone (osName : String = "Android", brand : String = "Samsung", model : String = "Galaxy S20 Edge"){
    init {
        println("Created a new Mobile Phone having "+osName+" OS, from "+brand+" model : "+model)
    }
}
*/