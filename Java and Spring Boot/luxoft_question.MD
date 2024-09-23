# <span style="color:#45ad51"> Razlika između && i & u javi ali u if uslovu kako se ponašaju</span>
- & is bitwise
    - both conditions always evaluated
- && is logicwise
    - evaluates left and then if true evaluates right side of operator
    
# <span style="color:#45ad51">O i W notacije za operacije nad listama vs O i W notacije za operacije nad povezanim listama
In Java, O-notation (Big O) and W-notation (Big W) are used to express algorithm performance, especially with regard to time and space complexity.

## Big O Notation (O-notation)
    Big O notation describes the worst-case time complexity of an algorithm or operation. It tells us how the runtime of an operation grows as the input size increases.

    Comparing ArrayList and LinkedList:
    Accessing an element by index (get(i)):

    ArrayList: O(1) (constant time). Since ArrayList is backed by an array, accessing an element at index i is a direct lookup.
    LinkedList: O(n) (linear time). To access an element at index i, the linked list must traverse the nodes from the start, making it a linear operation.
    Adding an element at the end (add(e)):

    ArrayList: O(1) (amortized constant time). When the array has enough space, adding is fast. However, when the array is full, it must resize itself, which takes O(n).
    LinkedList: O(1) (constant time). Since a linked list maintains a reference to the last node, adding an element at the end is constant.
    Adding an element at a specific index (add(i, e)):

    ArrayList: O(n) (linear time). The array needs to shift all elements after index i to the right, so the time grows linearly with the number of elements.
    LinkedList: O(n) (linear time). The list has to traverse the nodes to reach index i, then adjust the pointers to insert the new node.
    Removing an element (remove(i)):

    ArrayList: O(n) (linear time). Elements after the removed element must be shifted left.
    LinkedList: O(n) (linear time). The list needs to traverse to the node, then adjust pointers. Removing the first or last element takes O(1) time.

## Big W Notation (W-notation)
    Big W notation expresses the best-case time complexity of an algorithm, meaning it gives a lower bound on the execution time under optimal conditions. In practice, it's less commonly used than Big O because worst-case scenarios are more critical to consider.

    Comparing ArrayList and LinkedList in terms of W-notation:
    For many operations (like get(i) in an ArrayList or add(e) at the end of a LinkedList), the best-case performance matches the worst-case performance. Therefore:
    Accessing by index (get(i) in ArrayList): Best case is O(1), since it’s a direct lookup.
    Accessing by index in LinkedList: Best case is O(1) only for accessing the first element (get(0)), otherwise it’s O(n).
    Adding to the end (add(e)): Best case is O(1) for both ArrayList and LinkedList.
    However, W-notation is not as widely discussed in practical interview scenarios because it doesn’t capture the worst-case behavior, which is usually more important to assess.


# <span style="color:#45ad51"> Razlika između hash coda i equals, pod kojim uslovima prolazi test equals
Java Object methods

## equals()
    Compares if two objects are equal by comparing all of its attributes to be equal.
    Objects are equal if share memory location by default

    Cotract:
    1. Must be equal to itself equals(x) = true
    2. If x.equals(y) = true equals.(x) must be true
    3. If x.equals(y) and y.equals(z) =>  x.equals(z) must be true
    4. equals(null) = FALSE

## hashCode()
    Provides integer representation of an object. Used for hashing.

    Contract:
    1. If x.equals(y) = TRUE then it returns same value for hashCode()
    2. If x.equals(y) = FALSE usually returns different value

# <span style="color:#45ad51"> - Kako radi memorija u nizovima, kako se dodaje novi element u niz ali low level, sa aspekta memorije
#  Šta su to mape, load factor, hash code i hash tabele štreberski iz knjige, zašto je insert O(1) i load factor Mape
# <span style="color:#45ad51"> Ako treba da ubacim 1k podataka koju strukturu podataka koristim, liste ili linked liste
Array listu osim ako nema manipulacija sa podacima na sredini ili pocetku liste

# Razlika izmedju ExecutorSevice execute i submit metode
# <span style="color:#45ad51">  Razlika izmedju PUT i PATCH
    PUT: Zamenjuje ceo resurs novim podacima. Moraš poslati sve vrednosti (čak i one koje se ne menjaju), jer će se resurs na serveru potpuno zameniti.
    PATCH: Zamenjuje samo određene delove resursa. Šalješ samo polja koja želiš da izmeniš, ostala polja ostaju nepromenjena.
    
    Kada koristiti:
        Koristi PUT kada želiš da kompletno zameniš resurs.
        Koristi PATCH kada želiš da delimično izmeniš resurs, bez potrebe za slanjem celog objekta.
    
    U kontekstu RESTful API-ja, PATCH je efikasniji za delimična ažuriranja jer zahteva manje podataka u zahtevu, dok PUT može biti poželjan kada želiš da osiguraš konzistentnost kompletnog resursa.

# <span style="color:#45ad51"> Šta je interface segregacija
    The Interface Segregation Principle (ISP) is one of the five SOLID principles of object-oriented design. It states that:

    "Clients should not be forced to depend on interfaces they do not use."

    In simpler terms, classes should not be forced to implement large, general-purpose interfaces with many methods that they don’t need. Instead, interfaces should be broken down into smaller, more specific ones, each containing only the methods relevant to the implementing class.

    Key Idea:
        Interfaces should be narrow and focused on specific functionality.
        A class should implement only the interfaces it truly needs, avoiding methods that don’t apply to it.

    Why is it important?
        Fewer dependencies: If a class implements a large interface but uses only a few of its methods, any change to the unused methods can still affect that class unnecessarily.
        Simpler code: Small, specialized interfaces make the code more readable and maintainable.
        Flexibility: By having multiple smaller interfaces, classes can choose to implement only the functionalities they actually require.

# Šta je volatile identifier u Javi
# Šta radi AutoConfig anotacija u Javi
# Razlika izmedju Callable i Runnable interfejsa
# Čemu služi try with resources?
    Ne treba ti close na kraju
# Koje vrste memorije postoje u Javi?
# <span style="color:#45ad51"> Šta je funkcinalni interfejs?
    A functional interface in Java is an interface that contains exactly one abstract method. These interfaces are used primarily in functional programming scenarios, such as with lambda expressions and method references in Java.

    Characteristics of a Functional Interface:
    - One abstract method: The interface must have exactly one abstract method. This makes it compatible with lambda expressions.
    - Default or static methods: It can have multiple default or static methods, but those methods are not considered abstract.
    - The @FunctionalInterface annotation is often used to mark an interface as functional, but it is not required. This annotation helps catch errors at compile-time if the interface is not valid as a functional interface.

    Examples of Functional Interfaces in Java:
    - Runnable: Has a single abstract method run(), making it a functional interface.
    - Callable<V>: Has a single abstract method call(), which returns a value and throws an exception.
    - Comparator<T>: Contains the single abstract method compare(), which takes two arguments and returns an integer.
    - ActionListener (from Swing): Has a single abstract method actionPerformed().

    Functional interfaces are particularly useful when you need to pass behavior (a block of code) as an argument to methods or when you want to encapsulate behavior. 
    - Lambda expressions: Instead of creating anonymous inner classes, you can use a functional interface to pass behavior as a lambda expression.
    - Stream API: Functional interfaces play a crucial role in Java's Stream API. Interfaces like Predicate, Function, and Consumer are used to define the behavior in stream operations.
    - Event handling: In GUI applications (like Swing or JavaFX), functional interfaces are often used for event handling (e.g., ActionListener in Swing).

# <span style="color:#45ad51"> Šta je default metoda interfejsa?
    In Java, starting from Java 8, interfaces can have default methods. A default method is a method in an interface that has a default implementation, which allows classes implementing that interface to inherit the method without being forced to provide their own implementation. This feature was introduced to allow adding new methods to interfaces without breaking existing implementations.
    
    default keyword 
# Šta su niti, kako ih pokrećemo?
# Šta je threadLocal?
# Šta je Apstraktna fabrika?
# Čemu služi spring actuator?
# Zašto native query nije dobar?
# Java access specifiers
# Šta je garbage kolektor, kako radi?