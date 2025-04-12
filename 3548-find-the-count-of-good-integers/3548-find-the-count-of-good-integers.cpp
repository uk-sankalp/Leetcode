class Solution {
public:
    long long factorialArr[11];
    
    Solution() {
        factorialArr[0] = 1;
        for(int idx = 1; idx <= 10; idx++) {
            factorialArr[idx] = factorialArr[idx - 1] * idx;
        }
    }

    vector<long long> generatePalindromes(int digitCount) {
        vector<long long> palindromeList;
        if(digitCount == 0) return palindromeList;
        
        int halfLen = (digitCount + 1) / 2;
        long long startNum = pow(10, halfLen - 1);
        long long endNum = pow(10, halfLen) - 1;
        
        if(digitCount == 1) startNum = 0;
        
        for(long long firstHalf = startNum; firstHalf <= endNum; firstHalf++) {
            string halfStr = to_string(firstHalf);
            string fullPalindrome;

            if(digitCount % 2 == 0) {
                string reversedHalf = halfStr;
                reverse(reversedHalf.begin(), reversedHalf.end());
                fullPalindrome = halfStr + reversedHalf;
            } else {
                string truncatedHalf = halfStr.substr(0, halfStr.size() - 1);
                reverse(truncatedHalf.begin(), truncatedHalf.end());
                fullPalindrome = halfStr + truncatedHalf;
            }

            if(fullPalindrome.size() == digitCount) {
                long long palindromeNum = stoll(fullPalindrome);
                palindromeList.push_back(palindromeNum);
            }
        }
        return palindromeList;
    }

    vector<int> countDigits(long long number, int digitCount) {
        vector<int> digitFreq(10, 0);
        string numStr = to_string(number);
        while(numStr.size() < digitCount) numStr = "0" + numStr;
        
        for(char digit : numStr) digitFreq[digit - '0']++;
        return digitFreq;
    }

    long long calculatePermutations(vector<int> digitFreq, int digitCount) {
        long long permutationCount = 0;
        for(int digit = 1; digit <= 9; digit++) {
            if(digitFreq[digit] == 0) continue;
            
            vector<int> adjustedFreq = digitFreq;
            adjustedFreq[digit]--;
            bool isValid = true;
            
            for(int freq : adjustedFreq) {
                if(freq < 0) {
                    isValid = false;
                    break;
                }
            }
            
            if(!isValid) continue;
            
            long long validPermutations = factorialArr[digitCount - 1];
            for(int idx = 0; idx < 10; idx++) {
                validPermutations /= factorialArr[adjustedFreq[idx]];
            }
            permutationCount += validPermutations;
        }
        return permutationCount;
    }

    long long countGoodIntegers(int digitCount, int divisor) {
        vector<long long> palindromeList = generatePalindromes(digitCount);
        vector<long long> validPalindromes;
        
        for(auto palindrome : palindromeList) {
            if(palindrome % divisor == 0) validPalindromes.push_back(palindrome);
        }
        
        set<vector<int>> uniqueDigitFreq;
        for(auto validPalindrome : validPalindromes) {
            vector<int> digitFreq = countDigits(validPalindrome, digitCount);
            uniqueDigitFreq.insert(digitFreq);
        }
        
        long long totalGoodIntegers = 0;
        for(auto &digitFreq : uniqueDigitFreq) {
            totalGoodIntegers += calculatePermutations(digitFreq, digitCount);
        }
        return totalGoodIntegers;
    }
};