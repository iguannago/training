const fizzbuzz = require('./fizzbuzz');

function main() {
  for (let i = 1; i <= 100; i++) {
    console.log(fizzbuzz.fizzbuzz(i));
  }
}

main();
