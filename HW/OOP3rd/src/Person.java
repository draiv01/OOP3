import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Person implements Comparable<Person>, Iterable<Person> {
    private String name;
    private int age;
    private List<Person> people = new ArrayList<>();
    private int index = 0;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName(){return name;}
    int getAge(){return age;}


    @Override
    public int compareTo(Person otherPerson) {
        return this.name.compareTo(otherPerson.getName());
    }

    @Override
    public String toString() {
        return name;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator();
    }

    private class PersonIterator implements Iterator<Person> {
        @Override
        public boolean hasNext() {
            return index < people.size();
        }

        @Override
        public Person next() {
            if (hasNext()) {
                return people.get(index++);
            }
            return null;
        }
    }
    class PersonNameComparator implements Comparator<Person>{
  
        public int compare(Person a, Person b){
          
            return a.getName().compareTo(b.getName());
        }
    }
    class PersonAgeComparator implements Comparator<Person>{
      
        public int compare(Person a, Person b){
          
            if(a.getAge()> b.getAge())
                return 1;
            else if(a.getAge()< b.getAge())
                return -1;
            else
                return 0;
        }
    }
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 23);
        Person person2 = new Person("Bob", 34);
        Person person3 = new Person("Charlie", 10);
        Person person4 = new Person("David", 14);

        person1.addPerson(person1);
        person1.addPerson(person2);
        person1.addPerson(person3);
        person1.addPerson(person4);

//        System.out.println("initial list: " + person1);

        Collections.sort(person1.people);
        System.out.println("sort by name: " + person1.people);

        Collections.sort(person1.people, new NameLengthComparator());
        System.out.println("sort by name length: " + person1.people);

//        System.out.println("Итерация по списку:");
//        for (Person person : person1) {
//            System.out.println("Имя: " + person.getName());
        System.out.println("iterating:");
        Iterator<Person> iterator = person1.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println("name: " + person.getName()+ person.getAge());
        }
    }



}

class NameLengthComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getName().length() - person2.getName().length();
    }


}
