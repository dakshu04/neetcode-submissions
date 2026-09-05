class Solution:
    def pow(self, x : float, n : int) -> float:
        if n == 0:
            return 1.0
        if n == 1:
            return x
        if n % 2 == 0:
            return self.pow(x * x, n // 2)
        else:
            return x * self.pow(x, n - 1)
    def myPow(self, x: float, n: int) -> float:
        if n < 0:
            return 1.0 / self.pow(x, -n)
        return self.pow(x, n)
        