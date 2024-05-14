class SuperClass {
        // Instance Variables with different access modifiers
        private int privateVar;
        protected String protectedVar;
        public double publicVar;

        // Overloaded method inside the superclass
        public void overloadedMethod(int num) {
            System.out.println("Overloaded method with int parameter in SuperClass: " + num);
        }

        public void overloadedMethod(String str) {
            System.out.println("Overloaded method with String parameter in SuperClass: " + str);
        }

        //Overridden method in superclass
        public void overriddenMethod() {
            System.out.println("SuperClass overriddenMethod");
        }
    }

    // Subclass (Child Class) which inherits the superclass
    class SubClass extends SuperClass {
        // Overridden method in subclass
        @Override
        public void overriddenMethod() {
            System.out.println("SubClass overriddenMethod");
        }

        // Use of super keyword to call overridden method from superclass
        public void callSuperMethod() {
            super.overriddenMethod();
        }

        // Use of super keyword for parent constructor call
        public SubClass() {
            super();
            System.out.println("SubClass constructor called");
        }

        //Abstract method implementation in inherited class
        public void abstractMethod() {
            System.out.println("Abstract method implemented in SubClass");
        }
    }

    // Abstract class and method
    abstract class MyAbstractClass {
        public abstract void abstractMethod();
    }

    // SuperClass extending another abstract class
    class SuperSubClass extends MyAbstractClass {
        @Override
        public void abstractMethod() {
            System.out.println("Abstract method implemented in SuperClass");
        }
    }

    public class Main {
        public static void main(String[] args) {
            //Instance of the subclass
            SubClass sub = new SubClass();

            //Possibility to create instance of subclass while declaring it as type of superclass
            SuperClass a = new SubClass();

            //Call overridden method from subclass instance
            sub.overriddenMethod(); // Output: "SubClass overriddenMethod"

            //Print result of method getClass() into console for subclass instance
            System.out.println("Class of a: " + a.getClass());

            //Access superclass instance variables inside child class methods
            sub.protectedVar = "Protected Variable";
            System.out.println("Protected variable in SubClass: " + sub.protectedVar);
            sub.publicVar = 3.14;
            System.out.println("Public variable in SubClass: " + sub.publicVar);

            //Use of super keyword to call overridden method from superclass
            sub.callSuperMethod(); // Output: "SuperClass overriddenMethod"

        }
    }

