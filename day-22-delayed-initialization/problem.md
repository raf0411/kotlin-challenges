Day 22: Delayed Initialization ⏳

The Goal

In Android, you often have properties in a class (like an Activity or ViewModel) that cannot be initialized immediately in the constructor. You need to explore two different ways Kotlin provides to handle this "delayed initialization" for non-nullable properties.

Breaking Down the Problem

You will create two different scenarios:

    The Expensive Resource: Imagine an object that is very "expensive" to create (e.g., it opens a database connection). You want to avoid creating this object until the very first time it's actually needed. This is for a read-only (val) property.

    The Framework-Initialized Component: In Android, some objects (like UI components) can only be initialized in methods like onCreate(). You need a way to declare a non-nullable, changeable (var) property that you promise you will initialize later, before you use it.

Hint

This challenge explores two keywords for delayed initialization:

    by lazy { ... }: This is used for val properties. The code inside the {} block is only executed the very first time the property is accessed. Subsequent accesses will return the remembered result. It's thread-safe by default and perfect for expensive, read-only resources that you only want to compute once.

    lateinit var: This is used for var properties. It's a promise to the compiler that you will initialize this non-nullable property before you ever try to read from it. If you try to access it before it's been initialized, your app will crash with an UninitializedPropertyAccessException.

Output

    --- Scenario 1: Lazy Initialization ---
    DataService created. Database has not been touched.
    First data fetch:
    (Initializing database connection...)
    (Fetching data from the database...)
    Second data fetch:
    (Fetching data from the database...)
    
    --- Scenario 2: Late Initialization ---
    MainScreen created. Renderer is not yet available.
    (Renderer is being set up now...)
    (Drawing UI elements...)