# Arbitrage Currency Converter
An explanation of this project can be found here:

https://priceonomics.com/jobs/puzzle/

## Implementation

### Using Bellman-Ford approach
This approach is fully based on Vertexes and weights of Edges

### Using Iterative calculation
This is approach is lightweight and fast and can be scaled for better accuracy

### Using Recursive calculation
This is approach is heavy but simple in implementation. Might cause StackOverflowError

## How to run

The test are located in the package `src/test/java/algorithms`
You can execute the tests using command `mvn clean test`

## Results

As the output - you will find consequence chain of exchanging operations and its output per operation. Also final
profit.
Example:

`
Start amount: 11.5
End amount: 11.927729285600943
{USD -> EUR : 0.7809256=8.9806444, EUR -> BTC : 0.0096758=0.08689491908552, BTC -> USD : 137.2661303=11.927729285600943}
`
Contact me:
denys.zaiats@gmail.com