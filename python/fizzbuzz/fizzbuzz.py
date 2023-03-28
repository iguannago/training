def fizzbuzz(n):
    if multipleOf3(n) and multipleOf5(n):
        return "fizzbuzz"
    if multipleOf3(n):
        return "fizz"
    elif multipleOf5(n):
        return "buzz"
    return n.__str__()


def multipleOf5(n):
    return n % 5 == 0


def multipleOf3(n):
    return n % 3 == 0


def fizzbuzzList():
    numbers = list(range(1, 100))
    return print([fizzbuzz(n) for n in numbers])


fizzbuzzList()
