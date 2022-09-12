def search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        middle = (left + right) // 2
        if target == arr[middle]:
            return middle
        if arr[middle] < arr[left]:
            if target > arr[right] or target < arr[middle]:
                right = middle- 1
            else:
                left = middle + 1
        else:
            if target < arr[left] or target > arr[middle]:
                left = middle + 1
            else:
                right = middle - 1
    return None
