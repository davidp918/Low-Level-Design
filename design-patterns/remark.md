### Template Method Pattern vs Strategy Pattern

Template Method:

1. Use when the algorithm structure is mostly fixed, but certain steps need to be customizable by subclasses.
2. Best when you need to enforce a common flow with slight variations in steps.
3. Use it when the client uses the subclass

Strategy:

1. Use when you need to dynamically swap algorithms and offer flexibility to choose different behaviors at runtime.
2. Best when you have multiple interchangeable strategies that can be used without altering the client’s structure.
3. Promotes easier extension and maintenance since you can introduce new strategies without modifying existing classes.


### Problem of Singleton Pattern

1. Global State and Hidden Dependencies (the user can directly use the singleton without needing it in its argument)
2. Tight coupling
3. Difficult Unit tests

To avoid it in Spring, we can do:
1. Dependency Injection by instantiating the bean in configuration class, this avoids hidden dependency as dependencies are explicitly provided
2. Flexible scopes: Spring allows defining different scopes for beans, not just singletons. e.g., `prototype` scope instantiates a new instance every time the bean is requested
3. Easy unit testing
4. Inversion of Control: don’t need to worry about controlling the singleton's lifecycle