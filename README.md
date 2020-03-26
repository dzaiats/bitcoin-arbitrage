# Arbitrage Currency Converter
An explanation of this project can be found here:

https://priceonomics.com/jobs/puzzle/

## Implementation

### Using Bellman-Ford approach
This approach is fully based on Vertexes and weights of Edges
The complexity is O(VE), where V - the number of vertices and E is the number of edges.

### Using Iterative calculation
This is approach is lightweight and fast and can be scaled for better accuracy
In this case the complexity is O(log(N^2)), where N - is the number of elements in the list.

### Using Recursive calculation
This is approach is heavy but simple in implementation. Might cause StackOverflowError
In case of recursive the complexity is not easy to calculate due to specific implementation but in our case it is O(2*N^2)

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