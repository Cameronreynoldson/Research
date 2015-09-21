matrix = []
x = 0; 

with open("binding2.csv", "r") as file:
    next(file)
    for line in file:
        matrix.append(line.rstrip("\n").split(","))
for l in matrix:
    for i, n in enumerate(l):
        if n == "NA":
            l[i] = "0"
        l[i] = float(l[i])

for list in matrix:
    lowest = min(list)
    list[list.index(lowest)] = 100
    lowest = min(list)
    list[list.index(lowest)] = 100

characters = {1 : "A", 2 : "T", 3 : "C", 4 : "G"}
seq = ""
seqs = []

def calc(seq, matrix, rank, seqs, count, file):
    global x
    if count == 45:
        seqs.append(seq);
        seqs.append(rank)
        x += 1
        print(x)
        file.write(seq + " " + str(rank) + "\n")
    else: 
        for i in range(1,5):
            if matrix[len(seq)-1][i] != 100:
                prob = float(matrix[len(seq) - 1][i])
                if prob == 0:
                    seq = seq + "X"
                else:
                    seq = seq + characters[i]
                calc(seq, matrix, rank + prob, seqs, count + 1, file)
                seq = seq[:-1]
with open("sequences.txt", "w") as file:
    calc(seq, matrix, 0, seqs,0, file)
