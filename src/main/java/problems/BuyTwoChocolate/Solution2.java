package problems.BuyTwoChocolate;

public class Solution2 {
    // Method to calculate the maximum amount of money that can be spent on chocolates
    public int buyChoco(int[] prices, int money) {
        // Initialize variables to keep track of the minimum and second minimum prices
        int minPrice = Integer.MAX_VALUE; // Initialize minPrice to the maximum possible integer value
        int secPrice = Integer.MAX_VALUE; // Initialize secPrice to the maximum possible integer value

        // Find the minimum and second minimum prices in the prices array
        for (int price : prices) {
            if (price < minPrice) {
                // If the current price is less than the minimum price, update both minPrice and secPrice
                secPrice = minPrice; // Update secPrice to the previous value of minPrice
                minPrice = price;    // Update minPrice to the current price
            } else {
                // If the current price is not less than the minimum price, update only secPrice
                secPrice = Math.min(secPrice, price); // Update secPrice to the minimum of its current value and the current price
            }
        }

        // Check if the sum of the minimum and second minimum prices exceeds the available money
        if (minPrice + secPrice > money) {
            // If yes, return the available money as we cannot afford both the minimum and second minimum prices
            return money;
        }

        // Return the remaining money after purchasing chocolates at the minimum and second minimum prices
        return money - (minPrice + secPrice);
    }
}
