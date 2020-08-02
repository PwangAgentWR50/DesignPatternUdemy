# Factory
A component responsible solely for the wholesale (not piecewise) creation of objects.

# Motivation
1. Object creation logic becomes too convoluted
2. Constructor is not descriptive
    * Name mandated by name of containing type
    * Cannot overload with same sets of arguments with different names
    * Can turn into overloading hell
3. Wholesale object creation (Builder is piecewise) can be outsourced to
    * A separate function (Factory method)
    * That may exist in a separate class (Factory)
    * Can create hierarchy of factories with Abstract Factory
    
