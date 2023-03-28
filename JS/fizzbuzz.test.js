const { fizzbuzz } = require('./fizzbuzz');

describe('fizzbuzz', () => {
  test.each([
    [1, 1],
    [2, 2],
    [3, 'fizz'],
    [4, 4],
    [5, 'buzz'],
    [6, 'fizz'],
    [7, 7],
    [15, 'fizzbuzz'],
  ])('returns %s for %s', (input, expected) => {
    expect(fizzbuzz(input)).toBe(expected);
  });
});
