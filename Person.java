public class Person
{
    private String name;
    private int age;
    public Person( String _name, int _age)
    {
        name = _name;
        age = _age;
    }
    public String getName(){
        return name;
    }
    public int compareTo(Person other) {
        return this.age - other.age; 
    }
}
