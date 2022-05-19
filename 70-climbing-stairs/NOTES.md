* ith cell of dp will contain total number of ways to climb i staircase.
* nth cell will contain total number of ways to climb n staircases, which is our main big problem
* bigger problem is on the right side
* let's calculate of smaller problems
* dp[1] = 1 ( to reach 1st stair, there is only one way, jump of 1)
* dp[2] = 2 (there are two ways, jump of 1 1 and jump of 2 )
​
* To calculate dp[3]: To reach 3rd staircase, we can either take a jump of 2 from 1st   staircase or we can take a jump of 1 from 2nd staircase
so dp[3] = dp[1] + dp[2]
​
And finally by this way we can say
dp[i] = dp[i - 1] + dp[i - 2]