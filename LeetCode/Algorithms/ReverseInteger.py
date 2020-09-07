class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if str(x).startswith('-'):
            x = int(str(x).replace('-',''))
            x = int(str(x)[::-1])      
            if (x>= -2**31) and (x <= 2**31-1):
                return -x
            else:
                return 0
        else:
            x =int(str(x)[::-1])
            if (x>= -2**31) and (x <= 2**31-1):
                return x
            else:
                return 0

        