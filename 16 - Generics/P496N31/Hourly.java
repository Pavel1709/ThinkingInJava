//: generics/MultipleInterfaceVariants.java 
// {No CompileTimeError} (Will compile)
interface Payable<T> {}
class Employee implements Payable  {}
public class Hourly extends Employee implements Payable  {} ///:~