with open("../input.txt") as f:
    lines = f.read().strip().splitlines()

circuit = {}
for line in lines:
    e, r = line.split(" -> ")
    circuit[r] = e.split()


print(circuit["a"])
