class Solution:
    def mirrorDistance(self, n: int) -> int:
        reverse = str(n)[::-1]
        reverse = int (reverse)
        return abs(n - reverse)