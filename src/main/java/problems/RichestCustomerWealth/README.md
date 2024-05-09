# 1672. Richest Customer Wealth
You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

## Example 1:

Input
`["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]`
`[[1, 1, 0], [1], [2], [3], [1]]`
Output
`[null, true, true, false, false]`

Explanation
`ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
parkingSystem.addCar(3); // return false because there is no available slot for a small car
parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.`



**Constraints**:

`0 <= big, medium, small <= 1000`

`carType` is `1`, `2`, or `3`

At most `1000` calls will be made to `addCar`