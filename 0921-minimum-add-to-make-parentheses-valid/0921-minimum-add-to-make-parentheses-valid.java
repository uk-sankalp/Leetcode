class Solution {
   public int minAddToMakeValid(String S) {
	int unmatchedOpen = 0;
	int unmatchedClose = 0;
    
	for (char c : S.toCharArray()) {
		if (c == '(') {
            unmatchedOpen++;
        } else if (unmatchedOpen > 0){
			unmatchedOpen--;
        } else {
		    // This is a closed paren and there 
			// isn't an open one to balance it out
            unmatchedClose++;
        }
	}
        
    return unmatchedClose + unmatchedOpen;
}
}