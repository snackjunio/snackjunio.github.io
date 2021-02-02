class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        elif n == 2:
            return 2
        else:
            dp1 = 1
            dp2 = 2
            i = 3
            while i<=n:
                dp1,dp2 = dp2, dp1+dp2
                i += 1
            return dp2
            