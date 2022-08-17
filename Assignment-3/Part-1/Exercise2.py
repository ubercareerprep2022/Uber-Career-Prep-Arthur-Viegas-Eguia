import heapq
import os
import shutil
def readIntegers(file, target):
    arr = []
    num = file.readline()
    while num:
        arr.append(int(num))
        if len(arr) == target:
            break
        num = file.readline()
    return arr
def readAndSort(fileName, target):
    count = 1
    file = open(fileName, "r")
    arr = readIntegers(file, target)
    if os.path.exists('./temp/'):
        shutil.rmtree('./temp/')
    os.mkdir("./temp")
    while len(arr) > 0:
        arr.sort()
        tempFile = open("./temp/temp"+str(count)+".txt", "w")
        for i in arr:
            tempFile.write(str(i)+"\n")
        tempFile.close()
        arr = readIntegers(file, target)
        count += 1
    file.close()
def heapSort():
    file = open("output.txt","w+")
    heap = []
    for tempFiles in os.listdir("./temp"):
        if os.path.isfile("./temp/"+tempFiles):
            tempFile = open("./temp/"+str(tempFiles))
            heap.append((int(tempFile.readline()), tempFile))
        heapq.heapify(heap)
    while len(heap) > 0:
        minVal = heapq.heappop(heap)
        file.write(str(minVal[0])+"\n")
        num = minVal[1].readline()
        if num:
            heapq.heappush(heap, (int(num), minVal[1]))
        else:
            minVal[1].close()
    file.close()
def externalSort(fileName, target):
    readAndSort(fileName, target)
    heapSort()
externalSort("input.txt", 100)
