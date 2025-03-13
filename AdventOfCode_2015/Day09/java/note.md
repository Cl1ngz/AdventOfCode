# Note for Permutation  (Day 09 is hard Okay) //Used ai for permutate
Imagine we have a list: [A, B, C]  
We call: permute([A, B, C], start = 0, result = [])

--- At the top level (start = 0) ---
For i = 0:
    Swap index 0 with index 0:
      List remains: [A, B, C]
    Now, fix element at index 0 (A) and recursively permute the remaining elements:
    Call: permute([A, B, C], start = 1, result)
    
        --- Now inside the recursive call (start = 1) ---
        List is: [A, B, C]
        For i = 1:
            Swap index 1 with index 1:
              List remains: [A, B, C]
            Now, fix element at index 1 (B) and recursively permute the remaining element:
            Call: permute([A, B, C], start = 2, result)
            
                --- Base case (start = 2, which is list.size() - 1) ---
                List is: [A, B, C]
                Base case reached: add a copy of [A, B, C] to result.
                Result now: [[A, B, C]]
            
            Backtrack: swap back index 1 with index 1 (list still [A, B, C])
            
        For i = 2:
            Swap index 1 with index 2:
              List becomes: [A, C, B]
            Now, fix element at index 1 (now C) and permute the rest:
            Call: permute([A, C, B], start = 2, result)
            
                --- Base case (start = 2) ---
                List is: [A, C, B]
                Base case reached: add a copy of [A, C, B] to result.
                Result now: [[A, B, C], [A, C, B]]
            
            Backtrack: swap back index 1 with index 2 to restore list to [A, B, C]
        
        End of loop for start = 1.
    
Back in the top level (start = 0), continue loop:
    
For i = 1:
    Swap index 0 with index 1:
      List becomes: [B, A, C]
    Now, fix element at index 0 (B) and recursively permute remaining elements:
    Call: permute([B, A, C], start = 1, result)
    
        --- In recursive call (start = 1) with list [B, A, C] ---
        For i = 1:
            Swap index 1 with index 1:
              List remains: [B, A, C]
            Call: permute([B, A, C], start = 2, result)
                Base case reached: add [B, A, C] to result.
                Result now: [[A, B, C], [A, C, B], [B, A, C]]
            Backtrack (swap back index 1 with index 1; no change)
        
        For i = 2:
            Swap index 1 with index 2:
              List becomes: [B, C, A]
            Call: permute([B, C, A], start = 2, result)
                Base case reached: add [B, C, A] to result.
                Result now: [[A, B, C], [A, C, B], [B, A, C], [B, C, A]]
            Backtrack: swap back index 1 with index 2, restoring list to [B, A, C]
        
        End loop for start = 1.
    
    Backtrack: swap back index 0 with index 1 to restore list to [A, B, C]

For i = 2:
    Swap index 0 with index 2:
      List becomes: [C, B, A]
    Now, fix element at index 0 (C) and recursively permute the rest:
    Call: permute([C, B, A], start = 1, result)
    
        --- In recursive call (start = 1) with list [C, B, A] ---
        For i = 1:
            Swap index 1 with index 1:
              List remains: [C, B, A]
            Call: permute([C, B, A], start = 2, result)
                Base case reached: add [C, B, A] to result.
                Result now: [[A, B, C], [A, C, B], [B, A, C], [B, C, A], [C, B, A]]
            Backtrack: swap back index 1 with index 1.
        
        For i = 2:
            Swap index 1 with index 2:
              List becomes: [C, A, B]
            Call: permute([C, A, B], start = 2, result)
                Base case reached: add [C, A, B] to result.
                Result now: [[A, B, C], [A, C, B], [B, A, C], [B, C, A], [C, B, A], [C, A, B]]
            Backtrack: swap back index 1 with index 2, restoring list to [C, B, A]
        
        End loop for start = 1.
    
    Backtrack: swap back index 0 with index 2 to restore list to [A, B, C]

End of loop for start = 0.  
All permutations are now in result.
