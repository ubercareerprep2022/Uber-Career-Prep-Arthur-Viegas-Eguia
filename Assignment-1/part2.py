def pairsThatEqualSum(inputArray: list, targetSum: int) -> list:
    toSum = {}
    pairsThatEqualSum = []
    for item in inputArray:
        if item in toSum:
            pairsThatEqualSum.append((item, toSum[item]))
        else:
            toSum[targetSum - item] = item
    return pairsThatEqualSum
