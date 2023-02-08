# OOP_assignment2

This Java code contains three methods for counting the total number of lines in a group of text files.

createTextFiles - This method creates n number of text files with a random number of lines between 0 and a specified bound. The seed value is used to initialize a random number generator for generating the number of lines for each file. The names of the created files are stored in an array and returned.

getNumOfLines - This method uses a sequential approach to count the total number of lines in a group of text files. It reads each file line by line and increments a sum each time a line is read. The final sum is returned as the result.

getNumOfLinesThreads - This method uses multiple threads to count the total number of lines in a group of text files. It starts a separate thread for each file and waits for all threads to finish using the "join" method. The number of lines read by each thread is accumulated to give the final result.

getNumOfLinesThreadPool - This method also uses multiple threads to count the total number of lines in a group of text files. Instead of starting separate threads for each file, it uses a fixed thread pool to handle the task. The result from each thread is accumulated and returned as the final result.

##CustomExecutor
CustomExecutor is a custom thread pool executor in Java that extends the standard Java class ThreadPoolExecutor and adds additional functionality.
Features:
It maintains a list of tasks called AllTask which keeps track of the number of tasks submitted with a priority from 1 to 10. 
The CustomExecutor constructor creates a priority blocking queue and initializes AllTask with 10 zeros. 
The executor has two submit methods, one with and one without a TaskType, both of which create a Task object and a theFuthreObject object, add the task count for the priority, and then execute the theFuthreObject with the execute method.
 The beforeExecute method subtracts 1 from the count of the corresponding priority in AllTask just before executing a task.
 The getCurrentMax method returns the highest priority of the tasks that have not yet completed. 
The dwon method shuts down the executor.
Usage:
To use the CustomExecutor, create an instance of the class and submit tasks to it using the submit method. The submit method takes in a Callable and an optional TaskType as input and returns a theFutureObject. The theFutureObject can be used to retrieve the result of the task when it is completed.

##Task Class
A Java class that provides a wrapper for a Callable task with additional fields for task priority and type.
Features
Implements the "Callable" interface : The class has two constructors - one that takes a Callable task and a TaskType as arguments and sets the priority of the task based on the TaskType's priority value. The second constructor takes only a Callable task and sets its priority to 3 by default
Implements the "call" method from the "Callable" interface which allows the task to be executed when submitted to an executor.
Handles exceptions thrown by the wrapped Callable task.
Two static methods "createTask" which provide a convenient way to create Task instances, either with a TaskType or with a default priority of 3.

##TaskType Enumeration
This code defines an enumeration TaskType with three constants: COMPUTATIONAL, IO, and OTHER. Each constant is associated with a priority represented by an integer value ranging from 1 to 10.
TaskType(int priority): The constructor sets the typePriority field to the specified priority value, if it is a valid integer between 1 and 10. If not, it throws an IllegalArgumentException.
setPriority(int priority): Changes the priority of the task type to the specified value, if it is a valid integer between 1 and 10. If not, it throws an IllegalArgumentException.
getPriorityValue(): Returns the priority value of the task type.
getType(): Returns the constant of the TaskType enumeration representing the task type.
validatePriority(int priority): A private helper method that returns true if the specified priority value is a valid integer between 1 and 10, and false otherwise.
theFutureObject class
This class is an implementation of the Java FutureTask class and is used to run Task objects asynchronously. It extends the FutureTask class and implements the Comparable interface, allowing for sorting and comparing of theFutureObject objects based on their priority.
Usage
The theFutureObject class is used to handle tasks with priorities. The tasks are represented as Task objects of generic type T. The priority of a task is represented by an integer Pri.
The class contains the following methods:
compareTo(theFuthreObject<T> other): Compares the priority of the theFutureObject with another theFutureObject and returns an integer indicating the comparison result.
getTask(): Returns the Task object.
Pri(): Returns the priority of the task.

