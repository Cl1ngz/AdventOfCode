from collections import defaultdict

with open("../input.txt") as f:
    data = f.read().strip()


def part1(data):
    presents = defaultdict(int)
    x, y = 0, 0
    presents[(x, y)] += 1
    for c in data:
        match c:
            case ">":
                x += 1
                presents[(x, y)] += 1
            case "<":
                x -= 1
                presents[(x, y)] += 1
            case "^":
                y += 1
                presents[(x, y)] += 1
            case "v":
                y -= 1
                presents[(x, y)] += 1

    print(len(presents))


def part2(data):
    presents = defaultdict(int)
    MOVES = {">": (1, 0), "<": (-1, 0), "^": (0, 1), "v": (0, -1)}

    x1, y1 = 0, 0
    x2, y2 = 0, 0
    presents[(0, 0)] += 2
    for i, c in enumerate(data):
        x, y = MOVES[c]
        if i % 2 == 0:
            x1 += x
            y1 += y
            presents[(x1, y1)] += 1
        else:
            x2 += x
            y2 += y
            presents[(x2, y2)] += 1

    print(len(presents))


part1(data)
part2(data)
