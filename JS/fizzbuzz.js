function fizzbuzz(number) {
  if (multipleOf3(number) && multipleOf5(number)) {
    return 'fizzbuzz';
  }
  if (multipleOf5(number)) {
    return 'buzz';
  }
  if (multipleOf3(number)) {
    return 'fizz';
  }
  return number;
}

function multipleOf3(number) {
  return number % 3 === 0;
}

function multipleOf5(number) {
  return number % 5 === 0;
}

module.exports = { fizzbuzz };
