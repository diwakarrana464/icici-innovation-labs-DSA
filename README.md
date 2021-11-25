# icici-innovation-labs

Question:: Paul has a set of unique numbers. He wants to store numbers in a binary tree such that 
whenever a number is given, he can exactly tell how many numbers are less than the given 
number. 
 
Help Paul by coding the logic in your language of choice without using any libraries for tree 
implementation.

Explanation: 
Agoright is like this:

step 1: Constructing Height balance binary Tree.

step 2 : Updateing leftCount and rightCount

        a) LeftCount : Number of nodes present in left sub tree.
        
        b) RightCount : Number of nodes present in right sub tree.
        
step3: search number of smaller elements present in binary search tree and update smaller count accordingly.

step 4: return smaller count.

TIME COMPLEXITY :::
assumption let say k is number of distinct numbers on which operation is to preform.

BUILDING OF HEIGHT BALACING TREE REQUIRED : O(K*(LonK))

UPDATE LEFTCOUNT AND RIGHTCOUNT :           O(K)

FOR EACH SEARCH SMALLER COUNT :             O(lonK)
