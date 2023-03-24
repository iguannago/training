class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def greet(self):
        print("Hello, my name is " + self.name + " and I am " + str(self.age))


person = Person("David", 44)
person.greet()

# define class which extends Person
class Employee(Person):
    def __init__(self, name, age, salary):
        super().__init__(name, age)
        self.salary = salary

    def greet(self):
        print(
            "Hello, my name is "
            + self.name
            + " and I am "
            + str(self.age)
            + " and I make "
            + str(self.salary)
        )


employee = Employee("John", 55, 50000)
employee.greet()

# define interface
class IStream:
    def read(self):
        raise NotImplementedError

    def write(self, data):
        raise NotImplementedError

    # define class which implements interface


class SocketStream(IStream):
    def read(self):
        print("Reading data from socket")

    def write(self, data):
        print("Writing data to socket")


socketStream = SocketStream()
socketStream.read()
