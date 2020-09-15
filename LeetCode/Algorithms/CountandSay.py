class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        if n == 1:
            return '1'
        else:
            prevNum = self.countAndSay(n-1)
            count = 1
            currNum = ""
            for i in range(len(prevNum)):
                if(i == len(prevNum)-1) or (prevNum[i] != prevNum[i+1]):
                    currNum = currNum + str(count) + prevNum[i]
                    count = 1
                else:
                    count = count + 1
            return currNum
        
                
            