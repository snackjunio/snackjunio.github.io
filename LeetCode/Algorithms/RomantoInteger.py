class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        sumval = 0
        hikaku = 0
        i = len(s)-1
        roman = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
        while i>=0:
            s1 = roman[s[i]]
            if hikaku > s1:
                sumval -= s1
            else:
                sumval += s1
            hikaku = s1
            i -= 1
        return sumval
            