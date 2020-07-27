class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        pre=""
        i=0
        while len(strs) !=0 and i <= min([len(x) for x in strs])-1:
            if [strs[x][i] for x in range(len(strs))].count(strs[0][i]) == len(strs):
                pre += strs[0][i]
                i+=1         
            else:
                break
        return(pre)