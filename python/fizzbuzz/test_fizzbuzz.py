import pytest
from fizzbuzz import fizzbuzz


@pytest.mark.parametrize(
    "n, expected",
    [(1, "1"), (2, "2"), (3, "fizz"), (4, "4"), (5, "buzz"), (15, "fizzbuzz")],
)
def test_fizzbuzz(n, expected):
    assert fizzbuzz(n) == expected
