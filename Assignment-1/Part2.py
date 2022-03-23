def isStringPermutation(s1: str, s2: str) -> bool:
    if len(s1) != len(s2):
        return False
    letters = {}
    lettersToCompare = {}
    i = 0
    while i < len(s1):
        if s1[i] in letters:
            letters[s1[i]] += 1
        else:
            letters[s1[i]] = 1
        if s2[i] in lettersToCompare:
            lettersToCompare[s2[i]] += 1
        else:
            lettersToCompare[s2[i]] = 1
        i += 1
    for letter in letters.keys():
        if not (letter in lettersToCompare and lettersToCompare[letter] == letters[letter]):
            return False
    return True

def pairsThatEqualSum(inputArray: list, targetSum: int) -> list:
    toSum = {}
    pairsThatEqualSum = []
    for item in inputArray:
        if item in toSum:
            pairsThatEqualSum.append((item, toSum[item]))
        else:
            toSum[targetSum - item] = item
    return pairsThatEqualSum
