/**
 * @param {number} n
 * @return {Function} counter
 */
// var createCounter = function(n) {
    
//     return function() {
 function createCounter(start) {
  let count = start;
  return function() {
    return count++;
  }
}

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */