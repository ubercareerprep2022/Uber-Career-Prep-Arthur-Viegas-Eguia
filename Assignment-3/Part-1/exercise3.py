import heapreplace
def mergeIntoLargerArray(arr1, arr2):
    if len(arr2) > len(arr1):
        arr1, arr2 = arr2, arr1
    i = 0
    heapq.heapify(arr2)
    while arr[i] != None:
        if arr1[i] > arr2[0]:
            temp = arr1[i]
            arr1[i] = arr2[0]
            heapq.heapreplace(arr2, temp)
        i += 1
    while len(arr2) != 0:
        arr[i] = heapq.heapop(arr2)
        i += 1
