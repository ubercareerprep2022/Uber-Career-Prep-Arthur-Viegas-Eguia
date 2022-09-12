def powCode(number, exp):
    if number == 0:
                return 0
        def expHelper(number, exponent):
            if exponent == 0:
                return 1

            res = expHelper(number * number, exponent // 2)
            return number * res if exponent % 2 != 0 else res

        res = expHelper(number, abs(exponent))
        return res if exponent >= 0 else 1 / res
        
