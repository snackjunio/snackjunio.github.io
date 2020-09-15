class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        s = s.strip()
        count = 0
        for i in s[::-1]:
            if i == ' ':
                break
            else:
                count += 1
        return count