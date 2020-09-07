class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        open_list = ['(','{','[']
        close_list = [')','}',']']
        list = []
        for i in s:
            if i in open_list:
                list.append(i)
            elif i in close_list:
                pos = close_list.index(i)
                if len(list) > 0 and (open_list[pos] == list[len(list)-1]):
                    list.pop()
                else:
                    return False
        if len(list) == 0:
            return True
        else:
            return False