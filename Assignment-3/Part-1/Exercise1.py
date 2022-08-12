def SortArrayOnePass(arr, pivot):
    l, r = 0, len(arr) - 1
    for i in range(len(arr) - 1):
        if arr[i] < pivot:
            arr[l], arr[i] = arr[i], arr[l]
            l += 1
        elif arr[i] > pivot:
            arr[i], arr[r] = arr[r], arr[i]
            r -= 1
    return arr
print(SortArrayOnePass([5, 10, 5, 20, 5, 5, 10], 10))
