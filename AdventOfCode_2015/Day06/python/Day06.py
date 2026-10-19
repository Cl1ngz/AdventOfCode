import numpy as np

with open("../input.txt") as f:
    lines = f.read().strip().splitlines()


def part1():
    siatka = np.zeros((1000, 1000), dtype=bool)
    for line in lines:
        parts = line.split()
        if parts[0] == "turn":
            action = parts[1]
            start = tuple(map(int, parts[2].split(",")))
            end = tuple(map(int, parts[4].split(",")))
        else:
            action = "toggle"
            start = tuple(map(int, parts[1].split(",")))
            end = tuple(map(int, parts[3].split(",")))

        for i in range(start[0], end[0] + 1):
            for j in range(start[1], end[1] + 1):
                if action == "on":
                    siatka[i][j] = True
                elif action == "off":
                    siatka[i][j] = False
                elif action == "toggle":
                    siatka[i][j] = not siatka[i][j]

    print(np.sum(siatka))


def part2():
    siatka = np.zeros((1000, 1000), dtype=int)
    for line in lines:
        parts = line.split()
        if parts[0] == "turn":
            action = parts[1]
            start = tuple(map(int, parts[2].split(",")))
            end = tuple(map(int, parts[4].split(",")))
        else:
            action = "toggle"
            start = tuple(map(int, parts[1].split(",")))
            end = tuple(map(int, parts[3].split(",")))

        for i in range(start[0], end[0] + 1):
            for j in range(start[1], end[1] + 1):
                if action == "on":
                    siatka[i][j] += 1
                elif action == "off":
                    siatka[i][j] = max(0, siatka[i][j] - 1)
                elif action == "toggle":
                    siatka[i][j] += 2

    print(np.sum(siatka))


part1()
part2()
