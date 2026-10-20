with open("../input.txt") as f:
    lines = f.read().strip().splitlines()

circuit = {}
for line in lines:
    e, r = line.split(" -> ")
    circuit[r] = e.split()

saved = {}


def calculate(wire):
    if wire.isdigit():
        return int(wire)
    if wire in saved:
        return saved[wire]
    expr = circuit[wire]
    result = 0
    if len(expr) == 1:
        result = calculate(expr[0])
    elif len(expr) == 2:
        result = ~calculate(expr[1]) & 0xFFFF
    elif len(expr) == 3:
        left, op, right = expr
        if op == "AND":
            result = calculate(left) & calculate(right)
        elif op == "OR":
            result = calculate(left) | calculate(right)
        elif op == "LSHIFT":
            result = (calculate(left) << calculate(right)) & 0xFFFF
        elif op == "RSHIFT":
            result = (calculate(left) >> calculate(right)) & 0xFFFF
    saved[wire] = result
    return result


part1 = calculate("a")
print(part1)
saved.clear()
circuit["b"] = [str(part1)]
part2 = calculate("a")
print(part2)
