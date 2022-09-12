def findMin(arr):
    left, right = 0, len(arr) - 1
    res = float("inf")
    while left <= right:
        if arr[left] < arr[right]:
            res = min(res, arr[left])
            break
        middle = (left + right) // 2
        res = min(arr[middle], res)
        if arr[middle] < arr[left]:
            right = middle - 1
        else:
            left = middle + 1
    return res
