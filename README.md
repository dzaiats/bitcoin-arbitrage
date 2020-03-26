# Arbitrage Currency Converter
An explanation of this project can be found here:

https://priceonomics.com/jobs/puzzle/

## Implementation

### Using Bellman-Ford approach
This approach is fully based on Vertexes and weights of Edges
The complexity is O(V*E), where V - the number of vertices and E is the number of edges.
It is practical to use on not big amount of data (not big graphs). Otherwise, the complexity will be following to O(V * V^2), or O(V^3)

### Using Iterative calculation
This is approach is lightweight and fast and can be scaled for better accuracy
In this case the complexity is O(N^2), where N - is the number of elements in the list. But this complexity is flexible and depends on the random data in our case. It means that Complexity will be always between O(2*N) and O(N^2) or O((N^2)/2)

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