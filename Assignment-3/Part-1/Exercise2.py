import heapq
def parseFile():
    fileNum = 1
    file = open("input.txt", "r+")
    for line in file:
        file.truncate()
        break
    heap = []
    count = 0
    """
    for line in file:
        if count % 3 == 0:
            tempFile = open("temp"+str(fileNum)+".txt", "w")
            arr = []
            arr.append(int(line.strip()))
        elif count % 3 == 2:
            arr.append(int(line.strip()))
            arr.sort()
            print(arr)
            for i in arr:
                tempFile.write(str(i)+"\n")
            heap.append((arr[0], "temp"+str(fileNum)+".txt"))
            fileNum += 1
        else:
            arr.append(int(line.strip()))
        count += 1
    if count % 3 != 0:
            arr.append(int(line.strip()))
            arr.sort()
            print(arr)
            for i in arr:
                tempFile.write(str(i)+"\n")
            heap.append((arr[0], "temp"+str(fileNum)+".txt"))
            fileNum += 1
    
    heapq.heapify(heap)
    while heap:
        
    print(heap)
        
    """
parseFile()
